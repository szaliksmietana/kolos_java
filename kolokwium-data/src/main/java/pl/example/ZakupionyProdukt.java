package pl.example;


public class ZakupionyProdukt extends Produkt{
    public void setLiczbaSztuk(Integer liczbaSztuk) {
        this.liczbaSztuk = liczbaSztuk;
    }

    public Integer getLiczbaSztuk() {
        return liczbaSztuk;
    }

    Integer liczbaSztuk;
}
