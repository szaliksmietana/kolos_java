/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.data.kolos.wyp.service;

import java.util.List;
import pl.data.kolos.wyp.data.Wypozyczenie;

/**
 *
 * @author Admin
 */
public interface IFileExport {
    
    void eksportuj(List<Wypozyczenie> lista, String sciezka);
    
}
