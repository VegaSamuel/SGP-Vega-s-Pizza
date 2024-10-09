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
public class Promocion extends Producto {

    private String descripcion;

    /**
     * Constructor con ID, sin descripción.
     *
     * @param id ID de la promoción.
     * @param nombre Nombre de la promoción.
     * @param precio Precio de la promoción.
     * @param ingredientes Lista de Ingrediente para la promoción.
     */
    public Promocion(int id, String nombre, float precio, List<Ingrediente> ingredientes) {
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
    public Promocion(String descripcion, int id, String nombre, float precio, List<Ingrediente> ingredientes) {
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
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.descripcion);
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
