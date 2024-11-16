package dao;

import dominio.IngredientesPorProducto;
import excepciones.DAOException;
import interfaces.IIngredientesPorProductoDAO;
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
public class IngredientesPorProductoDAO implements IIngredientesPorProductoDAO {
    private final EntityManager em;
    
    public IngredientesPorProductoDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public IngredientesPorProducto obten(Long id) throws DAOException {
        IngredientesPorProducto ingredientes = null;
        
        try {
            ingredientes = em.find(IngredientesPorProducto.class, id);
        } catch(DAOException e) {
            System.out.println("No se pudo obtener el ingrediente: " + id);
        } finally {
            em.close();
        }
        
        return ingredientes;
    }

    @Override
    public void agregarIngredientesPorProducto(IngredientesPorProducto ingredientesPorProducto) throws DAOException {
        try {
            em.getTransaction().begin();
            em.persist(ingredientesPorProducto);
            em.getTransaction().commit();
        } catch(DAOException e) {
            if(em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("No se pudo agregar los ingredientes del producto");
        } finally {
            em.close();
        }
    }

    @Override
    public void modificarIngredientesPorProducto(IngredientesPorProducto ingredientesPorProducto) throws DAOException {
        try {
            em.getTransaction().begin();
            
            IngredientesPorProducto EIngredientes = em.find(IngredientesPorProducto.class, ingredientesPorProducto.getId());
            if(EIngredientes != null) {
                EIngredientes.setObjetoProducto(ingredientesPorProducto.getObjetoProducto());
                EIngredientes.setObjetoIngrediente(ingredientesPorProducto.getObjetoIngrediente());
                EIngredientes.setCantidadPorProducto(ingredientesPorProducto.getCantidadPorProducto());
                
                em.getTransaction().commit();
            }else {
                System.out.println("No se encontró el ingrediente que se quiere modificar");
            }
        } catch(DAOException e) {
            if(em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("No se pudo modificar el ingrediente del producto");
        } finally {
            em.close();
        }
    }

    @Override
    public void eliminarIngredientesPorProducto(Long id) throws DAOException {
        try {
            em.getTransaction().begin();
            
            IngredientesPorProducto EIngredientes = em.find(IngredientesPorProducto.class, id);
            if(EIngredientes != null) {
                em.remove(EIngredientes);
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
    public List<IngredientesPorProducto> obtenerIngredientesPorProducto() {
        List<IngredientesPorProducto> ingredientes = null;
        
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery(IngredientesPorProducto.class);
            Root<IngredientesPorProducto> i = cq.from(IngredientesPorProducto.class);
            
            cq.select(i);
            ingredientes = em.createQuery(cq).getResultList();
        } catch(NoResultException nre) {
            System.out.println("No se encontraron ingredientes");
        }
        
        return ingredientes;
    }
}
