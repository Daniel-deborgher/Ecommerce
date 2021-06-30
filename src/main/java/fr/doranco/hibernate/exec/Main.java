package fr.doranco.hibernate.exec;

import org.hibernate.Session;

import fr.doranco.ecommerce.entity.Adresse;
import fr.doranco.ecommerce.entity.Utilisateur;
import fr.doranco.ecommerce.utils.Dates;
import fr.doranco.model.dao.IUtilisateurDao;
import fr.doranco.model.dao.UtilisateurDao;


public class Main {


	public static void main(String[] args) throws Exception {
		IUtilisateurDao userDao = new UtilisateurDao();
		Session session = null;
		try {
			session = fr.doranco.ecommerce.model.HibernateConnector.getInstance().getSession();
			System.out.println(session);
			
			Adresse adresse1 = new Adresse(12, "Rue Lafayette", "Paris", "75000");

			Utilisateur user = new Utilisateur("HUGO", "Victor", Dates.convertStringToDateUtil("18/06/1940"), true, "Mr", "daniel.deb@deb.fr", "12034", "0102030405");
			adresse1.setUtilisateur(user);// Ne pas oublier pour récupérer l'Id
			user.getAdresses().add(adresse1);
			
			
			userDao.add(user);
			
//			System.out.println(userDao.getAll(Utilisateur.class));
//			System.out.println("====================================");

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
	

}
