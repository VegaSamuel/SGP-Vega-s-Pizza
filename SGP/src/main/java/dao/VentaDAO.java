package dao;

import dominio.Venta;
import excepciones.DAOException;
import interfaces.IVentaDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class VentaDAO implements IVentaDAO {
    private final EntityManager em;
    
    public VentaDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public Venta obten(Long id) throws DAOException {
        Venta venta = null;
        
        try {
            venta = em.find(Venta.class, id);
        }catch (DAOException e) {
            System.out.println("No se pudo obtener la venta: " + id);
        }finally {
            em.close();
        }
        
        return venta;
    }

    @Override
    public void agregarVenta(Venta venta) throws DAOException {
        try {
            em.getTransaction().begin();
            em.persist(venta);
            em.getTransaction().commit();
        }catch(DAOException e) {
            if(em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("No se pudo registrar la venta");
        }finally {
            em.close();
        }
    }

    @Override
    public void modificarVenta(Venta venta) throws DAOException {
        try {
            em.getTransaction().begin();
            
            Venta EVenta = em.find(Venta.class, venta.getId());
            if(EVenta != null) {
                EVenta.setObjetoPedido(venta.getObjetoPedido());
                EVenta.setObjetoProducto(venta.getObjetoProducto());
                EVenta.setCantidad(venta.getCantidad());
                EVenta.setPrecio(venta.getPrecio());
                EVenta.setImporte(venta.getImporte());
                
                em.getTransaction().commit();
            }else {
                System.out.println("No se encontró la venta que se quiere modificar");
            }
        }catch (DAOException e) {
            if(em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("No se pudo modificar la venta");
        }finally {
            em.close();
        }
    }

    @Override
    public void eliminarVenta(Long id) throws DAOException {
        try {
            em.getTransaction().begin();
            
            Venta EVenta = em.find(Venta.class, id);
            if(EVenta != null) {
                em.remove(EVenta);
            }else {
                System.out.println("No se encontró la venta mencionada");
            }
        }catch(DAOException e) {
            if(em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("No se pudo eliminar la venta");
        }finally {
            em.close();
        }
    }

    @Override
    public List<Venta> obtenerVentas() throws DAOException {
        List<Venta> ventas = null;
        
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery(Venta.class);
            Root<Venta> c = cq.from(Venta.class);
            
            cq.select(c);
            ventas = em.createQuery(cq).getResultList();
        }catch(NoResultException nre) {
            System.out.println("No se encontraron ventas");
        }finally {
            em.close();
        }
        
        return ventas;
    }
    
}
