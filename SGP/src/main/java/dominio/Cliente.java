package dominio;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Samuel Vega
 */
@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Column(name = "nombres", nullable = false, length = 100)
    private String nombres;
    
    @Column(name = "apellido_paterno", nullable = false, length = 50)
    private String apellidoPaterno;
    
    @Column(name = "apellido_materno", nullable = false, length = 50)
    private String apellidoMaterno;
    
    @Column(name = "direccion", nullable = false)
    private String direccion;
    
    @Column(name = "telefono", unique = true, nullable = false, length = 15)
    private String telefono;

    // Constructor vacío
    public Cliente() {
    }

    /**
     * Constructor sin ID
     *
     * @param nombres Nombres del cliente
     * @param apellidoPaterno Apellido paterno del cliente
     * @param apellidoMaterno Apellido materno del cliente
     * @param direccion Dirección del cliente
     * @param telefono Número de teléfono del cliente
     */
    public Cliente(String nombres, String apellidoPaterno, String apellidoMaterno, String direccion, String telefono) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    /**
     * Constructor del cliente
     *
     * @param id ID del cliente
     * @param nombres Nombres del cliente
     * @param apellidoPaterno Apellido paterno del cliente
     * @param apellidoMaterno Apellido materno del cliente
     * @param direccion Dirección del cliente
     * @param telefono Número de teléfono del cliente
     */
    public Cliente(Long id, String nombres, String apellidoPaterno, String apellidoMaterno, String direccion, String telefono) {
        this.id = id;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Cliente other = (Cliente) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * Manda la información del objeto.
     *
     * @return Información del objeto.
     */
    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombres=" + nombres + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", telefono=" + telefono + '}';
    }

}
