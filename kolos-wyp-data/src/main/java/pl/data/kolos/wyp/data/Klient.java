/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.data.kolos.wyp.data;

/**
 *
 * @author Admin
 */
public class Klient {
    private String imie;
    private String nazwisko;
    private int wiek;
    
    public Klient(String imie, String nazwisko, int wiek){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
    }
    
    public Klient(){}

    
    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public int getWiek() {
        return wiek;
    }
    
    
}
