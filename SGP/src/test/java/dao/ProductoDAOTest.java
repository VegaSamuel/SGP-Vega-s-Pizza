package dao;

import dominio.Cliente;
import dominio.Ingrediente;
import dominio.Producto;
import excepciones.DAOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author rezro
 */
public class ProductoDAOTest {

    private EntityManager em;
    private EntityTransaction et;
    private CriteriaBuilder cb;
    private ProductoDAO productos;
    private CriteriaQuery cqMock;
    private TypedQuery queryMock;

    @BeforeEach
    public void setUp() {
        em = mock(EntityManager.class);
        et = mock(EntityTransaction.class);
        cb = mock(CriteriaBuilder.class);
        cqMock = mock(CriteriaQuery.class);
        mock(Root.class);
        queryMock = mock(TypedQuery.class);

        when(em.getCriteriaBuilder()).thenReturn(cb);
        when(em.getTransaction()).thenReturn(et);

        productos = new ProductoDAO(em);
    }

    @Test
    public void obtenTest() {

    }

    @Test
    public void testObtenProductoExistente() {
        Long id = 1L;
        Producto productoEsperado = new Producto();
        when(em.find(Producto.class, id)).thenReturn(productoEsperado);

        Producto resultado = productos.obten(id);

        assertEquals(productoEsperado, resultado);
        verify(em).find(Producto.class, id);

    }

    @Test
    public void testAgregarProductoExitoso() throws DAOException {
        Producto producto = new Producto();

        productos.agregarProducto(producto);

        verify(et).begin();
        verify(em).persist(producto);
        verify(et).commit();
        verify(em).close();
    }

    @Test
    public void testModificarProductoExistente() throws DAOException {         
        List ing = new ArrayList();
        
        Producto producto = new Producto(1L,"nombre",10.0F, ing);
  
        when(em.find(Producto.class, producto.getId())).thenReturn(producto);

        producto.setNombre("nuevo nombre");
        productos.modificarProducto(producto);
        
       verify(em.getTransaction(), times(1)).begin();
       verify(em.getTransaction(), times(1)).commit();
    }
   

    @Test
    public void testEliminarProductoExistente() throws DAOException {
        Long id = 1L;
        Producto EProducto = new Producto();
        when(em.find(Producto.class, id)).thenReturn(EProducto);

        productos.eliminarProducto(id);

        verify(em, times(1)).remove(EProducto);

    }

    @Test
    public void testObtenerProductosExitoso() throws DAOException {        
        CriteriaQuery<Producto> cq = mock(CriteriaQuery.class);
        Root<Producto> r = mock(Root.class);
        Producto p = new Producto();
        
        when(cb.createQuery(Producto.class)).thenReturn(cq);
        when(cq.from(Producto.class)).thenReturn(r);
        
        List<Producto> lProductos = new ArrayList<>();
        lProductos.add(new Producto(1L, "nombre1",10.0F, p.getIngredientes()));
        lProductos.add(new Producto(2L, "nombre2",10.0F, p.getIngredientes()));
        
        TypedQuery<Producto> tq = mock(TypedQuery.class);
        
        when(em.createQuery(cq)).thenReturn(tq);
        when(tq.getResultList()).thenReturn(lProductos);
        
        List<Producto> result = productos.obtenerProductos();
        
        assertNotNull(result);
        assertEquals(2, result.size());
        
        assertEquals("nombre1", result.get(0).getNombre());
        assertEquals("nombre2", result.get(1).getNombre());
    }

}
