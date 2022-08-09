package com.example.demo.repositories;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.ActualizacionModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActualizacionRepository extends CrudRepository<ActualizacionModel, Integer> {
   
   public Optional<ActualizacionModel> findById(Integer id);
   public ArrayList<ActualizacionModel> findByUsuario(String user);
   public ArrayList<ActualizacionModel> findByfechaFinActualizacionIsNull();
   public ArrayList<ActualizacionModel> findByObservacionLike(String likePattern);
  
}
