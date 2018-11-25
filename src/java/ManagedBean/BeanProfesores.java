/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import Mantenimiento.MantenimientoAcceso;
import Mantenimiento.MantenimientoEscuela;
import Mantenimiento.MantenimientoProfesores;
import Persistencia.Acceso;
import Persistencia.Escuelas;
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

/**
 *
 * @author ruth.ramosusam
 */
@ManagedBean
@RequestScoped
public class BeanProfesores {

    private Profesores profesores=new Profesores();
    private final Escuelas escuelas=new Escuelas();
    private List<Profesores> listP=new ArrayList();
    MantenimientoProfesores map = new MantenimientoProfesores();
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    
    @PostConstruct
    public void init() {
         profesores.setIdAcceso(new Acceso());
//        notas.setNie(new Alumnos());
        listP = map.consultarTodosProfesores();

    }

    public Profesores getProfesores() {
        return profesores;
    }

    public void setProfesores(Profesores profesores) {
        this.profesores = profesores;
    }

    public List<Profesores> getListP() {
        return listP;
    }

    public void setListP(List<Profesores> listP) {
        this.listP = listP;
    }
    
    
    public void agregar(Profesores profesores){
        //Agregar Acceso
        Acceso acceso=new Acceso();
        
        String nombre=profesores.getNombre();
        String apellido=profesores.getApellido();
        String usuario;
        String password;
        Integer idMax;
        usuario = nombre.substring(0,3) + apellido.substring(0,3);
        
        int numeroAleatorio = (int) (Math.random()*999)+100;
        password= usuario+numeroAleatorio;
        
        acceso.setContrasena(password);
        acceso.setEstado("Activo");
        acceso.setIdAcceso(0);
        acceso.setUsuario(usuario);
        acceso.setNivelAcceso("Profesor");
        
        MantenimientoAcceso ma=new MantenimientoAcceso();
        ma.guardarAcesso(acceso);
        
        //idMaximo de acceso
        idMax=ma.consultarMaxAcceso();
        Acceso acces=new Acceso();
        acces.setIdAcceso(idMax);
        
        profesores.setIdAcceso(acces);
        profesores.setEstado("Activo");
        String fechaRegistro = formato.format(new Date());
        profesores.setFechaRegistro(fechaRegistro);
        //se trae de una variable estatica que se llenará al iniciar session
        escuelas.setCodigoEscuela(SessionIniciada.codigoEscuela); 
        profesores.setCodigoEscuela(escuelas);
        
    
        //Agregar Profesores
        map.guardarProfesores(profesores);
        listP=map.consultarTodosProfesores();
        String adv;
        if (map.guardarProfesores(profesores)==1) {
            adv="Guardado exitosamente";
        } else {
            adv="Error al guardar";
        }
        FacesMessage msg = new FacesMessage(adv);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public void modificar(Profesores profesores){
        
        profesores=map.consultarProfesores(profesores.getEscalafon());
        this.profesores=profesores;
        String adv;
        if (profesores!=null) {
            adv="Consulta exitosa";
        } else {
            adv="Error al consultar";
        }
        FacesMessage msg = new FacesMessage(adv);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public void eliminar(Profesores profesores){
        map.eliminarProfesores(profesores);
        listP=map.consultarTodosProfesores();
        String adv;
        if (map.eliminarProfesores(profesores)==1) {
            adv="Se ha eliminado exitosamente";
        } else {
            adv="Error al eliminar";
        }
        FacesMessage msg = new FacesMessage(adv);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public void actualizar(Profesores profesores){
        map.ActualizarProfesores(profesores);
        System.out.println("Actualizar: "+profesores);
        
        listP=map.consultarTodosProfesores();
        
        System.out.println("Se va a actualizar "+map.ActualizarProfesores(profesores));
        String adv;
        if (map.ActualizarProfesores(profesores)==1) {
            adv="Se ha actualizado Correctamente";
        } else {
            adv="Error al actualizar";
        }
        FacesMessage msg = new FacesMessage(adv);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
