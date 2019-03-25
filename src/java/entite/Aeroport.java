/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

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
 * @author gai
 */
@Entity
@Table(name = "AEROPORT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aeroport.findAll", query = "SELECT a FROM Aeroport a")
    , @NamedQuery(name = "Aeroport.findByIdAeroport", query = "SELECT a FROM Aeroport a WHERE a.idAeroport = :idAeroport")
    , @NamedQuery(name = "Aeroport.findByNomAeroport", query = "SELECT a FROM Aeroport a WHERE a.nomAeroport = :nomAeroport")
    , @NamedQuery(name = "Aeroport.findByNomVilleDesservie", query = "SELECT a FROM Aeroport a WHERE a.nomVilleDesservie = :nomVilleDesservie")})
public class Aeroport implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "IdAeroport")
    private String idAeroport;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NomAeroport")
    private String nomAeroport;
    @Size(max = 50)
    @Column(name = "NomVilleDesservie")
    private String nomVilleDesservie;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aeroportDept")
    private Collection<Vol> volCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aeroportArr")
    private Collection<Vol> volCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "baseAeroport")
    private Collection<Avion> avionCollection;

    public Aeroport() {
    }

    public Aeroport(String idAeroport) {
        this.idAeroport = idAeroport;
    }

    public Aeroport(String idAeroport, String nomAeroport) {
        this.idAeroport = idAeroport;
        this.nomAeroport = nomAeroport;
    }

    public String getIdAeroport() {
        return idAeroport;
    }

    public void setIdAeroport(String idAeroport) {
        this.idAeroport = idAeroport;
    }

    public String getNomAeroport() {
        return nomAeroport;
    }

    public void setNomAeroport(String nomAeroport) {
        this.nomAeroport = nomAeroport;
    }

    public String getNomVilleDesservie() {
        return nomVilleDesservie;
    }

    public void setNomVilleDesservie(String nomVilleDesservie) {
        this.nomVilleDesservie = nomVilleDesservie;
    }

    @XmlTransient
    public Collection<Vol> getVolCollection() {
        return volCollection;
    }

    public void setVolCollection(Collection<Vol> volCollection) {
        this.volCollection = volCollection;
    }

    @XmlTransient
    public Collection<Vol> getVolCollection1() {
        return volCollection1;
    }

    public void setVolCollection1(Collection<Vol> volCollection1) {
        this.volCollection1 = volCollection1;
    }

    @XmlTransient
    public Collection<Avion> getAvionCollection() {
        return avionCollection;
    }

    public void setAvionCollection(Collection<Avion> avionCollection) {
        this.avionCollection = avionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAeroport != null ? idAeroport.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aeroport)) {
            return false;
        }
        Aeroport other = (Aeroport) object;
        if ((this.idAeroport == null && other.idAeroport != null) || (this.idAeroport != null && !this.idAeroport.equals(other.idAeroport))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Aeroport[ idAeroport=" + idAeroport + " ]";
    }
    
}
