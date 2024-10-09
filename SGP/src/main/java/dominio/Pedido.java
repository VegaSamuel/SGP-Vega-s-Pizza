package dominio;

import java.util.Date;
import util.EstadoPedidos;
import util.TipoPago;

/**
 *
 * @author Samuel Vega
 */
public class Pedido {
    private int id;
    private String descripcion;
    private EstadoPedidos estado;
    private float costo;
    private Cliente cliente;
    private Date fecha;
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
    public Pedido(String descripcion, EstadoPedidos estado, float costo, Cliente cliente, Date fecha, TipoPago tipoPago) {
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
    public Pedido(int id, String descripcion, EstadoPedidos estado, Cliente cliente, float costo, Date fecha, TipoPago tipoPago) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.costo = costo;
        this.cliente = cliente;
        this.fecha = fecha;
        this.tipoPago = tipoPago;
    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
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
        int hash = 3;
        hash = 73 * hash + this.id;
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
        return this.id == other.id;
    }

    /**
     * Manda la información del objeto.
     * @return Información del objeto.
     */
    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", descripcion=" + descripcion + ", estado=" + estado + ", costo=" + costo + ", fecha=" + fecha + ", tipoPago=" + tipoPago + '}';
    }

}
