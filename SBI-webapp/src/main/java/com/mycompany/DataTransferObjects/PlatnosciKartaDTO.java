/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DataTransferObjects;

/**
 *
 * @author Jeremiasz
 */
public class PlatnosciKartaDTO {

    public String getIDPlatnosci() {
        return IDPlatnosci;
    }

    public void setIDPlatnosci(String IDPlatnosci) {
        this.IDPlatnosci = IDPlatnosci;
    }

    public String getIDKarty() {
        return IDKarty;
    }

    public void setIDKarty(String IDKarty) {
        this.IDKarty = IDKarty;
    }

    public double getKwota() {
        return kwota;
    }

    public void setKwota(double kwota) {
        this.kwota = kwota;
    }

    public String getDataPlatnosci() {
        return dataPlatnosci;
    }

    public void setDataPlatnosci(String dataPlatnosci) {
        this.dataPlatnosci = dataPlatnosci;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
    
    private String IDPlatnosci;
    private String IDKarty;
    private double kwota;
    private String dataPlatnosci;
    private String nazwa;
    
}
