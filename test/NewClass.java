
import Mantenimiento.MantenimientoAcceso;
import Mantenimiento.MantenimientoNivel;
import Persistencia.Acceso;
import Persistencia.Escuelas;
import Persistencia.Nivel;

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
      Nivel nivel = new Nivel();
      Escuelas es = new Escuelas();
      es.setCodigoEscuela(1);
       nivel.setGrado("primero");
       nivel.setCodigoEscuela(es);
       nivel.setEstado("af");
       nivel.setCampo("af");
       
MantenimientoNivel man= new MantenimientoNivel();
       
        System.out.println(man.ActualizarNivel(nivel));
    }
}
