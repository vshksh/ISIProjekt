package com.mycompany.DataTransferObjects;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlTransient;

/**
 *  Ta klasa jest mapowaniem tabeli bazy danych na klasę javową.
 *  Robi się je automatycznie poprzez prawy przycisk na pakiecie -> New -> Entity Classes from Database
 */

@Entity
@Table(name="klienci_indywidualni")
public class KlientIndywidualnyDTO implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "data_urodzenia")
    @Temporal(TemporalType.DATE)
    private Date dataUrodzenia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Plec")
    private String plec;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pesel")
    private Collection<Konta> kontaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pesel")
    private Collection<BazaKredytow> bazaKredytowCollection;



    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "PESEL")
    private String pesel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Imiona")
    private String imiona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Nazwisko")
    private String nazwisko;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Telefon")
    private String telefon;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "adres_email")
    private String adresEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "adres_korespondencji")
    private String adresKorespondencji;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "kod_pocztowy")
    private String kodPocztowy;
       
   


	public String getImiona() {
		return imiona;
	}

	public void setImiona(String imie) {
		this.imiona = imie;
	}
        
        public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
        
        public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
        
              public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
      


    public KlientIndywidualnyDTO() {
    }

    public KlientIndywidualnyDTO(String pesel) {
        this.pesel = pesel;
    }

    public KlientIndywidualnyDTO(String pesel, String imiona, String nazwisko, String telefon, String adresEmail, String adresKorespondencji, String kodPocztowy) {
        this.pesel = pesel;
        this.imiona = imiona;
        this.nazwisko = nazwisko;
        this.telefon = telefon;
        this.adresEmail = adresEmail;
        this.adresKorespondencji = adresKorespondencji;
        this.kodPocztowy = kodPocztowy;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pesel != null ? pesel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KlientIndywidualnyDTO)) {
            return false;
        }
        KlientIndywidualnyDTO other = (KlientIndywidualnyDTO) object;
        if ((this.pesel == null && other.pesel != null) || (this.pesel != null && !this.pesel.equals(other.pesel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.DataTransferObjects.FormularzRejestracjiDTO[ pesel=" + pesel + " ]";
    }

    public Date getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(Date dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    @XmlTransient
    public Collection<Konta> getKontaCollection() {
        return kontaCollection;
    }

    public void setKontaCollection(Collection<Konta> kontaCollection) {
        this.kontaCollection = kontaCollection;
    }

    @XmlTransient
    public Collection<BazaKredytow> getBazaKredytowCollection() {
        return bazaKredytowCollection;
    }

    public void setBazaKredytowCollection(Collection<BazaKredytow> bazaKredytowCollection) {
        this.bazaKredytowCollection = bazaKredytowCollection;
    }


    


}
