package dao;

import dominio.Pedido;
import excepciones.DAOException;
import interfaces.IPedidoDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import util.DBConector;

/**
 *
 * @author Samuel Vega
 */
public class PedidoDAO implements IPedidoDAO {
    private final EntityManager em = new DBConector().getEM();
    
    @Override
    public Pedido obten(Long id) throws DAOException {
        Pedido cliente = null;
        
        try {
            cliente = em.find(Pedido.class, id);
        }catch (DAOException e){
            System.out.println(e.getMessage());
        }finally {
            em.close();
        }
        
        return cliente;
    }

    @Override
    public void agregarPedido(Pedido pedido) throws DAOException {
        try {
            em.getTransaction().begin();
            em.persist(pedido);
            em.getTransaction().commit();
        }catch(DAOException e) {
            if(em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("No se pudo registrar el pedido");
        }finally {
            em.close();
        }
    }

    @Override
    public void modificarPedido(Pedido pedido) throws DAOException {
        try {
            em.getTransaction().begin();
            
            Pedido EPedido = em.find(Pedido.class, pedido.getId());
            if(EPedido != null) {
                EPedido.setDescripcion(pedido.getDescripcion());
                EPedido.setEstado(pedido.getEstado());
                EPedido.setCosto(pedido.getCosto());
                EPedido.setCliente(pedido.getCliente());
                EPedido.setFecha(pedido.getFecha());
                EPedido.setTipoPago(pedido.getTipoPago());
            }else {
                System.out.println("No se encontró el pedido que se quiere modificar");
            }
        }catch(DAOException e) {
            if(em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("No se pudo modificar el pedido");
        }finally {
            em.close();
        }
    }

    @Override
    public void eliminarPedido(Long id) throws DAOException {
        try {
            em.getTransaction().begin();
            
            Pedido EPedido = em.find(Pedido.class, id);
            if(EPedido != null) {
                em.remove(EPedido);
            }else {
                System.out.println("No se encontró el pedido mencionado");
            }
        }catch(DAOException e) {
            if(em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("No se pudo eliminar el pedido");
        }finally {
            em.close();
        }
    }

    @Override
    public List<Pedido> obtenerPedidos() throws DAOException {
        List<Pedido> pedidos = null;
        
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Pedido> cq = cb.createQuery(Pedido.class);
            Root<Pedido> c = cq.from(Pedido.class);
            
            cq.select(c);
            pedidos = em.createQuery(cq).getResultList();
        }catch(NoResultException nre) {
            System.out.println("No se encontrarón pedidos.");
        }finally {
            em.close();
        }
        
        return pedidos;
    }
    
}