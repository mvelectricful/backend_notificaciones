package com.mv.notificaciones.mv_notificaciones.repositories;
import com.mv.notificaciones.mv_notificaciones.entities.Orden;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrdenRepository extends JpaRepository<Orden,Long> {
    @Query("SELECT o FROM Orden o WHERE o.cuentaContrato = :cuentaContrato")
    List<Orden> findByCuentaContrato(@Param("cuentaContrato") String cuentaContrato);
    Page<Orden>findByFechaCarga(String fechaCarga,Pageable pageable);
}
