package com.mv.notificaciones.mv_notificaciones.services;

import com.mv.notificaciones.mv_notificaciones.entities.TipoNotificacion;
import com.mv.notificaciones.mv_notificaciones.repositories.TipoNotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class TipoNotificacionServiceImpl implements TipoNotificacionService{

    @Autowired
    private TipoNotificacionRepository repository;
    @Override
    public List<TipoNotificacion> findAll() {
        return (List<TipoNotificacion>) repository.findAll();
    }

    @Override
    public Optional<TipoNotificacion> findById(Long idTipo) {
        return repository.findById(idTipo);
    }
    @Transactional
    @Override
    public TipoNotificacion save(TipoNotificacion tipo) {
        return repository.save(tipo);
    }
    @Transactional
    @Override
    public Optional<TipoNotificacion> update(Long idTipo, TipoNotificacion tipo) {
        Optional<TipoNotificacion>tipoOptional = repository.findById(idTipo);
        if(tipoOptional.isPresent()){
            TipoNotificacion tipoDb = tipoOptional.orElseThrow();
            tipoDb.setNombreTipo(tipo.getNombreTipo());
            return Optional.of(repository.save(tipoDb));
        }
        return tipoOptional;
    }
    @Transactional
    @Override
    public Optional<TipoNotificacion> delete(Long idTipo) {
        Optional<TipoNotificacion>tipoOpt = repository.findById(idTipo);
        tipoOpt.ifPresent(tipo->{
            repository.delete(tipo);
        });
        return tipoOpt;
    }
}
