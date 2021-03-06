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
    public int guardar(Escuelas escuelas) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        int flag = 0;
        em.getTransaction().begin();
        try {
            em.persist(escuelas);
            em.getTransaction().commit();
            flag = 1;
            System.out.println("exito,guardarEscuelas,mantenimientoEscuelas");
        } catch (Exception e) {
            em.getTransaction().rollback();
            flag = 0;
            System.out.println("error,guardarEscuelas,mantenimientoEscuelas" + e);
        } finally {
            em.close();
        }
        return flag;
    }

    public Escuelas consultarid(int codigoEscuela) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        Escuelas escuel = null;
        em.getTransaction().begin();
        try {
            escuel = em.find(Escuelas.class, codigoEscuela);
            em.getTransaction().commit();
            System.out.println("exito,consultaridEscuela,mantenimientoEscuela");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("error,consultaridEscuela,mantenimientoEscuela" + e);
        } finally {
            em.close();
        }
        return escuel;
    }

    public List<Escuelas> consultar() {
        List<Escuelas> listaE = null;
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            Query query = em.createQuery("SELECT e FROM Escuelas e where e.estado='activo'");

            em.getTransaction().commit();
            listaE = query.getResultList();
            System.out.println(listaE + "si");
            return listaE;

        } catch (Exception e) {
            em.getTransaction().rollback();
            return null;
        } finally {
            em.close();
        }

    }

    public int Actualizar(Escuelas escuela) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        Escuelas esc = null;
        em.getTransaction().begin();
        int flag = 0;
        try {
            esc = em.find(Escuelas.class, escuela.getCodigoEscuela());
            esc.setCodigoEscuela(escuela.getCodigoEscuela());
            esc.setNombreEscuela(escuela.getNombreEscuela());
            esc.setDireccion(escuela.getDireccion());
            esc.setMunicipio(escuela.getMunicipio());
            esc.setTelefono(escuela.getTelefono());
            esc.setCorreo(escuela.getCorreo());
            esc.setLongitud(escuela.getLongitud());
            esc.setLatitud(escuela.getLatitud());
            esc.setNombreDirector(escuela.getNombreDirector());
            esc.setIdAcceso(escuela.getIdAcceso());
            esc.setEstado(escuela.getEstado());
            esc.setCampo(escuela.getCampo());

            em.getTransaction().commit();
            flag = 1;
            System.out.println("EXITOSO");
        } catch (Exception e) {

            em.getTransaction().rollback();
            flag = 0;
            System.out.println("ERROR. " + e);
        } finally {
            em.close();
        }
        return flag;

    }

    public int eliminar(Escuelas escuela) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        Escuelas esc = null;
        int flag = 0;
        try {
            em.getTransaction().begin();
            esc = em.find(Escuelas.class, escuela.getCodigoEscuela());
            esc.setCodigoEscuela(escuela.getCodigoEscuela());
            esc.setNombreEscuela(escuela.getNombreEscuela());
            esc.setDireccion(escuela.getDireccion());
            esc.setMunicipio(escuela.getMunicipio());
            esc.setTelefono(escuela.getTelefono());
            esc.setCorreo(escuela.getCorreo());
            esc.setLongitud(escuela.getLongitud());
            esc.setLatitud(escuela.getLatitud());
            esc.setNombreDirector(escuela.getNombreDirector());
            esc.setIdAcceso(escuela.getIdAcceso());
            esc.setEstado("inactivo");
            esc.setCampo(escuela.getCampo());
            em.getTransaction().commit();
            flag = 1;
            System.out.println("exito,eliminarEscuelas,mantenimientoEscuelas");
        } catch (Exception e) {
            em.getTransaction().rollback();
            flag = 0;
            System.out.println("error,eliminarEscuelas,mantenimientoEscuelas" + e);
        } finally {
            em.close();
        }
        return flag;

    }
    
    public String nombreDirector (int id_acceso){
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        Escuelas escuela = null;
        int codigo_escuela;
        String[] nombre = null;
        String nombreDirector = null;
        
        try {
            em.getTransaction().begin();
            codigo_escuela = Integer.parseInt(em.createNativeQuery("select codigo_escuela from escuelas where escuelas.id_acceso="+id_acceso+";").getSingleResult().toString());
            escuela = this.consultarid(codigo_escuela);
            nombre = escuela.getNombreDirector().split(" ");
            if (nombre.length>2) {
                nombreDirector = nombre[0]+nombre[2];
            }else{
                nombreDirector = escuela.getNombreDirector();
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: "+e.getMessage());
        }finally{
            em.close();
        }        
        return nombreDirector;
    }
}
