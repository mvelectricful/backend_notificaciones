package com.mv.notificaciones.mv_notificaciones.controllers;

import com.mv.notificaciones.mv_notificaciones.entities.Empleado;
import com.mv.notificaciones.mv_notificaciones.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService serviceEmpleado;

    @GetMapping
    public List<Empleado> list(){
        return serviceEmpleado.findAll();
    }

}
