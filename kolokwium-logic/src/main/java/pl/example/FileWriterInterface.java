package pl.example;

import java.io.IOException;
import java.util.List;

public interface FileWriterInterface<T extends Produkt> {
    void ZapiszListeDoPliku(List<T> lista, String nazwaPliku) throws IOException;
}
