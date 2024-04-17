package com.example.edadpersonas.service.serviceImp;

import com.example.edadpersonas.service.IEdadPersona;
import com.example.edadpersonas.util.EdadPersonaUtil;
import org.springframework.stereotype.Service;

@Service
public class EdadPersonaService implements IEdadPersona {
    @Override
    public int getEdadPersona(int dia, int mes, int ano) {
        return EdadPersonaUtil.getEdadPersona(dia, mes, ano);
    }
}
