/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author guillermo.bermudes
 */
@Entity
@Table(name = "nivel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nivel.findAll", query = "SELECT n FROM Nivel n")
    , @NamedQuery(name = "Nivel.findByGrado", query = "SELECT n FROM Nivel n WHERE n.grado = :grado")
    , @NamedQuery(name = "Nivel.findByCampo", query = "SELECT n FROM Nivel n WHERE n.campo = :campo")})
public class Nivel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "grado")
    private String grado;
    @Column(name = "campo")
    private String campo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grado")
    private Collection<Profesores> profesoresCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grado")
    private Collection<Alumnos> alumnosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grado")
    private Collection<Materias> materiasCollection;
    @JoinColumn(name = "codigo_escuela", referencedColumnName = "codigo_escuela")
    @ManyToOne(optional = false)
    private Escuelas codigoEscuela;

    public Nivel() {
    }

    public Nivel(String grado) {
        this.grado = grado;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    @XmlTransient
    public Collection<Profesores> getProfesoresCollection() {
        return profesoresCollection;
    }

    public void setProfesoresCollection(Collection<Profesores> profesoresCollection) {
        this.profesoresCollection = profesoresCollection;
    }

    @XmlTransient
    public Collection<Alumnos> getAlumnosCollection() {
        return alumnosCollection;
    }

    public void setAlumnosCollection(Collection<Alumnos> alumnosCollection) {
        this.alumnosCollection = alumnosCollection;
    }

    @XmlTransient
    public Collection<Materias> getMateriasCollection() {
        return materiasCollection;
    }

    public void setMateriasCollection(Collection<Materias> materiasCollection) {
        this.materiasCollection = materiasCollection;
    }

    public Escuelas getCodigoEscuela() {
        return codigoEscuela;
    }

    public void setCodigoEscuela(Escuelas codigoEscuela) {
        this.codigoEscuela = codigoEscuela;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grado != null ? grado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nivel)) {
            return false;
        }
        Nivel other = (Nivel) object;
        if ((this.grado == null && other.grado != null) || (this.grado != null && !this.grado.equals(other.grado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.Nivel[ grado=" + grado + " ]";
    }
    
}
