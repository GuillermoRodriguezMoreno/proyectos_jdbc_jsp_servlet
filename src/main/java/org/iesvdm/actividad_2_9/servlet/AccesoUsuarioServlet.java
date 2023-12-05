package org.iesvdm.actividad_2_9.servlet;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iesvdm.actividad_2_9.dao.UsuarioDAO;
import org.iesvdm.actividad_2_9.dao.UsuarioDAOImpl;
import org.iesvdm.actividad_2_9.models.Usuario;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "AccesoUsuarioServlet", value = "/AccesoUsuarioServlet")
public class AccesoUsuarioServlet extends HttpServlet {

    private UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Optional<Usuario> optUser = UtilsServlet.validaGrabarUsuario(request);
        String error = "";

        RequestDispatcher dispatcher = null;

        if (optUser.isPresent()){

            Usuario usuario = optUser.get();

            optUser = usuarioDAO.find(usuario.getUsuario());

            if(optUser.isPresent()){

                request.setAttribute("usuario", optUser.get());
                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/accesoPermitido.jsp");

            } else{

                error = "El Usuario no existe";
                request.setAttribute("error", error);
                dispatcher = request.getRequestDispatcher("/index.jsp");
            }


        }else {

            dispatcher = request.getRequestDispatcher("/index.jsp");
        }

        dispatcher.forward(request, response);
    }
}
