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
public class FormularzRejestracjiDTO {
    
    private String login;
    private String haslo;
    private String pesel;
    private String imiona;
    private String nazwisko;
    private String plec;
    private String telefon;
    private String adresEmail;
    private String adresKorespondencji;
    private String kodPocztowy;
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getImiona() {
        return imiona;
    }

    public void setImiona(String imiona) {
        this.imiona = imiona;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdresEmail() {
        return adresEmail;
    }

    public void setAdresEmail(String adresEmail) {
        this.adresEmail = adresEmail;
    }

    public String getAdresKorespondencji() {
        return adresKorespondencji;
    }

    public void setAdresKorespondencji(String adresKorespondencji) {
        this.adresKorespondencji = adresKorespondencji;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }
    

    
}
