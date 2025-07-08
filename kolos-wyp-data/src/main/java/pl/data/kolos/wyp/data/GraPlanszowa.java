/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.data.kolos.wyp.data;

/**
 *
 * @author Admin
 */
public class GraPlanszowa extends Pozycja{
    private int wiekMax;
    
    public GraPlanszowa(String nazwa, int wiekMin, int wiekMax){
        this.nazwa = nazwa;
        this.wiekMin = wiekMin;
        this.wiekMax = wiekMax;
    }

    @Override
    public boolean czyDozwolone(int wiek) {
        return wiek >= wiekMin && wiek <= wiekMax;
    }

    @Override
    public String opis() {
        return nazwa +", Gra planszowa";
    }
    
    
}
