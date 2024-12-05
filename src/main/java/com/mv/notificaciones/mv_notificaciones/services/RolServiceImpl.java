package com.mv.notificaciones.mv_notificaciones.services;
import com.mv.notificaciones.mv_notificaciones.entities.Rol;
import com.mv.notificaciones.mv_notificaciones.repositories.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImpl implements RolService{

    @Autowired
    private RolRepository repository;

    @Override
    public List<Rol> findAll() {
        return (List<Rol>) repository.findAll();
    }

    @Override
    public Optional<Rol> findById(Long idRol) {
        return repository.findById(idRol);
    }
    @Transactional
    @Override
    public Rol save(Rol rol) {
        return repository.save(rol);
    }
    @Transactional
    @Override
    public Optional<Rol> update(Long idRol, Rol rol) {
        Optional<Rol>rolOptional = repository.findById(idRol);
        if(rolOptional.isPresent()){
            Rol rolDb = rolOptional.orElseThrow();
            rolDb.setNombreRol(rol.getNombreRol());
            return Optional.of(rolDb);
        }
        return rolOptional;
    }
    @Transactional
    @Override
    public Optional<Rol> delete(Long idRol) {
        Optional<Rol>optionalRol = repository.findById(idRol);
        optionalRol.ifPresent(rol -> {
            repository.delete(rol);
        });
        return optionalRol;
    }
}
