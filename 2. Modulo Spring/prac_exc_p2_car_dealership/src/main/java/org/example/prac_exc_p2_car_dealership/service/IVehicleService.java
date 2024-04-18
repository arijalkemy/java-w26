package org.example.prac_exc_p2_car_dealership.service;

import org.example.prac_exc_p2_car_dealership.dto.FullVehicleDTO;
import org.example.prac_exc_p2_car_dealership.dto.SimpleVehicleDTO;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

public interface IVehicleService {
    public Integer addVehicle(FullVehicleDTO vehicleData);
    public List<SimpleVehicleDTO> getAllVehicles();
    public List<SimpleVehicleDTO> getVehiclesByDate(String since, String to);
    public List<SimpleVehicleDTO> getVehiclesByPrice(String since, String to);
    public FullVehicleDTO getVehicleById(Integer id);
}
