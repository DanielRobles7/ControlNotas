/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import Mantenimiento.MantenimientoAcceso;
import Mantenimiento.MantenimientoEscuela;
import Mantenimiento.MantenimientoNivel;
import Mantenimiento.MantenimientoProfesores;
import Persistencia.Acceso;
import Persistencia.Escuelas;
import Persistencia.Nivel;
import Persistencia.Profesores;
import estaticas.SessionIniciada;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class BeanProfesores {
    
    private Profesores profesores = new Profesores();
    private Escuelas escuelas = new Escuelas();
    private Nivel nivel = new Nivel();
    private List<Profesores> listP = new ArrayList();
    private List<Nivel> listN = new ArrayList();
    private List<Escuelas> listE = new ArrayList();
    MantenimientoProfesores map = new MantenimientoProfesores();
    MantenimientoNivel man = new MantenimientoNivel();
    MantenimientoEscuela mae = new MantenimientoEscuela();
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    
    @PostConstruct
    public void init() {
        profesores.setIdAcceso(new Acceso());
        profesores.setGrado(new Nivel());
        profesores.setCodigoEscuela(new Escuelas());
//        notas.setNie(new Alumnos());
        listN = man.consultarTodosNivel();
        listP = map.consultarTodosProfesores();
        listE = mae.consultar();
    }
    
    public Profesores getProfesores() {
        return profesores;
    }
    
    public void setProfesores(Profesores profesores) {
        this.profesores = profesores;
    }
    
    public Nivel getNivel() {
        return nivel;
    }
    
    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }
    
    public List<Profesores> getListP() {
        return listP;
    }
    
    public void setListP(List<Profesores> listP) {
        this.listP = listP;
    }
    
    public List<Nivel> getListN() {
        return listN;
    }
    
    public void setListN(List<Nivel> listN) {
        this.listN = listN;
    }
    
    public Escuelas getEscuelas() {
        return escuelas;
    }
    
    public void setEscuelas(Escuelas escuelas) {
        this.escuelas = escuelas;
    }
    
    public List<Escuelas> getListE() {
        return listE;
    }
    
    public void setListE(List<Escuelas> listE) {
        this.listE = listE;
    }
    
    public MantenimientoProfesores getMap() {
        return map;
    }
    
    public void setMap(MantenimientoProfesores map) {
        this.map = map;
    }
    
    public MantenimientoNivel getMan() {
        return man;
    }
    
    public void setMan(MantenimientoNivel man) {
        this.man = man;
    }
    
    public MantenimientoEscuela getMae() {
        return mae;
    }
    
    public void setMae(MantenimientoEscuela mae) {
        this.mae = mae;
    }
    
    public SimpleDateFormat getFormato() {
        return formato;
    }
    
    public void setFormato(SimpleDateFormat formato) {
        this.formato = formato;
    }
    
    public void agregar() {
        //Agregar Acceso
        Acceso acceso = new Acceso();
        
        String nombre = profesores.getNombre();
        String apellido = profesores.getApellido();
        String usuario;
        String password;
        Integer idMax;
        usuario = nombre.substring(0, 3) + apellido.substring(0, 3);
        
        int numeroAleatorio = (int) (Math.random() * 899) + 100;
        password = usuario + numeroAleatorio;
        
        acceso.setContrasena(password);
        acceso.setEstado("Activo");
        acceso.setIdAcceso(0);
        acceso.setUsuario(usuario);
        acceso.setNivelAcceso("Profesor");
        acceso.setCampo("");
        
        MantenimientoAcceso ma = new MantenimientoAcceso();
        ma.guardarAcesso(acceso);

        //idMaximo de acceso
        idMax = ma.consultarMaxAcceso();
        Acceso acces = new Acceso();
        acces.setIdAcceso(idMax);
        
        profesores.setIdAcceso(acces);
        profesores.setEstado("Activo");
        String fechaRegistro = formato.format(new Date());
        profesores.setFechaRegistro(fechaRegistro);
        //se trae de una variable estatica que se llenará al iniciar session
        escuelas.setCodigoEscuela(SessionIniciada.codigoEscuela);
        profesores.setGrado(nivel);
        profesores.setCodigoEscuela(escuelas);

        //Agregar Profesores
//        map.guardarProfesores(profesores);
        String adv;
        if (map.guardarProfesores(profesores) == 1) {
            listP = map.consultarTodosProfesores();
            profesores.setGrado(new Nivel());
            profesores = new Profesores();
            adv = "Guardado exitosamente";
            
        } else {
            adv = "Error al guardar";
        }
        FacesMessage msg = new FacesMessage(adv);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void modificar(Profesores profesores) {
        
        System.out.println("Escuela: " + profesores.getCodigoEscuela());
        
        profesores = map.consultarProfesores(profesores.getEscalafon());
        this.profesores = profesores;
        String adv;
        if (profesores != null) {
            adv = "Consulta exitosa";
        } else {
            adv = "Error al consultar";
        }
        FacesMessage msg = new FacesMessage(adv);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void eliminar(Profesores profesores) {
//        map.eliminarProfesores(profesores);
        String adv;
        if (map.eliminarProfesores(profesores) == 1) {
            listP = map.consultarTodosProfesores();
            adv = "Se ha eliminado exitosamente";
        } else {
            adv = "Error al eliminar";
        }
        FacesMessage msg = new FacesMessage(adv);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void actualizar() {
        
        System.out.println("Escuela: " + profesores.getCodigoEscuela());
        
        String adv = "";
        profesores.setEstado("activo");
        if (map.ActualizarProfesores(profesores) == 1) {
            
            listP = map.consultarTodosProfesores();
            adv = "Se ha actualizado Correctamente";
            
        } else {
            adv = "Error al actualizar";
        }
        FacesMessage msg = new FacesMessage(adv);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
