package com.asignacion.edad.demo.controlador;

import com.asignacion.edad.demo.servicio.IAsignacionEdad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorAsignacionEdad {
    @Autowired
    private IAsignacionEdad miAsignacionEdad;
    //Punto de acceso para la optencion del Día, Mes y Agno de nacimiento de una persona
    @GetMapping(path = "/edad/{dia}/{mes}/{agno}")
    public Integer solicitarDatosNacimiento(@PathVariable Integer dia, @PathVariable Integer mes,
                        @PathVariable Integer agno){
            miAsignacionEdad.calcularEdad(dia,mes,agno);
        return miAsignacionEdad.asignarEdad();
    }
}
