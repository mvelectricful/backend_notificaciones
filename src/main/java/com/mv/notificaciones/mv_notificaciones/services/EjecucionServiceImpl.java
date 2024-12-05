package com.mv.notificaciones.mv_notificaciones.services;

import com.mv.notificaciones.mv_notificaciones.entities.Ejecucion;
import com.mv.notificaciones.mv_notificaciones.repositories.EjecucionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EjecucionServiceImpl implements EjecucionService{

    @Autowired
    private EjecucionRepository repository;

    @Override
    public List<Ejecucion> findAll() {
        return (List<Ejecucion>)repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Ejecucion> findById(Long idEjecucion) {
        return repository.findById(idEjecucion);
    }
    @Transactional
    @Override
    public Ejecucion save(Ejecucion ejecucion) {
        return repository.save(ejecucion);
    }
    @Transactional
    @Override
    public Optional<Ejecucion> update(Long idEjecucion, Ejecucion ejecucion) {
        Optional<Ejecucion> ejecucionOptional = repository.findById(idEjecucion);
        if(ejecucionOptional.isPresent()){
            Ejecucion ejecucionDB = ejecucionOptional.orElseThrow();
            ejecucionDB.setFecha(ejecucion.getFecha());
            ejecucionDB.setHora(ejecucion.getHora());
            ejecucionDB.setFoto(ejecucion.getFoto());
            ejecucionDB.setFoto2(ejecucion.getFoto2());
            ejecucionDB.setObservacion(ejecucion.getObservacion());
            ejecucionDB.setFk_accion_codigo(ejecucion.getFk_accion_codigo());
            return Optional.of(repository.save(ejecucionDB));
        }
        return ejecucionOptional;
    }
    @Transactional
    @Override
    public Optional<Ejecucion> delete(Long idEjecucion) {
        Optional<Ejecucion> ejecucionDB = repository.findById(idEjecucion);
        ejecucionDB.ifPresent(eje->{
            repository.delete(eje);
        });
        return ejecucionDB;
    }

    @Transactional
    @Override
    public Iterable<Ejecucion> saveAll(Iterable<Ejecucion> ejecuciones) {
        return repository.saveAll(ejecuciones);
    }


}
