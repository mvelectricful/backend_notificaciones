package com.mv.notificaciones.mv_notificaciones.repositories;

import com.mv.notificaciones.mv_notificaciones.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
