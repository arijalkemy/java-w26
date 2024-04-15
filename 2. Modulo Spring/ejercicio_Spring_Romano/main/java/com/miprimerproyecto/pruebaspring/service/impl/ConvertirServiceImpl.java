package com.miprimerproyecto.pruebaspring.service.impl;

import com.miprimerproyecto.pruebaspring.service.IConvertirService;
import org.springframework.stereotype.Service;

@Service
public class ConvertirServiceImpl implements IConvertirService
{
    @Override
    public int numero(int numero) {
        return numero;
    }

}
