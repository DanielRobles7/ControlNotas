/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

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
        nivel.setCodigoEscuela(new Escuelas());
        
        lista=man.consultarTodosNivel();
        
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

        System.out.println("esto son las facturas" + nivel);
        MantenimientoNivel man = new MantenimientoNivel();
        man.guardarNivel(nivel);
        lista = man.consultarTodosNivel();
        nivel.setCodigoEscuela(new Escuelas());
    }
//    
//    public void eliminar(Nivel nivel){
//        this.nivel=nivel;
//        System.out.println(nivel);
//        lista.remove(nivel);
//    }

    public void eliminar(Nivel nivel) {
        MantenimientoNivel manf = new MantenimientoNivel();
        manf.eliminarNivel(nivel);
        lista = manf.consultarTodosNivel();
    }

    public void actualizar() {
        int numero = lista.lastIndexOf(nivel);
        lista.set(numero, nivel);

        nivel = new Nivel();
    }

}
