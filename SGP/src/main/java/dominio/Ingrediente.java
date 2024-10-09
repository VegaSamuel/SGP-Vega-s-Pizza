
package dominio;

import java.util.Objects;
import util.UnidadMedida;

/**
 *
 * @author Juan Sánchez
 */
public class Ingrediente {

    private int id;
    private String nombre;
    private int cantidad;
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
    public Ingrediente(String nombre, int cantidad, UnidadMedida unidadMedida) {
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
    public Ingrediente(int id, String nombre, int cantidad, UnidadMedida unidadMedida) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.unidadMedida = unidadMedida;
    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
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
        int hash = 5;
        hash = 79 * hash + this.id;
        hash = 79 * hash + Objects.hashCode(this.nombre);
        hash = 79 * hash + this.cantidad;
        hash = 79 * hash + Objects.hashCode(this.unidadMedida);
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
        if (this.id != other.id) {
            return false;
        }
        if (this.cantidad != other.cantidad) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return this.unidadMedida == other.unidadMedida;
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
