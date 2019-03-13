/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.controller;

import com.helloworld.apispring.model.dao.CiudadanoRepositorio;
import com.helloworld.apispring.model.entity.Ciudadano;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Lucho Pinilla
 */
@Component
public class CiudadanoServicio {

    @Autowired
    private CiudadanoRepositorio ciudadanoRepositorio;

    public CiudadanoServicio() {
    }

    public long crearPersona(Ciudadano ciudadano) {
        return ciudadanoRepositorio.crearPersona(ciudadano);
    }

    public Ciudadano ObtenerCiudadanoPorId(long id) {
        
        return ciudadanoRepositorio.ObtenerCiudadanoPorId(id);
 
    }

    public List<Ciudadano> MostrarCiudadanos() {
       return ciudadanoRepositorio.MostrarCiudadanos();
    }

}
