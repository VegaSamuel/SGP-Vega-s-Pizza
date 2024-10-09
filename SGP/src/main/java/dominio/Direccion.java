package dominio;

/**
 *
 * @author Samuel Vega
 */
public class Direccion {
    private int id;
    private String calle;
    private String colonia;
    private String numero;
    private int codigoPostal;
    private String ciudad;
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
    public Direccion(int id, String calle, String colonia, String numero, int codigoPostal, String ciudad, String estado) {
        this.id = id;
        this.calle = calle;
        this.colonia = colonia;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
        this.estado = estado;
    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public void setCodigoPostal(int codigoPostal) {
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
        int hash = 5;
        hash = 67 * hash + this.id;
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
        return this.id == other.id;
    }

    /**
     * Manda la información del objeto.
     * @return Información del objeto.
     */
    @Override
    public String toString() {
        return "Direccion{" + "id=" + id + ", calle=" + calle + ", colonia=" + colonia + ", numero=" + numero + ", codigoPostal=" + codigoPostal + ", ciudad=" + ciudad + ", estado=" + estado + '}';
    }

}
