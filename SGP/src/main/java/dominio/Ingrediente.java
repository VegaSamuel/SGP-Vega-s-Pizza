package dominio;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import util.enums.UnidadMedida;

/**
 *
 * @author Juan Sánchez
 */
@Entity
@Table(name = "ingredientes")
public class Ingrediente implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "unidad_medida", nullable = false)
    private UnidadMedida unidadMedida;

    //Constructor vacío
    public Ingrediente() {
    }

    /**
     * Constructor sin ID.
     *
     * @param nombre Nombre del ingrediente.
     * @param cantidad Cantidad del ingrediente.
     * @param unidadMedida Unidad de medida del ingrediente.
     */
    public Ingrediente(String nombre, Integer cantidad, UnidadMedida unidadMedida) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.unidadMedida = unidadMedida;
    }

    /**
     * Constructor de Ingrediente
     *
     * @param id ID del ingrediente.
     * @param nombre Nombre del ingrediente.
     * @param cantidad Cantidad del ingrediente.
     * @param unidadMedida Unidad de medida del ingrediente.
     */
    public Ingrediente(Long id, String nombre, Integer cantidad, UnidadMedida unidadMedida) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.unidadMedida = unidadMedida;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.cantidad);
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
        final Ingrediente other = (Ingrediente) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.cantidad, other.cantidad);
    }


    /**
     * Manda la información del objeto.
     *
     * @return Información del objeto.
     */
    @Override
    public String toString() {
        return "Ingrediente{" + "id=" + id + ", nombre=" + nombre + ", cantidad=" + cantidad + ", unidadMedida=" + unidadMedida + '}';
    }

}
