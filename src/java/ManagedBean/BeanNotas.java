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
import java.util.LinkedList;
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
    Materias materias = new Materias();
    Alumnos alumnos = new Alumnos();
    private List<Notas> listNo = new ArrayList();
    private List<Materias> listM = new ArrayList();
    private List<Alumnos> listNie = new ArrayList();

    @PostConstruct
    public void init() {

        BeanLoginAcceso beanLoginAcceso = new BeanLoginAcceso();
        MantenimientoMaterias manm = new MantenimientoMaterias();
        MantenimientoNotas man = new MantenimientoNotas();
        MantenimientoAlumnos ma = new MantenimientoAlumnos();
        notas.setNie(new Alumnos());
        notas.setNombreMateria(new Materias());
        listNie = ma.consultarTodosAlumnos();
        listNo = man.consultar();
        listM = manm.consultartodasMaterias();

        int idLogueado = beanLoginAcceso.getUser_id();  //aca debemos traer el valor del alumno logueado
        List<Notas> newList = new LinkedList<>();

        for (int i = 0; i < listNo.size(); i++) {
            if (listNo.get(i).getNie().getIdAcceso().getIdAcceso() == idLogueado) {           
                // de notas
                notas.setIdNota(listNo.get(i).getIdNota());
                notas.setNota1(listNo.get(i).getNota1());
                notas.setNota2(listNo.get(i).getNota2());
                notas.setNota3(listNo.get(i).getNota3());
                notas.setNota4(listNo.get(i).getNota4());
                notas.setNota5(listNo.get(i).getNota5());
                notas.setNota6(listNo.get(i).getNota6());
                notas.setPromerio(listNo.get(i).getPromerio());
                notas.setReposicion(listNo.get(i).getReposicion());
                notas.setFinal1(listNo.get(i).getFinal1());

                // de alumno
                alumnos.setNombre(listNo.get(i).getNie().getNombre());
                alumnos.setApellido(listNo.get(i).getNie().getApellido());
                notas.setNie(alumnos);

                // de materia
                materias.setNombreMateria(listNo.get(i).getNombreMateria().getNombreMateria());
                materias.setPonderacion1(listNo.get(i).getNombreMateria().getPonderacion1());
                materias.setPonderacion2(listNo.get(i).getNombreMateria().getPonderacion2());
                materias.setPonderacion3(listNo.get(i).getNombreMateria().getPonderacion3());
                materias.setPonderacion4(listNo.get(i).getNombreMateria().getPonderacion4());
                materias.setPonderacion5(listNo.get(i).getNombreMateria().getPonderacion5());
                materias.setPonderacion6(listNo.get(i).getNombreMateria().getPonderacion6());
                notas.setNombreMateria(materias);

                newList.add(notas);
            }
        }
        if (newList.size() > 0) {
            listNo = newList;
        }

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
//        man.guardar(notas);
        String adv = "";
        if (man.guardar(notas) == 1) {
            listNo = man.consultar();
            notas.setNie(new Alumnos());
            notas.setNombreMateria(new Materias());
            notas = new Notas();
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
//        man.eliminar(notas);
        String adv = "";
        if (man.eliminar(notas) == 1) {
            listNo = man.consultar();
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
        MantenimientoMaterias mant = new MantenimientoMaterias();
        double resultado1, resultado2, resultado3, resultado4, resultado5, resultado6, promedio, notafinal;
        Materias materias;
        materias = mant.consultarMateria(notas.getNombreMateria().getNombreMateria());
        resultado1 = (notas.getNota1() * materias.getPonderacion1());
        resultado2 = (notas.getNota2() * materias.getPonderacion2());
        resultado3 = (notas.getNota3() * materias.getPonderacion3());
        resultado4 = (notas.getNota4() * materias.getPonderacion4());
        resultado5 = (notas.getNota5() * materias.getPonderacion5());
        resultado6 = (notas.getNota6() * materias.getPonderacion6());
        promedio = (resultado1 + resultado2 + resultado3 + resultado4 + resultado5 + resultado6) / 100;
        notas.setPromerio(promedio);

        if (promedio >= 6) {
            notas.setReposicion(0.00);
        }

        if (notas.getReposicion() != 0) {
            notafinal = (promedio + notas.getReposicion()) / 2;
            notas.setFinal1(notafinal);
        } else {
            notafinal = promedio;
            notas.setFinal1(notafinal);
        }

        System.out.println(man.Actualizar(notas));

        String adv;
        System.out.println("esta es actualizar" + notas);
        if (man.Actualizar(notas) == 1) {
            listNo = man.consultar();
            adv = "Se ha Actualizado Correctamente";
        } else {
            adv = "No se ha podido actualizar";
        }
        FacesMessage msg = new FacesMessage(adv);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
