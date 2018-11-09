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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

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
      
  for(Escuelas e: listaE){
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
        man.guardarNivel(nivel);
        lista = man.consultarTodosNivel();
        nivel.setCodigoEscuela(new Escuelas());
        nivel=new Nivel();
    }
//    
//    public void eliminar(Nivel nivel){
//        this.nivel=nivel;
//        System.out.println(nivel);
//        lista.remove(nivel);
//    }

    public void modificar(Nivel nivel) {
        MantenimientoNivel man = new MantenimientoNivel();
        System.out.println("Modificaremos "+nivel.getGrado());
        nivel = man.consultarNivel(nivel.getGrado());
        this.nivel = nivel;

        System.out.println("este de modificar" + nivel);

    }

    public void eliminar(Nivel nivel) {
        MantenimientoNivel manf = new MantenimientoNivel();
        manf.eliminarNivel(nivel);
        lista = manf.consultarTodosNivel();
    }

    public void actualizar() {
        System.out.println("este es de actualizar"+nivel);
          MantenimientoNivel man = new MantenimientoNivel();
          man.ActualizarNivel(nivel);
         System.out.println(man.ActualizarNivel(nivel)); 
       
         lista= man.consultarTodosNivel();
         
         System.out.println("esta es actualizar"+ nivel);

    }

}
