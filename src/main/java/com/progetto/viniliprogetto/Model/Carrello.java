package com.progetto.viniliprogetto.Model;

import java.util.ArrayList;

public class Carrello {
    private final ArrayList<VinileInCarrello> vinili = new ArrayList<>();

    public void aggiungiVinile(Vinile vinile) {
        VinileInCarrello vic = cercaPerEan(vinile.getEan());
        if (vic == null) {
            VinileInCarrello vinInCarrello = new VinileInCarrello();
            vinInCarrello.setVinile(vinile);
            vinInCarrello.setQuantita(1);
            vinInCarrello.setCarrello(this);
            vinili.add(vinInCarrello);
        } else {
            vic.setQuantita(vic.getQuantita() + 1);
        }
    }

    public int getQuantitaCarrello() {
        int i = 0;
        for (VinileInCarrello vic : vinili) i++;
        return i;
    }

    public void rimuoviVinile(Vinile vinile) {
        VinileInCarrello vic = cercaPerEan(vinile.getEan());
        if (vic != null) vinili.remove(vic);
    }

    private VinileInCarrello cercaPerEan(String ean) {
        for (VinileInCarrello vic : vinili) {
            if (vic.getVinile().getEan().equals(ean)) return vic;
        }
        return null;
    }

    public void modificaQuantita(Vinile vinile, int quant) {
        VinileInCarrello vic = cercaPerEan(vinile.getEan());
        if (vic != null) vic.setQuantita(quant);
    }

    public ArrayList<VinileInCarrello> getVinili() {
        return vinili;
    }
    /*
    public int getTotprodotti() {
        aggiornaTotProdotti();
        return totprodotti;
    }

    public ArrayList<Vinile> getVinili() {
        return vinili;
    }

    public void aggiornaTotProdotti() {
        totprodotti = 0;
        for (Vinile v : vinili) {
            totprodotti += v.getQuantitaCarrello();
        }
    }

    public int getTotale() {
        int sum = 0;
        for (Vinile v : vinili) {
            sum += (v.getPrezzo() * v.getQuantitaCarrello());
        }
        return sum;
    }

    public int getTotaleNetto() {
        return getTotale() - (getTotale() * 22 / 100);
    }

    public int getIva() {
        return getTotale() - getTotaleNetto();
    }

    public int getCostoSpedizione() {
        if (getTotale() > 10000)
            return 0;
        if (getTotale() > 5000)
            return 750;
        if (getTotale() == 0) {
            return 0;
        } else
            return 1500;
    }

    public int getTotaleLordo() {
        return getTotale() + getCostoSpedizione();
    }

    public String convertiEuro(int prezzo) {
        int x = prezzo / 100;
        int y = prezzo % 100;
        if (y == 0) {
            return x + ",00";
        }
        return x + "," + y;
    }
    */
}