package dominio;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Juan Sánchez
 */
@Entity
@Table(name = "ventas")
public class Venta implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido", nullable = false)
    private Pedido objetoPedido;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto objetoProducto;
    
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;
    
    @Column(name = "precio", nullable = false)
    private Float precio;
    
    @Column(name = "importe", nullable = false)
    private Float importe;

    // Constructor vacío
    public Venta() {}

    /**
     * Constructor sin ID
     * @param objetoPedido Pedido de la venta
     * @param objetoProducto Producto vendido
     * @param cantidad Cantidad del producto que se vendieron
     * @param precio Precio unitario del producto
     * @param importe Importe (cantidad * precio)
     */
    public Venta(Pedido objetoPedido, Producto objetoProducto, Integer cantidad, Float precio, Float importe) {
        this.objetoPedido = objetoPedido;
        this.objetoProducto = objetoProducto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.importe = importe;
    }

    /**
     * Constructor de la venta
     * @param id ID de la venta
     * @param objetoPedido Pedido de la venta
     * @param objetoProducto Producto vendido
     * @param cantidad Cantidad del producto que se vendieron
     * @param precio Precio unitario del producto
     * @param importe Importe (cantidad * precio) 
     */
    public Venta(Long id, Pedido objetoPedido, Producto objetoProducto, Integer cantidad, Float precio, Float importe) {
        this.id = id;
        this.objetoPedido = objetoPedido;
        this.objetoProducto = objetoProducto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.importe = importe;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getObjetoPedido() {
        return objetoPedido;
    }

    public void setObjetoPedido(Pedido objetoPedido) {
        this.objetoPedido = objetoPedido;
    }

    public Producto getObjetoProducto() {
        return objetoProducto;
    }

    public void setObjetoProducto(Producto objetoProducto) {
        this.objetoProducto = objetoProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Float getImporte() {
        return importe;
    }

    public void setImporte(Float importe) {
        this.importe = importe;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.id);
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
        final Venta other = (Venta) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * Manda la información del objeto.
     *
     * @return Información del objeto.
     */
    @Override
    public String toString() {
        return "Venta{" + "id=" + id + ", objetoPedido=" + objetoPedido + ", objetoProducto=" + objetoProducto + ", cantidad=" + cantidad + ", precio=" + precio + ", importe=" + importe + '}';
    }

}
