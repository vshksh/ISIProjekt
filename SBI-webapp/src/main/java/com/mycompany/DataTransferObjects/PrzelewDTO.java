package com.mycompany.DataTransferObjects;


public class PrzelewDTO {

    public double getKwota() {
        return kwota;
    }

    public void setKwota(double kwota) {
        this.kwota = kwota;
    }

    public String getWaluta() {
        return waluta;
    }

    public void setWaluta(String waluta) {
        this.waluta = waluta;
    }

    public String getDataZlecenia() {
        return dataZlecenia;
    }

    public void setDataZlecenia(String dataZlecenia) {
        this.dataZlecenia = dataZlecenia;
    }

    public String getDataWykonania() {
        return dataWykonania;
    }

    public void setDataWykonania(String dataWykonania) {
        this.dataWykonania = dataWykonania;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getRachunekOdbiorcy() {
        return rachunekOdbiorcy;
    }

    public void setRachunekOdbiorcy(String rachunekOdbiorcy) {
        this.rachunekOdbiorcy = rachunekOdbiorcy;
    }

    public String getRachunekZleceniodawcy() {
        return rachunekZleceniodawcy;
    }

    public void setRachunekZleceniodawcy(String rachunekZleceniodawcy) {
        this.rachunekZleceniodawcy = rachunekZleceniodawcy;
    }

    private double kwota;
    private String waluta = "";
    private String dataZlecenia;
    private String dataWykonania;
    private String status;
    private String tytul;
    private String rachunekOdbiorcy;
    private String rachunekZleceniodawcy="";
   
    
}
