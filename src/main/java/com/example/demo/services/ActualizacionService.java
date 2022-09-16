package com.example.demo.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.demo.models.ActualizacionModel;
import com.example.demo.repositories.ActualizacionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ActualizacionService {
    @Autowired
    ActualizacionRepository actualizacionRepository;

    public ActualizacionService(ActualizacionRepository actualizacionRepository) {
        this.actualizacionRepository = actualizacionRepository;
    }

    public ArrayList<ActualizacionModel> obtenerActualizacion() {
       return  (ArrayList<ActualizacionModel>) actualizacionRepository.findAll();
    }   

    public Optional<ActualizacionModel> obtenerPorId(Integer id) { 

        return actualizacionRepository.findById(id);
    }

    public ArrayList<ActualizacionModel> obtenerPorObs(String obs) {
        String likePattern = "%"+obs+"%";
        return actualizacionRepository.findByObservacionLike(likePattern);
    }

    public ActualizacionModel guardarActualizacion( ActualizacionModel act) {   
            return actualizacionRepository.save(act);
    }

    public ArrayList<ActualizacionModel> obtenerPorUser(String user) {
        return actualizacionRepository.findByUsuario(user);
    }

    public ResponseEntity<?> borrarActualizacion(Integer id) {
        actualizacionRepository.deleteById(id);
        return null;         
    }

    public ArrayList<ActualizacionModel> obtenerFechaFin() {
        return actualizacionRepository.findByfechaFinActualizacionIsNull();
    }


    public Collection<ActualizacionModel> findByUsuario(String user) {

        Collection<ActualizacionModel> todos = (Collection<ActualizacionModel>) actualizacionRepository.findAll();

        return todos.stream().filter(
                ActualizacionModel -> ActualizacionModel.getUsuario() == user)
                .collect(Collectors.toList());
    }
}
