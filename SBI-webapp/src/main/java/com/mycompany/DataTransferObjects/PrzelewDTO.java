package com.mycompany.DataTransferObjects;


public class PrzelewDTO {

    String rachunekDoc;
    Double kwota;
    String waluta;
    String tytul;
    

    public String getRachunekDoc() {
        return rachunekDoc;
    }

    public void setRachunekDoc(String rachunekDoc) {
        this.rachunekDoc = rachunekDoc;
    }

    public Double getKwota() {
        return kwota;
    }

    public void setKwota(Double kwota) {
        this.kwota = kwota;
    }

    public String getWaluta() {
        return waluta;
    }

    public void setWaluta(String waluta) {
        this.waluta = waluta;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }
    
   
    
}
