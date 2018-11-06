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
    private  List<Nivel> lista=new ArrayList();

   
   
    @PostConstruct
            public void ini(){
                 nivel = new Nivel ();
              MantenimientoNivel man = new MantenimientoNivel();
             nivel.setCodigoEscuela(new Escuelas());
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


    
    
   
     public void agregar() {

        System.out.println("esto son las facturas" + nivel);
        MantenimientoNivel man = new MantenimientoNivel();
        man.guardarNivel(nivel);
        lista = man.consultarTodosNivel();
        nivel.setCodigoEscuela(new Escuelas());
    }
    
    public void eliminar(Nivel nivel){
        this.nivel=nivel;
        System.out.println(nivel);
        listN.remove(nivel);
    }
    
    public void eliminar(Factura factura) {
        MantenimientoFactura manf = new MantenimientoFactura();
        manf.eliminarFact(factura);
        lista = manf.consultarFact();
}
     public void actualizar(){
         int numero=listN.lastIndexOf(nivel);
         listN.set(numero, nivel);
         
         nivel = new Nivel();
     }
    
}
