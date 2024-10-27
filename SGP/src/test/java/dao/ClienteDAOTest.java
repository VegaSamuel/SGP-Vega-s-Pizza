package dao;

import dominio.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ClienteDAOTest {
    private EntityManager em;
    private EntityTransaction et;
    private CriteriaBuilder cb;
    private ClienteDAO clientes;
    
    @BeforeEach
    public void setUp() {
        em = mock(EntityManager.class);
        et = mock(EntityTransaction.class);
        cb = mock(CriteriaBuilder.class);
        
        when(em.getCriteriaBuilder()).thenReturn(cb);
        when(em.getTransaction()).thenReturn(et);
        
        clientes = new ClienteDAO(em);
    }
    
    @Test
    public void testObten_Long() {
        System.out.println("Prueba de ClienteDAO.obten(id)");
        Cliente cliente = new Cliente(1L, "Juan", "Minjares", "Ballarta", "Mulberry Street #17548", "6444897456");
        
        when(em.find(Cliente.class, 1L)).thenReturn(cliente);
        
        Cliente result = clientes.obten(1L);
        
        assertNotNull(result);
        assertEquals("Juan", result.getNombres());
    }

    @Test
    public void testObten_String() {
        System.out.println("Prueba de ClienteDAO.obten(telefono)");
        Cliente cliente = new Cliente(1L, "Juan", "Minjares", "Ballarta", "Mulberry Street #17548", "6444897456");
        
        CriteriaQuery<Cliente> cq = mock(CriteriaQuery.class);
        Root<Cliente> r = mock(Root.class);
        
        when(cb.createQuery(Cliente.class)).thenReturn(cq);
        when(cq.from(Cliente.class)).thenReturn(r);
        
        TypedQuery<Cliente> tq = mock(TypedQuery.class);
        when(em.createQuery(cq)).thenReturn(tq);
        when(tq.getSingleResult()).thenReturn(cliente);
        
        Cliente result = clientes.obten("6444897456");
        
        assertNotNull(result);
        assertEquals("Juan", result.getNombres());
    }

    @Test
    public void testAgregarCliente() {
        System.out.println("Prueba de ClienteDAO.agregarCliente()");
        Cliente cliente = new Cliente(1L, "Juan", "Minjares", "Ballarta", "Mulberry Street #17548", "6444897456");
        
        doNothing().when(em).persist(cliente);
        
        clientes.agregarCliente(cliente);
        
        verify(et, times(1)).begin();
        verify(em, times(1)).persist(cliente);
        verify(et, times(1)).commit();
    }

    @Test
    public void testModificarCliente() {
        System.out.println("Prueba de ClienteDAO.modificarCliente()");
        Cliente cliente = new Cliente(1L, "Juan", "Minjares", "Ballarta", "Mulberry Street #17548", "6444897456");
        
        when(em.find(Cliente.class, 1L)).thenReturn(cliente);
        
        cliente.setTelefono("1234567890");
        clientes.modificarCliente(cliente);
        
        verify(em.getTransaction(), times(1)).begin();
        verify(em.getTransaction(), times(1)).commit();
    }

    @Test
    public void testEliminarCliente() {
        System.out.println("Prueba de ClienteDAO.eliminarCliente()");
        Cliente cliente = new Cliente(1L, "Juan", "Minjares", "Ballarta", "Mulberry Street #17548", "6444897456");
        
        when(em.find(Cliente.class, 1L)).thenReturn(cliente);
        doNothing().when(em).remove(cliente);
        
        clientes.eliminarCliente(1L);
        
        verify(em, times(1)).remove(cliente);
    }

    @Test
    public void testObtenerClientes() {
        System.out.println("Prueba de ClienteDAO.obtenerClientes()");
        
        CriteriaQuery<Cliente> cq = mock(CriteriaQuery.class);
        Root<Cliente> r = mock(Root.class);
        
        when(cb.createQuery(Cliente.class)).thenReturn(cq);
        when(cq.from(Cliente.class)).thenReturn(r);
        
        List<Cliente> lClientes = new ArrayList<>();
        lClientes.add(new Cliente(1L, "Juan", "Minjares", "Ballarta", "Mulberry Street #17548", "6444897456"));
        lClientes.add(new Cliente(2L, "Yuzel", "Espinoza", "Juarez", "Sesamo Street #1234", "6447894567"));
        
        TypedQuery<Cliente> tq = mock(TypedQuery.class);
        
        when(em.createQuery(cq)).thenReturn(tq);
        when(tq.getResultList()).thenReturn(lClientes);
        
        List<Cliente> result = clientes.obtenerClientes();
        
        assertNotNull(result);
        assertEquals(2, result.size());
        
        assertEquals("Juan", result.get(0).getNombres());
        assertEquals("Yuzel", result.get(1).getNombres());
    }
    
}
