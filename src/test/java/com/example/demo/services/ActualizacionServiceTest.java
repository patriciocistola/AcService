package com.example.demo.services;

import com.example.demo.models.ActualizacionModel;
import com.example.demo.repositories.ActualizacionRepository;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;

class ActualizacionServiceTest {

    @Test
    void obtenerPorUserTest() {

        //Mockeo el repositorio
        ActualizacionRepository actualizacionRepository = Mockito.mock(ActualizacionRepository.class);
        Mockito.when(actualizacionRepository.findAll()).thenReturn(
                Arrays.asList(
                        new ActualizacionModel(1,"patricio", "prueba", null, null, 1),
                        new ActualizacionModel(2,"Oscar", "prueba", null, null, 1),
                        new ActualizacionModel(3,"patricio", "prueba", null, null, 1),
                        new ActualizacionModel(4,"patricio", "prueba", null, null, 1)
                )
        );

        //Construyo el servicio con el repositorio
        ActualizacionService actualizacionService = new ActualizacionService(actualizacionRepository);

        //Invoco el metodo a testiar
        Collection<ActualizacionModel> ActPorUsuario = actualizacionService.findByUsuario("patricio");

        //Me quedo con los Ids de los que cumplen con el nombre de usuario pasado por parametro
        List<Integer> ActIds = ActPorUsuario.stream().map(ActualizacionModel -> ActualizacionModel.getId()).collect(Collectors.toList());

        //Comparo los ids que deberia traer con los que tengo en ActIds
        assertThat(ActIds, CoreMatchers.is(Arrays.asList(1,3,4)));

    }
}