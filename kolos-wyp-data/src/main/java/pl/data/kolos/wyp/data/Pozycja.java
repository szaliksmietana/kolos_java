/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.data.kolos.wyp.data;

/**
 *
 * @author Admin
 */
public abstract class Pozycja {
    protected String nazwa;
    protected int wiekMin;
    
    
    public abstract boolean czyDozwolone(int wiek);
    public abstract String opis();
    
}
