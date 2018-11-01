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
@Table(name = "escuelas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Escuelas.findAll", query = "SELECT e FROM Escuelas e")
    , @NamedQuery(name = "Escuelas.findByCodigoEscuela", query = "SELECT e FROM Escuelas e WHERE e.codigoEscuela = :codigoEscuela")
    , @NamedQuery(name = "Escuelas.findByNombreEscuela", query = "SELECT e FROM Escuelas e WHERE e.nombreEscuela = :nombreEscuela")
    , @NamedQuery(name = "Escuelas.findByDireccion", query = "SELECT e FROM Escuelas e WHERE e.direccion = :direccion")
    , @NamedQuery(name = "Escuelas.findByMunicipio", query = "SELECT e FROM Escuelas e WHERE e.municipio = :municipio")
    , @NamedQuery(name = "Escuelas.findByTelefono", query = "SELECT e FROM Escuelas e WHERE e.telefono = :telefono")
    , @NamedQuery(name = "Escuelas.findByCorreo", query = "SELECT e FROM Escuelas e WHERE e.correo = :correo")
    , @NamedQuery(name = "Escuelas.findByLongitud", query = "SELECT e FROM Escuelas e WHERE e.longitud = :longitud")
    , @NamedQuery(name = "Escuelas.findByLatitud", query = "SELECT e FROM Escuelas e WHERE e.latitud = :latitud")
    , @NamedQuery(name = "Escuelas.findByNombreDirector", query = "SELECT e FROM Escuelas e WHERE e.nombreDirector = :nombreDirector")
    , @NamedQuery(name = "Escuelas.findByCampo", query = "SELECT e FROM Escuelas e WHERE e.campo = :campo")})
public class Escuelas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo_escuela")
    private Integer codigoEscuela;
    @Column(name = "nombre_escuela")
    private String nombreEscuela;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "municipio")
    private String municipio;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "correo")
    private String correo;
    @Column(name = "longitud")
    private String longitud;
    @Column(name = "latitud")
    private String latitud;
    @Column(name = "nombre_director")
    private String nombreDirector;
    @Column(name = "campo")
    private String campo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoEscuela")
    private Collection<Profesores> profesoresCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoEscuela")
    private Collection<Alumnos> alumnosCollection;
    @JoinColumn(name = "id_acceso", referencedColumnName = "id_acceso")
    @ManyToOne(optional = false)
    private Acceso idAcceso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoEscuela")
    private Collection<Nivel> nivelCollection;

    public Escuelas() {
    }

    public Escuelas(Integer codigoEscuela) {
        this.codigoEscuela = codigoEscuela;
    }

    public Integer getCodigoEscuela() {
        return codigoEscuela;
    }

    public void setCodigoEscuela(Integer codigoEscuela) {
        this.codigoEscuela = codigoEscuela;
    }

    public String getNombreEscuela() {
        return nombreEscuela;
    }

    public void setNombreEscuela(String nombreEscuela) {
        this.nombreEscuela = nombreEscuela;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getNombreDirector() {
        return nombreDirector;
    }

    public void setNombreDirector(String nombreDirector) {
        this.nombreDirector = nombreDirector;
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

    public Acceso getIdAcceso() {
        return idAcceso;
    }

    public void setIdAcceso(Acceso idAcceso) {
        this.idAcceso = idAcceso;
    }

    @XmlTransient
    public Collection<Nivel> getNivelCollection() {
        return nivelCollection;
    }

    public void setNivelCollection(Collection<Nivel> nivelCollection) {
        this.nivelCollection = nivelCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoEscuela != null ? codigoEscuela.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Escuelas)) {
            return false;
        }
        Escuelas other = (Escuelas) object;
        if ((this.codigoEscuela == null && other.codigoEscuela != null) || (this.codigoEscuela != null && !this.codigoEscuela.equals(other.codigoEscuela))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.Escuelas[ codigoEscuela=" + codigoEscuela + " ]";
    }
    
}
