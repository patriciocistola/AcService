package com.example.demo.controllers;

import com.example.demo.models.ActualizacionModel;
import com.example.demo.repositories.ActualizacionRepository;
import com.example.demo.services.ActualizacionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ActualizacionControllerTest {

    @Mock
    private ActualizacionService actualizacionservice;

    @InjectMocks
    private ActualizacionRepository actualizacionRepository;

    @Test
    public void shouldReturnMessage() throws Exception {

        ActualizacionModel testUser  = new ActualizacionModel(1,"patricio","prueba",null,null,1);

        Mockito.when(actualizacionRepository.save(testUser));

        final ActualizacionModel resultado = actualizacionservice.guardarActualizacion(testUser);

        Assertions.assertEquals(resultado.usuario, testUser.usuario);
        Assertions.assertEquals(resultado.observacion, testUser.observacion);

        Mockito.verify(actualizacionRepository.findById(7));

    }
}