/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import Mantenimiento.MantenimientoEscuela;
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
        System.out.println("Estas son las escuelas "+escuela);
        MantenimientoEscuela me=new MantenimientoEscuela();
        me.guardar(escuela);
        listE=me.consultar();
    }
    public void modificar(Escuelas escuela){
        MantenimientoEscuela me=new MantenimientoEscuela();
        System.out.println("Modificaremos "+escuela.getCodigoEscuela());
        escuela=me.consultarid(escuela.getCodigoEscuela());
        this.escuela=escuela;
        System.out.println("Modificar: "+escuela);
    }
    public void eliminar(Escuelas escuela){
        MantenimientoEscuela me=new MantenimientoEscuela();
        me.eliminar(escuela);
        listE=me.consultar();
    }
    public void actualizar(){
        System.out.println("Actualizar "+escuela);
        MantenimientoEscuela me=new MantenimientoEscuela();
        me.Actualizar(escuela);
        System.out.println(me.Actualizar(escuela));
        listE=me.consultar();
        System.out.println("esta es de actualizar "+escuela);
    }
}
