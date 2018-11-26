
import Mantenimiento.MantenimientoAcceso;
import Mantenimiento.MantenimientoEscuela;
import Mantenimiento.MantenimientoNotas;
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
public class pruebas {

    public static void main(String[] args) {

        MantenimientoAcceso ma = new MantenimientoAcceso();
//        MantenimientoEscuela man = new MantenimientoEscuela();
//        MantenimientoNotas manN= new MantenimientoNotas();
//   
//        System.out.println(manN.consultarMaxNotas());

        Acceso acceso = ma.loginAcceso("EST3697", "3697");
        
        if (acceso != null) {
            System.out.println("Usuario correcto\n"+acceso.accesoInfo());
            System.out.println("Bienvenido '"+ma.nombreBienvenida(acceso.getIdAcceso(), acceso.getNivelAcceso())+"'");
        } else {
            System.out.println("Usuario o contraseña incorecta o no existe");
        }
        System.exit(0);
//        System.out.println(""+ma.logAcceso("DIR670639", "670639"));

    }
}
