/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gai
 */
@Entity
@Table(name = "AFFECTATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Affectation.findAll", query = "SELECT a FROM Affectation a")
    , @NamedQuery(name = "Affectation.findByNumVol", query = "SELECT a FROM Affectation a WHERE a.affectationPK.numVol = :numVol")
    , @NamedQuery(name = "Affectation.findByDateVol", query = "SELECT a FROM Affectation a WHERE a.affectationPK.dateVol = :dateVol")
    , @NamedQuery(name = "Affectation.findByIdPilote", query = "SELECT a FROM Affectation a WHERE a.idPilote = :idPilote")})
public class Affectation implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AffectationPK affectationPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdPilote")
    private short idPilote;
    @JoinColumn(name = "NumAvion", referencedColumnName = "NumAvion")
    @ManyToOne
    private Avion numAvion;

    public Affectation() {
    }

    public Affectation(AffectationPK affectationPK) {
        this.affectationPK = affectationPK;
    }

    public Affectation(AffectationPK affectationPK, short idPilote) {
        this.affectationPK = affectationPK;
        this.idPilote = idPilote;
    }

    public Affectation(String numVol, Date dateVol) {
        this.affectationPK = new AffectationPK(numVol, dateVol);
    }

    public AffectationPK getAffectationPK() {
        return affectationPK;
    }

    public void setAffectationPK(AffectationPK affectationPK) {
        this.affectationPK = affectationPK;
    }

    public short getIdPilote() {
        return idPilote;
    }

    public void setIdPilote(short idPilote) {
        this.idPilote = idPilote;
    }

    public Avion getNumAvion() {
        return numAvion;
    }

    public void setNumAvion(Avion numAvion) {
        this.numAvion = numAvion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (affectationPK != null ? affectationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Affectation)) {
            return false;
        }
        Affectation other = (Affectation) object;
        if ((this.affectationPK == null && other.affectationPK != null) || (this.affectationPK != null && !this.affectationPK.equals(other.affectationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Affectation[ affectationPK=" + affectationPK + " ]";
    }
    
}
