/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package dao;

import dominio.Cliente;
import dominio.Pedido;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import util.EstadoPedidos;
import util.TipoPago;

/**
 *
 * @author PC
 */
public class PedidoDAOTest {

    private EntityManager em;
    private EntityTransaction et;
    private CriteriaBuilder cb;
    private PedidoDAO pedidos;

    public PedidoDAOTest() {
    }

    @BeforeEach
    public void setUp() {
        em = mock(EntityManager.class);
        et = mock(EntityTransaction.class);
        cb = mock(CriteriaBuilder.class);

        when(em.getCriteriaBuilder()).thenReturn(cb);
        when(em.getTransaction()).thenReturn(et);

        pedidos = new PedidoDAO(em);
    }

    /**
     * Test of obten method, of class PedidoDAO.
     */
    @Test
    public void testObten_Long() {
        System.out.println("Prueba de PedidoDAO.obten(id)");
        Pedido pedido = new Pedido(
                "Pedido de prueba",
                EstadoPedidos.COCINANDO,
                12.0f,
                5.0f,
                new Cliente(),
                Calendar.getInstance(),
                TipoPago.EFECTIVO
        );

        when(em.find(Pedido.class, 1L)).thenReturn(pedido);

        Pedido result = pedidos.obten(1L);

        assertNotNull(result);
        assertEquals("Pedido de prueba", result.getDescripcion());

    }

    /**
     * Test of agregarPedido method, of class PedidoDAO.
     */
    @Test
    public void testAgregarPedido() {
        System.out.println("Prueba de PedidoDAO.agregarPedido()");
        Pedido pedido = new Pedido(
                "Pedido de prueba",
                EstadoPedidos.COCINANDO,
                12.0f,
                5.0f,
                new Cliente(),
                Calendar.getInstance(),
                TipoPago.EFECTIVO
        );
        doNothing().when(em).persist(pedido);

        pedidos.agregarPedido(pedido);

        verify(et, times(1)).begin();
        verify(em, times(1)).persist(pedido);
        verify(et, times(1)).commit();

    }

    /**
     * Test of modificarPedido method, of class PedidoDAO.
     */
    @Test
    public void testModificarPedido() {
        System.out.println("Prueba de PedidoDAO.modificarPedido()");
        Pedido pedido = new Pedido(
                "Pedido de prueba",
                EstadoPedidos.COCINANDO,
                12.0f,
                5.0f,
                new Cliente(),
                Calendar.getInstance(),
                TipoPago.EFECTIVO
        );

        pedido.setId(1L);

        when(em.find(Pedido.class, 1L)).thenReturn(pedido);

        pedido.setDescripcion("Cambio de descripcion");
        pedidos.modificarPedido(pedido);

        verify(em.getTransaction(), times(1)).begin();
        verify(em.getTransaction(), times(1)).commit();

    }

    /**
     * Test of eliminarPedido method, of class PedidoDAO.
     */
    @Test
    public void testEliminarPedido() {
        System.out.println("Prueba de PedidoDAO.eliminarPedido()");
        Pedido pedido = new Pedido(
                "Pedido de prueba",
                EstadoPedidos.COCINANDO,
                12.0f,
                5.0f,
                new Cliente(),
                Calendar.getInstance(),
                TipoPago.EFECTIVO
        );
        pedido.setId(1L);
        when(em.find(Pedido.class, 1L)).thenReturn(pedido);
        doNothing().when(em).remove(pedido);

        pedidos.eliminarPedido(1L);

        verify(em, times(1)).remove(pedido);
    }

    /**
     * Test of obtenerPedidos method, of class PedidoDAO.
     */
    @Test
    public void testObtenerPedidos() {
        System.out.println("Prueba de PedidoDAO.obtenerPedidos()");
        CriteriaQuery<Pedido> cq = mock(CriteriaQuery.class);
        Root<Pedido> r = mock(Root.class);

        when(cb.createQuery(Pedido.class)).thenReturn(cq);
        when(cq.from(Pedido.class)).thenReturn(r);

        List<Pedido> lPedidos = new ArrayList<>();
        lPedidos.add(new Pedido(
                "Pedido de prueba",
                EstadoPedidos.COCINANDO,
                12.0f,
                5.0f,
                new Cliente(),
                Calendar.getInstance(),
                TipoPago.EFECTIVO
        ));

        lPedidos.add(new Pedido(
                "Pedido de prueba 02",
                EstadoPedidos.ENVIADO,
                15.0f,
                5.0f,
                new Cliente(),
                Calendar.getInstance(),
                TipoPago.TRANSFERENCIA
        ));

        TypedQuery<Pedido> tq = mock(TypedQuery.class);

        when(em.createQuery(cq)).thenReturn(tq);
        when(tq.getResultList()).thenReturn(lPedidos);

        List<Pedido> result = pedidos.obtenerPedidos();

        assertNotNull(result);
        assertEquals(2, result.size());

        assertEquals("Pedido de prueba", result.get(0).getDescripcion());
        assertEquals("Pedido de prueba 02", result.get(1).getDescripcion());
    }

    /**
     * Test of obtenerPedidosEntreFechas method, of class PedidoDAO.
     */
    @Test
public void testObtenerPedidosEntreFechas() { 
    System.out.println("Prueba de PedidoDAO.obtenerPedidosEntreFechas()");
    
    // Simulación del CriteriaBuilder y CriteriaQuery
    CriteriaBuilder cb = mock(CriteriaBuilder.class);
    CriteriaQuery<Pedido> cq = mock(CriteriaQuery.class);
    Root<Pedido> r = mock(Root.class);
    Predicate predicado = mock(Predicate.class);

    // Simulación de Calendar
    Calendar fecha0 = Calendar.getInstance();
    fecha0.set(2024, Calendar.AUGUST, 22);

    Calendar fecha1 = Calendar.getInstance();
    fecha1.set(2024, Calendar.AUGUST, 21);

    Calendar fecha2 = Calendar.getInstance();
    fecha2.set(2024, Calendar.AUGUST, 24);

    // Datos de prueba
    List<Pedido> lPedidos = new ArrayList<>();
    lPedidos.add(new Pedido(
            "Pedido de prueba",
            EstadoPedidos.COCINANDO,
            12.0f,
            5.0f,
            new Cliente(),
            fecha0,
            TipoPago.EFECTIVO
    ));

    lPedidos.add(new Pedido(
            "Pedido de prueba 02",
            EstadoPedidos.ENVIADO,
            15.0f,
            5.0f,
            new Cliente(),
            fecha0,
            TipoPago.TRANSFERENCIA
    ));

    TypedQuery<Pedido> tq = mock(TypedQuery.class);

    // Asegurarse de que se devuelve un CriteriaQuery no nulo
    when(em.getCriteriaBuilder()).thenReturn(cb);
    when(cb.createQuery(Pedido.class)).thenReturn(cq);
    when(cq.from(Pedido.class)).thenReturn(r);
    
    // Simulación de Predicate y CriteriaQuery
    when(cb.between(any(), any(Date.class), any(Date.class))).thenReturn(predicado);  // Mock de between
    when(cq.select(r)).thenReturn(cq);  
    when(cq.where(predicado)).thenReturn(cq);
    
    // Simulación del TypedQuery
    when(em.createQuery(cq)).thenReturn(tq);
    when(tq.getResultList()).thenReturn(lPedidos);

    // Ejecución del método a probar
    List<Pedido> result = pedidos.obtenerPedidosEntreFechas(fecha1, fecha2);

    // Verificaciones
    assertNotNull(result);
    assertEquals(2, result.size());
    assertEquals("Pedido de prueba", result.get(0).getDescripcion());
    assertEquals("Pedido de prueba 02", result.get(1).getDescripcion());
}




}
