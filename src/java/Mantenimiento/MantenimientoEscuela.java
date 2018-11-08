
package Mantenimiento;

import java.util.List;
import javax.persistence.Query;
import javax.persistence.EntityManager;

import Persistencia.Escuelas;



public class MantenimientoEscuela {
  
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
    public int guardar(Escuelas escuelas){
        EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
        int flag=0;
        em.getTransaction().begin();
        try{
            em.persist(escuelas);
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
    
    public Escuelas consultarid(int codigoEscuela){
          EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
          Escuelas escuel=null;
          em.getTransaction().begin();
          try{
             escuel=em.find(Escuelas.class, codigoEscuela);
              em.getTransaction().commit();
              
          }catch(Exception e){
              em.getTransaction().rollback();
              
          }finally{
              em.close();
          }
         return escuel; 
    }
    
    public List<Escuelas> consultar(){
        List<Escuelas> listaE=null;
          EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
          em.getTransaction().begin();
          try{
              Query query=em.createQuery("SELECT e FROM Escuelas e");
              
              em.getTransaction().commit();
              listaE=query.getResultList();
              System.out.println(listaE+"si");
              return listaE;
              
          }catch(Exception e){
              em.getTransaction().rollback();
             return null; 
          }finally{
              em.close();
          }
          
    }
 public int Actualizar(Escuelas escuela){
          EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
          Escuelas esc=null;
          em.getTransaction().begin();
         int flag=0;
          try{
              esc=em.find(Escuelas.class, escuela.getCodigoEscuela());
            esc.setNombreEscuela(escuela.getNombreEscuela());
             esc.setDireccion(escuela.getDireccion());
             esc.setMunicipio(escuela.getMunicipio());
             esc.setTelefono(escuela.getTelefono());
             esc.setCorreo(escuela.getCorreo());
             esc.setLongitud(escuela.getLongitud());
             esc.setLatitud(escuela.getLatitud());
             esc.setNombreDirector(escuela.getNombreEscuela());
             esc.setIdAcceso(escuela.getIdAcceso());
             esc.setEstado(escuela.getEstado());
             esc.setCampo(escuela.getCampo());
                      
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
 
  public int eliminar(Escuelas escuelas){
          EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
          Escuelas escue=null;
          em.getTransaction().begin();
         int flag=0;
          try{
              escue=em.find(Escuelas.class, escuelas.getCodigoEscuela());
            em.remove(escue);
                      
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
