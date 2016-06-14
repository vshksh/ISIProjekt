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

public class DaneKredyt 
{
    private int kwota=0;
    private int okres=0; // na ile miesięcy będzie kredyt
    private String stancywilny="";
    private String wyksztalcenie="";
    private String statusmieszkaniowy="";
    private String formazatrudnienia="";
    private int ile_w_domu=0; // liczba osób w gospodarstwie domowym
    private int lacznydochod=0; // laczny dochod w gospodarstwie domowym
    private String waluta="";
    private int rachunek=0;

    public String getWaluta() {
        return waluta;
    }

    public void setWaluta(String waluta) {
        this.waluta = waluta;
    }

    public int getRachunek() {
        return rachunek;
    }

    public void setRachunek(int rachunek) {
        this.rachunek = rachunek;
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

    public String getStancywilny() {
        return stancywilny;
    }

    public void setStancywilny(String stancywilny) {
        this.stancywilny = stancywilny;
    }

    public String getWyksztalcenie() {
        return wyksztalcenie;
    }

    public void setWyksztalcenie(String wyksztalcenie) {
        this.wyksztalcenie = wyksztalcenie;
    }

    public String getStatusmieszkaniowy() {
        return statusmieszkaniowy;
    }

    public void setStatusmieszkaniowy(String statusmieszkaniowy) {
        this.statusmieszkaniowy = statusmieszkaniowy;
    }

    public String getFormazatrudnienia() {
        return formazatrudnienia;
    }

    public void setFormazatrudnienia(String formazatrudnienia) {
        this.formazatrudnienia = formazatrudnienia;
    }

    public int getIle_w_domu() {
        return ile_w_domu;
    }

    public void setIle_w_domu(int ile_w_domu) {
        this.ile_w_domu = ile_w_domu;
    }

    public int getLacznydochod() {
        return lacznydochod;
    }

    public void setLacznydochod(int lacznydochod) {
        this.lacznydochod = lacznydochod;
    }
    
}