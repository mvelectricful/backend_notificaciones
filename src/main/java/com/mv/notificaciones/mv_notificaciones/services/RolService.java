package com.mv.notificaciones.mv_notificaciones.services;

import com.mv.notificaciones.mv_notificaciones.entities.Rol;


import java.util.List;
import java.util.Optional;

public interface RolService {
    List<Rol> findAll();
    Optional<Rol>findById(Long idRol);
    Rol save(Rol rol);
    Optional<Rol>update(Long idRol,Rol rol);
    Optional<Rol>delete(Long idRol);
}
