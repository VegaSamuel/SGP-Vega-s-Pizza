package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Esta clase crea la conexión con la base de datos y regresa el entity manager.
 * @author Samuel Vega
 */
public class DBConector {
    private static final EntityManagerFactory emf =  Persistence.createEntityManagerFactory("sgpvegas");
    
    public EntityManager getEM() {
        return emf.createEntityManager();
    }
    
    public static void close() {
        if(emf != null) {
            emf.close();
        }
    }
}
