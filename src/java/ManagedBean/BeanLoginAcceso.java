/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import Mantenimiento.MantenimientoAcceso;
import Persistencia.Acceso;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

/**
 *
 * @author julio.benavidesusam
 */
@ManagedBean
@RequestScoped
public class BeanLoginAcceso {

    private String username;
    private String password;
    private static int idAcceso;
    private static String usuario;
    private static String contrasena;
    private static String nivelAcceso;
    private static String estado;
    
    /**
     * Creates a new instance of BeanLoginAcceso
     */
    public BeanLoginAcceso() {
    }

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

    public static int getIdAcceso() {
        return idAcceso;
    }

    public static String getUsuario() {
        return usuario;
    }

    public static String getContrasena() {
        return contrasena;
    }

    public static String getNivelAcceso() {
        return nivelAcceso;
    }

    public static String getEstado() {
        return estado;
    }
    
    
    public void loginInicioSesion(){
        MantenimientoAcceso mantenimiento = new MantenimientoAcceso();
        Acceso acceso = mantenimiento.loginAcceso(username, password);
        String nombre = mantenimiento.nombreBienvenida(idAcceso, nivelAcceso);
        FacesMessage message = null;
        boolean loggedIn = false;
        
        if (acceso != null) {
            BeanLoginAcceso.idAcceso = acceso.getIdAcceso();
            BeanLoginAcceso.usuario = acceso.getUsuario();
            BeanLoginAcceso.contrasena = acceso.getContrasena();
            BeanLoginAcceso.nivelAcceso = acceso.getNivelAcceso();
            BeanLoginAcceso.estado = acceso.getEstado();
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", nombre);
        }else{
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Usuario o contraseña incorrecta");
        }
        
        FacesContext.getCurrentInstance().addMessage(null, message);
        PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
    }
}
