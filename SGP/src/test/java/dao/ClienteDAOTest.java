package dao;

import dominio.Cliente;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Samuel Vega
 */
public class ClienteDAOTest {
    
    public ClienteDAOTest() {
    }
    
    @BeforeEach
    public void setUp() {
    }

    /**
     * Test of obten method, of class ClienteDAO.
     */
    @Test
    public void testObten_Long() {
        System.out.println("obten");
        Long id = null;
        ClienteDAO instance = new ClienteDAO();
        Cliente expResult = null;
        Cliente result = instance.obten(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obten method, of class ClienteDAO.
     */
    @Test
    public void testObten_String() {
        System.out.println("obten");
        String telefono = "";
        ClienteDAO instance = new ClienteDAO();
        Cliente expResult = null;
        Cliente result = instance.obten(telefono);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarCliente method, of class ClienteDAO.
     */
    @Test
    public void testAgregarCliente() {
        System.out.println("agregarCliente");
        Cliente cliente = null;
        ClienteDAO instance = new ClienteDAO();
        instance.agregarCliente(cliente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificarCliente method, of class ClienteDAO.
     */
    @Test
    public void testModificarCliente() {
        System.out.println("modificarCliente");
        Cliente cliente = null;
        ClienteDAO instance = new ClienteDAO();
        instance.modificarCliente(cliente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarCliente method, of class ClienteDAO.
     */
    @Test
    public void testEliminarCliente() {
        System.out.println("eliminarCliente");
        Long id = null;
        ClienteDAO instance = new ClienteDAO();
        instance.eliminarCliente(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerClientes method, of class ClienteDAO.
     */
    @Test
    public void testObtenerClientes() {
        System.out.println("obtenerClientes");
        ClienteDAO instance = new ClienteDAO();
        List<Cliente> expResult = null;
        List<Cliente> result = instance.obtenerClientes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
