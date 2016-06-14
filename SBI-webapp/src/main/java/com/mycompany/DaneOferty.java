/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

/**
 *
 * @author Przemek
 */
public class DaneOferty 
{
    private int kwota=0;
    private int okres=0;
    private double zdolnosc_kredytowa=0;
    private double prowizja=0;
    private double oprocentowanie=0;
    private String waluta="";
    private int rachunek=0;

    public int getRachunek() {
        return rachunek;
    }

    public void setRachunek(int rachunek) {
        this.rachunek = rachunek;
    }
    

    public String getWaluta() {
        return waluta;
    }

    public void setWaluta(String waluta) {
        this.waluta = waluta;
    }
    

    public double getProwizja() {
        return prowizja;
    }

    public void setProwizja(double prowizja) {
        this.prowizja = prowizja;
    }

    public double getOprocentowanie() {
        return oprocentowanie;
    }

    public void setOprocentowanie(double oprocentowanie) {
        this.oprocentowanie = oprocentowanie;
    }

    public int getKwota() {
        return kwota;
    }

    public void setKwota(int kwota) {
        this.kwota = kwota;
    }

    public int getOkres() {
        return okres;
    }

    public void setOkres(int okres) {
        this.okres = okres;
    }

    public double getZdolnosc_kredytowa() {
        return zdolnosc_kredytowa;
    }

    public void setZdolnosc_kredytowa(double zdolnosc_kredytowa) {
        this.zdolnosc_kredytowa = zdolnosc_kredytowa;
    }
    
    public DaneOferty (int kwota, int okres, double zdolnosc, double prowizja, double oprocentowanie, String waluta, int rachunek)
    {
        this.kwota=kwota;
        this.okres=okres;
        this.zdolnosc_kredytowa=zdolnosc;
        this.prowizja=prowizja;
        this.oprocentowanie=oprocentowanie;
        this.waluta=waluta;
        this.rachunek=rachunek;
    }
    
}