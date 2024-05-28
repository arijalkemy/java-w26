package empleadosNOSQL.empleadosNOSQL.controller;


import empleadosNOSQL.empleadosNOSQL.domain.Empleado;
import empleadosNOSQL.empleadosNOSQL.service.EmpleadoServiceImpl;
import empleadosNOSQL.empleadosNOSQL.service.IEmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Provider;

@RestController
@RequestMapping("/empleado")
@RequiredArgsConstructor
public class EmpleadoController {

    private final IEmpleadoService empleadoServiceImpl;

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Empleado empleado){
        Empleado empleadoGuardado = empleadoServiceImpl.guardar(empleado);
        return ResponseEntity.status(HttpStatus.CREATED).body(empleadoGuardado);
    }
}
