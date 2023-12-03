package org.iesvdm.actividad_2_9.models;

import java.util.Objects;

public class Usuario {

    // Atributos

    private String usuario;
    private String contraseña;

    // Constructor

    public Usuario(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public Usuario() {

    }

    // Getters y Setters
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    // Metodos

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario1 = (Usuario) o;
        return Objects.equals(getUsuario(), usuario1.getUsuario()) && Objects.equals(getContraseña(), usuario1.getContraseña());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsuario(), getContraseña());
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "usuario='" + usuario + '\'' +
                ", contraseña='" + contraseña + '\'' +
                '}';
    }
}
