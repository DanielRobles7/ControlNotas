/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mantenimiento;

import Persistencia.Profesores;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author eliseo.garciausam
 */
public class MantenimientoProfesores {

    public int guardarProfesores(Profesores profesores) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        int flag = 0;
        em.getTransaction().begin();
        try {
            em.persist(profesores);
            em.getTransaction().commit();
            flag = 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
            flag = 0;
        } finally {
            em.close();
        }
        return flag;
    }

    public Profesores consultarProfesores(int escalafon) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        Profesores profesores = null;
        em.getTransaction().begin();
        try {
            profesores = em.find(Profesores.class, escalafon);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return profesores;
    }

    public List<Profesores> consultarTodosProfesores() {
        List<Profesores> listaProfesores = null;
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            Query query = em.createQuery("Select p from Profesores p where p.estado='activo'");
            em.getTransaction().commit();
            listaProfesores = query.getResultList();
            System.out.println(listaProfesores);
            return listaProfesores;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return null;
        } finally {
            em.close();
        }
    }

    public int ActualizarProfesores(Profesores profesores) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        Profesores pro = null;
        em.getTransaction().begin();
        int flag = 0;
        try {
            pro = em.find(Profesores.class, profesores.getEscalafon());
            pro.setEscalafon(profesores.getEscalafon());
            pro.setNombre(profesores.getNombre());
            pro.setApellido(profesores.getApellido());
            pro.setEmail(profesores.getEmail());
            pro.setDireccion(profesores.getDireccion());
            pro.setEdad(profesores.getEdad());
            pro.setTelefono(profesores.getTelefono());
            pro.setFechaNacimiento(profesores.getFechaNacimiento());
            pro.setFechaRegistro(profesores.getFechaRegistro());
            pro.setIdAcceso(profesores.getIdAcceso());
            pro.setCodigoEscuela(profesores.getCodigoEscuela());
            pro.setGrado(profesores.getGrado());
            pro.setEstado(profesores.getEstado());
            pro.setCampo(profesores.getCampo());

            em.getTransaction().commit();
            System.out.println("Exito Mantenimiento");
            flag = 1;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                
            em.getTransaction().rollback();
            }
            System.out.println("Error Mantenimiento... "+e);
            flag = 0;
        } finally {
            em.close();
        }
        return flag;
    }

    public int eliminarProfesores(Profesores profesores) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        Profesores pro = null;
        int flag = 0;
        try {
            em.getTransaction().begin();
            pro = em.find(Profesores.class, profesores.getEscalafon());
            pro.setEscalafon(profesores.getEscalafon());
            pro.setNombre(profesores.getNombre());
            pro.setApellido(profesores.getApellido());
            pro.setEmail(profesores.getEmail());
            pro.setDireccion(profesores.getDireccion());
            pro.setEdad(profesores.getEdad());
            pro.setTelefono(profesores.getTelefono());
            pro.setFechaNacimiento(profesores.getFechaNacimiento());
            pro.setFechaRegistro(profesores.getFechaRegistro());
            pro.setIdAcceso(profesores.getIdAcceso());
            pro.setCodigoEscuela(profesores.getCodigoEscuela());
            pro.setGrado(profesores.getGrado());
            pro.setEstado("inactivo");
            pro.setCampo(profesores.getCampo());
            em.getTransaction().commit();
            flag = 1;
        } catch (Exception e) {
            em.getTransaction().rollback();
            flag = 0;
        } finally {
            em.close();
        }
        return flag;
    }
    
    public String nombreProfesor (int id_acceso){
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        Profesores profesor = null;
        int escalafon;
        String[] apellido = null;
        String[] nombre = null;
        String Profesor = null;
        
        try {
            em.getTransaction().begin();
            escalafon = Integer.parseInt(em.createNativeQuery("select escalafon from profesores where id_acceso="+id_acceso+";").getSingleResult().toString());
            profesor = this.consultarProfesores(escalafon);
            apellido = profesor.getApellido().split(" ");
            nombre = profesor.getNombre().split(" ");
            Profesor = nombre[0]+" "+apellido[0];
        } catch (NumberFormatException e) {
            System.out.println("Error: "+e.getMessage());
        }finally{
            em.close();
        }        
        return Profesor;
    }

//    public int eliminarProfesores(Profesores profesores){
//        EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
//        Profesores pro=null;
//        em.getTransaction().begin();
//        int flag=0;
//        try{
//           pro=em.find(Profesores.class, profesores.getEscalafon());
//           em.remove(pro);
//           em.getTransaction().commit();
//           flag=1;
//        }catch(Exception e){
//            em.getTransaction().rollback();
//            flag=0;
//        }finally{
//            em.close();
//        }
//        return flag;
//    }
}
