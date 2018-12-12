/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import Mantenimiento.MantenimientoMaterias;
import Mantenimiento.MantenimientoNivel;
import Persistencia.Materias;
import Persistencia.Nivel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author diego.orellanausam
 */
@ManagedBean
@RequestScoped
public class BeanMaterias {
    
    private Materias materia = new Materias();
    private List<Materias> listM = new ArrayList();
    private List<Nivel> listN = new ArrayList();
    
    @PostConstruct
    public void init() {
        materia.setGrado(new Nivel());
        MantenimientoMaterias mam = new MantenimientoMaterias();
        MantenimientoNivel man = new MantenimientoNivel();
        listM = mam.consultartodasMaterias();
        listN = man.consultarTodosNivel();
//
//        for (Nivel e : listN) {
//            System.out.println(e.getGrado());
//            System.out.println(e.getEstado());
//            System.out.println(e.getCodigoEscuela());
//        }

    }
    
    public Materias getMateria() {
        return materia;
    }
    
    public void setMateria(Materias materia) {
        this.materia = materia;
    }
    
    public List<Materias> getListM() {
        return listM;
    }
    
    public void setListM(List<Materias> listM) {
        this.listM = listM;
    }
    
    public List<Nivel> getListN() {
        return listN;
    }
    
    public void setListN(List<Nivel> listN) {
        this.listN = listN;
    }
    
    public void agregar() {
        System.out.println("Estas son las materias" + materia);
        
        MantenimientoMaterias mm = new MantenimientoMaterias();
        
        materia.setPonderacion1(0.0);
        materia.setPonderacion2(0.0);
        materia.setPonderacion3(0.0);
        materia.setPonderacion4(0.0);
        materia.setPonderacion5(0.0);
        materia.setPonderacion6(0.0);
        materia.setPeriodo("");
        materia.setEstadoPeriodo("Activo");
        materia.setEstado("activo");
//        mm.guardarMaterias(materia);
        String adv = "";
        if (mm.guardarMaterias(materia) == 1) {
            listM = mm.consultartodasMaterias();
            materia = new Materias();
            adv = "Guardado exitosamente";
        } else {
            adv = "Error al guardar";
        }
        materia.setGrado(new Nivel());
        FacesMessage msg = new FacesMessage(adv);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void modificar(Materias materia) {
        MantenimientoMaterias mm = new MantenimientoMaterias();
        System.out.println("Modificaremos " + materia.getNombreMateria());
        materia = mm.consultarMateria(materia.getNombreMateria());
        this.materia = materia;
        
        System.out.println("este de modificar" + materia);
        
        String adv = "";
        if (materia != null) {
            adv = "Consulta exitosa";
        } else {
            adv = "No se pudo realizar la consulta";
        }
        FacesMessage msg = new FacesMessage(adv);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void eliminar(Materias materia) {
        MantenimientoMaterias mm = new MantenimientoMaterias();
//        mm.eliminarMaterias(materia);
        String adv = "";
        if (mm.eliminarMaterias(materia) == 1) {
            listM = mm.consultartodasMaterias();
            adv = "Se elimino correctamente";
        } else {
            adv = "No se ha podido eliminar";
        }
        FacesMessage msg = new FacesMessage(adv);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void actualizar() {
        System.out.println("este es de actualizar" + materia);
        MantenimientoMaterias mm = new MantenimientoMaterias();
//        mm.ActualizarMaterias(materia);
        System.out.println(mm.ActualizarMaterias(materia));
        materia.setEstadoPeriodo("activo");
        materia.setEstado("activo");
        String adv = "";
        System.out.println("esta es actualizar" + materia);
        if (mm.ActualizarMaterias(materia) == 1) {
            listM = mm.consultartodasMaterias();
            adv = "Se ha Actualizado Correctamente";
        } else {
            adv = "No se ha podido actualizar";
        }
        FacesMessage msg = new FacesMessage(adv);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
}
