
import Mantenimiento.MantenimientoAcceso;
import Mantenimiento.MantenimientoAlumnos;
import Mantenimiento.MantenimientoEscuela;
import Mantenimiento.MantenimientoNotas;
import Mantenimiento.MantenimientoProfesores;
import Persistencia.Acceso;
import Persistencia.Alumnos;
import java.util.LinkedList;
import java.util.List;

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
        MantenimientoEscuela man = new MantenimientoEscuela();
        MantenimientoProfesores manP = new MantenimientoProfesores();
        MantenimientoAlumnos manAlumm = new MantenimientoAlumnos();
        MantenimientoNotas manN= new MantenimientoNotas();
        
//   
//        System.out.println(manN.consultarMaxNotas());
/*
        Acceso acceso = ma.loginAcceso("EST3697", "3697");
        
        if (acceso != null) {
            System.out.println("Usuario correcto\n"+acceso.accesoInfo());
            System.out.println("Bienvenido '"+ma.nombreBienvenida(acceso.getIdAcceso(), acceso.getNivelAcceso())+"'");
        } else {
            System.out.println("Usuario o contraseña incorecta o no existe");
        }
*/
//        List<Alumnos> listaActivos = new LinkedList<>();
//        listaActivos = manAlumm.consultarTodosAlumnos();
//        for (Alumnos alumnos : listaActivos) {
//            System.out.println(alumnos.toString());
//        }
        
        if (manP.eliminarProfesores(manP.consultarProfesores(68438997))==1) {
            System.out.println("inactivado");
        }else{
            System.out.println("no se pudo inactivar");
        }
        System.exit(0);
//        System.out.println(""+ma.logAcceso("DIR670639", "670639"));

    }
}
