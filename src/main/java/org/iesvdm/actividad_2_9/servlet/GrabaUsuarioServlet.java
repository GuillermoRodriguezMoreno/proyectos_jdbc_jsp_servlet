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

@WebServlet(name = "GrabarUsuarioServlet", value = "/GrabarUsuarioServlet")
public class GrabaUsuarioServlet extends HttpServlet {

    private UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = null;

        Optional<Usuario> optUsuario = UtilsServlet.validaGrabar(request);

        if(optUsuario.isPresent()){

            Usuario usuario = optUsuario.get();

            this.usuarioDAO.create(usuario);

            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/accesoPermitido.jsp");

        }else {

            dispatcher = request.getRequestDispatcher("/index.jsp");

        }

        dispatcher.forward(request, response);
    }
}
