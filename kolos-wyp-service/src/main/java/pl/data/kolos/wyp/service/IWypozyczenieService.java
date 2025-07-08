/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.data.kolos.wyp.service;

import java.util.List;
import java.util.Map;
import pl.data.kolos.wyp.data.Wypozyczenie;

/**
 *
 * @author Admin
 */
public interface IWypozyczenieService {
    void dodajWypozyczenie(Wypozyczenie w);
    List<Wypozyczenie> getWszystkie();
    Map<String, Long>raportKlientow();
    Map<String, Long>rodzajRaportu();
    
    
}
