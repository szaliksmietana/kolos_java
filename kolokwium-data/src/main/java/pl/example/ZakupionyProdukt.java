package pl.example;


public class ZakupionyProdukt extends Produkt{
    private Integer liczbaSztuk;

    public void setLiczbaSztuk(Integer liczbaSztuk) {
        this.liczbaSztuk = liczbaSztuk;
    }

    public Integer getLiczbaSztuk() {
        return liczbaSztuk;
    }


    public ZakupionyProdukt() {}
}
