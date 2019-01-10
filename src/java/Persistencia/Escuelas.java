/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ruth.ramosusam
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
    , @NamedQuery(name = "Escuelas.findByEstado", query = "SELECT e FROM Escuelas e WHERE e.estado = :estado")
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "longitud")
    private Double longitud;
    @Column(name = "latitud")
    private Double latitud;
    @Column(name = "nombre_director")
    private String nombreDirector;
    @Column(name = "estado")
    private String estado;
    @Column(name = "campo")
    private String campo;
    @JoinColumn(name = "id_acceso", referencedColumnName = "id_acceso")
    @ManyToOne(optional = false)
    private Acceso idAcceso;

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

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public String getNombreDirector() {
        return nombreDirector;
    }

    public void setNombreDirector(String nombreDirector) {
        this.nombreDirector = nombreDirector;
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

    public Acceso getIdAcceso() {
        return idAcceso;
    }

    public void setIdAcceso(Acceso idAcceso) {
        this.idAcceso = idAcceso;
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
