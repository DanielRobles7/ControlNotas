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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "acceso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acceso.findAll", query = "SELECT a FROM Acceso a")
    , @NamedQuery(name = "Acceso.findByIdAcceso", query = "SELECT a FROM Acceso a WHERE a.idAcceso = :idAcceso")
    , @NamedQuery(name = "Acceso.findByUsuario", query = "SELECT a FROM Acceso a WHERE a.usuario = :usuario")
    , @NamedQuery(name = "Acceso.findByContrasena", query = "SELECT a FROM Acceso a WHERE a.contrasena = :contrasena")
    , @NamedQuery(name = "Acceso.findByNivelAcceso", query = "SELECT a FROM Acceso a WHERE a.nivelAcceso = :nivelAcceso")
    , @NamedQuery(name = "Acceso.findByEstado", query = "SELECT a FROM Acceso a WHERE a.estado = :estado")
    , @NamedQuery(name = "Acceso.findByCampo", query = "SELECT a FROM Acceso a WHERE a.campo = :campo")})
public class Acceso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_acceso")
    private Integer idAcceso;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "contrasena")
    private String contrasena;
    @Column(name = "nivel_acceso")
    private String nivelAcceso;
    @Column(name = "estado")
    private String estado;
    @Column(name = "campo")
    private String campo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAcceso")
    private Collection<Profesores> profesoresCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAcceso")
    private Collection<Alumnos> alumnosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAcceso")
    private Collection<Escuelas> escuelasCollection;

    public Acceso() {
    }

    public Acceso(Integer idAcceso) {
        this.idAcceso = idAcceso;
    }

    public Integer getIdAcceso() {
        return idAcceso;
    }

    public void setIdAcceso(Integer idAcceso) {
        this.idAcceso = idAcceso;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNivelAcceso() {
        return nivelAcceso;
    }

    public void setNivelAcceso(String nivelAcceso) {
        this.nivelAcceso = nivelAcceso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
    public Collection<Escuelas> getEscuelasCollection() {
        return escuelasCollection;
    }

    public void setEscuelasCollection(Collection<Escuelas> escuelasCollection) {
        this.escuelasCollection = escuelasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAcceso != null ? idAcceso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acceso)) {
            return false;
        }
        Acceso other = (Acceso) object;
        if ((this.idAcceso == null && other.idAcceso != null) || (this.idAcceso != null && !this.idAcceso.equals(other.idAcceso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.Acceso[ idAcceso=" + idAcceso + " ]";
    }
    
}
