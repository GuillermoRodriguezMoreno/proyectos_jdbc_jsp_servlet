package org.iesvdm.actividad_2_9.dao;

import org.iesvdm.actividad_2_9.models.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioDAO {

    public void create(Usuario usuario);

    public List<Usuario> getAll();

    public void update(Usuario usuario);

    public Optional<Usuario> find(String nombreUsuario);


    public void delete(String nombre);
}
