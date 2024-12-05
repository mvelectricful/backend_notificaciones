package com.mv.notificaciones.mv_notificaciones.controllers;



import com.mv.notificaciones.mv_notificaciones.entities.TipoNotificacion;
import com.mv.notificaciones.mv_notificaciones.services.TipoNotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipo")
public class TipoController {

    @Autowired
    private TipoNotificacionService serviceTipo;
    @GetMapping
    public List<TipoNotificacion> list(){
        return serviceTipo.findAll();
    }

    @PostMapping
    public ResponseEntity<TipoNotificacion>create(@RequestBody TipoNotificacion tipoNotificacion){
        TipoNotificacion tipoNew = serviceTipo.save(tipoNotificacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoNew);
    }


}
