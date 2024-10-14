package dominio;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import util.EstadoPedidos;
import util.TipoPago;

/**
 *
 * @author Samuel Vega
 */
@Entity
@Table(name = "pedidos")
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Column(name = "descipcion", nullable = false, length = 100)
    private String descripcion;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "estado_pedido", nullable = false)
    private EstadoPedidos estado;
    
    @Column(name = "costo", nullable = false)
    private Float costo;
    
    //@Column(name = "envio", nullable = false)
    //private Float envio;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;
    
    @Column(name = "fecha_compra", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fecha;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_pago", nullable = false)
    private TipoPago tipoPago;

    // Constructor vacío
    public Pedido() { }

    /**
     * Constructor sin ID
     * @param descripcion Descripción del pedido
     * @param estado Estado del pedido (Cocinando, Enviado, Cancelado, Pagado)
     * @param costo Costo del pedido
     * @param cliente Cliente que realizó el pedido
     * @param fecha Fecha en la que se realizó el pedido
     * @param tipoPago Tipo de pago utilizado para el pedido
     */
    public Pedido(String descripcion, EstadoPedidos estado, Float costo, Cliente cliente, Calendar fecha, TipoPago tipoPago) {
        this.descripcion = descripcion;
        this.estado = estado;
        this.costo = costo;
        this.cliente = cliente;
        this.fecha = fecha;
        this.tipoPago = tipoPago;
    }

    /**
     * Constructor del pedido
     * @param id ID del pedido
     * @param descripcion Descripción del pedido
     * @param estado Estado del pedido (Cocinando, Enviado, Cancelado, Pagado)
     * @param costo Costo del pedido
     * @param cliente Cliente que realizó el pedido
     * @param fecha Fecha en la que se realizó el pedido
     * @param tipoPago Tipo de pago utilizado para el pedido
     */
    public Pedido(Long id, String descripcion, EstadoPedidos estado, Cliente cliente, Float costo, Calendar fecha, TipoPago tipoPago) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.costo = costo;
        this.cliente = cliente;
        this.fecha = fecha;
        this.tipoPago = tipoPago;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EstadoPedidos getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedidos estado) {
        this.estado = estado;
    }

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pedido other = (Pedido) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * Manda la información del objeto.
     * @return Información del objeto.
     */
    @Override
    public String toString() {
        return String.format(
        "<html>%s<br>%s (%s)<br>%s - %s, %s, %d, %d<br>$ %.2f</html>",
            String.valueOf(this.id),
            this.descripcion,
            this.estado.name().toLowerCase(),
            this.cliente.getNombres(),
            this.cliente.getDireccion().getCalle(),
            this.cliente.getDireccion().getColonia(),
            Integer.parseInt(cliente.getDireccion().getNumero()),
            this.cliente.getDireccion().getCodigoPostal(),
            this.costo
        );
    }

}
