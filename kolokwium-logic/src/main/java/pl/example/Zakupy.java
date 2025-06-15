package pl.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Zakupy implements ZakupyInterface {
    private List<ZakupionyProdukt> listaZakupow = new ArrayList<>();
    private static final int MAX_WAGA = 20000;

    @Override
    public void dodawanieProduktu(ZakupionyProdukt produkt) throws IncorrectValueException {
        if (produkt.getNazwaProduktu() == null || produkt.getNazwaProduktu().trim().isEmpty()) {
            throw new IncorrectValueException("Nazwa produktu nie może być pusta.");
        }

        if (produkt.getWaga() < 1000 || produkt.getWaga() > 20000) {
            throw new IncorrectValueException("Waga produktu musi być między 1 kg (1000 g) a 20 kg (20000 g). Podano: " + produkt.getWaga() + " g");
        }

        if (produkt.getCenaZaSztuke() < 0.01f || produkt.getCenaZaSztuke() > 1000.0f) {
            throw new IncorrectValueException("Cena za sztukę musi być między 0.01 zł a 1000 zł. Podano: " + produkt.getCenaZaSztuke());
        }

        if (produkt.getLiczbaSztuk() < 1 || produkt.getLiczbaSztuk() > 100) {
            throw new IncorrectValueException("Liczba sztuk musi być między 1 a 100. Podano: " + produkt.getLiczbaSztuk());
        }

        int aktualnaWaga = CalkowitaWagaProduktow();
        int wagaNowego = produkt.getWaga() * produkt.getLiczbaSztuk();

        if (aktualnaWaga + wagaNowego > MAX_WAGA) {
            throw new IncorrectValueException("Przekroczeno makszymalną wagę 20kg, Aktualna: " +
                    (aktualnaWaga / 1000.0) + " kg, nowy produkt: " +
                    (wagaNowego / 1000.0) + " kg");

        }
        listaZakupow.add(produkt);
    }

    @Override
    public List<ZakupionyProdukt> ZwrocListeProduktow() {
        return listaZakupow;
    }

    @Override
    public Optional<ZakupionyProdukt> ZwrocWybranyProduktPoNazwie(String nazwa) {
        return Optional.ofNullable(listaZakupow.stream()
                .filter(p -> p.getNazwaProduktu().equalsIgnoreCase(nazwa))
                .findFirst()
                .orElse(null));
    }

    @Override
    public Optional<ZakupionyProdukt> ZwrocWybranyProduktPoNumerze(int index) {
        if (index >= 0 && index < listaZakupow.size()) {
            return Optional.ofNullable(listaZakupow.get(index));
        }
        return null;
    }

    @Override
    public int IleProduktowNaLiscie() {
        return listaZakupow.size();
    }

    @Override
    public int CalkowitaWagaProduktow() {
        return listaZakupow.stream()
                .mapToInt(p -> p.getWaga() * p.getLiczbaSztuk())
                .sum();
    }

    @Override
    public float SumaWartosciProdutkow() {
        return (float) listaZakupow.stream()
                .mapToDouble(p -> p.getCenaZaSztuke() * p.getLiczbaSztuk())
                .sum();
    }
}
