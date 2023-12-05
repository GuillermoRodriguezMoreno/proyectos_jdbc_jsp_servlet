package org.iesvdm.actividad_2_9.servlet;

import jakarta.servlet.http.HttpServletRequest;
import org.iesvdm.actividad_2_9.models.Usuario;

import java.util.Objects;
import java.util.Optional;

public class UtilsServlet {

    public static Optional<Usuario> validaGrabarUsuario(HttpServletRequest request){

        String nombreUsuario = null;
        String contraseña = null;
        String flag = null;
        String error = null;

        try {

            flag = "nombre";

            Objects.requireNonNull(request.getParameter("usuario"));

            if (request.getParameter("usuario").isBlank()) {

                error = "Parámetro vacío o todo espacios blancos.";
                throw new RuntimeException("Parámetro vacío o todo espacios blancos.");
            }

            nombreUsuario = request.getParameter("usuario");

            flag = "contraseña";

            Objects.requireNonNull(request.getParameter("contraseña"));

            if (request.getParameter("contraseña").isBlank()) {

                error = "Parámetro vacío o todo espacios blancos.";
                throw new RuntimeException("Parámetro vacío o todo espacios blancos.");
            }

            contraseña = request.getParameter("contraseña");

            return Optional.of(new Usuario(nombreUsuario, contraseña));

        }catch (Exception e){

            e.printStackTrace();

            request.setAttribute("error", "Error en el campo " + flag + ": " + error);
            return Optional.empty();

        }
    }
}
