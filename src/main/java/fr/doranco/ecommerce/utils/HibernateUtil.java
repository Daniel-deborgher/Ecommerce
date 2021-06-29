package fr.doranco.ecommerce.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class HibernateUtil {
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			try {
			// On créé un registry
			registry = new StandardServiceRegistryBuilder().configure().build();
			
			// On créé un MetadataSources
			MetadataSources sources = new MetadataSources(registry);
			
			// On créé un Metadata
			Metadata metadata = sources.getMetadataBuilder().build();
			
			// On créé un SessionFactory
			sessionFactory = metadata.getSessionFactoryBuilder().build();
			
			}
			catch (Exception e){
				e.printStackTrace();
				if(registry != null) {
					StandardServiceRegistryBuilder.destroy(registry);
				}
			}
			
		}
		return sessionFactory;
	}
	public static void shutdown() {
		if(registry != null) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

}
