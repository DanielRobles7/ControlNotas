/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mantenimiento;

import Persistencia.Materias;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author eliseo.garciausam
 */
public class MantenimientoMaterias {
    
    public int guardarMaterias(Materias materias){
       EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
       int flag=0;
       em.getTransaction().begin();
       try{
           em.persist(materias);
           em.getTransaction().commit();
           flag=1;
           System.out.println("exito,guardarMaterias,mantenimientoMaterias");
       }catch(Exception e){
           System.out.println(e.getMessage());
           em.getTransaction().rollback();
           flag=0;
           System.out.println("error.guardarMaterias,mantenimientoMaterias"+e);
       }finally{
           em.close();
       }
       return flag;
    }
    
    public Materias consultarMateria(String nombreMateria){
        EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
        Materias materias=null;
        em.getTransaction().begin();
        try{
            materias=em.find(Materias.class, nombreMateria);
            em.getTransaction().commit();
            System.out.println("exito,consultarMaterias,mantenimientoMaterias");
        }catch(Exception e){
            em.getTransaction().rollback();
            System.out.println("error,consultarMaterias,mantenimientoMaterias"+e);
        }finally{
            em.close();
        }
        return materias;
    }
    
    public List<Materias> consultartodasMaterias(){
       List<Materias> listaMaterias=null;
       EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
       em.getTransaction().begin();
       try{
           Query query=em.createQuery("Select m from Materias m");
           em.getTransaction().commit();
           listaMaterias=query.getResultList();
           System.out.println(listaMaterias);
           return listaMaterias;
       }catch(Exception e){
           em.getTransaction().rollback();
           return null;
       }finally{
           em.close();
       }
    }
    
    public int ActualizarMaterias(Materias materias){
       EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
       Materias mat=null;
       em.getTransaction().begin();
       int flag=0;
       try{
          mat=em.find(Materias.class, materias.getNombreMateria());
          mat.setNombreMateria(materias.getNombreMateria());
          mat.setGrado(materias.getGrado());
          mat.setPonderacion1(materias.getPonderacion1());
          mat.setPonderacion2(materias.getPonderacion2());
          mat.setPonderacion3(materias.getPonderacion3());
          mat.setPonderacion4(materias.getPonderacion4());
          mat.setPonderacion5(materias.getPonderacion5());
          mat.setPonderacion6(materias.getPonderacion6());
          mat.setPeriodo(materias.getPeriodo());
          mat.setEstadoPeriodo(materias.getEstadoPeriodo());
          mat.setEstado(materias.getEstado());
          mat.setCampo(materias.getCampo());
          
          em.getTransaction().commit();
          flag=1;
           System.out.println("exito,actualizarMaterias,mantenimientoMaterias");
       }catch(Exception e){
           em.getTransaction().rollback();
           flag=0;
           System.out.println("error,actualizarMaterias,mantenimientoMaterias"+e);
       }finally{
           em.close();
       }
       return flag;
    }
    
    public int eliminarMaterias(Materias materias){
        EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
        Materias mat=null;
        em.getTransaction().begin();
        int flag=0;
        try{
            mat=em.find(Materias.class, materias.getNombreMateria());
            em.remove(mat);
            em.getTransaction().commit();
            flag=1;
            System.out.println("exito,eliminarMaterias,mantenimientoMaterias");
        }catch(Exception e){
            em.getTransaction().rollback();
            flag=0;
            System.out.println("error,eliminarMaterias,mantenimientoMaterias"+e);
        }finally{
            em.close();
        }
        return flag;
    }
    
}
