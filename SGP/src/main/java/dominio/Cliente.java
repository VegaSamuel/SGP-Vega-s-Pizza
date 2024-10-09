package dominio;

/**
 *
 * @author Samuel Vega
 */
public class Cliente {
    private int id;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    //private Direccion direccion;
    private String telefono;

    // Constructor vacío
    public Cliente() { }

    /**
     * Constructor sin ID
     * @param nombres Nombres del cliente
     * @param apellidoPaterno Apellido paterno del cliente
     * @param apellidoMaterno Apellido materno del cliente
     * @param telefono Número de teléfono del cliente
     */
    public Cliente(String nombres, String apellidoPaterno, String apellidoMaterno, String telefono) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.telefono = telefono;
    }

    /**
     * Constructor del cliente
     * @param id ID del cliente
     * @param nombres Nombres del cliente
     * @param apellidoPaterno Apellido paterno del cliente
     * @param apellidoMaterno Apellido materno del cliente
     * @param telefono Número de teléfono del cliente
     */
    public Cliente(int id, String nombres, String apellidoPaterno, String apellidoMaterno, String telefono) {
        this.id = id;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.telefono = telefono;
    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + this.id;
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
        return this.id == other.id;
    }

    /**
     * Manda la información del objeto.
     * @return Información del objeto.
     */
    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombres=" + nombres + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", telefono=" + telefono + '}';
    }

}
