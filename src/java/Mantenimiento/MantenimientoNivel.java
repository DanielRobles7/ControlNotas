
package Mantenimiento;


import Mantenimiento.JpaUtil;
import Persistencia.Nivel;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.EntityManager;



public class MantenimientoNivel {

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
    public int guardarNivel(Nivel nivel){
        EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
        int flag=0;
        em.getTransaction().begin();
        try{
            em.persist(nivel);
            em.getTransaction().commit();
            flag=1;
        }catch(Exception e){
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
            flag=0;
        }finally{
            em.close();
        }
        return flag;
    }
    
    public Nivel consultarNivel(String grado){
          EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
          Nivel nivel=null;
          em.getTransaction().begin();
          try{
             nivel=em.find(Nivel.class, grado);
              em.getTransaction().commit();
              
          }catch(Exception e){
              em.getTransaction().rollback();
              
          }finally{
              em.close();
          }
         return nivel; 
    }
    
    public List<Nivel> consultarTodosNivel(){
        List<Nivel> listaNivel=null;
          EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
          em.getTransaction().begin();
          try{
              Query query=em.createQuery("SELECT n FROM Nivel n");
              
              em.getTransaction().commit();
              listaNivel=query.getResultList();
              System.out.println(listaNivel);
              return listaNivel;
              
          }catch(Exception e){
              em.getTransaction().rollback();
             return null; 
          }finally{
              em.close();
          }
          
    }
 public int ActualizarNivel(Nivel nivel){
          EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
          Nivel niv=null;
          em.getTransaction().begin();
         int flag=0;
          try{
              niv=em.find(Nivel.class, nivel.getGrado());
             niv.setGrado(nivel.getGrado());
             niv.setCodigoEscuela(nivel.getCodigoEscuela());
            niv.setEstado(nivel.getEstado());
            niv.setCampo(nivel.getCampo());
            
          
                      
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
 
  public int eliminarNivel(Nivel nivel){
          EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
          Nivel niv=null;
          em.getTransaction().begin();
         int flag=0;
          try{
              niv=em.find(Nivel.class, nivel.getGrado());
            em.remove(niv);
                      
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
  
  
 
}
