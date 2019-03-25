/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gai
 */
@Entity
@Table(name = "AVION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Avion.findAll", query = "SELECT a FROM Avion a")
    , @NamedQuery(name = "Avion.findByNumAvion", query = "SELECT a FROM Avion a WHERE a.numAvion = :numAvion")})
public class Avion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NumAvion")
    private Integer numAvion;
    @OneToMany(mappedBy = "numAvion")
    private Collection<Affectation> affectationCollection;
    @JoinColumn(name = "BaseAeroport", referencedColumnName = "IdAeroport")
    @ManyToOne(optional = false)
    private Aeroport baseAeroport;
    @JoinColumn(name = "TypeAvion", referencedColumnName = "TypeAvion")
    @ManyToOne(optional = false)
    private Type typeAvion;

    public Avion() {
    }

    public Avion(Integer numAvion) {
        this.numAvion = numAvion;
    }

    public Integer getNumAvion() {
        return numAvion;
    }

    public void setNumAvion(Integer numAvion) {
        this.numAvion = numAvion;
    }

    @XmlTransient
    public Collection<Affectation> getAffectationCollection() {
        return affectationCollection;
    }

    public void setAffectationCollection(Collection<Affectation> affectationCollection) {
        this.affectationCollection = affectationCollection;
    }

    public Aeroport getBaseAeroport() {
        return baseAeroport;
    }

    public void setBaseAeroport(Aeroport baseAeroport) {
        this.baseAeroport = baseAeroport;
    }

    public Type getTypeAvion() {
        return typeAvion;
    }

    public void setTypeAvion(Type typeAvion) {
        this.typeAvion = typeAvion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numAvion != null ? numAvion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Avion)) {
            return false;
        }
        Avion other = (Avion) object;
        if ((this.numAvion == null && other.numAvion != null) || (this.numAvion != null && !this.numAvion.equals(other.numAvion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Avion[ numAvion=" + numAvion + " ]";
    }
    
}
