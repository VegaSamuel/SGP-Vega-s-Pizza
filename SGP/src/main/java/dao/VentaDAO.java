package dao;

import dominio.Pedido;
import dominio.Venta;
import excepciones.DAOException;
import interfaces.IVentaDAO;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import util.enums.EstadoVentas;

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
                EVenta.setEstado(venta.getEstado());
                
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
                em.getTransaction().commit();
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
            Join<Venta, Pedido> pedidoJoin = c.join("objetoPedido");
            
            Predicate estadoPagada = cb.equal(c.get("estado"), EstadoVentas.PAGADA);
            
            cq.select(c).where(estadoPagada).groupBy(pedidoJoin.get("id"));
            ventas = em.createQuery(cq).getResultList();
        }catch(NoResultException nre) {
            System.out.println("No se encontraron ventas");
        }finally {
            em.close();
        }
        
        return ventas;
    }
    
    @Override
    public List<Venta> obtenVentasPedido(Pedido pedido) throws DAOException {
        List<Venta> ventas = null;
        
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Venta> cq = cb.createQuery(Venta.class);
            Root<Venta> v = cq.from(Venta.class);
            
            cq.where(cb.equal(v.get("objetoPedido"), pedido));
            ventas = em.createQuery(cq).getResultList();
        }catch (DAOException e) {
            System.out.println("No se pudo obtener la venta con el pedido: " + pedido.getId());
        }finally {
            em.close();
        }
        
        return ventas;
    }
    
    @Override
    public List<Venta> obtenVentasEntreFechas(Calendar fechaInicio, Calendar fechaFin) {
        List<Venta> ventas = null;

        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Venta> cq = cb.createQuery(Venta.class);
            Root<Venta> ventaRoot = cq.from(Venta.class);
            Join<Venta, Pedido> pedidoJoin = ventaRoot.join("objetoPedido");

            // Convertir Calendar a Date
            Date fechaInicioDate = fechaInicio.getTime();
            Date fechaFinDate = fechaFin.getTime();

            Predicate rangoFechas = cb.between(pedidoJoin.get("fecha"), fechaInicioDate, fechaFinDate);
            Predicate estadoPagada = cb.equal(ventaRoot.get("estado"), EstadoVentas.PAGADA);
            
            cq.select(ventaRoot).where(cb.and(rangoFechas, estadoPagada)).groupBy(pedidoJoin.get("id"));

            ventas = em.createQuery(cq).getResultList();
        } catch (NoResultException nre) {
            System.out.println("No se encontraron pedidos en el rango de fechas proporcionado.");
        } finally {
            em.close();
        }

        return ventas;
    }
}
