package fr.doranco.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.query.Query;

import fr.doranco.ecommerce.entity.Adresse;
import fr.doranco.ecommerce.entity.Utilisateur;

import fr.doranco.ecommerce.model.EcommerceDataSource;
import fr.doranco.ecommerce.model.HibernateConnector;
import fr.doranco.ecommerce.utils.Dates;



public class UtilisateurDao extends AbstractEntityFacade<Utilisateur> implements IUtilisateurDao {

	IAdresseDao adresseDao = new AdresseDao();
	
	@Override
	public Utilisateur getUtilisateurByEmail(String email) throws Exception {
		
		Session session = HibernateConnector.getInstance().getSession();
		Query<?> query = session.createQuery("SELECT u FROM Utilisateur u WHERE u.email =: email");
		query.setParameter("email", email);
		Utilisateur user = (Utilisateur) query.getSingleResult();
		
		if (session != null && session.isOpen()) {
			session.close();
		}
		return user;

	}

}