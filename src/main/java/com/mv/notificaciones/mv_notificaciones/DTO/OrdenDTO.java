package com.mv.notificaciones.mv_notificaciones.DTO;

import com.mv.notificaciones.mv_notificaciones.entities.Ejecucion;
import com.mv.notificaciones.mv_notificaciones.entities.Empleado;
import com.mv.notificaciones.mv_notificaciones.entities.TipoNotificacion;
import jakarta.persistence.*;

public class OrdenDTO {
    private Long idOrden;

    private String orden;
    private String nombreCliente;
    private String tarifaCliente;
    private String telefono;
    private String direccion;
    private String parroquia;
    private String barrio;
    private String piso;
    private String deuda;
    private String antiguedad;
    private String numeroMedidor;
    private String cuentaContrato;
    private String cuen;
    private String marcaMedidor;
    private String latitud;
    private String longitud;
    private String numCarga;
    private String fechaCarga;
    private String mru;
    private String porcion;
    private String plan;
    private String zona;
    private String sector;
    private String ruta;
    private String secuencia;
    private TipoNotificacion fkTipoNotificacion;
    private Empleado fkEmpleadoId;
    private Ejecucion ejecucionId;
    private Integer total;

    public OrdenDTO(String fechaCarga, String mru, String plan, String zona, String sector, String ruta,Integer total) {
        this.fechaCarga = fechaCarga;
        this.mru = mru;
        this.plan = plan;
        this.zona = zona;
        this.ruta = ruta;
        this.sector = sector;
        this.total = total;
    }
    public OrdenDTO(Empleado empleado,String fechaCarga, String mru, Integer total) {
        this.fkEmpleadoId = empleado;
        this.fechaCarga = fechaCarga;
        this.mru = mru;
        this.total = total;
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

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "{" +
                "fechaCarga='" + fechaCarga + '\'' +
                ", mru='" + mru + '\'' +
                ", porcion='" + porcion + '\'' +
                ", plan='" + plan + '\'' +
                ", zona='" + zona + '\'' +
                ", sector='" + sector + '\'' +
                ", ruta='" + ruta + '\'' +
                ", total=" + total +
                '}';
    }
}
