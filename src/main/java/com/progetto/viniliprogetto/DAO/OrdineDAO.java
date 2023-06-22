package com.progetto.viniliprogetto.DAO;

import com.progetto.viniliprogetto.Controller.MyServletException;
import com.progetto.viniliprogetto.Model.Ordine;
import com.progetto.viniliprogetto.Model.Utente;
import com.progetto.viniliprogetto.Model.Vinile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrdineDAO {

    public void doSave(Ordine ordini, Utente utente) throws MyServletException {
        try (Connection con = ConPool.getConnection()) {
            String sql = "Insert into ordini (oradiordine,quantitalibro,id_utente,isbn,tipo,anno_pubblicazione,numero_pagine,prezzo,descrizione,autore,titolo,copertina,quantita,totale) values";
            for (int i = 0; i < ordini.getVinile().size(); i++) {
                Vinile v = ordini.getVinile().get(i);
                sql = sql + "(\"" + ordini.getOraordine() + "\"," + v.getQuantitaCarrello() + "," + utente.getId() + ",\"" + v.getEAN() + "\"," + v.getAnno_pubblicazione() + "," + v.getPrezzo() + ",\"" + v.getDescrizione() + "\",\"" + v.getAutore() + "\",\"" + v.getTitolo() + "\",\"" + v.getPath() + "\"," + ordini.getQuantita() + "," + ordini.getTotale() + ")";
                if (i != ordini.getVinile().size() - 1) {
                    sql = sql + ",";
                }
            }
            sql = sql + ";";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<Ordine> doRetrieveAll() {
        ArrayList<Ordine> o = new ArrayList<Ordine>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con
                    .prepareStatement("SELECT oradiordine,quantita,totale,id_utente,username FROM ordini,utente where ordini.id_utente=utente.id order by oradiordine");
            ResultSet rs = ps.executeQuery();
            String next = "0", prec = "0";
            int i = 0;
            Ordine temp = null;
            while (rs.next()) {
                next = rs.getString(1);
                if (prec.equals(next)) {
                } else {
                    if (i == 0) {
                        i++;
                    } else {
                        o.add(temp);
                    }
                    prec = next;
                    temp = new Ordine();
                    temp.setOraordine(rs.getString(1));
                    temp.setQuantita(rs.getInt(2));
                    temp.setTotale(rs.getInt(3));
                    temp.setIdutente(rs.getInt(4));
                    temp.setNomeutente(rs.getString(5));
                }
            }
            if (temp != null) o.add(temp);
            return o;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public ArrayList<Ordine> doRetrieveByUserId(int idutente) {
        ArrayList<Ordine> o = new ArrayList<Ordine>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con
                    .prepareStatement("SELECT oradiordine,quantita,totale,ean, anno_pubblicazione,prezzo,descrizione,autore,titolo,copertina,quantitalibro FROM ordini WHERE id_utente=?  order by oradiordine");
            ps.setInt(1, idutente);
            ResultSet rs = ps.executeQuery();
            String next = "0", prec = "0";
            int i = 0;
            Ordine temp = null;
            while (rs.next()) {
                next = rs.getString(1);
                if (prec.equals(next)) {
                    Vinile ltemp = new Vinile();
                    ltemp.setQuantitaCarrello(rs.getInt(8));
                    ltemp.setEAN(rs.getString(1));
                    ltemp.setAnno_pubblicazione(rs.getInt(2));
                    ltemp.setPrezzo(rs.getInt(3));
                    ltemp.setDescrizione(rs.getString(4));
                    ltemp.setAutore(rs.getString(5));
                    ltemp.setTitolo(rs.getString(6));
                    ltemp.setPath(rs.getString(7));
                    temp.addVinile(ltemp);
                } else {
                    if (i == 0) {
                        i++;
                    } else {
                        o.add(temp);
                    }
                    prec = next;
                    temp = new Ordine();
                    temp.setOraordine(rs.getString(1));
                    temp.setQuantita(rs.getInt(2));
                    temp.setTotale(rs.getInt(3));
                    Vinile ltemp = new Vinile();
                    ltemp.setEAN(rs.getString(4));
                    ltemp.setAnno_pubblicazione(rs.getInt(5));
                    ltemp.setPrezzo(rs.getInt(6));
                    ltemp.setDescrizione(rs.getString(7));
                    ltemp.setAutore(rs.getString(8));
                    ltemp.setTitolo(rs.getString(9));
                    ltemp.setPath(rs.getString(10));
                    temp.addVinile(ltemp);
                }
            }
            if (temp != null) o.add(temp);
            return o;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Ordine doRetrievebyUserIdAndOra(String ora, int idutente) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con
                    .prepareStatement("SELECT oradiordine,quantita,totale,ean, anno_pubblicazione,prezzo,descrizione,autore,titolo,copertina,quantitalibro FROM ordini WHERE id_utente=? and oradiordine=?  order by oradiordine");
            ps.setInt(1, idutente);
            ps.setString(2, ora);
            Ordine o = new Ordine();
            ResultSet rs = ps.executeQuery();
            Boolean b = true;
            while (rs.next()) {
                if (b) {
                    o.setOraordine(rs.getString(1));
                    o.setQuantita(rs.getInt(2));
                    o.setTotale(rs.getInt(3));
                    b = false;
                }
                Vinile temp = new Vinile();
                temp.setEAN(rs.getString(4));
                temp.setAnno_pubblicazione(rs.getInt(5));
                temp.setPrezzo(rs.getInt(6));
                temp.setDescrizione(rs.getString(7));
                temp.setAutore(rs.getString(8));
                temp.setTitolo(rs.getString(9));
                temp.setPath(rs.getString(10));
                temp.setQuantitaCarrello(rs.getInt(11));
                o.addVinile(temp);
            }
            if (o.getVinile().size() > 0) {
                return o;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Boolean ceckIfExistbyIsbnAndUserID(String ean, int idutente) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con
                    .prepareStatement("SELECT * FROM ordini WHERE ean=? and id_utente = ?");
            ps.setString(1, ean);
            ps.setInt(2, idutente);
            ResultSet s = ps.executeQuery();

            if (s.next()) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
