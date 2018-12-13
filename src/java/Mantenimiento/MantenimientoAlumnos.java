/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mantenimiento;

import Persistencia.Alumnos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author eliseo.garciausam
 */
public class MantenimientoAlumnos {
    public static void main(String[] args) {
        MantenimientoAlumnos mal=new MantenimientoAlumnos();
        
        System.out.println(mal.consultarAlumnos(2548));
        
    }

    public int guardarAlumnos(Alumnos alumnos) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        int flag = 0;
        em.getTransaction().begin();
        try {
            em.persist(alumnos);
            em.getTransaction().commit();
            flag = 1;
            System.out.println("exito,guardarAlumnos,mantenimientoAlumnos");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
            flag = 0;
            System.out.println("error guardarAlumnos,mantenimientoAlumnos" + e);
        } finally {
            em.close();
        }
        return flag;
    }

    public Alumnos consultarAlumnos(int nie) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        Alumnos alumno = null;
        em.getTransaction().begin();
        try {
            alumno = em.find(Alumnos.class, nie);
            em.getTransaction().commit();
            System.out.println("exito,consultarAlumnos,mantenimientoAlumnos");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("error,consultarAlumnos,mantenimientoAlumnos" + e);
        } finally {
            em.close();
        }
        return alumno;
    }

    public List<Alumnos> consultarTodosAlumnos() {
        List<Alumnos> listaAlumnos = null;
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            Query query = em.createQuery("Select a from Alumnos a where a.estado='activo'");
            em.getTransaction().commit();
            listaAlumnos = query.getResultList();
            System.out.println(listaAlumnos);
            return listaAlumnos;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return null;
        } finally {
            em.close();
        }
    }

    public int ActualizarAlumnos(Alumnos alumnos) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        Alumnos alm = null;
        em.getTransaction().begin();
        int flag = 0;
        try {
            alm = em.find(Alumnos.class, alumnos.getNie());
            alm.setNie(alumnos.getNie());
            alm.setNombre(alumnos.getNombre());
            alm.setApellido(alumnos.getApellido());
            alm.setEmail(alumnos.getEmail());
            alm.setDireccion(alumnos.getDireccion());
            alm.setEdad(alumnos.getEdad());
            alm.setTelefono(alumnos.getTelefono());
            alm.setFechaNacimiento(alumnos.getFechaNacimiento());
            alm.setFechaRegistro(alumnos.getFechaRegistro());
            alm.setEstado(alumnos.getEstado());
            alm.setCampo(alumnos.getCampo());
            alm.setIdAcceso(alumnos.getIdAcceso());
            alm.setCodigoEscuela(alumnos.getCodigoEscuela());
            alm.setGrado(alumnos.getGrado());

            em.getTransaction().commit();
            flag = 1;
            System.out.println("exito,ActualizarAlumnos,mantenimientoAlumnos");
        } catch (Exception e) {
            em.getTransaction().rollback();
            flag = 0;
            System.out.println("error,ActualizarAlumnos,mantenimientoAlumnos" + e);
        } finally {
            em.close();
        }
        return flag;
    }

    public int eliminarAlumnos(Alumnos alumnos) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        Alumnos alm = null;

        int flag = 0;
        try {
            em.getTransaction().begin();
            alm = em.find(Alumnos.class, alumnos.getNie());
            alm.setNie(alumnos.getNie());
            alm.setNombre(alumnos.getNombre());
            alm.setApellido(alumnos.getApellido());
            alm.setEmail(alumnos.getEmail());
            alm.setDireccion(alumnos.getDireccion());
            alm.setEdad(alumnos.getEdad());
            alm.setTelefono(alumnos.getTelefono());
            alm.setFechaNacimiento(alumnos.getFechaNacimiento());
            alm.setFechaRegistro(alumnos.getFechaRegistro());
            alm.setEstado("inactivo");
            alm.setCampo(alumnos.getCampo());
            alm.setIdAcceso(alumnos.getIdAcceso());
            alm.setCodigoEscuela(alumnos.getCodigoEscuela());
            alm.setGrado(alumnos.getGrado());
            em.getTransaction().commit();
            flag = 1;
        } catch (Exception e) {
            em.getTransaction().rollback();
            flag = 0;
            System.out.println("error eliminarAlumnos,mantenimientoAlumnos" + e);
        } finally {
            em.close();
        }
        return flag;
    }

//    public int eliminarAlumnos(Alumnos alumnos){
//         EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
//         Alumnos alm =null;
//         em.getTransaction().begin();
//         int flag=0;
//         try{
//             alm=em.find(Alumnos.class,alumnos.getNie());
//             em.remove(alm);
//             em.getTransaction().commit();
//             flag=1;
//         }catch(Exception e){
//             em.getTransaction().rollback();
//             flag=0;
//             System.out.println("error eliminarAlumnos,mantenimientoAlumnos"+e);
//         }finally{
//             em.close();
//         }
//         return flag;
//    }
}
