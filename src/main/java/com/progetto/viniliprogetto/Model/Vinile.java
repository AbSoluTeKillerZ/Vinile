package com.progetto.viniliprogetto.Model;

import java.util.ArrayList;
import java.util.List;

public class Vinile {
    private String ean;
    private int annoPubblicazione;
    private int prezzo;
    private int numeroDisponibili;
    private String autore;
    private String titolo;
    private String copertina;
    private List<Genere> genere = new ArrayList<>();

    public String getEan() {
        return ean;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getCopertina() {
        return copertina;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setCopertina(String Copertina) {
        this.copertina = Copertina;
    }

    public List<Genere> getGenere() {
        return genere;
    }

    public void setGenere(List<Genere> genere) {
        this.genere = genere;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    public int getNumeroDisponibili() {
        return numeroDisponibili;
    }

    public void setNumeroDisponibili(int numeroDisponibili) {
        this.numeroDisponibili = numeroDisponibili;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }
}