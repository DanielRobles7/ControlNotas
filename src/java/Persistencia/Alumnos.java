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
 * @author eliseo.garciausam
 */
@Entity
@Table(name = "alumnos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alumnos.findAll", query = "SELECT a FROM Alumnos a")
    , @NamedQuery(name = "Alumnos.findByNie", query = "SELECT a FROM Alumnos a WHERE a.nie = :nie")
    , @NamedQuery(name = "Alumnos.findByNombre", query = "SELECT a FROM Alumnos a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Alumnos.findByApellido", query = "SELECT a FROM Alumnos a WHERE a.apellido = :apellido")
    , @NamedQuery(name = "Alumnos.findByEmail", query = "SELECT a FROM Alumnos a WHERE a.email = :email")
    , @NamedQuery(name = "Alumnos.findByDireccion", query = "SELECT a FROM Alumnos a WHERE a.direccion = :direccion")
    , @NamedQuery(name = "Alumnos.findByEdad", query = "SELECT a FROM Alumnos a WHERE a.edad = :edad")
    , @NamedQuery(name = "Alumnos.findByTelefono", query = "SELECT a FROM Alumnos a WHERE a.telefono = :telefono")
    , @NamedQuery(name = "Alumnos.findByFechaNacimiento", query = "SELECT a FROM Alumnos a WHERE a.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Alumnos.findByFechaRegistro", query = "SELECT a FROM Alumnos a WHERE a.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "Alumnos.findByEstado", query = "SELECT a FROM Alumnos a WHERE a.estado = :estado")
    , @NamedQuery(name = "Alumnos.findByCampo", query = "SELECT a FROM Alumnos a WHERE a.campo = :campo")})
public class Alumnos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nie")
    private Integer nie;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "email")
    private String email;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "edad")
    private Integer edad;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;
    @Column(name = "fecha_registro")
    private String fechaRegistro;
    @Column(name = "estado")
    private String estado;
    @Column(name = "campo")
    private String campo;
    @JoinColumn(name = "id_acceso", referencedColumnName = "id_acceso")
    @ManyToOne(optional = false)
    private Acceso idAcceso;
    @JoinColumn(name = "codigo_escuela", referencedColumnName = "codigo_escuela")
    @ManyToOne(optional = false)
    private Escuelas codigoEscuela;
    @JoinColumn(name = "grado", referencedColumnName = "grado")
    @ManyToOne(optional = false)
    private Nivel grado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nie")
    private Collection<Notas> notasCollection;

    public Alumnos() {
    }

    public Alumnos(Integer nie) {
        this.nie = nie;
    }

    public Integer getNie() {
        return nie;
    }

    public void setNie(Integer nie) {
        this.nie = nie;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
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

    public Escuelas getCodigoEscuela() {
        return codigoEscuela;
    }

    public void setCodigoEscuela(Escuelas codigoEscuela) {
        this.codigoEscuela = codigoEscuela;
    }

    public Nivel getGrado() {
        return grado;
    }

    public void setGrado(Nivel grado) {
        this.grado = grado;
    }

    @XmlTransient
    public Collection<Notas> getNotasCollection() {
        return notasCollection;
    }

    public void setNotasCollection(Collection<Notas> notasCollection) {
        this.notasCollection = notasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nie != null ? nie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumnos)) {
            return false;
        }
        Alumnos other = (Alumnos) object;
        if ((this.nie == null && other.nie != null) || (this.nie != null && !this.nie.equals(other.nie))) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "Persistencia.Alumnos[ nie=" + nie + " ]";
//    }
    @Override
    public String toString() {
        return "Alumnos{" + "nie=" + nie + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", direccion=" + direccion + ", edad=" + edad + ", telefono=" + telefono + ", fechaNacimiento=" + fechaNacimiento + ", fechaRegistro=" + fechaRegistro + ", estado=" + estado + ", campo=" + campo + '}';
    }
    
}
