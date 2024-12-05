package com.mv.notificaciones.mv_notificaciones.services;

import com.mv.notificaciones.mv_notificaciones.entities.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User save(User user);

}
