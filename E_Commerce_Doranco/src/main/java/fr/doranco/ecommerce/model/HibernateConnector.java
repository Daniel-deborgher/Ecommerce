package fr.doranco.ecommerce.model;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public final class HibernateConnector {

	private static HibernateConnector instance;
	private static SessionFactory sessionFactory;
	
	@SuppressWarnings("deprecation")
	private HibernateConnector() {
		
		if (sessionFactory == null) {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
		
//		Configuration config = new Configuration().configure();
//		StandardServiceRegistryBuilder registry = new StandardServiceRegistryBuilder();
//		registry.applySettings(config.getProperties());
//		ServiceRegistry serviceRegistry = registry.build();
//		sessionFactory = config.buildSessionFactory(serviceRegistry);
	}
	
	public Session getSession() {
		return sessionFactory.openSession();
	}
	
	public static synchronized HibernateConnector getInstance() {
		if (instance == null) {
			instance = new HibernateConnector();
		}
		return instance;
	}
	
	public static void shutdown() throws HibernateException {
		if (sessionFactory != null && ((Session) sessionFactory).isOpen()) {
			sessionFactory.close();
		}
		instance = null;
	}
}
