/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import Mantenimiento.MantenimientoAcceso;
import Mantenimiento.MantenimientoAlumnos;
import Mantenimiento.MantenimientoEscuela;
import Mantenimiento.MantenimientoNivel;
import Persistencia.Acceso;
import Persistencia.Alumnos;
import Persistencia.Escuelas;
import Persistencia.Nivel;
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
public class BeanAlumno {

    private Alumnos alumnos=new Alumnos();
    private List<Alumnos> listAl=new ArrayList();
    private List<Acceso> listAc=new ArrayList();
    private List<Escuelas> listEs=new ArrayList();
    private List<Nivel> listN=new ArrayList();
    
    @PostConstruct
    public void init(){
        alumnos.setCodigoEscuela(new Escuelas());
        alumnos.setIdAcceso(new Acceso());
        alumnos.setGrado(new Nivel());
        
        MantenimientoAcceso mac=new MantenimientoAcceso();
        MantenimientoAlumnos mal=new MantenimientoAlumnos();
        MantenimientoEscuela mes= new MantenimientoEscuela();
        MantenimientoNivel mni=new MantenimientoNivel();
        
        listAl=mal.consultarTodosAlumnos();
        listAc=mac.consultarTodosAcceso();
        listEs=mes.consultar();
        listN=mni.consultarTodosNivel();
        
    }

    public Alumnos getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Alumnos alumnos) {
        this.alumnos = alumnos;
    }

    public List<Alumnos> getListAl() {
        return listAl;
    }

    public void setListAl(List<Alumnos> listAl) {
        this.listAl = listAl;
    }

    public List<Acceso> getListAc() {
        return listAc;
    }

    public void setListAc(List<Acceso> listAc) {
        this.listAc = listAc;
    }

    public List<Escuelas> getListEs() {
        return listEs;
    }

    public void setListEs(List<Escuelas> listEs) {
        this.listEs = listEs;
    }

    public List<Nivel> getListN() {
        return listN;
    }

    public void setListN(List<Nivel> listN) {
        this.listN = listN;
    }
    
    public void agregar(){
        MantenimientoAlumnos ma=new MantenimientoAlumnos();
        
        String adv="";
        if (ma.guardarAlumnos(alumnos)==1) {
            listAl=ma.consultarTodosAlumnos();
            alumnos=new Alumnos();
            adv="Guardado exitosamente";
        } else {
            adv="Error";
        }
    }
}
