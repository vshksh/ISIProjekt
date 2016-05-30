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
@Table(name = "baza_kredytow")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BazaKredytow.findAll", query = "SELECT b FROM BazaKredytow b"),
    @NamedQuery(name = "BazaKredytow.findByIDkredytu", query = "SELECT b FROM BazaKredytow b WHERE b.iDkredytu = :iDkredytu"),
    @NamedQuery(name = "BazaKredytow.findByKwota", query = "SELECT b FROM BazaKredytow b WHERE b.kwota = :kwota"),
    @NamedQuery(name = "BazaKredytow.findByWaluta", query = "SELECT b FROM BazaKredytow b WHERE b.waluta = :waluta"),
    @NamedQuery(name = "BazaKredytow.findByOprocentowanie", query = "SELECT b FROM BazaKredytow b WHERE b.oprocentowanie = :oprocentowanie"),
    @NamedQuery(name = "BazaKredytow.findByTerminSplaty", query = "SELECT b FROM BazaKredytow b WHERE b.terminSplaty = :terminSplaty"),
    @NamedQuery(name = "BazaKredytow.findByNaliczoneOdsetki", query = "SELECT b FROM BazaKredytow b WHERE b.naliczoneOdsetki = :naliczoneOdsetki")})
public class BazaKredytow implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
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
    private double oprocentowanie;
    @Basic(optional = false)
    @NotNull
    @Column(name = "termin_splaty")
    @Temporal(TemporalType.DATE)
    private Date terminSplaty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "naliczone_odsetki")
    private double naliczoneOdsetki;
    @JoinColumn(name = "PESEL", referencedColumnName = "PESEL")
    @ManyToOne(optional = false)
    private KlientIndywidualnyDTO pesel;

    public BazaKredytow() {
    }

    public BazaKredytow(Integer iDkredytu) {
        this.iDkredytu = iDkredytu;
    }

    public BazaKredytow(Integer iDkredytu, double kwota, String waluta, double oprocentowanie, Date terminSplaty, double naliczoneOdsetki) {
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

    public double getOprocentowanie() {
        return oprocentowanie;
    }

    public void setOprocentowanie(double oprocentowanie) {
        this.oprocentowanie = oprocentowanie;
    }

    public Date getTerminSplaty() {
        return terminSplaty;
    }

    public void setTerminSplaty(Date terminSplaty) {
        this.terminSplaty = terminSplaty;
    }

    public double getNaliczoneOdsetki() {
        return naliczoneOdsetki;
    }

    public void setNaliczoneOdsetki(double naliczoneOdsetki) {
        this.naliczoneOdsetki = naliczoneOdsetki;
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
        hash += (iDkredytu != null ? iDkredytu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BazaKredytow)) {
            return false;
        }
        BazaKredytow other = (BazaKredytow) object;
        if ((this.iDkredytu == null && other.iDkredytu != null) || (this.iDkredytu != null && !this.iDkredytu.equals(other.iDkredytu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.DataTransferObjects.BazaKredytow[ iDkredytu=" + iDkredytu + " ]";
    }
    
}
