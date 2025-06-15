package pl.example;


public abstract class Produkt {
    private String nazwaProduktu;
    private Integer Waga;
    private Float cenaZaSztuke;

    public void setCenaZaSztuke(Float cenaZaSztuke) {
        this.cenaZaSztuke = cenaZaSztuke;
    }

    public void setWaga(Integer waga) {
        this.Waga = waga;
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


    public Produkt() {}
}
