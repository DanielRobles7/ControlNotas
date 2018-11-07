/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;


import Mantenimiento.MantenimientoMaterias;
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
public class BeanNotas {

     Notas notas=new Notas();
    private List<Notas> listNo=new ArrayList();
    private List<Materias> listM=new ArrayList();
    
    @PostConstruct
    public void init() {
        notas = new Notas();
        MantenimientoMaterias manm = new MantenimientoMaterias();
//        MantenimientoNotas man = new MantenimientoNotas();
       notas.setNombreMateria(new Materias());
        
//        lista=man.consultarTodosNivel();
            listM=manm.consultartodasMaterias();
        
    }
    
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

    public List<Materias> getListM() {
        return listM;
    }

    public void setListM(List<Materias> listM) {
        this.listM = listM;
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
