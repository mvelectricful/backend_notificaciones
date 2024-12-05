package com.mv.notificaciones.mv_notificaciones.repositories;

import com.mv.notificaciones.mv_notificaciones.entities.Rol;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RolRepository extends CrudRepository<Rol,Long> {
    Optional<Rol> findByNombreRol(String nombreRol);
}
