/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.data.kolos.wyp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import pl.data.kolos.wyp.data.Ksiazka;
import pl.data.kolos.wyp.data.Wypozyczenie;

/**
 *
 * @author Admin
 */
public class WypozyczenieService implements IWypozyczenieService{

    private List<Wypozyczenie> lista = new ArrayList<>();
    
    @Override
    public void dodajWypozyczenie(Wypozyczenie w) {
        lista.add(w);
    }

    @Override
    public List<Wypozyczenie> getWszystkie() {
        return lista;
    }

    @Override
    public Map<String, Long> raportKlientow() {
        return lista.stream()
                .collect(Collectors.groupingBy(
                    w -> {
                        int wiek = w.getKlient().getWiek();
                        if (wiek <= 10) return "Dzieci";
                        else if (wiek <= 17) return "Młodzież";
                        else return "Dorośli";
                    },
                    Collectors.counting()
                ));
    }

    @Override
    public Map<String, Long> rodzajRaportu() {
        return lista.stream()
                .collect(Collectors.groupingBy(
                    w -> w.getPozycja() instanceof Ksiazka ? "Książka" : "Gry",
                    Collectors.counting()
                ));
    }
    
}
