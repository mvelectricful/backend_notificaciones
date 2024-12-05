package com.mv.notificaciones.mv_notificaciones.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "orden")
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orden")
    private Long id;
    @Column(name = "num_orden",unique = true,length = 50,nullable = false)
    private String orden;
    @Column(name="nombre_cliente",length = 200)
    private String nombreCliente;
    @Column(name="tarifa_cliente",length = 45)
    private String tarifaCliente;
    @Column(name = "telefono",length = 25)
    private String telefono;
    private String direccion;
    private String parroquia;
    private String barrio;
    @Column(name = "piso",length = 45)
    private String piso;
    @Column(name = "deuda")
    private String deuda;
    @Column(name = "antiguedad",length = 5)
    private String antiguedad;
    @Column(name="numero_medidor",length = 45)
    private String numeroMedidor;
    @Column(name="cuenta_contrato",length = 45)
    private String cuentaContrato;
    @Column(name="cuen",length = 50)
    private String cuen;
    @Column(name="marca_medidor",length = 45)
    private String marcaMedidor;
    private String latitud;
    private String longitud;
    @Column(name="num_carga",length = 4)
    private String numCarga;
    @Column(name="fecha_carga")
    private String fechaCarga;
    @Column(name = "mru",length = 8)
    private String mru;
    @Column(name = "porcion",length = 8)
    private String porcion;
    @Column(name = "plan",length = 11)
    private String plan;
    @Column(name = "zona",length = 11)
    private String zona;
    @Column(name = "sector",length = 11)
    private String sector;
    @Column(name = "ruta",length = 11)
    private String ruta;
    @Column(name = "secuencia",length = 10)
    private String secuencia;
    @ManyToOne
    @JoinColumn(name = "fk_tipo_notificacion",nullable = false)
    private TipoNotificacion fkTipoNotificacion;
    @ManyToOne
    @JoinColumn(name = "fk_empleado_id",nullable = true)
    private Empleado fkEmpleadoId;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "fkOrden")
    @JsonManagedReference
    private Ejecucion ejecucionId;

    public Orden() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getTarifaCliente() {
        return tarifaCliente;
    }

    public void setTarifaCliente(String tarifaCliente) {
        this.tarifaCliente = tarifaCliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getParroquia() {
        return parroquia;
    }

    public void setParroquia(String parroquia) {
        this.parroquia = parroquia;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getDeuda() {
        return deuda;
    }

    public void setDeuda(String deuda) {
        this.deuda = deuda;
    }

    public String getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(String antiguedad) {
        this.antiguedad = antiguedad;
    }

    public String getNumeroMedidor() {
        return numeroMedidor;
    }

    public void setNumeroMedidor(String numeroMedidor) {
        this.numeroMedidor = numeroMedidor;
    }

    public String getCuentaContrato() {
        return cuentaContrato;
    }

    public void setCuentaContrato(String cuentaContrato) {
        this.cuentaContrato = cuentaContrato;
    }

    public String getCuen() {
        return cuen;
    }

    public void setCuen(String cuen) {
        this.cuen = cuen;
    }

    public String getMarcaMedidor() {
        return marcaMedidor;
    }

    public void setMarcaMedidor(String marcaMedidor) {
        this.marcaMedidor = marcaMedidor;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getNumCarga() {
        return numCarga;
    }

    public void setNumCarga(String numCarga) {
        this.numCarga = numCarga;
    }

    public String getFechaCarga() {
        return fechaCarga;
    }

    public void setFechaCarga(String fechaCarga) {
        this.fechaCarga = fechaCarga;
    }

    public String getMru() {
        return mru;
    }

    public void setMru(String mru) {
        this.mru = mru;
    }

    public String getPorcion() {
        return porcion;
    }

    public void setPorcion(String porcion) {
        this.porcion = porcion;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(String secuencia) {
        this.secuencia = secuencia;
    }

    public TipoNotificacion getFkTipoNotificacion() {
        return fkTipoNotificacion;
    }

    public void setFkTipoNotificacion(TipoNotificacion fkTipoNotificacion) {
        this.fkTipoNotificacion = fkTipoNotificacion;
    }

    public Empleado getFkEmpleadoId() {
        return fkEmpleadoId;
    }

    public void setFkEmpleadoId(Empleado fkEmpleadoId) {
        this.fkEmpleadoId = fkEmpleadoId;
    }

    public Ejecucion getEjecucionId() {
        return ejecucionId;
    }

    public void setEjecucionId(Ejecucion ejecucionId) {
        this.ejecucionId = ejecucionId;
    }

    @Override
    public String toString() {
        return "Orden{" +
                "id=" + id +
                ", orden='" + orden + '\'' +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", tarifaCliente='" + tarifaCliente + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", parroquia='" + parroquia + '\'' +
                ", barrio='" + barrio + '\'' +
                ", piso='" + piso + '\'' +
                ", deuda=" + deuda +
                ", antiguedad='" + antiguedad + '\'' +
                ", numeroMedidor='" + numeroMedidor + '\'' +
                ", cuentaContrato='" + cuentaContrato + '\'' +
                ", cuen='" + cuen + '\'' +
                ", marcaMedidor='" + marcaMedidor + '\'' +
                ", latitud='" + latitud + '\'' +
                ", longitud='" + longitud + '\'' +
                ", numCarga='" + numCarga + '\'' +
                ", fechaCarga=" + fechaCarga +
                ", mru='" + mru + '\'' +
                ", porcion='" + porcion + '\'' +
                ", plan='" + plan + '\'' +
                ", zona='" + zona + '\'' +
                ", sector='" + sector + '\'' +
                ", ruta='" + ruta + '\'' +
                ", secuencia='" + secuencia + '\'' +
                ", fkTipoNotificacion=" + fkTipoNotificacion +
                ", fkEmpleadoId=" + fkEmpleadoId +
                ", ejecucionId=" + ejecucionId +
                '}';
    }
}
