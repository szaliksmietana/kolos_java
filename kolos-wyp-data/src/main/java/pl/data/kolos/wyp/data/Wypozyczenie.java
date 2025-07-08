/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.data.kolos.wyp.data;

import pl.data.kolos.wyp.data.Klient;
import pl.data.kolos.wyp.data.Pozycja;
/**
 *
 * @author Admin
 */
public class Wypozyczenie {
    private Klient klient;
    private Pozycja pozycja;
    
    public Wypozyczenie(Pozycja pozycja, Klient klient){
        this.pozycja = pozycja;
        this.klient = klient;
    }

    public Klient getKlient() {
        return klient;
    }

    public Pozycja getPozycja() {
        return pozycja;
    }

    @Override
    public String toString() {
        return pozycja.opis() + ", " + klient.getNazwisko() + ", wiek: " + klient.getWiek();
    }
    
    
}
