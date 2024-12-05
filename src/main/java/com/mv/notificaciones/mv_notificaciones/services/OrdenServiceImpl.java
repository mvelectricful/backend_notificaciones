package com.mv.notificaciones.mv_notificaciones.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.mv.notificaciones.mv_notificaciones.DTO.OrdenDTO;
import com.mv.notificaciones.mv_notificaciones.entities.Ejecucion;
import com.mv.notificaciones.mv_notificaciones.entities.Orden;
import com.mv.notificaciones.mv_notificaciones.repositories.EjecucionRepository;
import com.mv.notificaciones.mv_notificaciones.repositories.OrdenRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrdenServiceImpl implements OrdenService {

    @Autowired
    private OrdenRepository repository;
    @Autowired
    private EjecucionRepository repositoryEjecucion;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Orden> findAll() {
        return (List<Orden>)repository.findAll();
    }

    @Transactional
    @Override
    public Optional<Orden> findByID(Long idOrden) {
        return repository.findById(idOrden);
    }

    @Transactional
    @Override
    public Orden save(Orden orden) {
        Orden ordenCreada = repository.save(orden);
        Ejecucion ejecucionOrden = new Ejecucion();
        ejecucionOrden.setFkOrden(orden);
        repositoryEjecucion.save(ejecucionOrden);
        return ordenCreada;
    }
    @Transactional
    @Override
    public Optional<Orden> update(Long idOrden, Orden orden) {
        Optional<Orden> ordenOptional = repository.findById(idOrden);
        if(ordenOptional.isPresent()){
            //aun no implementado
            Orden ordenDb = ordenOptional.orElseThrow();
        }
        return ordenOptional;
    }
    @Transactional
    @Override
    public Optional<Orden> delete(Long idOrden) {
        Optional<Orden>ordenDb = repository.findById(idOrden);
        ordenDb.ifPresent(ord->{
            repository.delete(ord);
        });
        return ordenDb;
    }

    @Transactional
    @Override
    public Iterable<Orden> saveAll(Iterable<Orden> ordenes) {
        Iterable<Orden> itOrdenes =  repository.saveAll(ordenes);
        for(Orden orden : ordenes){
            Ejecucion ejecucion = new Ejecucion();
            ejecucion.setFkOrden(orden);
            repositoryEjecucion.save(ejecucion);
        }
        return itOrdenes;
    }
    @Transactional(readOnly = true)
    @Override
    public List<OrdenDTO> getDistribucion(Orden orden) {
        String sql = "SELECT fecha_carga ,mru,plan,zona,sector,ruta,count(*) as Total from orden " +
                " WHERE fecha_carga = :fechaCarga AND fk_tipo_notificacion = :tipo  AND fk_empleado_id is null "+
                " group by mru order by mru";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("fechaCarga", orden.getFechaCarga());
        query.setParameter("tipo", orden.getFkTipoNotificacion().getIdTipoNotificacion());
        List<Object[]> resultados = query.getResultList();
        return resultados.stream().map(result->{
                    String fechaCargaObtenida = (String) result[0];
                    String mru = (String) result[1];
                    String plan = (String) result[2];
                    String zona = (String) result[3];
                    String sector = (String) result[4];
                    String ruta = (String) result[5];
                    Integer total = (result[6] != null) ? ((Number) result[6]).intValue() : null;
                    return new OrdenDTO(fechaCargaObtenida,mru,plan,zona,sector,ruta,total);
                }
        ).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public Integer setAsignacionDistribucion(List<JsonNode> ordenes) {
        Integer totalIngresados=0;
        for(JsonNode orden : ordenes){
            String sql = "UPDATE orden SET fk_empleado_id = :idEmpleado WHERE fecha_carga = :fechaCarga AND mru = :mruIngresado AND fk_empleado_id is null LIMIT :total";
            Query query = entityManager.createNativeQuery(sql);
            query.setParameter("idEmpleado",orden.get("fkEmpleadoId").asText());
            query.setParameter("fechaCarga",orden.get("fechaCarga").asText());
            query.setParameter("mruIngresado",orden.get("mru").asText());
            query.setParameter("total",orden.get("total").asInt());
             totalIngresados = query.executeUpdate();
        }
        return totalIngresados;
    }

    @Override
    public List<Orden> findByIdCuentaContrato(String cuentaContrato) {
        return repository.findByCuentaContrato(cuentaContrato);
    }

    @Override
    public Page<Orden> findAllPerDateWithPagination(int offset, int pageSize) {
        Page<Orden> ordenes = repository.findAll(PageRequest.of(offset,pageSize));
        return ordenes;
    }

    @Override
    public Page<Orden> findByFechaCargaWithPagination(String fechaCarga, int offset,int pageSize) {
        return repository.findByFechaCarga(fechaCarga,PageRequest.of(offset,pageSize));
    }


}
