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
 * @author eliseo.garciausam
 */
@Entity
@Table(name = "profesores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesores.findAll", query = "SELECT p FROM Profesores p")
    , @NamedQuery(name = "Profesores.findByEscalafon", query = "SELECT p FROM Profesores p WHERE p.escalafon = :escalafon")
    , @NamedQuery(name = "Profesores.findByNombre", query = "SELECT p FROM Profesores p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Profesores.findByApellido", query = "SELECT p FROM Profesores p WHERE p.apellido = :apellido")
    , @NamedQuery(name = "Profesores.findByEmail", query = "SELECT p FROM Profesores p WHERE p.email = :email")
    , @NamedQuery(name = "Profesores.findByDireccion", query = "SELECT p FROM Profesores p WHERE p.direccion = :direccion")
    , @NamedQuery(name = "Profesores.findByEdad", query = "SELECT p FROM Profesores p WHERE p.edad = :edad")
    , @NamedQuery(name = "Profesores.findByTelefono", query = "SELECT p FROM Profesores p WHERE p.telefono = :telefono")
    , @NamedQuery(name = "Profesores.findByFechaNacimiento", query = "SELECT p FROM Profesores p WHERE p.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Profesores.findByFechaRegistro", query = "SELECT p FROM Profesores p WHERE p.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "Profesores.findByEstado", query = "SELECT p FROM Profesores p WHERE p.estado = :estado")
    , @NamedQuery(name = "Profesores.findByCampo", query = "SELECT p FROM Profesores p WHERE p.campo = :campo")})
public class Profesores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "escalafon")
    private Integer escalafon;
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

    public Profesores() {
    }

    public Profesores(Integer escalafon) {
        this.escalafon = escalafon;
    }

    public Integer getEscalafon() {
        return escalafon;
    }

    public void setEscalafon(Integer escalafon) {
        this.escalafon = escalafon;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (escalafon != null ? escalafon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesores)) {
            return false;
        }
        Profesores other = (Profesores) object;
        if ((this.escalafon == null && other.escalafon != null) || (this.escalafon != null && !this.escalafon.equals(other.escalafon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.Profesores[ escalafon=" + escalafon + " ]";
    }
    
}
