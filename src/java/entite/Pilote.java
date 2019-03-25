/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

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

/**
 *
 * @author gai
 */
@Entity
@Table(name = "PILOTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pilote.findAll", query = "SELECT p FROM Pilote p")
    , @NamedQuery(name = "Pilote.findByIdPilote", query = "SELECT p FROM Pilote p WHERE p.idPilote = :idPilote")
    , @NamedQuery(name = "Pilote.findByNomPilote", query = "SELECT p FROM Pilote p WHERE p.nomPilote = :nomPilote")
    , @NamedQuery(name = "Pilote.findByPrenomPilote", query = "SELECT p FROM Pilote p WHERE p.prenomPilote = :prenomPilote")})
public class Pilote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdPilote")
    private Short idPilote;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NomPilote")
    private String nomPilote;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PrenomPilote")
    private String prenomPilote;

    public Pilote() {
    }

    public Pilote(Short idPilote) {
        this.idPilote = idPilote;
    }

    public Pilote(Short idPilote, String nomPilote, String prenomPilote) {
        this.idPilote = idPilote;
        this.nomPilote = nomPilote;
        this.prenomPilote = prenomPilote;
    }

    public Short getIdPilote() {
        return idPilote;
    }

    public void setIdPilote(Short idPilote) {
        this.idPilote = idPilote;
    }

    public String getNomPilote() {
        return nomPilote;
    }

    public void setNomPilote(String nomPilote) {
        this.nomPilote = nomPilote;
    }

    public String getPrenomPilote() {
        return prenomPilote;
    }

    public void setPrenomPilote(String prenomPilote) {
        this.prenomPilote = prenomPilote;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPilote != null ? idPilote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pilote)) {
            return false;
        }
        Pilote other = (Pilote) object;
        if ((this.idPilote == null && other.idPilote != null) || (this.idPilote != null && !this.idPilote.equals(other.idPilote))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Pilote[ idPilote=" + idPilote + " ]";
    }
    
}
