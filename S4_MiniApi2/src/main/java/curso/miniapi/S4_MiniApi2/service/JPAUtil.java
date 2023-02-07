package curso.miniapi.S4_MiniApi2.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
	private static final String PERSISTENCE_UNIT_NAME = "PERSISTENCE";
	private static EntityManagerFactory factory;

	public static EntityManagerFactory getEntityManagerFactory() {
		if (factory==null) {
			factory=Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}
		EntityManager manager = factory.createEntityManager();
		return factory;				
	}
	
	public static EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager manager = factory.createEntityManager();
        return manager;
    }
	
	public static void shutdown() {
		if (factory!=null) {
			factory.close();
		}		
	}
}
