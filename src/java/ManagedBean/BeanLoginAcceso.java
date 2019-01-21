/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import Mantenimiento.MantenimientoAcceso;
import Mantenimiento.MantenimientoAlumnos;
import Mantenimiento.MantenimientoEscuela;
import Mantenimiento.MantenimientoProfesores;
import Persistencia.Acceso;
import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.PrimeFaces;

/**
 *
 * @author julio.benavidesusam
 */
@ManagedBean
@RequestScoped
public class BeanLoginAcceso {

    HttpSession session = SessionUtils.getSession();

    private String username;
    private String password;
    private int user_id;
    private String names;
    private String acces_lvl;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public int getUser_id() {
        user_id = Integer.parseInt(session.getAttribute("user_id").toString());
        return user_id;
    }

    public String getNames() {
        names = session.getAttribute("username").toString();
        return names;
    }

    public String getAcces_lvl() {
        acces_lvl = session.getAttribute("acces_level").toString();
        return acces_lvl;
    }

    public String inicioSesion() throws IOException{
        MantenimientoAcceso mantenimiento = new MantenimientoAcceso();
        Acceso acceso = mantenimiento.loginAcceso(username, password);
        FacesMessage message = null;
        boolean loggedIn = false;

        if (acceso != null) {
            session.setAttribute("user_id", acceso.getIdAcceso());
            session.setAttribute("acces_level", acceso.getNivelAcceso());

            switch (acceso.getNivelAcceso()) {
                case "Director":
                    MantenimientoEscuela mantenimientoEscuela = new MantenimientoEscuela();
                    session.setAttribute("username", mantenimientoEscuela.nombreDirector(acceso.getIdAcceso()));
                    break;
                case "Profesor":
                    MantenimientoProfesores mantenimientoProfesores = new MantenimientoProfesores();
                    session.setAttribute("username", mantenimientoProfesores.nombreProfesor(acceso.getIdAcceso()));
                    break;
                case "estudiante":
                    MantenimientoAlumnos mantenimientoAlumnos = new MantenimientoAlumnos();
                    session.setAttribute("username", mantenimientoAlumnos.nombreAlumno(acceso.getIdAcceso()));
                    break;
            }

            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", session.getAttribute("username").toString());
            FacesContext.getCurrentInstance().addMessage(null, message);
            PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
            return "success";
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Usuario o contraseña incorrecta");
            FacesContext.getCurrentInstance().addMessage(null, message);
            PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
            return "index";
        }
    }
    
    public void cierreSesion() throws IOException{
        session.invalidate();
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }
}
