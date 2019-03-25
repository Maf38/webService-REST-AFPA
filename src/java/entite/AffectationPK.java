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
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author gai
 */
@Embeddable
public class AffectationPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "NumVol")
    private String numVol;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateVol")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateVol;

    public AffectationPK() {
    }

    public AffectationPK(String numVol, Date dateVol) {
        this.numVol = numVol;
        this.dateVol = dateVol;
    }

    public String getNumVol() {
        return numVol;
    }

    public void setNumVol(String numVol) {
        this.numVol = numVol;
    }

    public Date getDateVol() {
        return dateVol;
    }

    public void setDateVol(Date dateVol) {
        this.dateVol = dateVol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numVol != null ? numVol.hashCode() : 0);
        hash += (dateVol != null ? dateVol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AffectationPK)) {
            return false;
        }
        AffectationPK other = (AffectationPK) object;
        if ((this.numVol == null && other.numVol != null) || (this.numVol != null && !this.numVol.equals(other.numVol))) {
            return false;
        }
        if ((this.dateVol == null && other.dateVol != null) || (this.dateVol != null && !this.dateVol.equals(other.dateVol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.AffectationPK[ numVol=" + numVol + ", dateVol=" + dateVol + " ]";
    }
    
}
