package com.mv.notificaciones.mv_notificaciones.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "usuario_rol")
public class UsuarioRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario_rol")
    private Long idUsuarioRol;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario fkIdUsuario;

    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false)
    private Rol fkIdRol;

    public UsuarioRol() {
    }

    public UsuarioRol(Long idUsuarioRol) {
        this.idUsuarioRol = idUsuarioRol;
    }

    public Usuario getFkIdUsuario() {
        return fkIdUsuario;
    }

    public void setFkIdUsuario(Usuario fkIdUsuario) {
        this.fkIdUsuario = fkIdUsuario;
    }

    public Rol getFkIdRol() {
        return fkIdRol;
    }

    public void setFkIdRol(Rol fkIdRol) {
        this.fkIdRol = fkIdRol;
    }
}
