package dao;

import dominio.Pedido;
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
    public Pedido obten(Long id) {
        Pedido cliente = null;
        
        try {
            cliente = em.find(Pedido.class, id);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            em.close();
        }
        
        return cliente;
    }

    @Override
    public void agregarPedido(Pedido pedido) {
        try {
            em.getTransaction().begin();
            em.persist(pedido);
            em.getTransaction().commit();
        }catch(Exception e) {
            if(em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("No se pudo registrar el cliente");
        }finally {
            em.close();
        }
    }

    @Override
    public void modificarPedido(Pedido pedido) {
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
                System.out.println("No se encontró el cliente que se quiere modificar");
            }
        }catch(Exception e) {
            if(em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("No se pudo modificar el cliente");
        }finally {
            em.close();
        }
    }

    @Override
    public void eliminarPedido(Long id) {
        try {
            em.getTransaction().begin();
            
            Pedido EPedido = em.find(Pedido.class, id);
            if(EPedido != null) {
                em.remove(EPedido);
            }else {
                System.out.println("No se encontró el cliente mencionado");
            }
        }catch(Exception e) {
            if(em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("No se pudo eliminar el cliente");
        }finally {
            em.close();
        }
    }

    @Override
    public List<Pedido> obtenerPedidos() {
        List<Pedido> pedidos = null;
        
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Pedido> cq = cb.createQuery(Pedido.class);
            Root<Pedido> c = cq.from(Pedido.class);
            
            cq.select(c);
            pedidos = em.createQuery(cq).getResultList();
        }catch(NoResultException nre) {
            System.out.println("No se encontrarón clientes.");
        }finally {
            em.close();
        }
        
        return pedidos;
    }
    
}
