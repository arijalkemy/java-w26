package com.mercadolibre.seguro_autos.repository;

import com.mercadolibre.seguro_autos.models.Siniestro;
import com.mercadolibre.seguro_autos.models.Vehicle;
import com.mercadolibre.seguro_autos.models.VehicleSiniestro;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiclesRepository extends JpaRepository<Vehicle, Long> {
    @Query("SELECT v FROM vehicles v ORDER BY v.fabricacion ASC")
    List<Vehicle> findAllOrderByYear();
    @Query("SELECT v FROM vehicles v WHERE v.cantidadRuedas > 4 AND v.fabricacion = YEAR(NOW())")
    List<Vehicle> findAllVehiclesByRuedasMorethan4();
    @Query("SELECT v FROM vehicles v JOIN siniestros s ON s.vehicle.id=v.id WHERE s.perdidaEconomica>=10000")
    List<Vehicle> findAllByPerdidaEconomica();
    // @Query("SELECT v FROM vehicles v JOIN v.siniestros s ON s.vehicle.id=v.id WHERE s.perdidaEconomica>=2000")
    @Query("SELECT s FROM siniestros s JOIN vehicles v ON v.id=s.vehicle.id WHERE s.perdidaEconomica>=7800")
    List<Siniestro> findAllByPerdidaEconomicaExtended();
    // List<Vehicle> findAllByPerdidaEconomicaExtended();

    // List<Vehicle> get();
    // Vehicle getVehicleById(int id);
    // void addVehicle(Vehicle vehicle);
    // void updateVehicle(Vehicle vehicle);
    // void deleteVehicle(int id);
}
