package dominio;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Juan Sánchez
 */
@Entity
@Table(name = "ingredientes_por_producto")
public class IngredientesPorProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "id_producto", nullable = false)
    private Producto objetoProducto;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "id_ingrediente", nullable = false)
    private Ingrediente objetoIngrediente;
    
    @Column(name = "cantidad_por_producto", nullable = false)
    private Integer cantidadPorProducto;

    //Constructor vacío
    public IngredientesPorProducto() {
    }

    /**
     * Constructor sin ID.
     *
     * @param objetoProducto ID del Producto
     * @param objetoIngrediente ID del Ingrediente
     * @param cantidadPorProducto Cantidad de ingredientes usados en el Producto
     */
    public IngredientesPorProducto(Producto objetoProducto, Ingrediente objetoIngrediente, Integer cantidadPorProducto) {
        this.objetoProducto = objetoProducto;
        this.objetoIngrediente = objetoIngrediente;
        this.cantidadPorProducto = cantidadPorProducto;
    }

    /**
     * Constructor de IngredientesPorProducto
     *
     * @param id ID de IngredientesPorProducto
     * @param objetoProducto ID del Producto
     * @param objetoIngrediente ID del Ingrediente
     * @param cantidadPorProducto Cantidad de ingredientes usados en el Producto
     */
    public IngredientesPorProducto(Long id, Producto objetoProducto, Ingrediente objetoIngrediente, Integer cantidadPorProducto) {
        this.id = id;
        this.objetoProducto = objetoProducto;
        this.objetoIngrediente = objetoIngrediente;
        this.cantidadPorProducto = cantidadPorProducto;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Producto getObjetoProducto() {
        return objetoProducto;
    }

    public void setObjetoProducto(Producto objetoProducto) {
        this.objetoProducto = objetoProducto;
    }

    public Ingrediente getObjetoIngrediente() {
        return objetoIngrediente;
    }

    public void setObjetoIngrediente(Ingrediente objetoIngrediente) {
        this.objetoIngrediente = objetoIngrediente;
    }

    public Integer getCantidadPorProducto() {
        return cantidadPorProducto;
    }

    public void setCantidadPorProducto(Integer cantidadPorProducto) {
        this.cantidadPorProducto = cantidadPorProducto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final IngredientesPorProducto other = (IngredientesPorProducto) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * Manda la información del objeto.
     *
     * @return Información del objeto.
     */
    @Override
    public String toString() {
        return "IngredientesPorProducto{" + "id=" + id + ", objetoProducto=" + objetoProducto + ", objetoIngrediente=" + objetoIngrediente + ", cantidadPorProducto=" + cantidadPorProducto + '}';
    }

}
