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
@Table(name = "materias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materias.findAll", query = "SELECT m FROM Materias m")
    , @NamedQuery(name = "Materias.findByNombreMateria", query = "SELECT m FROM Materias m WHERE m.nombreMateria = :nombreMateria")
    , @NamedQuery(name = "Materias.findByPonderacion1", query = "SELECT m FROM Materias m WHERE m.ponderacion1 = :ponderacion1")
    , @NamedQuery(name = "Materias.findByPonderacion2", query = "SELECT m FROM Materias m WHERE m.ponderacion2 = :ponderacion2")
    , @NamedQuery(name = "Materias.findByPonderacion3", query = "SELECT m FROM Materias m WHERE m.ponderacion3 = :ponderacion3")
    , @NamedQuery(name = "Materias.findByPonderacion4", query = "SELECT m FROM Materias m WHERE m.ponderacion4 = :ponderacion4")
    , @NamedQuery(name = "Materias.findByPonderacion5", query = "SELECT m FROM Materias m WHERE m.ponderacion5 = :ponderacion5")
    , @NamedQuery(name = "Materias.findByPonderacion6", query = "SELECT m FROM Materias m WHERE m.ponderacion6 = :ponderacion6")
    , @NamedQuery(name = "Materias.findByCampo", query = "SELECT m FROM Materias m WHERE m.campo = :campo")})
public class Materias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nombre_materia")
    private String nombreMateria;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ponderacion_1")
    private Double ponderacion1;
    @Column(name = "ponderacion_2")
    private Double ponderacion2;
    @Column(name = "ponderacion_3")
    private Double ponderacion3;
    @Column(name = "ponderacion_4")
    private Double ponderacion4;
    @Column(name = "ponderacion_5")
    private Double ponderacion5;
    @Column(name = "ponderacion_6")
    private Double ponderacion6;
    @Column(name = "campo")
    private String campo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nombreMateria")
    private Collection<Notas> notasCollection;
    @JoinColumn(name = "grado", referencedColumnName = "grado")
    @ManyToOne(optional = false)
    private Nivel grado;

    public Materias() {
    }

    public Materias(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public Double getPonderacion1() {
        return ponderacion1;
    }

    public void setPonderacion1(Double ponderacion1) {
        this.ponderacion1 = ponderacion1;
    }

    public Double getPonderacion2() {
        return ponderacion2;
    }

    public void setPonderacion2(Double ponderacion2) {
        this.ponderacion2 = ponderacion2;
    }

    public Double getPonderacion3() {
        return ponderacion3;
    }

    public void setPonderacion3(Double ponderacion3) {
        this.ponderacion3 = ponderacion3;
    }

    public Double getPonderacion4() {
        return ponderacion4;
    }

    public void setPonderacion4(Double ponderacion4) {
        this.ponderacion4 = ponderacion4;
    }

    public Double getPonderacion5() {
        return ponderacion5;
    }

    public void setPonderacion5(Double ponderacion5) {
        this.ponderacion5 = ponderacion5;
    }

    public Double getPonderacion6() {
        return ponderacion6;
    }

    public void setPonderacion6(Double ponderacion6) {
        this.ponderacion6 = ponderacion6;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    @XmlTransient
    public Collection<Notas> getNotasCollection() {
        return notasCollection;
    }

    public void setNotasCollection(Collection<Notas> notasCollection) {
        this.notasCollection = notasCollection;
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
        hash += (nombreMateria != null ? nombreMateria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materias)) {
            return false;
        }
        Materias other = (Materias) object;
        if ((this.nombreMateria == null && other.nombreMateria != null) || (this.nombreMateria != null && !this.nombreMateria.equals(other.nombreMateria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.Materias[ nombreMateria=" + nombreMateria + " ]";
    }
    
}
