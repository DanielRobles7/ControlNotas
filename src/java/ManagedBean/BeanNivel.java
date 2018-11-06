/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import Persistencia.Nivel;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ruth.ramosusam
 */
@ManagedBean
@RequestScoped
public class BeanNivel {

    Nivel nivel=new Nivel();
    private static List<Nivel> listN=new ArrayList();
    
    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public List<Nivel> getListN() {
        return listN;
    }

    public void setListN(List<Nivel> listN) {
        this.listN = listN;
    }
    
     public void agregar(){
        System.out.println(nivel);
        
        listN.add(nivel);
        System.out.println(listN);
        
        nivel=new Nivel();
    }
    
    public void eliminar(Nivel nivel){
        this.nivel=nivel;
        System.out.println(nivel);
        listN.remove(nivel);
    }
    
    public void modificar(Nivel nivel){
        this.nivel= nivel; 
        System.out.println(nivel);
   
}
     public void actualizar(){
         int numero=listN.lastIndexOf(nivel);
         listN.set(numero, nivel);
         
         nivel = new Nivel();
     }
    
}
