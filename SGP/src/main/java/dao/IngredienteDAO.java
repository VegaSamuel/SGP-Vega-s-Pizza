package dao;

import dominio.Ingrediente;
import excepciones.DAOException;
import interfaces.IIngredienteDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * 
 * @author Samuel Vega
 */
public class IngredienteDAO implements IIngredienteDAO {
    private final EntityManager em;
    
    public IngredienteDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public Ingrediente obten(Long id) throws DAOException {
        Ingrediente ingrediente = null;
        
        try {
            ingrediente = em.find(Ingrediente.class, id);
        } catch(DAOException e) {
            System.out.println("No se pudo obtener el ingrediente: " + id);
        } finally {
            em.close();
        }
        
        return ingrediente;
    }

    @Override
    public void agregarIngrediente(Ingrediente ingrediente) throws DAOException {
        try {
            em.getTransaction().begin();
            em.persist(ingrediente);
            em.getTransaction().commit();
        } catch(DAOException e) {
            if(em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("No se pudo agregar el ingrediente");
        } finally {
            em.close();
        }
    }

    @Override
    public void modificarIngrediente(Ingrediente ingrediente) throws DAOException {
        try {
            em.getTransaction().begin();
            
            Ingrediente EIngrediente = em.find(Ingrediente.class, ingrediente.getId());
            if(EIngrediente != null) {
                EIngrediente.setNombre(ingrediente.getNombre());
                EIngrediente.setCantidad(ingrediente.getCantidad());
                EIngrediente.setUnidadMedida(ingrediente.getUnidadMedida());
                
                em.getTransaction().commit();
            }else {
                System.out.println("No se encontró el ingrediente que se quiere modificar");
            }
        } catch(DAOException e) {
            if(em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("No se pudo modificar el ingrediente");
        } finally {
            em.close();
        }
    }

    @Override
    public void eliminarIngrediente(Ingrediente ingrediente) throws DAOException {
        try {
            em.getTransaction().begin();
            
            Ingrediente EIngrediente = em.find(Ingrediente.class, ingrediente.getId());
            if(EIngrediente != null) {
                em.remove(EIngrediente);
                em.getTransaction().commit();
            }else {
                System.out.println("No se encontró el ingrediente que se quiere eliminar");
            }
        } catch(DAOException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("No se pudo eliminar el ingrediente");
        } finally {
            em.close();
        }
    }

    @Override
    public List<Ingrediente> obtenerIngredientes() throws DAOException {
        List<Ingrediente> ingredientes = null;
        
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery(Ingrediente.class);
            Root<Ingrediente> i = cq.from(Ingrediente.class);
            
            cq.select(i);
            ingredientes = em.createQuery(cq).getResultList();
        } catch(NoResultException nre) {
            System.out.println("No se encontraron ingredientes");
        }
        
        return ingredientes;
    }
    
}
