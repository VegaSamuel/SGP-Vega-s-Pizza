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
@Table(name = "direccion")
public class Direccion implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Column(name = "calle", nullable = false, length = 50)
    private String calle;
    
    @Column(name = "colonia", nullable = false, length = 50)
    private String colonia;
    
    @Column(name = "numero_casa", nullable = false, length = 15)
    private String numero;
    
    @Column(name = "codigo_postal", nullable = false)
    private Integer codigoPostal;
    
    @Column(name = "ciudad", nullable = false, length = 50)
    private String ciudad;
    
    @Column(name = "estado", nullable = false, length = 50)
    private String estado;

    // Constructor vacío
    public Direccion() { }

    /**
     * Constructor sin ID
     * @param calle Calle
     * @param colonia Colonia
     * @param numero Número de casa
     * @param codigoPostal Código postal
     * @param ciudad Ciudad
     * @param estado Estado del país
     */
    public Direccion(String calle, String colonia, String numero, int codigoPostal, String ciudad, String estado) {
        this.calle = calle;
        this.colonia = colonia;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
        this.estado = estado;
    }

    /**
     * Constructor de la dirección
     * @param id ID de la dirección
     * @param calle Calle
     * @param colonia Colonia
     * @param numero Número de casa
     * @param codigoPostal Código postal
     * @param ciudad Ciudad
     * @param estado Estado del país 
     */
    public Direccion(Long id, String calle, String colonia, String numero, Integer codigoPostal, String ciudad, String estado) {
        this.id = id;
        this.calle = calle;
        this.colonia = colonia;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
        this.estado = estado;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(Integer codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Direccion other = (Direccion) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * Manda la información del objeto.
     * @return Información del objeto.
     */
    @Override
    public String toString() {
        return calle + ", " + colonia + ", " + numero;
    }

}
