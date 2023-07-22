package com.progetto.viniliprogetto.Controller;

import com.progetto.viniliprogetto.Model.Indirizzo;

import javax.servlet.http.HttpServletRequest;

public class ProcessaIndirizzo {

    private ProcessaIndirizzo() {
    }

    public static Indirizzo getIndirizzoFromRequest(HttpServletRequest request) throws Exception {
        String strada = request.getParameter("via");
        String citta = request.getParameter("citta");
        String cap = request.getParameter("cap");
        String numeroCivico = request.getParameter("numero-civico");
        String telefono = request.getParameter("telefono");
        String error = "";
        if (strada == null || strada.trim().isEmpty())
            error += "Campo strada non valido; ";
        if (citta == null || citta.trim().isEmpty())
            error += "Citta non valida; ";
        if (cap == null || cap.trim().isEmpty() || cap.length() > 6 || !cap.matches("\\d+"))
            error += "Il cap non deve essere vuoto";
        if (numeroCivico == null || numeroCivico.trim().isEmpty())
            error += "Numero civico non valido; ";
        if (telefono == null || telefono.trim().isEmpty() || !telefono.matches("\\d+"))
            error += "Campo telefono non valido: " + telefono + "; ";
        if (!error.isEmpty())
            throw new Exception(error);
        Indirizzo indirizzo = new Indirizzo();
        indirizzo.setStrada(strada);
        indirizzo.setTelefono(telefono);
        indirizzo.setNumeroCivico(numeroCivico);
        indirizzo.setCap(cap);
        return indirizzo;
    }
}
