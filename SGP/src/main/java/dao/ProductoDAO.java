package dao;

import dominio.Producto;
import excepciones.DAOException;
import interfaces.IProductoDAO;
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
public class ProductoDAO implements IProductoDAO {
    EntityManager em;
    
    public ProductoDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public Producto obten(Long id) throws DAOException {
        Producto producto = null;
        
        try {
            producto = em.find(Producto.class, id);
        }catch (DAOException e){
            System.out.println(e.getMessage());
        }finally {
            em.close();
        }
        
        return producto;
    }

    @Override
    public void agregarProducto(Producto producto) throws DAOException {
        try {
            em.getTransaction().begin();
            em.persist(producto);
            em.getTransaction().commit();
        }catch(DAOException e) {
            if(em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("No se pudo registrar el producto");
        }finally {
            em.close();
        }
    }

    @Override
    public void modificarProducto(Producto producto) throws DAOException {
        try {
            em.getTransaction().begin();
            
            Producto EProducto = em.find(Producto.class, producto.getId());
            if(EProducto != null) {
                EProducto.setNombre(producto.getNombre());
                EProducto.setPrecio(producto.getPrecio());
                EProducto.setIngredientes(producto.getIngredientes());
            }else {
                System.out.println("No se encontró el producto que se quiere modificar");
            }
        }catch(DAOException e) {
            if(em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("No se pudo modificar el producto");
        }finally {
            em.close();
        }
    }

    @Override
    public void eliminarProducto(Long id) throws DAOException {
        try {
            em.getTransaction().begin();
            
            Producto EProducto = em.find(Producto.class, id);
            if(EProducto != null) {
                em.remove(EProducto);
            }else {
                System.out.println("No se encontró el producto mencionado");
            }
        }catch(DAOException e) {
            if(em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("No se pudo eliminar el producto");
        }finally {
            em.close();
        }
    }

    @Override
    public List<Producto> obtenerProductos() throws DAOException {
        List<Producto> productos = null;
        
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Producto> cq = cb.createQuery(Producto.class);
            Root<Producto> c = cq.from(Producto.class);
            
            cq.select(c);
            productos = em.createQuery(cq).getResultList();
        }catch(NoResultException nre) {
            System.out.println("No se encontrarón productos.");
        }finally {
            em.close();
        }
        
        return productos;
    }
    
}
