package pl.example;


public abstract class Produkt {
    public void setCenaZaSztuke(Float cenaZaSztuke) {
        this.cenaZaSztuke = cenaZaSztuke;
    }

    public void setWaga(Integer waga) {
        Waga = waga;
    }

    public void setNazwaProduktu(String nazwaProduktu) {
        this.nazwaProduktu = nazwaProduktu;
    }

    public Float getCenaZaSztuke() {
        return cenaZaSztuke;
    }

    public Integer getWaga() {
        return Waga;
    }

    public String getNazwaProduktu() {
        return nazwaProduktu;
    }

    private String nazwaProduktu;
    private Integer Waga;
    private Float cenaZaSztuke;
}
