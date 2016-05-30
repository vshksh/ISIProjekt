/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DataTransferObjects;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Przemek
 */
@Entity
@Table(name = "konta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Konta.findAll", query = "SELECT k FROM Konta k"),
    @NamedQuery(name = "Konta.findByNazwaKonta", query = "SELECT k FROM Konta k WHERE k.nazwaKonta = :nazwaKonta"),
    @NamedQuery(name = "Konta.findByRola", query = "SELECT k FROM Konta k WHERE k.rola = :rola"),
    @NamedQuery(name = "Konta.findByHaslo", query = "SELECT k FROM Konta k WHERE k.haslo = :haslo"),
    @NamedQuery(name = "Konta.findByResetowanieHasla", query = "SELECT k FROM Konta k WHERE k.resetowanieHasla = :resetowanieHasla"),
    @NamedQuery(name = "Konta.findByStanKonta", query = "SELECT k FROM Konta k WHERE k.stanKonta = :stanKonta"),
    @NamedQuery(name = "Konta.findByTESTsciezkaformularza", query = "SELECT k FROM Konta k WHERE k.tESTsciezkaformularza = :tESTsciezkaformularza")})
public class Konta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "nazwa_konta")
    private String nazwaKonta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "rola")
    private String rola;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "haslo")
    private String haslo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "resetowanie_hasla")
    private boolean resetowanieHasla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "stan_konta")
    private String stanKonta;
    @Size(max = 60)
    @Column(name = "TEST_sciezka_formularza")
    private String tESTsciezkaformularza;
    @JoinColumn(name = "PESEL", referencedColumnName = "PESEL")
    @ManyToOne(optional = false)
    private KlientIndywidualnyDTO pesel;

    public Konta() {
    }

    public Konta(String nazwaKonta) {
        this.nazwaKonta = nazwaKonta;
    }

    public Konta(String nazwaKonta, String rola, String haslo, boolean resetowanieHasla, String stanKonta) {
        this.nazwaKonta = nazwaKonta;
        this.rola = rola;
        this.haslo = haslo;
        this.resetowanieHasla = resetowanieHasla;
        this.stanKonta = stanKonta;
    }

    public String getNazwaKonta() {
        return nazwaKonta;
    }

    public void setNazwaKonta(String nazwaKonta) {
        this.nazwaKonta = nazwaKonta;
    }

    public String getRola() {
        return rola;
    }

    public void setRola(String rola) {
        this.rola = rola;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public boolean getResetowanieHasla() {
        return resetowanieHasla;
    }

    public void setResetowanieHasla(boolean resetowanieHasla) {
        this.resetowanieHasla = resetowanieHasla;
    }

    public String getStanKonta() {
        return stanKonta;
    }

    public void setStanKonta(String stanKonta) {
        this.stanKonta = stanKonta;
    }

    public String getTESTsciezkaformularza() {
        return tESTsciezkaformularza;
    }

    public void setTESTsciezkaformularza(String tESTsciezkaformularza) {
        this.tESTsciezkaformularza = tESTsciezkaformularza;
    }

    public KlientIndywidualnyDTO getPesel() {
        return pesel;
    }

    public void setPesel(KlientIndywidualnyDTO pesel) {
        this.pesel = pesel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nazwaKonta != null ? nazwaKonta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Konta)) {
            return false;
        }
        Konta other = (Konta) object;
        if ((this.nazwaKonta == null && other.nazwaKonta != null) || (this.nazwaKonta != null && !this.nazwaKonta.equals(other.nazwaKonta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.DataTransferObjects.Konta[ nazwaKonta=" + nazwaKonta + " ]";
    }
    
}
