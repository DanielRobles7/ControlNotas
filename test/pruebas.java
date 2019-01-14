
import Mantenimiento.JpaUtil;
import Mantenimiento.MantenimientoAcceso;
import Mantenimiento.MantenimientoAlumnos;
import Mantenimiento.MantenimientoEscuela;
import Mantenimiento.MantenimientoNotas;
import Mantenimiento.MantenimientoProfesores;
import Persistencia.Acceso;
import Persistencia.Alumnos;
import Persistencia.Escuelas;
import Persistencia.Profesores;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;

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
        /*
        if (manP.eliminarProfesores(manP.consultarProfesores(68438997))==1) {
            System.out.println("inactivado");
        }else{
            System.out.println("no se pudo inactivar");
        }
        */
//        String nombre1 = "ABC DEF";
//        String apellido1 = "UVW XYZ";
//        String prof = null;
//        
//        String[] n_part = nombre1.split(" ");
//        String[] a_part = apellido1.split(" ");
//        prof = n_part[0]+" "+a_part[0];
//        System.out.println(prof);
        
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        Escuelas escuela = null;
        int id_acceso= 2;
        int cod_esc;
        
//        try {
//            em.getTransaction().begin();
//            cod_esc = Integer.parseInt(em.createNativeQuery("select codigo_escuela from escuelas where escuelas.id_acceso="+id_acceso+";").getSingleResult().toString());
//            escuela = man.consultarid(cod_esc);
//            System.out.println("nombre dir: "+escuela.getNombreDirector());
//        } catch (NumberFormatException e) {
//            System.out.println("Error: "+e.getMessage());
//        }finally{
//            em.close();
//        }
        
//        Profesores profesor = null;
//        int escalafon;
//        String[] apellido = null;
//        String[] nombre = null;
//        String nombreProfesor = null;
//        
//        try {
//            em.getTransaction().begin();
//            escalafon = Integer.parseInt(em.createNativeQuery("select escalafon from profesores where id_acceso="+id_acceso+";").getSingleResult().toString());
//            profesor = manP.consultarProfesores(escalafon);
//            apellido = profesor.getApellido().split(" ");
//            nombre = profesor.getNombre().split(" ");
//            nombreProfesor = nombre[0]+" "+apellido[0];
//            System.out.println("f_name: "+nombreProfesor);
//        } catch (NumberFormatException e) {
//            System.out.println("Error: "+e.getMessage());
//        }finally{
//            em.close();
//        }
        
        Alumnos alumno = null;
        int nie=25456608;
        String[] apellido = null;
        String[] nombre = null;
        String nombreAlumno = null;
        
        try {
            em.getTransaction().begin();
//            nie = Integer.parseInt(em.createNativeQuery("select nie from alumnos where id_acceso="+id_acceso+";").getSingleResult().toString());
//            alumno = manAlumm.consultarAlumnos(nie);
            alumno = manAlumm.consultarAlumnos(nie);
            apellido = alumno.getApellido().split(" ");
            nombre = alumno.getNombre().split(" ");
            nombreAlumno = nombre[0]+" "+apellido[0];
            System.out.println("f_name: "+nombreAlumno);
        } catch (NumberFormatException e) {
            System.out.println("Error: "+e.getMessage());
        }finally{
            em.close();
        }
        
        System.exit(0);
//        System.out.println(""+ma.logAcceso("DIR670639", "670639"));

    }
}
