/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author Juan Sánchez
 */
public class Producto {

    private int id;
    private String nombre;
    private float precio;
    private List<Ingrediente> ingredientes;

    //Constructor vacío
    public Producto() {
    }

    /**
     * Constructor sin ID.
     *
     * @param nombre Nombre del Producto.
     * @param precio Precio del Producto.
     * @param ingredientes Lista de Ingrediente para el Producto
     */
    public Producto(String nombre, float precio, List<Ingrediente> ingredientes) {
        this.nombre = nombre;
        this.precio = precio;
        this.ingredientes = ingredientes;
    }

    /**
     * Constructor de Producto.
     *
     * @param id ID del Producto.
     * @param nombre Nombre del Producto.
     * @param precio Precio del Producto.
     * @param ingredientes Lista de Ingrediente para el Producto.
     */
    public Producto(int id, String nombre, float precio, List<Ingrediente> ingredientes) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.ingredientes = ingredientes;
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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.id;
        hash = 23 * hash + Objects.hashCode(this.nombre);
        hash = 23 * hash + Float.floatToIntBits(this.precio);
        hash = 23 * hash + Objects.hashCode(this.ingredientes);
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
        final Producto other = (Producto) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Float.floatToIntBits(this.precio) != Float.floatToIntBits(other.precio)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.ingredientes, other.ingredientes);
    }

    /**
     * Manda la información del objeto.
     *
     * @return Información del objeto.
     */
    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", ingredientes=" + ingredientes + '}';
    }

}
