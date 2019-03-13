/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.controller;

import com.helloworld.apispring.model.entity.Ciudadano;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class Controller {

    @Autowired
    private CiudadanoServicio ciudadanoServicio;

    @RequestMapping(value = "/ciudadanos/", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> crearPersona(@RequestBody Ciudadano ciudadano) {
        System.out.println(ciudadano.getId());
        String resultado = "Se creo persona con ID: " + ciudadanoServicio.crearPersona(ciudadano);
        return new ResponseEntity<String>(resultado, HttpStatus.OK);
    }

    @RequestMapping(value = "/ciudadanos/{id}", method = RequestMethod.GET)
    public ResponseEntity<Ciudadano> ObtenerCiudadanoPorId(@PathVariable("id") long id) {
        Ciudadano ciudadano = ciudadanoServicio.ObtenerCiudadanoPorId(id);
        return new ResponseEntity<Ciudadano>(ciudadano, HttpStatus.OK);
    }

    @RequestMapping(value = "/ciudadanos/", method = RequestMethod.GET)
    public ResponseEntity<List<Ciudadano>> obtenerCiudadanos() {
        List<Ciudadano> ciudadano = ciudadanoServicio.MostrarCiudadanos();
        return new ResponseEntity<List<Ciudadano>>(ciudadano, HttpStatus.OK);
    }
    
    
    

}
