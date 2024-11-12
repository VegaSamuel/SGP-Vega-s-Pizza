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
    
    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "estado_pedido", nullable = false)
    private EstadoPedidos estado;
    
    @Column(name = "costo", nullable = false)
    private Float costo;
    
    @Column(name = "envio", nullable = false)
    private Float envio;
    
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
     * @param envio Costo del envio del pedido
     * @param cliente Cliente que realizó el pedido
     * @param fecha Fecha en la que se realizó el pedido
     * @param tipoPago Tipo de pago utilizado para el pedido
     */
    public Pedido(String descripcion, EstadoPedidos estado, Float costo, Float envio, Cliente cliente, Calendar fecha, TipoPago tipoPago) {
        this.descripcion = descripcion;
        this.estado = estado;
        this.costo = costo;
        this.envio = envio;
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
     * @param envio Costo de envío del pedido
     * @param fecha Fecha en la que se realizó el pedido
     * @param tipoPago Tipo de pago utilizado para el pedido
     */
    public Pedido(Long id, String descripcion, EstadoPedidos estado, Cliente cliente, Float costo, Float envio, Calendar fecha, TipoPago tipoPago) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.costo = costo;
        this.envio = envio;
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

    public Float getEnvio() {
        return envio;
    }

    public void setEnvio(Float envio) {
        this.envio = envio;
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
        "<html>%s (%s)<br>%s <br>%s - %s <br>$ %.2f %s (%s) </html>",
            String.valueOf(this.id),
            this.estado.name().toLowerCase(),
            this.descripcion,
            this.cliente.getNombres(),
            this.cliente.getDireccion(),
            this.costo,
            (this.envio > 0) ? String.format(" + $ %.2f de envío", this.envio) : " (Sin costo de envío)",
            this.tipoPago.name().toLowerCase()
        );
    }

    public boolean esActual() {
        return this.estado == EstadoPedidos.COCINANDO || this.estado == EstadoPedidos.ENVIADO;
    }
    
}
