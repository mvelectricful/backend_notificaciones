package com.mv.notificaciones.mv_notificaciones.services;

import com.mv.notificaciones.mv_notificaciones.entities.Acciones;
import com.mv.notificaciones.mv_notificaciones.repositories.AccionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AccionesServiceImpl implements AccionesService{
    @Autowired
    private AccionesRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Acciones> findAll() {
        return (List<Acciones>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Acciones> findById(Long idAccion) {
        return repository.findById(idAccion);
    }

    @Transactional
    @Override
    public Acciones save(Acciones accion) {
        return repository.save(accion);
    }

    @Transactional
    @Override
    public Optional<Acciones> update(Long idAccion, Acciones accion) {
        Optional<Acciones> accionesOptional = repository.findById(idAccion);
        if(accionesOptional.isPresent()){
            Acciones accionDb = accionesOptional.orElseThrow();
            accionDb.setNombreAccion(accion.getNombreAccion());
            accionDb.setCodigoAccion(accion.getCodigoAccion());
            accionDb.setDescripcionAccion(accion.getDescripcionAccion());
            accionDb.setValorAccion(accion.getValorAccion());
            accionDb.setCargaAccion(accion.getCargaAccion());
            return Optional.of(repository.save(accionDb));
        }
        return accionesOptional;
    }

    @Transactional
    @Override
    public Optional<Acciones> delete(Long idAccion) {
        Optional<Acciones>accionesDb = repository.findById(idAccion);
        accionesDb.ifPresent(acc->{
            repository.delete(acc);
        });
        return accionesDb;
    }
}
