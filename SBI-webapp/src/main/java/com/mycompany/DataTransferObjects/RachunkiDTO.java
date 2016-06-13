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
public class RachunkiDTO 
{
    private String numerRachunku;
    private double saldo;
    private String waluta = "";
    private String login;
        
    public String getNumerRachunku() {
        return numerRachunku;
    }

    public void setNumerRachunku(String numerRachunku) {
        this.numerRachunku = numerRachunku;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getWaluta() {
        return waluta;
    }

    public void setWaluta(String waluta) {
        this.waluta = waluta;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
        
        
    
}
