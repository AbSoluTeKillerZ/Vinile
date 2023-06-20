package com.progetto.viniliprogetto.Model;

import java.util.ArrayList;

public class Carrello {
    private ArrayList<Vinile> vinile = new ArrayList<Vinile>();
    private int totale = 0;
    private int totprodotti = 0;

    public void setVinile(ArrayList<Vinile> libro) {
        this.vinile = libro;
    }

    public void setVinile(Vinile v) {
        for (Vinile vin : vinile) {
            if (v.getEAN().equals(vin.getEAN())) {
                vin.setQuantitaCarrello(vin.getQuantitaCarrello() + 1);
                totale = totale + vin.getPrezzo();
                totprodotti = totprodotti + 1;
                return;
            }
        }
        v.setQuantitaCarrello(1);
        vinile.add(v);
        totale = totale + v.getPrezzo();
        totprodotti = totprodotti + 1;
    }

    public void removeVinile(Vinile v) {
        for (int i = 0; i < vinile.size(); i++) {
            if (vinile.get(i).getEAN().equals(v.getEAN())) {
                vinile.remove(i);
                break;
            }
        }
        aggiornaTotProdotti();
    }

    public int getTotprodotti() {
        aggiornaTotProdotti();
        return totprodotti;
    }

    public ArrayList<Vinile> getLibro() {
        return vinile;
    }

    public void aggiornaTotProdotti() {
        totprodotti = 0;
        for (Vinile v : vinile) {
            totprodotti += v.getQuantitaCarrello();
        }
    }

    public int getTotale() {
        int sum = 0;
        for (Vinile v : vinile) {
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

    public Boolean findLibrobyIsbn(String isbn) {
        for (int i = 0; i < vinile.size(); i++) {
            if (vinile.get(i).getEAN().equals(isbn)) {
                return true;
            }
        }
        return false;
    }
}
