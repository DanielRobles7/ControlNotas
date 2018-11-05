/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mantenimiento;

import Persistencia.Acceso;
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
        Acceso acce = new Acceso();
        acce.setIdAcceso(0);
        acce.setUsuario("cheyo");
        acce.setContrasena("123456");
        acce.setNivelAcceso("profesor");
        acce.setEstado("activo");
        acce.setCampo("gdgdgdgdg");
        if(man.guardarAcesso(acce)==1){
            System.out.println("exito");
        }else{
            System.out.println("fallo");
        }
        System.exit(0);
    }
   
    public int guardarAcesso(Acceso acceso){
        EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
        int flag=0;
        em.getTransaction().begin();
        try{
           em.persist(acceso);
           em.getTransaction().commit();
           flag=1;
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
        return flag;
    }
    
    public Acceso consultarAcceso(int idAcceso){
        EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
        Acceso acceso=null;
        em.getTransaction().begin();
        try{
           acceso=em.find(Acceso.class, idAcceso);
           em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
        return acceso;
    }
    
    public List consultarTodosAcceso(){
        List<Acceso>listaAcceso=null;
        EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
           Query query=em.createQuery("Select a from Acceso a");
           em.getTransaction().commit();
           listaAcceso=query.getResultList();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
        return listaAcceso;
    }
    
    public Acceso eliminarAcceso(int idAcceso){
         EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
         Acceso acceso=null;
         em.getTransaction().begin();
         try{
            acceso=em.find(Acceso.class, idAcceso);
            em.remove(acceso);
            em.getTransaction().commit();
         }catch(Exception e){
             System.out.println("error"+e);
             em.getTransaction().rollback();
         }finally{
             em.close();
         }
         return acceso;
    }
    
    public int actualizarAcceso(Acceso acceso){
        EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
        Acceso acces=null;
        em.getTransaction().begin();
        int flag=0;
        try{
           acceso=em.find(Acceso.class,acceso.getIdAcceso());
           acces.setIdAcceso(acceso.getIdAcceso());
           acces.setUsuario(acceso.getUsuario());
           acces.setContrasena(acceso.getContrasena());
           acces.setNivelAcceso(acceso.getNivelAcceso());
           acces.setEstado(acceso.getEstado());
           acces.setCampo(acceso.getCampo());
           em.getTransaction().commit();
           flag=1;
        }catch(Exception e){
            System.out.println("error"+e);
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
        return flag;
    }
}
