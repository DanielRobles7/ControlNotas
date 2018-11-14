/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import Mantenimiento.MantenimientoAcceso;
import Mantenimiento.MantenimientoEscuela;
import Persistencia.Acceso;
import Persistencia.Escuelas;
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
public class BeanEscuela {

    private Escuelas escuela=new Escuelas();
    private List<Escuelas> listE=new ArrayList();

    
    @PostConstruct
    public void init() {
         escuela.setIdAcceso(new Acceso());
        MantenimientoEscuela mae = new MantenimientoEscuela();
//        notas.setNie(new Alumnos());
        listE = mae.consultar();

    }
    
    public Escuelas getEscuela() {
        return escuela;
    }

    public void setEscuela(Escuelas escuela) {
        this.escuela = escuela;
    }

    public List<Escuelas> getListE() {
        return listE;
    }

    public void setListE(List<Escuelas> listE) {
        this.listE = listE;
    }
    public void agregar(){
        //Agregar Acceso
        Acceso acceso=new Acceso();
        
        String nombre=escuela.getNombreDirector();
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
        
        MantenimientoAcceso ma=new MantenimientoAcceso();
        ma.guardarAcesso(acceso);
        
        //idMaximo de acceso
        idMax=ma.consultarMaxAcceso();
        Acceso acces=new Acceso();
        acces.setIdAcceso(idMax);
        
        escuela.setIdAcceso(acces);
        escuela.setEstado("Activo");
    
        //Agregar Escuela
        MantenimientoEscuela me=new MantenimientoEscuela();
        me.guardar(escuela);
        listE=me.consultar();
        
    }
    public void modificar(Escuelas escuela){
        MantenimientoEscuela me=new MantenimientoEscuela();
        escuela=me.consultarid(escuela.getCodigoEscuela());
        this.escuela=escuela;
    }
    public void eliminar(Escuelas escuela){
        MantenimientoEscuela me=new MantenimientoEscuela();
        me.eliminar(escuela);
        listE=me.consultar();
    }
    public void actualizar(){
        MantenimientoEscuela me= new MantenimientoEscuela();
        me.Actualizar(escuela);
        System.out.println("Actualizar: "+escuela);
        
        listE=me.consultar();
        
        System.out.println("esta se va actualizar: "+me.Actualizar(escuela));
    }
}
