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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gai
 */
@Entity
@Table(name = "VOL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vol.findAll", query = "SELECT v FROM Vol v")
    , @NamedQuery(name = "Vol.findByNumVol", query = "SELECT v FROM Vol v WHERE v.numVol = :numVol")
    , @NamedQuery(name = "Vol.findByHd\u00e9part", query = "SELECT v FROM Vol v WHERE v.hd\u00e9part = :hd\u00e9part")
    , @NamedQuery(name = "Vol.findByHarriv\u00e9e", query = "SELECT v FROM Vol v WHERE v.harriv\u00e9e = :harriv\u00e9e")})
public class Vol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "NumVol")
    private String numVol;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Hd\u00e9part")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hdépart;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Harriv\u00e9e")
    @Temporal(TemporalType.TIMESTAMP)
    private Date harrivée;
    @JoinColumn(name = "AeroportDept", referencedColumnName = "IdAeroport")
    @ManyToOne(optional = false)
    private Aeroport aeroportDept;
    @JoinColumn(name = "AeroportArr", referencedColumnName = "IdAeroport")
    @ManyToOne(optional = false)
    private Aeroport aeroportArr;

    public Vol() {
    }

    public Vol(String numVol) {
        this.numVol = numVol;
    }

    public Vol(String numVol, Date hdépart, Date harrivée) {
        this.numVol = numVol;
        this.hdépart = hdépart;
        this.harrivée = harrivée;
    }

    public String getNumVol() {
        return numVol;
    }

    public void setNumVol(String numVol) {
        this.numVol = numVol;
    }

    public Date getHdépart() {
        return hdépart;
    }

    public void setHdépart(Date hdépart) {
        this.hdépart = hdépart;
    }

    public Date getHarrivée() {
        return harrivée;
    }

    public void setHarrivée(Date harrivée) {
        this.harrivée = harrivée;
    }

    public Aeroport getAeroportDept() {
        return aeroportDept;
    }

    public void setAeroportDept(Aeroport aeroportDept) {
        this.aeroportDept = aeroportDept;
    }

    public Aeroport getAeroportArr() {
        return aeroportArr;
    }

    public void setAeroportArr(Aeroport aeroportArr) {
        this.aeroportArr = aeroportArr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numVol != null ? numVol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vol)) {
            return false;
        }
        Vol other = (Vol) object;
        if ((this.numVol == null && other.numVol != null) || (this.numVol != null && !this.numVol.equals(other.numVol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Vol[ numVol=" + numVol + " ]";
    }
    
}
