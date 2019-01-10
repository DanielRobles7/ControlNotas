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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

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
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    
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

    public SimpleDateFormat getFormato() {
        return formato;
    }

    public void setFormato(SimpleDateFormat formato) {
        this.formato = formato;
    }
    
    
    
    public void agregar(){
        Acceso acceso=new Acceso();
        
        String nombre=alumnos.getNombre();
        String usuario;
        String password;
        Integer idMax;
        usuario = nombre.substring(0,6);
        
        int numeroAleatorio = (int) (Math.random()*999)+100;
        password= usuario+numeroAleatorio;
        
        acceso.setContrasena(password);
        acceso.setEstado("Activo");
        acceso.setIdAcceso(0);
        acceso.setUsuario(usuario);
        acceso.setNivelAcceso("Director");
        
        MantenimientoAcceso mac=new MantenimientoAcceso();
        mac.guardarAcesso(acceso);
        
        //idMaximo de acceso
        idMax=mac.consultarMaxAcceso();
        Acceso acces=new Acceso();
        acces.setIdAcceso(idMax);
        
        alumnos.setIdAcceso(acces);
        alumnos.setEstado("activo");
        
        MantenimientoAlumnos ma=new MantenimientoAlumnos();
        alumnos.setEstado("activo");
        String fecha=formato.format(new Date());
        alumnos.setFechaRegistro(fecha);
        String adv="";
        if (ma.guardarAlumnos(alumnos)==1) {
            listAl=ma.consultarTodosAlumnos();
            alumnos=new Alumnos();
            adv="Guardado exitosamente";
        } else {
            adv="Error";
        }
        alumnos.setCodigoEscuela(new Escuelas());
        alumnos.setIdAcceso(new Acceso());
        alumnos.setGrado(new Nivel());
        
        FacesMessage msg = new FacesMessage(adv);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void modificar(Alumnos alumnos){
        System.out.println("Alumno:"+alumnos.getNie());
        MantenimientoAlumnos ma=new MantenimientoAlumnos();
        alumnos= ma.consultarAlumnos(alumnos.getNie());
        this.alumnos=alumnos;
        String adv="";
        if (alumnos!=null) {
            adv="Consulta Exitosa";
        } else {
            adv="Error al consultar";
        }
        FacesMessage msg = new FacesMessage(adv);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void eliminar(Alumnos alumnos){
        MantenimientoAlumnos ma=new MantenimientoAlumnos();
         
        String adv="";
        if (ma.eliminarAlumnos(alumnos)== 1) {
            listAl=ma.consultarTodosAlumnos();
            adv="Eliminado Correctamente";
        } else {
            adv="Error al eliminar";
        }
        FacesMessage msg = new FacesMessage(adv);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public void actualizar(){
        MantenimientoAlumnos ma=new MantenimientoAlumnos();
        alumnos.setEstado("activo");
        String adv="";
        if (ma.ActualizarAlumnos(alumnos)==1) {
            listAl=ma.consultarTodosAlumnos();
            alumnos=new Alumnos();
            adv="Modificado exitosamente";
        } else {
            adv="Error al modificar";
        }
        FacesMessage msg = new FacesMessage(adv);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
}
