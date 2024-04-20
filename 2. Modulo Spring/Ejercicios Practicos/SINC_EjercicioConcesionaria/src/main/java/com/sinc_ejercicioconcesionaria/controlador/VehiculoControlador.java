package com.sinc_ejercicioconcesionaria.controlador;

import com.sinc_ejercicioconcesionaria.dto.VehiculoRequestDTO;
import com.sinc_ejercicioconcesionaria.dto.VehiculoResponseDTO;
import com.sinc_ejercicioconcesionaria.servicio.IVehiculoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/v1/api/vehicles")
public class VehiculoControlador {

    @Autowired
    private IVehiculoServicio iVehiculoServicio;

    @PostMapping(path = "/")
    public void agregarVehiculo(@RequestBody VehiculoRequestDTO vehiculoRequestDTO) {
        iVehiculoServicio.agregarVehiculo(vehiculoRequestDTO);
    }
    //prueba: localhost:8080/v1/api/vehicles/
    /*{
        "marca": "Volkswagen",
        "modelo": "Gol",
        "fechaFabricacion": "2017-07-25",
        "numeroKilometros": 34003,
        "puertas": 3,
        "precio": 13000,
        "moneda": "AR",
        "servicesDto": [
            {
                "fecha": "2003-05-20",
                "kilometros": 60000,
                "descripcion": "Cambio de filtros"
            },
            {
                "fecha": "2025-05-20",
                "kilometros": 60000,
                "descripcion": "Cambio de ruedas"
            }
        ],
        "cantidadDueños": 1
    }*/

    /*{
        "marca": "Chevrolet",
        "modelo": "Corsa",
        "fechaFabricacion": "2000-11-20",
        "numeroKilometros": 115000,
        "puertas": 5,
        "precio": 9000,
        "moneda": "AR",
        "servicesDto": [
            {
                "fecha": "2003-05-20",
                "kilometros": 60000,
                "descripcion": "Cambio de filtros"
            }
        ],
        "cantidadDueños": 2
    }*/

    @GetMapping(path = "/")
    public List<VehiculoResponseDTO> consultarUsados(){
        return iVehiculoServicio.obtenerVehiculosUsados();
    }
    //prueba: localhost:8080/v1/api/vehicles/

    @GetMapping(path = "/dates")
    public List<VehiculoResponseDTO> consultarPorRangoFechas(@RequestParam LocalDate since,
                                                             @RequestParam LocalDate to) {
        return iVehiculoServicio.obtenerVehiculosPorPeriodos(since, to);
    }
    //prueba: localhost:8080/v1/api/vehicles/dates?since=2000-01-01&to=2024-01-01

    @GetMapping(path = "/prices")
    public List<VehiculoResponseDTO> consultarVehiculosPorRangoPrecio(@RequestParam int since,
                                                                      @RequestParam int to) {
        return iVehiculoServicio.obtenerVehiculosPorRangoPrecio(since, to);
    }
    //prueba: localhost:8080/v1/api/vehicles/prices?since=10000&to=20000

    @GetMapping(path = "/{modelo}")
    VehiculoResponseDTO obtenerVehiculoPorModelo(@PathVariable String modelo) {
        return iVehiculoServicio.obtenerVehiculoPorModelo(modelo);
    }
    //prueba: localhost:8080/v1/api/vehicles/GOL
    //decidí cambiar el id por modelo en la consulta ya que la entidad no contaba con un atributo id
    //y si bien modificar eso no requeria mucho retrabajo al usar dto, opté por simplificarlo y filtrar
    //por modelo ya que en sí la logica es igual al momento de practicar

}
