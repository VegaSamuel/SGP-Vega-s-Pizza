package excepciones;

/**
 *
 * @author Samuel Vega
 */
public class DAOException extends RuntimeException {
    
    public DAOException() {}
    
    public DAOException(String msg) {
        super(msg);
    }
    
    public DAOException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
