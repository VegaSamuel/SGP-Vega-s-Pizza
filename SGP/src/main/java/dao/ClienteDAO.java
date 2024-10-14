package dao;

import dominio.Cliente;
import excepciones.DAOException;
import interfaces.IClienteDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import util.DBConector;

/**
 * DAO del cliente
 * @author Samuel Vega
 */
public class ClienteDAO implements IClienteDAO {
    private final EntityManager em = new DBConector().getEM();
    
    @Override
    public Cliente obten(Long id) throws DAOException {
        Cliente cliente = null;
        
        try {
            cliente = em.find(Cliente.class, id);
        }catch (DAOException e){
            System.out.println("No se pudo obtener el cliente: " + id);
        }finally {
            em.close();
        }
        
        return cliente;
    }

    @Override
    public Cliente obten(String telefono) throws DAOException {
        Cliente cliente = null;
        
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Cliente> cq = cb.createQuery(Cliente.class);
            Root<Cliente> c = cq.from(Cliente.class);
            
            cq.where(cb.equal(c.get("telefono"), telefono));
            cliente = em.createQuery(cq).getSingleResult();
        }catch (NoResultException nre) {
            System.out.println("No se encontró ningún cliente con ese teléfono.");
        }catch (NonUniqueResultException nure) {
            System.out.println("Se encontraron muchos clientes con este mismo teléfono.");
        }finally {
            em.close();
        }
        
        return cliente;
    }

    @Override
    public void agregarCliente(Cliente cliente) throws DAOException {
        try {
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
        }catch(DAOException e) {
            if(em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("No se pudo registrar el cliente");
        }finally {
            em.close();
        }
    }

    @Override
    public void modificarCliente(Cliente cliente) throws DAOException {
        try {
            em.getTransaction().begin();
            
            Cliente ECliente = em.find(Cliente.class, cliente.getId());
            if(ECliente != null) {
                ECliente.setNombres(cliente.getNombres());
                ECliente.setApellidoPaterno(cliente.getApellidoPaterno());
                ECliente.setApellidoMaterno(cliente.getApellidoMaterno());
                ECliente.setDireccion(cliente.getDireccion());
                ECliente.setTelefono(cliente.getTelefono());
            }else {
                System.out.println("No se encontró el cliente que se quiere modificar");
            }
        }catch(DAOException e) {
            if(em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("No se pudo modificar el cliente");
        }finally {
            em.close();
        }
    }

    @Override
    public void eliminarCliente(Long id) throws DAOException {
        try {
            em.getTransaction().begin();
            
            Cliente ECliente = em.find(Cliente.class, id);
            if(ECliente != null) {
                em.remove(ECliente);
            }else {
                System.out.println("No se encontró el cliente mencionado");
            }
        }catch(DAOException e) {
            if(em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("No se pudo eliminar el cliente");
        }finally {
            em.close();
        }
    }

    @Override
    public List<Cliente> obtenerClientes() throws DAOException {
        List<Cliente> clientes = null;
        
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Cliente> cq = cb.createQuery(Cliente.class);
            Root<Cliente> c = cq.from(Cliente.class);
            
            cq.select(c);
            clientes = em.createQuery(cq).getResultList();
        }catch(NoResultException nre) {
            System.out.println("No se encontrarón clientes.");
        }finally {
            em.close();
        }
        
        return clientes;
    }
    
}
