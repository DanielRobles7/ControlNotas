/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import Mantenimiento.MantenimientoAlumnos;
import Mantenimiento.MantenimientoMaterias;
import Mantenimiento.MantenimientoNotas;
import Persistencia.Alumnos;
import Persistencia.Materias;
import Persistencia.Notas;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ruth.ramosusam
 */
@ManagedBean
@RequestScoped
public class BeanAlumnoConsulta {

    
    private List<Notas> listN=new ArrayList();
    private Notas not;
    private List<Materias> listM=new ArrayList();
    private Materias mat;
    private List<Alumnos> listA=new ArrayList();
    private Alumnos alu;

    public List<Notas> getListN() {
        return listN;
    }

    public void setListN(List<Notas> listN) {
        this.listN = listN;
    }

    public Notas getNot() {
        return not;
    }

    public void setNot(Notas not) {
        this.not = not;
    }

    public List<Materias> getListM() {
        return listM;
    }

    public void setListM(List<Materias> listM) {
        this.listM = listM;
    }

    public Materias getMat() {
        return mat;
    }

    public void setMat(Materias mat) {
        this.mat = mat;
    }

    public List<Alumnos> getListA() {
        return listA;
    }

    public void setListA(List<Alumnos> listA) {
        this.listA = listA;
    }

    public Alumnos getAlu() {
        return alu;
    }

    public void setAlu(Alumnos alu) {
        this.alu = alu;
    }
    
    @PostConstruct
    public void init() {
        MantenimientoAlumnos ma=new MantenimientoAlumnos();
        MantenimientoMaterias mm=new MantenimientoMaterias();
        MantenimientoNotas mn=new MantenimientoNotas();
        
        listA=ma.consultarTodosAlumnos();
        listM=mm.consultartodasMaterias();
        listN=mn.consultar();
    }
    
}
