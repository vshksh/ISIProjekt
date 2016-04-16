/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DataTransferObjects;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jeremiasz
 */
@Entity
@Table(name = "rachunki")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rachunki.findAll", query = "SELECT r FROM Rachunki r"),
    @NamedQuery(name = "Rachunki.findByNumerRachunku", query = "SELECT r FROM Rachunki r WHERE r.numerRachunku = :numerRachunku"),
    @NamedQuery(name = "Rachunki.findBySaldo", query = "SELECT r FROM Rachunki r WHERE r.saldo = :saldo"),
    @NamedQuery(name = "Rachunki.findByWaluta", query = "SELECT r FROM Rachunki r WHERE r.waluta = :waluta"),
    @NamedQuery(name = "Rachunki.findByRodzajRachunku", query = "SELECT r FROM Rachunki r WHERE r.rodzajRachunku = :rodzajRachunku"),
    @NamedQuery(name = "Rachunki.findByLimitWyp\u0142aty", query = "SELECT r FROM Rachunki r WHERE r.limitWyp\u0142aty = :limitWyp\u0142aty")})
public class Rachunki implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 26)
    @Column(name = "numer_rachunku")
    private String numerRachunku;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saldo")
    private double saldo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "waluta")
    private String waluta;
    @Size(max = 20)
    @Column(name = "rodzaj_rachunku")
    private String rodzajRachunku;
    @Column(name = "limit_wyp\u0142aty")
    private Integer limitWypłaty;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numerRachunku")
    private Collection<Karty> kartyCollection;
    @JoinColumn(name = "nazwa_konta", referencedColumnName = "nazwa_konta")
    @ManyToOne(optional = false)
    private Konta nazwaKonta;

    public Rachunki() {
    }

    public Rachunki(String numerRachunku) {
        this.numerRachunku = numerRachunku;
    }

    public Rachunki(String numerRachunku, double saldo, String waluta) {
        this.numerRachunku = numerRachunku;
        this.saldo = saldo;
        this.waluta = waluta;
    }

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

    public String getRodzajRachunku() {
        return rodzajRachunku;
    }

    public void setRodzajRachunku(String rodzajRachunku) {
        this.rodzajRachunku = rodzajRachunku;
    }

    public Integer getLimitWypłaty() {
        return limitWypłaty;
    }

    public void setLimitWypłaty(Integer limitWypłaty) {
        this.limitWypłaty = limitWypłaty;
    }

    @XmlTransient
    public Collection<Karty> getKartyCollection() {
        return kartyCollection;
    }

    public void setKartyCollection(Collection<Karty> kartyCollection) {
        this.kartyCollection = kartyCollection;
    }

    public Konta getNazwaKonta() {
        return nazwaKonta;
    }

    public void setNazwaKonta(Konta nazwaKonta) {
        this.nazwaKonta = nazwaKonta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numerRachunku != null ? numerRachunku.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rachunki)) {
            return false;
        }
        Rachunki other = (Rachunki) object;
        if ((this.numerRachunku == null && other.numerRachunku != null) || (this.numerRachunku != null && !this.numerRachunku.equals(other.numerRachunku))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.DataTransferObjects.Rachunki[ numerRachunku=" + numerRachunku + " ]";
    }
    
}