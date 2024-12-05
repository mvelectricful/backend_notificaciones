package com.mv.notificaciones.mv_notificaciones.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_notificacion")
public class TipoNotificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_notificacion")
    private Long idTipoNotificacion;
    @Column(name = "nombre_tipo")
    private String nombreTipo;

    public TipoNotificacion() {
    }

    public TipoNotificacion(Long idTipoNotificacion) {
        this.idTipoNotificacion = idTipoNotificacion;
    }

    public Long getIdTipoNotificacion() {
        return idTipoNotificacion;
    }

    public void setIdTipoNotificacion(Long idTipoNotificacion) {
        this.idTipoNotificacion = idTipoNotificacion;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }
}
