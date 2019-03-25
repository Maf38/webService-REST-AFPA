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
 * @author gai
 */
@Entity
@Table(name = "TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Type.findAll", query = "SELECT t FROM Type t")
    , @NamedQuery(name = "Type.findByTypeAvion", query = "SELECT t FROM Type t WHERE t.typeAvion = :typeAvion")
    , @NamedQuery(name = "Type.findByCapacite", query = "SELECT t FROM Type t WHERE t.capacite = :capacite")})
public class Type implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "TypeAvion")
    private String typeAvion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Capacite")
    private int capacite;
    @JoinColumn(name = "idConstructeur", referencedColumnName = "IdConstructeur")
    @ManyToOne(optional = false)
    private Constructeur idConstructeur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeAvion")
    private Collection<Avion> avionCollection;

    public Type() {
    }

    public Type(String typeAvion) {
        this.typeAvion = typeAvion;
    }

    public Type(String typeAvion, int capacite) {
        this.typeAvion = typeAvion;
        this.capacite = capacite;
    }

    public String getTypeAvion() {
        return typeAvion;
    }

    public void setTypeAvion(String typeAvion) {
        this.typeAvion = typeAvion;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public Constructeur getIdConstructeur() {
        return idConstructeur;
    }

    public void setIdConstructeur(Constructeur idConstructeur) {
        this.idConstructeur = idConstructeur;
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
        hash += (typeAvion != null ? typeAvion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Type)) {
            return false;
        }
        Type other = (Type) object;
        if ((this.typeAvion == null && other.typeAvion != null) || (this.typeAvion != null && !this.typeAvion.equals(other.typeAvion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Type[ typeAvion=" + typeAvion + " ]";
    }
    
}
