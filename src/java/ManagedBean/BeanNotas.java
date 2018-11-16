/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import Mantenimiento.MantenimientoAlumnos;
import Mantenimiento.MantenimientoMaterias;
import Mantenimiento.MantenimientoNotas;
import Persistencia.Alumnos;
import Persistencia.Materias;
import Persistencia.Notas;
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
public class BeanNotas {

    Notas notas = new Notas();
    private List<Notas> listNo = new ArrayList();
    private List<Materias> listM = new ArrayList();
    private List<Alumnos> listNie = new ArrayList();

    @PostConstruct
    public void init() {

        MantenimientoMaterias manm = new MantenimientoMaterias();
        MantenimientoNotas man = new MantenimientoNotas();
        MantenimientoAlumnos ma = new MantenimientoAlumnos();
        notas.setNie(new Alumnos());
        notas.setNombreMateria(new Materias());
        listNie = ma.consultarTodosAlumnos();
        listNo = man.consultar();
        listM = manm.consultartodasMaterias();

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

    public List<Alumnos> getListNie() {
        return listNie;
    }

    public void setListNie(List<Alumnos> listNie) {
        this.listNie = listNie;
    }

    public void agregar() {
        System.out.println("esto son las notas" + notas);
        MantenimientoNotas man = new MantenimientoNotas();
        notas.setNota1(0.0);
        notas.setNota2(0.0);
        notas.setNota3(0.0);
        notas.setNota4(0.0);
        notas.setNota5(0.0);
        notas.setNota6(0.0);
        notas.setPromerio(0.0);
        notas.setReposicion(0.0);
        notas.setFinal1(0.0);
        notas.setEstadoAlumno("activo");
        notas.setEstadoNotas("activo");
        man.guardar(notas);
        listNo = man.consultar();
        notas.setNie(new Alumnos());
        notas.setNombreMateria(new Materias());
        notas = new Notas();
        String adv = "";
        if (man.guardar(notas) == 1) {
            adv = "Guardado correctamente";
        } else {
            adv = "No se ha Guardado correctamente";
        }
        FacesMessage msg = new FacesMessage(adv);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void modificar(Notas notas) {
        MantenimientoNotas man = new MantenimientoNotas();
        System.out.println("Modificaremos " + notas.getIdNota());
        notas = man.consultarid(notas.getIdNota());
        this.notas = notas;

        System.out.println("este de modificar" + notas);

        String adv = "";
        if (notas != null) {
            adv = "Consulta exitosa";
        } else {
            adv = "No se pudo realizar la consulta";
        }
        FacesMessage msg = new FacesMessage(adv);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void eliminar(Notas notas) {
        MantenimientoNotas man = new MantenimientoNotas();
        man.eliminar(notas);
        listNo = man.consultar();
        String adv = "";
        if (man.eliminar(notas) == 1) {
            adv = "Se elimino correctamente";
        } else {
            adv = "No se ha podido eliminar";
        }
        FacesMessage msg = new FacesMessage(adv);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void actualizar() {
        System.out.println("este es de actualizar" + notas);
        MantenimientoNotas man = new MantenimientoNotas();
        man.Actualizar(notas);
        System.out.println(man.Actualizar(notas));

        listNo = man.consultar();
        String adv = "";
        System.out.println("esta es actualizar" + notas);
        if (man.Actualizar(notas) == 1) {
            adv = "Se ha Actualizado Correctamente";
        } else {
            adv = "No se ha podido actualizar";
        }
        FacesMessage msg = new FacesMessage(adv);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
