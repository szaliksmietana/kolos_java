/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.data.kolos.wyp.logic;

import java.util.Scanner;
import pl.data.kolos.wyp.data.GraPlanszowa;
import pl.data.kolos.wyp.data.Klient;
import pl.data.kolos.wyp.data.Ksiazka;
import pl.data.kolos.wyp.data.Pozycja;
import pl.data.kolos.wyp.data.Wypozyczenie;
import pl.data.kolos.wyp.service.TxtExporter;
import pl.data.kolos.wyp.service.WypozyczenieService;

/**
 *
 * @author Admin
 */
public class MainMenu {
    private static final Scanner scanner = new Scanner(System.in);
    private static final WypozyczenieService service = new WypozyczenieService();
    
    public static void main(String[] args){
        while(true){
            System.out.println("""
                               1. Dodanie nowego wypożyczenia 
                               2. Wyświetlenie listy wypożyczeń 
                               3. Wygenerowanie raportu 
                               4. Zapis do pliku 
                               5. Zakończenie programu 
                               """);
            
            switch(scanner.nextLine()){
                case "1" -> dodaj();
                case "2" -> service.getWszystkie().forEach(x -> System.out.println(x));
                case "3" -> raport();
                case "4" -> new TxtExporter().eksportuj(service.getWszystkie(), "wypozyczenia.txt");
                case "5" -> System.exit(0);
                default -> System.out.println("Nieznana opcja.");
                    
            }
        }
    }
    
    
    public static void dodaj(){
        Pozycja p = null;
        System.out.println("1. Książka 2. Gra planszowa");
        switch(scanner.nextLine()){
            case "1" ->{
                System.out.println("Podaj nazwe ksiazki");
                String nazwa = scanner.nextLine();
                System.out.println("Podaj autora");
                String autor = scanner.nextLine();
                System.out.println("Podaj wiek minimlany");
                int wiek = Integer.parseInt(scanner.nextLine());
                
                p = new Ksiazka(nazwa, autor, wiek);
            }
            
            case "2" ->{
                System.out.println("Podaj nazwe gry");
                String nazwa = scanner.nextLine();
                System.out.println("Podaj wiek minimalny");
                int wiekMin = Integer.parseInt(scanner.nextLine());
                System.out.println("Podaj wiek max");
                int wiekMax = Integer.parseInt(scanner.nextLine());
                
                p = new GraPlanszowa(nazwa, wiekMin, wiekMax);
            }
            default -> {System.out.println("Nieznana opcja.");
            }
        }
                       
                                    
        if (p == null) return;

        System.out.println("Podaj imie");
        String imie = scanner.nextLine();
        System.out.println("Podaj nazwisko");
        String nazwisko = scanner.nextLine();
        System.out.println("Podaj wiek");
        int wiek = Integer.parseInt(scanner.nextLine());
        
        Klient klient = new Klient(imie, nazwisko, wiek);
        if(!p.czyDozwolone(wiek)){
            System.out.println("OSTRZEŻENIE: Wiek klienta nie jest odpowiedni dla tej pozycji!");
        }
        
        service.dodajWypozyczenie(new Wypozyczenie(p, klient));
    }
    
    public static void raport(){
        System.out.println("Rodzaje pozycji: ");
        service.rodzajRaportu().forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println("Kategorie wiekowe klientów: ");
        service.raportKlientow().forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
