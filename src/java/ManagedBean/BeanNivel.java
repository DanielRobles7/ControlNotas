/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import Mantenimiento.MantenimientoEscuela;
import Mantenimiento.MantenimientoNivel;
import Persistencia.Escuelas;
import Persistencia.Nivel;
import java.io.Serializable;
import java.util.ArrayList;
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
public class BeanNivel implements Serializable {

    private Nivel nivel;
    private List<Nivel> lista = new ArrayList();
    private List<Escuelas> listaE = new ArrayList();

    @PostConstruct
    public void init() {
        nivel = new Nivel();
        MantenimientoNivel man = new MantenimientoNivel();
        MantenimientoEscuela mae = new MantenimientoEscuela();
        nivel.setCodigoEscuela(new Escuelas());
        listaE = mae.consultar();
        lista = man.consultarTodosNivel();

        for (Escuelas e : listaE) {
            System.out.println(e.getCodigoEscuela());
            System.out.println(e.getNombreEscuela());
        }

    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public List<Nivel> getLista() {
        return lista;
    }

    public void setLista(List<Nivel> lista) {
        this.lista = lista;
    }

    public List<Escuelas> getListaE() {
        return listaE;
    }

    public void setListaE(List<Escuelas> listaE) {
        this.listaE = listaE;
    }

    public void agregar() {

        System.out.println("esto son las nivel" + nivel);
        MantenimientoNivel man = new MantenimientoNivel();
        nivel.setEstado("activo");
        man.guardarNivel(nivel);
        lista = man.consultarTodosNivel();
        nivel.setCodigoEscuela(new Escuelas());
        nivel = new Nivel();
        String advertencia = "";
        
            if (man.guardarNivel(nivel) == 1) {
                advertencia = "Guardado correctamente";
            } else {
                advertencia = "No se ha guardado";
            
        }
        FacesMessage msg = new FacesMessage(advertencia);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
//    
//    public void eliminar(Nivel nivel){
//        this.nivel=nivel;
//        System.out.println(nivel);
//        lista.remove(nivel);
//    }

    public void modificar(Nivel nivel) {
        MantenimientoNivel man = new MantenimientoNivel();
        System.out.println("Modificaremos " + nivel.getGrado());
        nivel = man.consultarNivel(nivel.getGrado());

        String advertencia = "";
        if (nivel != null) {
            this.nivel = nivel;
            advertencia = "Datos Consultados correctamente";
        } else {
            advertencia = "Consulta no realizada";
        }

        System.out.println("este de modificar" + nivel);
        FacesMessage msg = new FacesMessage(advertencia);
        FacesContext.getCurrentInstance().addMessage(null, msg);

    }

    public void eliminar(Nivel nivel) {
        MantenimientoNivel manf = new MantenimientoNivel();
        manf.eliminarNivel(nivel);
        lista = manf.consultarTodosNivel();
        String advertencia = "";
        
            if (manf.eliminarNivel(nivel) == 1) {
                advertencia = "Se ha eliminado correctamente";
            } else {
                advertencia = "No se ha podido eliminar";
            
        }
        FacesMessage msg = new FacesMessage(advertencia);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void actualizar() {
        System.out.println("este es de actualizar" + nivel);
        MantenimientoNivel man = new MantenimientoNivel();
        man.ActualizarNivel(nivel);
        System.out.println(man.ActualizarNivel(nivel));

        lista = man.consultarTodosNivel();

        System.out.println("esta es actualizar" + nivel);

        String advertencia = "";
        
            if (man.ActualizarNivel(nivel) == 1) {
                advertencia = "Actualizado correctamente";
            } else {
                advertencia = "No se ha actualizado";
            }
        
        FacesMessage msg = new FacesMessage(advertencia);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
