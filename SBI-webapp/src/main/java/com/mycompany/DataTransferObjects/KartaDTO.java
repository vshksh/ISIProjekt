package com.mycompany.DataTransferObjects;


public class KartaDTO {

    String numerKarty = "";
    String PIN;
    int limitKarty;
    int statusKarty = 0;
    String dataWaznosci = "";

 
    public String getNumerKarty() {
        return numerKarty;
    }

    public void setNumerKarty(String numerKarty) {
        this.numerKarty = numerKarty;
    }

    public String getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public int getLimitKarty() {
        return limitKarty;
    }

    public void setLimitKarty(int limitKarty) {
        this.limitKarty = limitKarty;
    }
        
    public String getDataWaznosci() {
        return dataWaznosci;
    }

    public void setDataWaznosci(String dataWaznosci) {
        this.dataWaznosci = dataWaznosci;
    }

    public int getStatusKarty() {
        return statusKarty;
    }

    public void setStatusKarty(int statusKarty) {
        this.statusKarty = statusKarty;
    }

    
    
}
