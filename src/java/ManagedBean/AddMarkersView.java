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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author ruth.ramosusam
 */
@ManagedBean
@RequestScoped
public class AddMarkersView {

    private MapModel emptyModel;
    private MapModel simpleModel;
    private String title;
    private double lat;
    private double lng;
    private List<Escuelas> School=new ArrayList();
    
    @PostConstruct
    public void init() {
        emptyModel = new DefaultMapModel();
        simpleModel = new DefaultMapModel();
        MantenimientoEscuela mes=new MantenimientoEscuela();
        School=mes.consultar();
        for(Escuelas es: School){
            LatLng coord1 = new LatLng(es.getLatitud(),es.getLongitud());
            simpleModel.addOverlay(new Marker(coord1, es.getNombreEscuela()));
        }
    }

    public MapModel getEmptyModel() {
        return emptyModel;
    }

    public void setEmptyModel(MapModel emptyModel) {
        this.emptyModel = emptyModel;
    }

    public MapModel getSimpleModel() {
        return simpleModel;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public List<Escuelas> getSchool() {
        return School;
    }

    public void setSchool(List<Escuelas> School) {
        this.School = School;
    }
    
    
    
    
    
    public void addMarker() {
        Escuelas esc=new Escuelas();
        Marker marker = new Marker(new LatLng(lat, lng), title);
        emptyModel.addOverlay(marker);
         
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Added", "Lat:" + lat + ", Lng:" + lng));
    }
    
    
    
}
