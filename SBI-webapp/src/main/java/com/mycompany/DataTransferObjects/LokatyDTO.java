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
public class LokatyDTO {

    private int idLokaty;
    private String numerRachunku;
    private double kwota;
    private double procent;
    private String dataZalozenia;
    private String terminZakonczenia;
    private double naliczenia;
    
    public int getIdLokaty() {
        return idLokaty;
    }

    public void setIdLokaty(int idLokaty) {
        this.idLokaty = idLokaty;
    }

    public String getNumerRachunku() {
        return numerRachunku;
    }

    public void setNumerRachunku(String numerRachunku) {
        this.numerRachunku = numerRachunku;
    }

    public double getKwota() {
        return kwota;
    }

    public void setKwota(double kwota) {
        this.kwota = kwota;
    }
    
    public double getProcent() {
        return procent;
    }

    public void setProcent(double procent) {
        this.procent = procent;
    }
    public String getDataZalozenia() {
        return dataZalozenia;
    }

    public void setDataZalozenia(String dataZalozenia) {
        this.dataZalozenia = dataZalozenia;
    }

    public String getTerminZakonczenia() {
        return terminZakonczenia;
    }

    public void setTerminZakonczenia(String terminZakonczenia) {
        this.terminZakonczenia = terminZakonczenia;
    }

    public double getNaliczenia() {
        return naliczenia;
    }

    public void setNaliczenia(double naliczenia) {
        this.naliczenia = naliczenia;
    }
    
}
