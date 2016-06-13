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
 * @author Przemek
 */
@Entity
@Table(name = "konta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Konta.findAll", query = "SELECT k FROM Konta k"),
    @NamedQuery(name = "Konta.findByLogin", query = "SELECT k FROM Konta k WHERE k.login = :login"),
    @NamedQuery(name = "Konta.findByHaslo", query = "SELECT k FROM Konta k WHERE k.haslo = :haslo"),
    @NamedQuery(name = "Konta.findByRola", query = "SELECT k FROM Konta k WHERE k.rola = :rola"),
    @NamedQuery(name = "Konta.findByResetowanieHasla", query = "SELECT k FROM Konta k WHERE k.resetowanieHasla = :resetowanieHasla"),
    @NamedQuery(name = "Konta.findByNazwaKonta", query = "SELECT k FROM Konta k WHERE k.nazwaKonta = :nazwaKonta"),
    @NamedQuery(name = "Konta.findByStanKonta", query = "SELECT k FROM Konta k WHERE k.stanKonta = :stanKonta"),
    @NamedQuery(name = "Konta.findByTESTsciezkaformularza", query = "SELECT k FROM Konta k WHERE k.tESTsciezkaformularza = :tESTsciezkaformularza"),
    @NamedQuery(name = "Konta.findByPesel", query = "SELECT k FROM Konta k WHERE k.pesel = :pesel")})
public class Konta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "haslo")
    private String haslo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "rola")
    private String rola;
    @Column(name = "resetowanie_hasla")
    private Boolean resetowanieHasla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "nazwa_konta")
    private String nazwaKonta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "stan_konta")
    private String stanKonta;
    @Size(max = 60)
    @Column(name = "TEST_sciezka_formularza")
    private String tESTsciezkaformularza;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "PESEL")
    private String pesel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kontaIDkonta")
    private Collection<Rachunki> rachunkiCollection;

    public Konta() {
    }

    public Konta(String login) {
        this.login = login;
    }

    public Konta(String login, String haslo, String rola, String nazwaKonta, String stanKonta, String pesel) {
        this.login = login;
        this.haslo = haslo;
        this.rola = rola;
        this.nazwaKonta = nazwaKonta;
        this.stanKonta = stanKonta;
        this.pesel = pesel;
    }

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

    public String getRola() {
        return rola;
    }

    public void setRola(String rola) {
        this.rola = rola;
    }

    public Boolean getResetowanieHasla() {
        return resetowanieHasla;
    }

    public void setResetowanieHasla(Boolean resetowanieHasla) {
        this.resetowanieHasla = resetowanieHasla;
    }

    public String getNazwaKonta() {
        return nazwaKonta;
    }

    public void setNazwaKonta(String nazwaKonta) {
        this.nazwaKonta = nazwaKonta;
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

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    @XmlTransient
    public Collection<Rachunki> getRachunkiCollection() {
        return rachunkiCollection;
    }

    public void setRachunkiCollection(Collection<Rachunki> rachunkiCollection) {
        this.rachunkiCollection = rachunkiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (login != null ? login.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Konta)) {
            return false;
        }
        Konta other = (Konta) object;
        if ((this.login == null && other.login != null) || (this.login != null && !this.login.equals(other.login))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.DataTransferObjects.Konta[ login=" + login + " ]";
    }
    
}
