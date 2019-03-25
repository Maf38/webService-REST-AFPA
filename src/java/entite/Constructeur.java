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
@Table(name = "CONSTRUCTEUR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Constructeur.findAll", query = "SELECT c FROM Constructeur c")
    , @NamedQuery(name = "Constructeur.findByIdConstructeur", query = "SELECT c FROM Constructeur c WHERE c.idConstructeur = :idConstructeur")
    , @NamedQuery(name = "Constructeur.findByNomConstructeur", query = "SELECT c FROM Constructeur c WHERE c.nomConstructeur = :nomConstructeur")})
public class Constructeur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdConstructeur")
    private Short idConstructeur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NomConstructeur")
    private String nomConstructeur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConstructeur")
    private Collection<Type> typeCollection;

    public Constructeur() {
    }

    public Constructeur(Short idConstructeur) {
        this.idConstructeur = idConstructeur;
    }

    public Constructeur(Short idConstructeur, String nomConstructeur) {
        this.idConstructeur = idConstructeur;
        this.nomConstructeur = nomConstructeur;
    }

    public Short getIdConstructeur() {
        return idConstructeur;
    }

    public void setIdConstructeur(Short idConstructeur) {
        this.idConstructeur = idConstructeur;
    }

    public String getNomConstructeur() {
        return nomConstructeur;
    }

    public void setNomConstructeur(String nomConstructeur) {
        this.nomConstructeur = nomConstructeur;
    }

    @XmlTransient
    public Collection<Type> getTypeCollection() {
        return typeCollection;
    }

    public void setTypeCollection(Collection<Type> typeCollection) {
        this.typeCollection = typeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConstructeur != null ? idConstructeur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Constructeur)) {
            return false;
        }
        Constructeur other = (Constructeur) object;
        if ((this.idConstructeur == null && other.idConstructeur != null) || (this.idConstructeur != null && !this.idConstructeur.equals(other.idConstructeur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Constructeur[ idConstructeur=" + idConstructeur + " ]";
    }
    
}
