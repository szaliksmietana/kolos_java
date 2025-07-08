/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.data.kolos.wyp.data;

import pl.data.kolos.wyp.data.Pozycja;
/**
 *
 * @author Admin
 */
public class Ksiazka extends Pozycja {
    private String autor;
    
    public Ksiazka(String nazwa, String autor, int wiekMin){
        this.nazwa = nazwa;
        this.autor = autor;
        this.wiekMin = wiekMin;
    }

    @Override
    public boolean czyDozwolone(int wiek) {
        return wiek >= wiekMin;
    }

    @Override
    public String opis() {
        return nazwa + ", autor:" + autor + ", Książka";
    }
    
    
}
