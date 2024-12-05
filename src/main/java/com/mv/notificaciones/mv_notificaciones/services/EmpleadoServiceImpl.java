package com.mv.notificaciones.mv_notificaciones.services;

import com.mv.notificaciones.mv_notificaciones.entities.Empleado;
import com.mv.notificaciones.mv_notificaciones.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

    @Autowired
    private EmpleadoRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Empleado> findAll() {
        return (List<Empleado>) repository.findAll();
    }

    @Override
    public Optional<Empleado> findById(Long idEmpleado) {
        return repository.findById(idEmpleado);
    }

    @Override
    public Empleado save(Empleado empleado) {
        return repository.save(empleado);
    }

    @Override
    public Optional<Empleado> update(Long idEmpleado, Empleado empleado) {
        Optional<Empleado>empleadoOptional = repository.findById(idEmpleado);
        if(empleadoOptional.isPresent()){
            Empleado empleadoDb = empleadoOptional.orElseThrow();
            empleadoDb.setAsignado(empleado.getAsignado());
            empleadoDb.setContratista(empleado.getContratista());
            empleadoDb.setFkIdUsuario(empleado.getFkIdUsuario());
            return Optional.of(repository.save(empleadoDb));
        }
        return empleadoOptional;
    }

    @Override
    public Optional<Empleado> delete(Long idEmpleado) {
        Optional<Empleado>empleadoDb = repository.findById(idEmpleado);
        empleadoDb.ifPresent(emp->{
            repository.delete(emp);
        });
        return empleadoDb;
    }
}
