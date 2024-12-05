package com.mv.notificaciones.mv_notificaciones.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.mv.notificaciones.mv_notificaciones.DTO.APIResponse;
import com.mv.notificaciones.mv_notificaciones.DTO.OrdenDTO;
import com.mv.notificaciones.mv_notificaciones.entities.Orden;
import com.mv.notificaciones.mv_notificaciones.services.OrdenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenController {
    @Autowired
    private OrdenService serviceOrden;

    @GetMapping
    public List<Orden> list(){
        return serviceOrden.findAll();
    }
    @GetMapping("/pagination/{offset}/{pageSize}")
    public APIResponse<Page<Orden>> getOrdenesWithPagination(@PathVariable int offset, @PathVariable int pageSize){
        Page<Orden> ordenesWithPagination = serviceOrden.findAllPerDateWithPagination(offset,pageSize);
        return new APIResponse<>(ordenesWithPagination.getSize(),ordenesWithPagination);
    }
    @GetMapping("/consulta/{offset}/{pageSize}/{fechaCarga}")
    public APIResponse<Page<Orden>> getOrdersPerDateWithPagination(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String fechaCarga){
        Page<Orden> ordenesPerDateWithPagination = serviceOrden.findByFechaCargaWithPagination(fechaCarga,offset,pageSize);
        return new APIResponse<>(ordenesPerDateWithPagination.getSize(),ordenesPerDateWithPagination);
    }


    @GetMapping("/consulta/{cuentaContrato}")
    public List<Orden> viewByCuentaContrato (@PathVariable String cuentaContrato){
        return serviceOrden.findByIdCuentaContrato(cuentaContrato);
    }


    @PostMapping
    public Orden create(@RequestBody Orden orden){
        return serviceOrden.save(orden);
    }

    @PostMapping("/saveAll")
    public Iterable<Orden> createMasiva(@RequestBody Iterable<Orden>ordenes){
        return serviceOrden.saveAll(ordenes);
    }


    @PostMapping("/distribucion")
    public ResponseEntity<?> getDistribucion(@RequestBody Orden orden){
        List<OrdenDTO> ordenes = serviceOrden.getDistribucion(orden);
        return ordenes.size()>0 ? ResponseEntity.status(HttpStatus.CREATED).body(ordenes) : ResponseEntity.notFound().build();
    }

    @PutMapping("/asignacion")
    public ResponseEntity<?>asignacionTrabajos(@RequestBody List<JsonNode>ordenes) {
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceOrden.setAsignacionDistribucion(ordenes));
    }
}
