package com.mv.notificaciones.mv_notificaciones.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "acciones")
public class Acciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_accion")
    private Long idAccion;
    @Column(name = "nombre_accion")
    private String nombreAccion;
    @Column(name = "codigo_accion")
    private String codigoAccion;
    @Column(name = "descripcion_accion")
    private String descripcionAccion;
    @Column(name = "valor_accion")
    private String valorAccion;
    @Column(name = "carga_accion")
    private String cargaAccion;

    public Acciones() {
    }

    public Acciones(String nombreAccion, String codigoAccion, String descripcionAccion, String valorAccion, String cargaAccion) {
        this.nombreAccion = nombreAccion;
        this.codigoAccion = codigoAccion;
        this.descripcionAccion = descripcionAccion;
        this.valorAccion = valorAccion;
        this.cargaAccion = cargaAccion;
    }

    public String getNombreAccion() {
        return nombreAccion;
    }

    public void setNombreAccion(String nombreAccion) {
        this.nombreAccion = nombreAccion;
    }

    public String getCodigoAccion() {
        return codigoAccion;
    }

    public void setCodigoAccion(String codigoAccion) {
        this.codigoAccion = codigoAccion;
    }

    public String getDescripcionAccion() {
        return descripcionAccion;
    }

    public void setDescripcionAccion(String descripcionAccion) {
        this.descripcionAccion = descripcionAccion;
    }

    public String getValorAccion() {
        return valorAccion;
    }

    public void setValorAccion(String valorAccion) {
        this.valorAccion = valorAccion;
    }

    public String getCargaAccion() {
        return cargaAccion;
    }

    public void setCargaAccion(String cargaAccion) {
        this.cargaAccion = cargaAccion;
    }
}
