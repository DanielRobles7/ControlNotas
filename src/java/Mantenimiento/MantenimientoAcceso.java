/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mantenimiento;

import Persistencia.Acceso;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author eliseo.garciausam
 */
public class MantenimientoAcceso {

    public static void main(String[] args) {
        MantenimientoAcceso man = new MantenimientoAcceso();
//        Acceso acce = new Acceso();
//        acce.setIdAcceso(0);
//        acce.setUsuario("cheyo");
//        acce.setContrasena("123456");
//        acce.setNivelAcceso("profesor");
//        acce.setEstado("activo");
//        acce.setCampo("gdgdgdgdg");
//        if(man.guardarAcesso(acce)==1){
//            System.out.println("exito");
//        }else{
//            System.out.println("fallo");
//        }
//         System.out.println("ID MAXIMO: "+man.consultarMaxAcceso());
//        Acceso acceso = man.loginAcceso("", "");
//        if (acceso != null) {
//            System.out.println(acceso.toString());
//        }else{
//            System.out.println("Usuario o contraseña incorecta o no existe");
//        }
//        System.exit(0);
    }

    public int guardarAcesso(Acceso acceso) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        int flag = 0;
        em.getTransaction().begin();
        try {
            em.persist(acceso);
            em.getTransaction().commit();
            flag = 1;
            System.out.println("guardarAcceso,mantenimientoAcceso,exito");
        } catch (Exception e) {
            System.out.println("error, acceso no se ha guardado" +e.getMessage());
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return flag;
    }

    public Acceso consultarAcceso(int idAcceso) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        Acceso acceso = null;
        em.getTransaction().begin();
        try {
            acceso = em.find(Acceso.class, idAcceso);
            em.getTransaction().commit();

            System.out.println(acceso);
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("consultarAcceso,mantenimentoAcceso,Error" + e);
        } finally {
            em.close();
        }
        return acceso;
    }

    public List consultarTodosAcceso() {
        List<Acceso> listaAcceso = null;
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            Query query = em.createQuery("Select a from Acceso a where a.estado='activo'");
            em.getTransaction().commit();
            listaAcceso = query.getResultList();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Error,consultarAcceso,MantenimientoAcceso" + e);
        } finally {
            em.close();
        }
        return listaAcceso;
    }

//    public Acceso eliminarAcceso(int idAcceso) {
//        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
//        Acceso acceso = null;
//        em.getTransaction().begin();
//        try {
//            acceso = em.find(Acceso.class, idAcceso);
//            em.remove(acceso);
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            System.out.println("error eliminarAcceso,mantenimientoAcceso" + e);
//            em.getTransaction().rollback();
//        } finally {
//            em.close();
//        }
//        return acceso;
//    }

    public int actualizarAcceso(Acceso acceso) {

        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        Acceso acces;
        int flag = 0;
        System.out.println(acceso);
        try {
            em.getTransaction().begin();
            acces = em.find(Acceso.class, acceso.getIdAcceso());
            acces.setIdAcceso(acceso.getIdAcceso());
            acces.setUsuario(acceso.getUsuario());
            acces.setContrasena(acceso.getContrasena());
            acces.setNivelAcceso(acceso.getNivelAcceso());
            acces.setEstado(acceso.getEstado());
            acces.setCampo(acceso.getCampo());
            em.getTransaction().commit();
            flag = 1;
            System.out.println("ActualizarAcceso, MantenimientoAcces, Correcto ");
        } catch (Exception e) {
            System.out.println("Error, ActualizarAcceso, MantenimientoAcceso " + e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return flag;
    }
    
    public int eliminarAcceso(Acceso acceso) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        Acceso acces = null;        
        try {
            em.getTransaction().begin();
            acces = em.find(Acceso.class, acceso.getIdAcceso());
            acces.setIdAcceso(acceso.getIdAcceso());
            acces.setUsuario(acceso.getUsuario());
            acces.setContrasena(acceso.getContrasena());
            acces.setNivelAcceso(acceso.getNivelAcceso());
            acces.setEstado("inactivo");
            acces.setCampo(acceso.getCampo());
            em.getTransaction().commit();
            return 1;
        } catch (Exception e) {
            System.out.println("error eliminarAcceso,mantenimientoAcceso" + e);
            em.getTransaction().rollback();
            return 0;
        } finally {
            em.close();
        }
    }

    public Integer consultarMaxAcceso() {
        int idMax = 0;
        String sql = "select max(a.idAcceso) from Acceso a";
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            idMax = Integer.parseInt(em.createQuery(sql).getSingleResult().toString());
            em.getTransaction().commit();
            System.out.println("consultar max, mantenimientoAcceso, Correcto ");
        } catch (NumberFormatException e) {
            em.getTransaction().rollback();
            System.out.println("error en consultar max, mantenimientoAcceso " + e);
        } finally {
            em.close();
        }
        return idMax;
    }

    public Acceso loginAcceso(String username, String password) {

        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        Acceso acceso = new Acceso();
        int id_acceso = 0;

        try {
            em.getTransaction().begin();
            id_acceso = Integer.parseInt(em.createNativeQuery("SELECT id_acceso FROM Acceso WHERE usuario = '" + username + "' AND contrasena = '" + password + "' AND estado = 'activo';").getSingleResult().toString());
            em.getTransaction().commit();
            System.out.println("Consulta correcta, el ID es: '" + id_acceso + "'");
            acceso = this.consultarAcceso(id_acceso);
        } catch (NumberFormatException e) {
            em.getTransaction().rollback();
            acceso = null;
            System.out.println("No se pudo llevar a cabo la consulta\nError: " + e);
        } finally {
            em.close();
        }
        return acceso;
    }

    public String nombreBienvenida(int idAcceso, String nivelAcceso) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        String nombre = null;

        try {
            em.getTransaction().begin();
            switch (nivelAcceso) {
                case "director":
                    nombre = em.createNativeQuery("SELECT nombre_director FROM escuelas WHERE id_acceso = " + idAcceso + ";").getSingleResult().toString();
                    em.getTransaction().commit();
                    break;
                case "profesor":
                    nombre = em.createNativeQuery("SELECT nombre FROM profesores WHERE id_acceso = " + idAcceso + ";").getSingleResult().toString();
                    em.getTransaction().commit();
                    break;
                case "estudiante":
                    nombre = em.createNativeQuery("SELECT nombre FROM alumnos WHERE id_acceso = " + idAcceso + ";").getSingleResult().toString();
                    em.getTransaction().commit();
                    break;
            }
        } catch (Exception e) {
            System.out.println("No se pudo consultar de consulta\nError: " + e);
        } finally {
            em.close();
        }
        return nombre;
    }
}
