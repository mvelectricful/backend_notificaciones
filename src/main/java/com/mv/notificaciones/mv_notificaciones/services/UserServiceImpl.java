package com.mv.notificaciones.mv_notificaciones.services;

import com.mv.notificaciones.mv_notificaciones.entities.Rol;
import com.mv.notificaciones.mv_notificaciones.entities.User;
import com.mv.notificaciones.mv_notificaciones.repositories.RolRepository;
import com.mv.notificaciones.mv_notificaciones.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return (List<User>) repository.findAll();
    }

    @Override
    @Transactional
    public User save(User user) {
        Optional<Rol> optionalRolUser = rolRepository.findByNombreRol("ROLE_USER");
        List<Rol>roles = new ArrayList<>();
        optionalRolUser.ifPresent(roles::add);
        if(user.isAdmin()){
            Optional<Rol> optionalRolAdmin = rolRepository.findByNombreRol("ROLE_ADMIN");
            optionalRolAdmin.ifPresent(roles::add);
        }
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }
}
