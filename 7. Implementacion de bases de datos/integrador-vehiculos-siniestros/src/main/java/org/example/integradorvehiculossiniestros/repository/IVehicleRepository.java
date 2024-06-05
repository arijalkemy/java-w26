package org.example.integradorvehiculossiniestros.repository;

import org.example.integradorvehiculossiniestros.entity.Vehicle;
import org.example.integradorvehiculossiniestros.entity.middle.Plate;
import org.example.integradorvehiculossiniestros.entity.middle.PlateBrand;
import org.example.integradorvehiculossiniestros.entity.middle.PlateBrandModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle, Integer> {

    @Query("select v.plate as plate from Vehicle v")
    List<Plate> getAllPlates();

    @Query("select v.plate as plate, v.brand as brand from Vehicle v order by v.fabricationDate")
    List<PlateBrand> getAllPlatesBrandOrderedByDate();

    @Query("select v.plate as plate from Vehicle v where v.wheels > 4 and year(v.fabricationDate) = year(current_date())")
    List<Plate> getAllPlatesByWheelsAndYear();

    @Query("select v.plate as plate, v.brand as brand, v.model as model from Vehicle v " +
            "join AccidentRegistry ar on ar.vehicle.id = v.id " +
            "where ar.moneyLoss > 500")
    List<PlateBrandModel> getAllDetailsByAccident();

    @Query("select sum(ar.moneyLoss) from Vehicle v " +
            "join AccidentRegistry ar on ar.vehicle.id = v.id " +
            "where ar.moneyLoss > 500")
    Double getTotalMoneyLoss();

}
