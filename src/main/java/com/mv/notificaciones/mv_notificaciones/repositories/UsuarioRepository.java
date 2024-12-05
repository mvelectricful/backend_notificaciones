package com.mv.notificaciones.mv_notificaciones.repositories;

import com.mv.notificaciones.mv_notificaciones.entities.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario,Long> {
}
