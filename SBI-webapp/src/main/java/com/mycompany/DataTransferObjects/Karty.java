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
 * @author Jeremiasz
 */
@Entity
@Table(name = "karty")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Karty.findAll", query = "SELECT k FROM Karty k"),
    @NamedQuery(name = "Karty.findByNumerKarty", query = "SELECT k FROM Karty k WHERE k.numerKarty = :numerKarty"),
    @NamedQuery(name = "Karty.findByStatus", query = "SELECT k FROM Karty k WHERE k.status = :status"),
    @NamedQuery(name = "Karty.findByNazwaKarty", query = "SELECT k FROM Karty k WHERE k.nazwaKarty = :nazwaKarty"),
    @NamedQuery(name = "Karty.findByPin", query = "SELECT k FROM Karty k WHERE k.pin = :pin"),
    @NamedQuery(name = "Karty.findByDatawa\u017cno\u015bci", query = "SELECT k FROM Karty k WHERE k.datawa\u017cno\u015bci = :datawa\u017cno\u015bci"),
    @NamedQuery(name = "Karty.findByCvc2", query = "SELECT k FROM Karty k WHERE k.cvc2 = :cvc2"),
    @NamedQuery(name = "Karty.findByCvc21", query = "SELECT k FROM Karty k WHERE k.cvc21 = :cvc21")})
public class Karty implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "numer_karty")
    private String numerKarty;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nazwa_karty")
    private String nazwaKarty;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "PIN")
    private String pin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "Data wa\u017cno\u015bci")
    private String dataważności;
    @Column(name = "CVC2")
    private Integer cvc2;
    @Column(name = "CVC2")
    private Integer cvc21;
    @JoinColumn(name = "numer_rachunku", referencedColumnName = "numer_rachunku")
    @ManyToOne(optional = false)
    private Rachunki numerRachunku;

    public Karty() {
    }

    public Karty(String numerKarty) {
        this.numerKarty = numerKarty;
    }

    public Karty(String numerKarty, String status, String nazwaKarty, String pin, String dataważności) {
        this.numerKarty = numerKarty;
        this.status = status;
        this.nazwaKarty = nazwaKarty;
        this.pin = pin;
        this.dataważności = dataważności;
    }

    public String getNumerKarty() {
        return numerKarty;
    }

    public void setNumerKarty(String numerKarty) {
        this.numerKarty = numerKarty;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNazwaKarty() {
        return nazwaKarty;
    }

    public void setNazwaKarty(String nazwaKarty) {
        this.nazwaKarty = nazwaKarty;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getDataważności() {
        return dataważności;
    }

    public void setDataważności(String dataważności) {
        this.dataważności = dataważności;
    }

    public Integer getCvc2() {
        return cvc2;
    }

    public void setCvc2(Integer cvc2) {
        this.cvc2 = cvc2;
    }

    public Integer getCvc21() {
        return cvc21;
    }

    public void setCvc21(Integer cvc21) {
        this.cvc21 = cvc21;
    }

    public Rachunki getNumerRachunku() {
        return numerRachunku;
    }

    public void setNumerRachunku(Rachunki numerRachunku) {
        this.numerRachunku = numerRachunku;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numerKarty != null ? numerKarty.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Karty)) {
            return false;
        }
        Karty other = (Karty) object;
        if ((this.numerKarty == null && other.numerKarty != null) || (this.numerKarty != null && !this.numerKarty.equals(other.numerKarty))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.DataTransferObjects.Karty[ numerKarty=" + numerKarty + " ]";
    }
    
}
