package org.iesvdm.actividad_2_9.dao;

import org.iesvdm.actividad_2_9.models.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioDAOImpl extends AbstractDAOImpl implements UsuarioDAO {
    @Override
    public void create(Usuario usuario) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();


            //1 alternativas comentadas:
            //Ver también, AbstractDAOImpl.executeInsert ...
            //Columna fabricante.codigo es clave primaria auto_increment, por ese motivo se omite de la sentencia SQL INSERT siguiente.
            ps = conn.prepareStatement("INSERT INTO usuario VALUES (?, ?)");

            int idx = 1;
            ps.setString(idx++, usuario.getUsuario());
            ps.setString(idx++, usuario.getContraseña());

            int rows = ps.executeUpdate();
            if (rows == 0)
                System.out.println("INSERT de usuario con 0 filas insertadas.");

        } catch (SQLException | ClassNotFoundException  e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }

    }

    @Override
    public List<Usuario> getAll() {

        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;

        List<Usuario> listUsuario = new ArrayList<>();

        try {
            conn = connectDB();

            // Se utiliza un objeto Statement dado que no hay parámetros en la consulta.
            s = conn.createStatement();

            rs = s.executeQuery("SELECT * FROM usuario");
            while (rs.next()) {
                Usuario usuario = new Usuario();

                usuario.setUsuario(rs.getString("usuario"));
                usuario.setContraseña(rs.getString("contraseña"));

                listUsuario.add(usuario);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, s, rs);
        }
        return listUsuario;

    }

    @Override
    public Optional<Usuario> find(String nombreUsuario) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("SELECT * FROM usuario WHERE usuario = ?");

            ps.setString(1, nombreUsuario);

            rs = ps.executeQuery();

            if (rs.next()) {
                Usuario usuario = new Usuario();

                usuario.setUsuario(rs.getString("usuario"));
                usuario.setContraseña(rs.getString("contraseña"));

                return Optional.of(usuario);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }

        return Optional.empty();

    }

    @Override
    public void update(Usuario usuario) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("UPDATE usuario SET usuario = ?, contraseña = ? WHERE usuario = ?");
            int idx = 1;
            ps.setString(idx++, usuario.getUsuario());
            ps.setString(idx++, usuario.getContraseña());

            int rows = ps.executeUpdate();

            if (rows == 0)
                System.out.println("Update de usuario con 0 registros actualizados.");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }

    }

    @Override
    public void delete(String nombre) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("DELETE FROM usuario WHERE usuario = ?");
            int idx = 1;
            ps.setString(idx, nombre);

            int rows = ps.executeUpdate();

            if (rows == 0)
                System.out.println("Delete de usuario con 0 registros eliminados.");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }

    }
}
