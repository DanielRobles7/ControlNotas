/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;


import Persistencia.Notas;
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
public class BeanNotas {

     Notas notas=new Notas();
    List<Notas> listNo=new ArrayList();
    
    
    public BeanNotas() {
    }

    public Notas getNotas() {
        return notas;
    }

    public void setNotas(Notas notas) {
        this.notas = notas;
    }

    public List<Notas> getListNo() {
        return listNo;
    }

    public void setListNo(List<Notas> listNo) {
        this.listNo = listNo;
    }
    
    
    
    public void agregar(){
        System.out.println(notas);
        
        listNo.add(notas);
        System.out.println(listNo);
        
        notas=new Notas();
    }
    public void eliminar(Notas notas){
        this.notas=notas;
        System.out.println(notas);
        listNo.remove(notas);
    }
    
    public void modificar(Notas notas){
        this.notas= notas; 
        System.out.println(notas);
   
}
     public void actualizar(){
         int numero=listNo.lastIndexOf(notas);
         listNo.set(numero, notas);
         
         notas = new Notas();
     }
    
}
