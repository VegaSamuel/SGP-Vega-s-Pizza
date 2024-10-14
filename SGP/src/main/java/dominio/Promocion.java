package dominio;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Juan Sánchez
 */
@Entity
@Table(name = "promociones")
public class Promocion extends Producto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    // Constructor vacío
    public Promocion() {}

    /**
     * Constructor con ID, sin descripción.
     *
     * @param id ID de la promoción.
     * @param nombre Nombre de la promoción.
     * @param precio Precio de la promoción.
     * @param ingredientes Lista de Ingrediente para la promoción.
     */
    public Promocion(Long id, String nombre, float precio, List<Ingrediente> ingredientes) {
        super(id, nombre, precio, ingredientes);
    }

    /**
     * Constructor con ID, con descripción.
     *
     * @param descripcion Descripción de la promoción.
     * @param id ID de la promoción.
     * @param nombre Nombre de la promoción.
     * @param precio Precio de la promoción.
     * @param ingredientes Lista de Ingrediente para la promoción.
     */
    public Promocion(String descripcion, Long id, String nombre, float precio, List<Ingrediente> ingredientes) {
        super(id, nombre, precio, ingredientes);
        this.descripcion = descripcion;
    }

    // Getters & Setters
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.descripcion);
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
        final Promocion other = (Promocion) obj;
        return Objects.equals(this.descripcion, other.descripcion);
    }

    /**
     * Manda la información del objeto.
     *
     * @return Información del objeto.
     */
    @Override
    public String toString() {
        return "Promocion{" + "descripcion=" + descripcion + '}';
    }

}
