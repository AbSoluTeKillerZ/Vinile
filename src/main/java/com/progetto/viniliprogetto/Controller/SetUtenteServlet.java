package com.progetto.viniliprogetto.Controller;


import com.progetto.viniliprogetto.DAO.UtenteDAO;
import com.progetto.viniliprogetto.Model.Utente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/setutente")
public class SetUtenteServlet extends HttpServlet {/*
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Utente utente = (Utente) session.getAttribute("utente");
        if (utente != null && utente.isAdmin() == true) {
            UtenteDAO dao = new UtenteDAO();
            String idutente = request.getParameter("id");
            String flag = request.getParameter("id1");
            int id = 0;
            try {
                id = Integer.parseInt(idutente);
            } catch (NumberFormatException er) {
                throw new MyServletException("Utente non trovato!");
            }
            Utente user = null;
            try {
                user = dao.doRetrieveById(id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (user == null) throw new MyServletException("Utente non trovato!");
            if (flag.equals("0")) {
                try {
                    dao.doSetAdmin(user, false);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else if (flag.equals("1")) {
                try {
                    dao.doSetAdmin(user, true);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                throw new MyServletException("Errore parametri");
            }
            response.sendRedirect("gestisciutenti");
        } else {
            throw new MyServletException("Sezione dedicata agli admin!");
        }
    }*/
}
