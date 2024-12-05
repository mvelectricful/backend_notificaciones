package com.mv.notificaciones.mv_notificaciones.services;

import com.mv.notificaciones.mv_notificaciones.entities.Empleado;

import java.util.List;
import java.util.Optional;

public interface EmpleadoService {
    List<Empleado>findAll();
    Optional<Empleado>findById(Long idEmpleado);
    Empleado save(Empleado empleado);
    Optional<Empleado>update(Long idEmpleado,Empleado empleado);
    Optional<Empleado>delete(Long idEmpleado);
}
