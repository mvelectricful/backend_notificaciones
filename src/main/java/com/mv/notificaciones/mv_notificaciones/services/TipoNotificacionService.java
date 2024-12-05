package com.mv.notificaciones.mv_notificaciones.services;

import com.mv.notificaciones.mv_notificaciones.entities.TipoNotificacion;

import java.util.List;
import java.util.Optional;

public interface TipoNotificacionService {
    List<TipoNotificacion> findAll();
    Optional<TipoNotificacion> findById(Long idTipo);
    TipoNotificacion save(TipoNotificacion tipo);
    Optional<TipoNotificacion> update(Long idTipo,TipoNotificacion tipo);
    Optional<TipoNotificacion> delete(Long idTipo);

}
