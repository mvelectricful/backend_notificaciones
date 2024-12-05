package com.mv.notificaciones.mv_notificaciones.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "ejecucion")
public class Ejecucion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ejecucion")
    private Long idEjecucion;
    private String fecha;
    private String hora;
    private String observacion;
    private String foto;
    private String foto2;
    @ManyToOne
    @JoinColumn(name = "fk_accion_codigo")
    private Acciones fk_accion_codigo;

    @OneToOne
    @JoinColumn(name = "fk_orden_id",referencedColumnName ="num_orden",unique = true)
    @JsonBackReference
    private Orden fkOrden;

    public Ejecucion(){

    }

    public Ejecucion(Long idEjecucion) {
        this.idEjecucion = idEjecucion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getFoto2() {
        return foto2;
    }

    public void setFoto2(String foto2) {
        this.foto2 = foto2;
    }

    public Acciones getFk_accion_codigo() {
        return fk_accion_codigo;
    }

    public void setFk_accion_codigo(Acciones fk_accion_codigo) {
        this.fk_accion_codigo = fk_accion_codigo;
    }

    public Orden getFkOrden() {
        return fkOrden;
    }

    public void setFkOrden(Orden fkOrden) {
        this.fkOrden = fkOrden;
    }
}
