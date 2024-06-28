package empleadosNOSQL.empleadosNOSQL.service;

import empleadosNOSQL.empleadosNOSQL.domain.Empleado;
import empleadosNOSQL.empleadosNOSQL.repository.IEmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmpleadoServiceImpl implements IEmpleadoService {
    private final IEmpleadoRepository empleadoRepository;

    @Override
    public Empleado guardar(Empleado empleado){
        return empleadoRepository.save(empleado);
    }

}
