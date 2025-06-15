package pl.example;

import java.util.List;
import java.util.Optional;

public interface ZakupyInterface {
    void dodawanieProduktu(ZakupionyProdukt produkt) throws IncorrectValueException;

    List<ZakupionyProdukt> ZwrocListeProduktow();

    Optional<ZakupionyProdukt> ZwrocWybranyProduktPoNazwie(String nazwa);

    Optional<ZakupionyProdukt> ZwrocWybranyProduktPoNumerze(int index);

    int IleProduktowNaLiscie();
    int CalkowitaWagaProduktow();
    float SumaWartosciProdutkow();

}
