package com.w26.concesionarioautos.repository;

import com.w26.concesionarioautos.entity.Service;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
@Data
public class ServicesRepository {

    private List<Service> serviceList;

    public ServicesRepository()
    {
        this.serviceList = new ArrayList<>();
        this.load();
    }

    public void load()
    {
        for (int i = 0; i < 5; i++) {
            Random random = new Random();

            Service service = new Service(LocalDate.now(), random.nextInt(10000, 100000), "Cambio de aceite");
            serviceList.add(service);
        }
    }


}
