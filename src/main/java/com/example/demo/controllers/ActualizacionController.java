package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.ActualizacionModel;
import com.example.demo.services.ActualizacionService;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actualizacion")
public class ActualizacionController {
    @Autowired
    ActualizacionService actualizacionService;

    @ApiOperation("Retorna una lista con todas las actualizaciones")
    @GetMapping()
    public ArrayList<ActualizacionModel> obtenerActualizacion() {
        return actualizacionService.obtenerActualizacion();
    }
      
    @ApiOperation("Retorna una actualizacion por su id")
    @GetMapping(path = "/{id}")
    public Optional<ActualizacionModel> obtenerActualizacionPorId(@RequestParam(value="id") Integer id) {
        return this.actualizacionService.obtenerPorId(id);
    }

    @ApiOperation("Retorna una lista con todas las actualizaciones que contengan la observacion")
    @GetMapping(path = "/{obs}")
    public ArrayList<ActualizacionModel> obtenerActualizacionPorObs(@RequestParam(value="obs") String obs) {
        return this.actualizacionService.obtenerPorObs(obs);
    }

    @ApiOperation("Retorna una lista con todas las actualizaciones que contengan el usuario")
    @GetMapping(path = "/{user}")
    public ArrayList<ActualizacionModel> obtenerActualizacionPorUser(@RequestParam(value="user") String user) {
        return this.actualizacionService.obtenerPorUser(user);
    }

    @ApiOperation("Crea un objeto de tipo actualizacion")
    @PostMapping()
    public ActualizacionModel postActualizacion(@RequestBody ActualizacionModel actualizacion) {          
            return this.actualizacionService.guardarActualizacion(actualizacion);        
    }
   
    @ApiOperation("Modifica un objeto de tipo actualizacion")
    @PutMapping()
    public ActualizacionModel putActualizacion(@RequestBody ActualizacionModel actualizacion) {
        return this.actualizacionService.guardarActualizacion(actualizacion);
    }

    @ApiOperation("Elimina un objeto de tipo actualizacion")
    @RequestMapping(value="/{id}", method={RequestMethod.DELETE})
    public ResponseEntity<?> delActualizacion(@RequestParam(value="id") Integer id) {
         this.actualizacionService.borrarActualizacion(id);
        return ResponseEntity.ok().body("Se elimino correctamente la actualizacion con id : " + id);
    }
 
    @GetMapping(path = "/")
    public ArrayList<ActualizacionModel> obtenerActualizacionPorFechaFin() {
        return this.actualizacionService.obtenerFechaFin();
    }
 

}
