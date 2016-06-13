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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;

/**
 *
 * @author Przemek
 */
@Entity
@Table(name = "oferty")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oferty.findAll", query = "SELECT o FROM Oferty o"),
    @NamedQuery(name = "Oferty.findByNazwa", query = "SELECT o FROM Oferty o WHERE o.nazwa = :nazwa"),
    @NamedQuery(name = "Oferty.findByTyp", query = "SELECT o FROM Oferty o WHERE o.typ = :typ"),
    @NamedQuery(name = "Oferty.findByLimity", query = "SELECT o FROM Oferty o WHERE o.limity = :limity"),
    @NamedQuery(name = "Oferty.findByProcent", query = "SELECT o FROM Oferty o WHERE o.procent = :procent")})
public class Oferty implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Nazwa")
    private String nazwa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 21)
    @Column(name = "Typ")
    private String typ;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Limity")
    private Double limity;
    @Column(name = "Procent")
    private Float procent;

    public Oferty() {
    }

    public Oferty(String nazwa) {
        this.nazwa = nazwa;
    }

    public Oferty(String nazwa, String typ) {
        this.nazwa = nazwa;
        this.typ = typ;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public Double getLimity() {
        return limity;
    }

    public void setLimity(Double limity) {
        this.limity = limity;
    }

    public Float getProcent() {
        return procent;
    }

    public void setProcent(Float procent) {
        this.procent = procent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nazwa != null ? nazwa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oferty)) {
            return false;
        }
        Oferty other = (Oferty) object;
        if ((this.nazwa == null && other.nazwa != null) || (this.nazwa != null && !this.nazwa.equals(other.nazwa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.DataTransferObjects.Oferty[ nazwa=" + nazwa + " ]";
    }
    
    
}
