/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DataTransferObjects;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Przemek
 */
@Entity
@Table(name = "kredyty")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kredyty.findAll", query = "SELECT k FROM Kredyty k"),
    @NamedQuery(name = "Kredyty.findByIDkredytu", query = "SELECT k FROM Kredyty k WHERE k.iDkredytu = :iDkredytu"),
    @NamedQuery(name = "Kredyty.findByKwota", query = "SELECT k FROM Kredyty k WHERE k.kwota = :kwota"),
    @NamedQuery(name = "Kredyty.findByWaluta", query = "SELECT k FROM Kredyty k WHERE k.waluta = :waluta"),
    @NamedQuery(name = "Kredyty.findByOprocentowanie", query = "SELECT k FROM Kredyty k WHERE k.oprocentowanie = :oprocentowanie"),
    @NamedQuery(name = "Kredyty.findByTerminSplaty", query = "SELECT k FROM Kredyty k WHERE k.terminSplaty = :terminSplaty"),
    @NamedQuery(name = "Kredyty.findByNaliczoneOdsetki", query = "SELECT k FROM Kredyty k WHERE k.naliczoneOdsetki = :naliczoneOdsetki"),
    @NamedQuery(name = "Kredyty.findByZatwierdzenie", query = "SELECT k FROM Kredyty k WHERE k.zatwierdzenie = :zatwierdzenie")})
public class Kredyty implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_kredytu")
    private Integer iDkredytu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "kwota")
    private double kwota;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "waluta")
    private String waluta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "oprocentowanie")
    private float oprocentowanie;
    @Basic(optional = false)
    @NotNull
    @Column(name = "termin_splaty")
    @Temporal(TemporalType.DATE)
    private Date terminSplaty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "naliczone_odsetki")
    private float naliczoneOdsetki;
    @Column(name = "zatwierdzenie")
    private Short zatwierdzenie;
    @JoinColumn(name = "rachunkinumer_rachunku", referencedColumnName = "numer_rachunku")
    @ManyToOne(optional = false)
    private Rachunki rachunkinumerRachunku;

    public Kredyty() {
    }

    public Kredyty(Integer iDkredytu) {
        this.iDkredytu = iDkredytu;
    }

    public Kredyty(Integer iDkredytu, double kwota, String waluta, float oprocentowanie, Date terminSplaty, float naliczoneOdsetki) {
        this.iDkredytu = iDkredytu;
        this.kwota = kwota;
        this.waluta = waluta;
        this.oprocentowanie = oprocentowanie;
        this.terminSplaty = terminSplaty;
        this.naliczoneOdsetki = naliczoneOdsetki;
    }

    public Integer getIDkredytu() {
        return iDkredytu;
    }

    public void setIDkredytu(Integer iDkredytu) {
        this.iDkredytu = iDkredytu;
    }

    public double getKwota() {
        return kwota;
    }

    public void setKwota(double kwota) {
        this.kwota = kwota;
    }

    public String getWaluta() {
        return waluta;
    }

    public void setWaluta(String waluta) {
        this.waluta = waluta;
    }

    public float getOprocentowanie() {
        return oprocentowanie;
    }

    public void setOprocentowanie(float oprocentowanie) {
        this.oprocentowanie = oprocentowanie;
    }

    public Date getTerminSplaty() {
        return terminSplaty;
    }

    public void setTerminSplaty(Date terminSplaty) {
        this.terminSplaty = terminSplaty;
    }

    public float getNaliczoneOdsetki() {
        return naliczoneOdsetki;
    }

    public void setNaliczoneOdsetki(float naliczoneOdsetki) {
        this.naliczoneOdsetki = naliczoneOdsetki;
    }

    public Short getZatwierdzenie() {
        return zatwierdzenie;
    }

    public void setZatwierdzenie(Short zatwierdzenie) {
        this.zatwierdzenie = zatwierdzenie;
    }

    public Rachunki getRachunkinumerRachunku() {
        return rachunkinumerRachunku;
    }

    public void setRachunkinumerRachunku(Rachunki rachunkinumerRachunku) {
        this.rachunkinumerRachunku = rachunkinumerRachunku;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDkredytu != null ? iDkredytu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kredyty)) {
            return false;
        }
        Kredyty other = (Kredyty) object;
        if ((this.iDkredytu == null && other.iDkredytu != null) || (this.iDkredytu != null && !this.iDkredytu.equals(other.iDkredytu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.DataTransferObjects.Kredyty[ iDkredytu=" + iDkredytu + " ]";
    }
    
}
