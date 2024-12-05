package com.mv.notificaciones.mv_notificaciones.services;

import com.mv.notificaciones.mv_notificaciones.entities.Ejecucion;

import java.util.List;
import java.util.Optional;

public interface EjecucionService {
    List<Ejecucion> findAll();
    Optional<Ejecucion>findById(Long idEjecucion);
    Ejecucion save(Ejecucion ejecucion);
    Optional<Ejecucion> update(Long idEjecucion,Ejecucion ejecucion);
    Optional<Ejecucion>delete(Long idEjecucion);
    Iterable<Ejecucion>saveAll(Iterable<Ejecucion> ejecuciones);

}
