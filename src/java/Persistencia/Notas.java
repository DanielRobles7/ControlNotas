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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "notas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notas.findAll", query = "SELECT n FROM Notas n")
    , @NamedQuery(name = "Notas.findByIdNota", query = "SELECT n FROM Notas n WHERE n.idNota = :idNota")
    , @NamedQuery(name = "Notas.findByNota1", query = "SELECT n FROM Notas n WHERE n.nota1 = :nota1")
    , @NamedQuery(name = "Notas.findByNota2", query = "SELECT n FROM Notas n WHERE n.nota2 = :nota2")
    , @NamedQuery(name = "Notas.findByNota3", query = "SELECT n FROM Notas n WHERE n.nota3 = :nota3")
    , @NamedQuery(name = "Notas.findByNota4", query = "SELECT n FROM Notas n WHERE n.nota4 = :nota4")
    , @NamedQuery(name = "Notas.findByNota5", query = "SELECT n FROM Notas n WHERE n.nota5 = :nota5")
    , @NamedQuery(name = "Notas.findByNota6", query = "SELECT n FROM Notas n WHERE n.nota6 = :nota6")
    , @NamedQuery(name = "Notas.findByPromerio", query = "SELECT n FROM Notas n WHERE n.promerio = :promerio")
    , @NamedQuery(name = "Notas.findByReposicion", query = "SELECT n FROM Notas n WHERE n.reposicion = :reposicion")
    , @NamedQuery(name = "Notas.findByFinal1", query = "SELECT n FROM Notas n WHERE n.final1 = :final1")
    , @NamedQuery(name = "Notas.findByEstadoAlumno", query = "SELECT n FROM Notas n WHERE n.estadoAlumno = :estadoAlumno")
    , @NamedQuery(name = "Notas.findByEstadoNotas", query = "SELECT n FROM Notas n WHERE n.estadoNotas = :estadoNotas")
    , @NamedQuery(name = "Notas.findByCampo", query = "SELECT n FROM Notas n WHERE n.campo = :campo")})
public class Notas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_nota")
    private Integer idNota;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nota_1")
    private Double nota1;
    @Column(name = "nota_2")
    private Double nota2;
    @Column(name = "nota_3")
    private Double nota3;
    @Column(name = "nota_4")
    private Double nota4;
    @Column(name = "nota_5")
    private Double nota5;
    @Column(name = "nota_6")
    private Double nota6;
    @Column(name = "promerio")
    private Double promerio;
    @Column(name = "reposicion")
    private Double reposicion;
    @Column(name = "final")
    private Double final1;
    @Column(name = "estado_alumno")
    private String estadoAlumno;
    @Column(name = "estado_notas")
    private String estadoNotas;
    @Column(name = "campo")
    private String campo;
    @JoinColumn(name = "nie", referencedColumnName = "nie")
    @ManyToOne(optional = false)
    private Alumnos nie;
    @JoinColumn(name = "nombre_materia", referencedColumnName = "nombre_materia")
    @ManyToOne(optional = false)
    private Materias nombreMateria;

    public Notas() {
    }

    public Notas(Integer idNota) {
        this.idNota = idNota;
    }

    public Integer getIdNota() {
        return idNota;
    }

    public void setIdNota(Integer idNota) {
        this.idNota = idNota;
    }

    public Double getNota1() {
        return nota1;
    }

    public void setNota1(Double nota1) {
        this.nota1 = nota1;
    }

    public Double getNota2() {
        return nota2;
    }

    public void setNota2(Double nota2) {
        this.nota2 = nota2;
    }

    public Double getNota3() {
        return nota3;
    }

    public void setNota3(Double nota3) {
        this.nota3 = nota3;
    }

    public Double getNota4() {
        return nota4;
    }

    public void setNota4(Double nota4) {
        this.nota4 = nota4;
    }

    public Double getNota5() {
        return nota5;
    }

    public void setNota5(Double nota5) {
        this.nota5 = nota5;
    }

    public Double getNota6() {
        return nota6;
    }

    public void setNota6(Double nota6) {
        this.nota6 = nota6;
    }

    public Double getPromerio() {
        return promerio;
    }

    public void setPromerio(Double promerio) {
        this.promerio = promerio;
    }

    public Double getReposicion() {
        return reposicion;
    }

    public void setReposicion(Double reposicion) {
        this.reposicion = reposicion;
    }

    public Double getFinal1() {
        return final1;
    }

    public void setFinal1(Double final1) {
        this.final1 = final1;
    }

    public String getEstadoAlumno() {
        return estadoAlumno;
    }

    public void setEstadoAlumno(String estadoAlumno) {
        this.estadoAlumno = estadoAlumno;
    }

    public String getEstadoNotas() {
        return estadoNotas;
    }

    public void setEstadoNotas(String estadoNotas) {
        this.estadoNotas = estadoNotas;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public Alumnos getNie() {
        return nie;
    }

    public void setNie(Alumnos nie) {
        this.nie = nie;
    }

    public Materias getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(Materias nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNota != null ? idNota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notas)) {
            return false;
        }
        Notas other = (Notas) object;
        if ((this.idNota == null && other.idNota != null) || (this.idNota != null && !this.idNota.equals(other.idNota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.Notas[ idNota=" + idNota + " ]";
    }
    
}
