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

/**
 *
 * @author eliseo.garciausam
 */
@ManagedBean
@RequestScoped
public class BeanAcceso {

    private Integer idAcceso;
    private String usuario;
    private String contrasena;
    private String nivelAcceso;
    private String estado;
    private String campo;

    public BeanAcceso() {
    }

    public Integer getIdAcceso() {
        return idAcceso;
    }

    public void setIdAcceso(Integer idAcceso) {
        this.idAcceso = idAcceso;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNivelAcceso() {
        return nivelAcceso;
    }

    public void setNivelAcceso(String nivelAcceso) {
        this.nivelAcceso = nivelAcceso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public void consultardatos() {
        MantenimientoAcceso m = new MantenimientoAcceso();
        Acceso a = m.consultarAcceso(idAcceso);
        String advertencia = "";
        if (a != null) {
            this.idAcceso = a.getIdAcceso();
            this.usuario = a.getUsuario();
            this.contrasena = a.getContrasena();
            this.nivelAcceso = a.getNivelAcceso();
            this.estado = a.getEstado();
            this.campo = a.getCampo();
            advertencia = "Consultando datos";
        } else {
            advertencia = "Datos no encontrados";
        }
        FacesMessage msg = new FacesMessage(advertencia);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void guardarDatos() {
        MantenimientoAcceso m = new MantenimientoAcceso();
        String advertencia = "";

        if (this.usuario == null || this.usuario.equals("")) {
            advertencia += "El usuario es obligatorio";
        }
        if (this.contrasena == null || this.contrasena.equals("")) {
            advertencia += "La contrasena es obligatoria";
        }
        if (this.nivelAcceso == null || this.nivelAcceso.equals("")) {
            advertencia += "El nivel de acceso es obligatorio";
        }
        if (this.estado == null || this.estado.equals("")) {
            advertencia += "El estado es obligatorio";
        }
        if (this.campo == null || this.campo.equals("")) {
            advertencia += "El campo es obligatorio";
        }
        if (advertencia.equals("")) {
            Acceso acc = new Acceso();
            acc.setUsuario(usuario);
            acc.setContrasena(contrasena);
            acc.setNivelAcceso(nivelAcceso);
            acc.setEstado(estado);
            acc.setCampo(campo);

            Acceso valAcc = m.consultarAcceso(idAcceso);
            if (valAcc != null) {
                advertencia = "Acceso ya esta registrado";
            } else {
                if (m.guardarAcesso(acc) == 1) {
                    advertencia = "Datos almacenados satisfactoriamente";
                } else {
                    advertencia = "Error al tratar de almacenar datos";
                }
            }
        }
        FacesMessage msg = new FacesMessage(advertencia);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
