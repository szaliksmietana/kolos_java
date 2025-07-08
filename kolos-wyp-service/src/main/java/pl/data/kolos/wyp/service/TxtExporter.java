/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.data.kolos.wyp.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import pl.data.kolos.wyp.data.Wypozyczenie;

/**
 *
 * @author Admin
 */
public class TxtExporter implements IFileExport{

    @Override
    public void eksportuj(List<Wypozyczenie> lista, String sciezka) {
        try{
            PrintWriter writer = new PrintWriter(sciezka);
            lista.forEach(w -> writer.println(w.toString()));
            System.out.println("Zapisano do pliku. " + sciezka);
        } catch(IOException e){
            System.out.println("Błąd" + e.getMessage());
        }
    }
    
}
