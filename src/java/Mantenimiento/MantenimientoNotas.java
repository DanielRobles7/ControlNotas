
package Mantenimiento;

import java.util.List;
import javax.persistence.Query;
import javax.persistence.EntityManager;


import Persistencia.Notas;



public class MantenimientoNotas {
  
    public static void main(String[] args) {
     
     //   List<Cliente> listaCliente= man.consultarTodosUsuario();
      //  Iterator it=listaCliente.iterator();
        //while(it.hasNext()){
          //  Usuario u=(Usuario) it.next();
          // System.out.println("usuario"+u.getNombre());
            //System.out.println("correo"+u.getCorreo());
        }
         /* Usuario usuario = new Usuario();
        usuario.setNombre("guillermo");
        usuario.setCorreo("prueba2");
  
      usuario=  man.consultarUsuario(1);
        System.out.println("este es actualizar");
        man.guardarUsuario(usuario);

    }
*/
    public int guardar(Notas notas){
        EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
        int flag=0;
        em.getTransaction().begin();
        try{
            System.out.println("esta son las notas "+notas.toString());
            em.persist(notas);
            em.getTransaction().commit();
            flag=1;
        }catch(Exception e){
            em.getTransaction().rollback();
            flag=0;
        }finally{
            em.close();
        }
        return flag;
    }
    
    public Notas consultarid(int idNota){
          EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
          Notas not=null;
          em.getTransaction().begin();
          try{
             not=em.find(Notas.class, idNota);
              em.getTransaction().commit();
              
          }catch(Exception e){
              em.getTransaction().rollback();
              
          }finally{
              em.close();
          }
         return not; 
    }
    
    public List<Notas> consultar(){
        List<Notas> listaN=null;
          EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
          em.getTransaction().begin();
          try{
              Query query=em.createQuery("SELECT n FROM Notas n");
              
              em.getTransaction().commit();
              listaN=query.getResultList();
              System.out.println(listaN+"si");
              return listaN;
              
          }catch(Exception e){
              em.getTransaction().rollback();
             return null; 
          }finally{
              em.close();
          }
          
    }
 public int Actualizar(Notas notas){
          EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
          Notas not=null;
          em.getTransaction().begin();
         int flag=0;
          try{
              not=em.find(Notas.class, notas.getIdNota());
            not.setIdNota(notas.getIdNota());
             not.setNie(notas.getNie());
             not.setNombreMateria(notas.getNombreMateria());
             not.setNota1(notas.getNota1());
             not.setNota2(notas.getNota2());
             not.setNota3(notas.getNota3());
             not.setNota4(notas.getNota4());
             not.setNota5(notas.getNota5());
             not.setNota6(notas.getNota6());
             not.setPromerio(notas.getPromerio());
             not.setReposicion(notas.getReposicion());
             not.setFinal1(notas.getFinal1());
             not.setEstadoAlumno(notas.getEstadoAlumno());
             not.setEstadoNotas(notas.getEstadoNotas());
             not.setCampo(notas.getCampo());
              em.getTransaction().commit();
               flag=1;
          }catch(Exception e){
            
              em.getTransaction().rollback();
            flag=0; 
          }finally{
              em.close();
          }
        return flag;
       
 
          
    
   
}    
 
  public int eliminar(Notas notas){
          EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
          Notas not=null;
          em.getTransaction().begin();
         int flag=0;
          try{
              not=em.find(Notas.class, notas.getIdNota());
            em.remove(not);
                      
              em.getTransaction().commit();
               flag=1;
          }catch(Exception e){
            
              em.getTransaction().rollback();
            flag=0; 
          }finally{
              em.close();
          }
        return flag;
       

}
  
       public Integer consultarMaxNotas(){
        int idMax=0;
        String sql="select max(n.idNota) from Notas n";
        EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
           idMax = Integer.parseInt(em.createQuery(sql).getSingleResult().toString());
           em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
        return idMax;
    }
}
