package pl.example;

import pl.example.ZakupionyProdukt;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class ProduktFileWriter implements FileWriterInterface<ZakupionyProdukt> {


    @Override
    public void ZapiszListeDoPliku(List<ZakupionyProdukt> lista, String nazwaPliku) throws IOException {
        List<ZakupionyProdukt> posortowanaLista = lista.stream()
                .sorted(Comparator.comparingDouble(p -> p.getCenaZaSztuke() * p.getLiczbaSztuk()))
                .toList();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nazwaPliku))) {
            for (ZakupionyProdukt p : posortowanaLista) {
                writer.write("Produkt: " + p.getNazwaProduktu() + "\n");
                writer.write("Waga: " + p.getWaga() + " g\n");
                writer.write("Cena za sztukę: " + p.getCenaZaSztuke() + " zł\n");
                writer.write("Liczba sztuk: " + p.getLiczbaSztuk() + "\n");
                writer.write("Wartość całkowita: " + (p.getCenaZaSztuke() * p.getLiczbaSztuk()) + " zł\n");
                writer.write("------\n");
            }
        }
    }
}
