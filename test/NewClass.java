
import Mantenimiento.MantenimientoAcceso;
import Mantenimiento.MantenimientoEscuela;
import Mantenimiento.MantenimientoNotas;

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
    
   MantenimientoAcceso mana = new MantenimientoAcceso();  
   
   MantenimientoEscuela man = new MantenimientoEscuela();
   MantenimientoNotas manN= new MantenimientoNotas();
   
        System.out.println(man.consultar());




    
}
}