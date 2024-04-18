package com.EjercicioSpring.Ejercicio11_Excepciones.service.interfaces;

import com.EjercicioSpring.Ejercicio11_Excepciones.dto.BlogDTO;

import java.util.List;

public interface IBlogService {

    public boolean crearLibro(BlogDTO blogDTO);
    public BlogDTO obtenerLibroPorId(Long id);
    public List<BlogDTO> obtenerBlogs();

}
