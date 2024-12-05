package com.mv.notificaciones.mv_notificaciones.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.mv.notificaciones.mv_notificaciones.DTO.OrdenDTO;
import com.mv.notificaciones.mv_notificaciones.entities.Orden;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface OrdenService {
    List<Orden>findAll();
    Optional<Orden> findByID(Long idOrden);
    Orden save(Orden orden);
    Optional<Orden>update(Long idOrden, Orden orden);
    Optional<Orden>delete(Long idOrden);
    Iterable<Orden>saveAll(Iterable<Orden> ordenes);
    List<OrdenDTO>getDistribucion(Orden orden);
    Integer setAsignacionDistribucion(List<JsonNode> ordenes);
    List<Orden> findByIdCuentaContrato(String cuentaContrato);

    Page<Orden> findAllPerDateWithPagination(int offset, int pageSize);
    Page<Orden>findByFechaCargaWithPagination(String fechaCarga, int offset,int pageSize);
}
