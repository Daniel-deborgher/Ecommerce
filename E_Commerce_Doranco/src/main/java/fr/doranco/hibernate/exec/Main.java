package fr.doranco.hibernate.exec;


import org.hibernate.Session;
import org.hibernate.Transaction;



import fr.doranco.ecommerce.entity.Utilisateur;
import fr.doranco.ecommerce.utils.Dates;
import fr.doranco.ecommerce.utils.HibernateUtil;

public class Main {


	public static void main(String[] args) throws Exception {
			Utilisateur	 utilisateur1 = new Utilisateur("Daniel", "D", 
					Dates.convertStringToDateUtil("11/12/1994"), false, 
					"Mr", "d.daniel@gmail.com", "123456789", "0102030405");
			
			Transaction transaction = null;
			Session session = null;
			try {
				session = HibernateUtil.getSessionFactory().openSession()
				transaction = session.beginTransaction();
				session.save(utilisateur1);
				transaction.commit();
			} catch(Exception e) {
				if(transaction != null) {
					transaction.rollback();
				}
				e.printStackTrace();
			} finally {
				if (session 
			}
	}
	

}
