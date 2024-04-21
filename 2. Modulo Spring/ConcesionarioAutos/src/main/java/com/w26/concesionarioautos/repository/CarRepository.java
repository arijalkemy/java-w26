package com.w26.concesionarioautos.repository;

import com.w26.concesionarioautos.entity.Car;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
@Repository
public class CarRepository {

    private List<Car> carList;

    public CarRepository()
    {
        carList = new ArrayList<>();
        this.load();
    }

    public void load()
    {
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            Car carNew = new Car("Marca"+1, "Model"+1, LocalDate.now(), random.nextInt(10000, 100000), 4, random.nextDouble(20000000, 50000000),"COP", 1);
            carList.add(carNew);
        }
    }
}
