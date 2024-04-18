package com.bootcampjava.blogapirest.repository;

import com.bootcampjava.blogapirest.model.EntradaBlog;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IEntradaBlogRepository {
    HashMap<Integer,EntradaBlog>  obtenerTodas();
    EntradaBlog traerUnaPorId(Integer id);
    EntradaBlog cargarUno(EntradaBlog nuevaEntrada);
}
