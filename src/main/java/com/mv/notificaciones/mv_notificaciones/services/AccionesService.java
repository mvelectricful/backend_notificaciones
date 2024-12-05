package com.mv.notificaciones.mv_notificaciones.services;

import com.mv.notificaciones.mv_notificaciones.entities.Acciones;

import java.util.List;
import java.util.Optional;

public interface AccionesService {

    List<Acciones> findAll();
    Optional<Acciones>findById(Long idAccion);
    Acciones save(Acciones accion);
    Optional<Acciones>update(Long idAccion,Acciones accion);
    Optional<Acciones>delete(Long idAccion);
}
