package pl.example;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ZakupyInterface zakupy = new Zakupy();
        Scanner scanner = new Scanner(System.in);
        boolean run = true;

        while(run){
            System.out.println("\n---MENU ----");
            System.out.println("1. Dodaj produkt");
            System.out.println("2. Wyświetl listę produktów");
            System.out.println("3. Szczegóły produktu");
            System.out.println("4. Raport");
            System.out.println("5. Zapisz listę produktów");
            System.out.println("6. Zakończ");

            System.out.println("Wybierz opcję: ");
            String choice = scanner.nextLine();

            switch(choice){
                case "1":
                    try{
                        ZakupionyProdukt nowy = new ZakupionyProdukt();

                        System.out.println("Nazwa produktu: ");
                        nowy.setNazwaProduktu(scanner.nextLine());

                        System.out.println("Waga (w gramach): ");
                        nowy.setWaga(Integer.parseInt(scanner.nextLine()));

                        System.out.println("Cena za sztukę: ");
                        nowy.setCenaZaSztuke(Float.parseFloat(scanner.nextLine()));

                        System.out.println("Liczba sztuk: ");
                        nowy.setLiczbaSztuk(Integer.parseInt(scanner.nextLine()));

                        zakupy.dodawanieProduktu(nowy);
                        System.out.println("Produkt został dodany!");
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case "2":
                    zakupy.ZwrocListeProduktow().forEach((ZakupionyProdukt p) -> {
                        System.out.println("- "+ p.getNazwaProduktu()+
                                ", sztuk " + p.getLiczbaSztuk() +
                                ", cena: " + p.getCenaZaSztuke() + " zł");
                    });
                    break;

                case "3":
                    System.out.print("Podaj nazwę lub numer produktu: ");
                    String nazwa = scanner.nextLine();
                    Optional<ZakupionyProdukt> produkt = zakupy.ZwrocWybranyProduktPoNazwie(nazwa);
                    if (produkt.isPresent()) {
                        ZakupionyProdukt p = produkt.get();
                        System.out.println("Nazwa: " + p.getNazwaProduktu());
                        System.out.println("Waga: " + p.getWaga() + " g");
                        System.out.println("Cena: " + p.getCenaZaSztuke() + " zł");
                        System.out.println("Liczba sztuk: " + p.getLiczbaSztuk());
                    } else {
                        System.out.println("Nie znaleziono produktu o tej nazwie.");
                    }
                    break;

                case "4":
                    System.out.println("Liczba produktów: " +zakupy.IleProduktowNaLiscie());
                    System.out.println("Suma wag: " + zakupy.CalkowitaWagaProduktow() / 1000.0 + " kg");
                    System.out.println("Suma wartości: " + zakupy.SumaWartosciProdutkow() + " zł");
                    break;

                case "5":
                    System.out.println("podaj nazwe pliku do zapisu: ");

                    String nazwaPliku = scanner.nextLine();

                    Thread watekZapis = new Thread(() -> {
                        try {
                            FileWriterInterface<ZakupionyProdukt> writer = new ProduktFileWriter();
                            writer.ZapiszListeDoPliku(zakupy.ZwrocListeProduktow(), nazwaPliku);
                            System.out.println("Zakończono zapis do pliku.");
                        } catch (IOException e) {
                            System.out.println("Błąd podczas zapisu do pliku: " + e.getMessage());
                        } catch (Exception e) {
                            System.out.println("Nieoczekiwany błąd: " + e.getMessage());
                        }
                    });

                    watekZapis.start();
                    break;

                case "6":
                System.out.println("Zamykam program. Do widzenia!");
                run = false;
                break;


            }

        }
    }
}
