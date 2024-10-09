/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author Juan Sánchez
 */
public class IngredientesPorProducto {

    private int id;
    private int objetoProducto;
    private int objetoIngrediente;
    private int cantidadPorProducto;

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
    public IngredientesPorProducto(int objetoProducto, int objetoIngrediente, int cantidadPorProducto) {
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
    public IngredientesPorProducto(int id, int objetoProducto, int objetoIngrediente, int cantidadPorProducto) {
        this.id = id;
        this.objetoProducto = objetoProducto;
        this.objetoIngrediente = objetoIngrediente;
        this.cantidadPorProducto = cantidadPorProducto;
    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getObjetoProducto() {
        return objetoProducto;
    }

    public void setObjetoProducto(int objetoProducto) {
        this.objetoProducto = objetoProducto;
    }

    public int getObjetoIngrediente() {
        return objetoIngrediente;
    }

    public void setObjetoIngrediente(int objetoIngrediente) {
        this.objetoIngrediente = objetoIngrediente;
    }

    public int getCantidadPorProducto() {
        return cantidadPorProducto;
    }

    public void setCantidadPorProducto(int cantidadPorProducto) {
        this.cantidadPorProducto = cantidadPorProducto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.id;
        hash = 79 * hash + this.objetoProducto;
        hash = 79 * hash + this.objetoIngrediente;
        hash = 79 * hash + this.cantidadPorProducto;
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
        if (this.id != other.id) {
            return false;
        }
        if (this.objetoProducto != other.objetoProducto) {
            return false;
        }
        if (this.objetoIngrediente != other.objetoIngrediente) {
            return false;
        }
        return this.cantidadPorProducto == other.cantidadPorProducto;
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
