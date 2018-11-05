
import Mantenimiento.MantenimientoAcceso;
import Persistencia.Acceso;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eliseo.garciausam
 */
public class NewClass {
    public static void main(String[] args) {
       Acceso acc= new Acceso();
       acc.setIdAcceso(0);
       acc.setUsuario("prueba");
       acc.setContrasena("1234");
       acc.setNivelAcceso("1");
       acc.setEstado("s");
       acc.setCampo("a");
        
        MantenimientoAcceso man= new MantenimientoAcceso();
       man.guardarAcesso(acc);
    }
}
