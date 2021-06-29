package fr.doranco.model.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.query.Query;

import fr.doranco.ecommerce.entity.Utilisateur;


public class UtilisateurDao implements IUtilisateurDao {

	@Override
	public Utilisateur get(Class<Utilisateur> entity, Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Utilisateur entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Utilisateur getUserByEmail(String email) throws Exception {
		Session session = fr.doranco.ecommerce.model.HibernateConnector.getInstance().getSession();
		Query<?> query = session.createNamedQuery("User.findByEmail");
		query.setParameter("email", email);
		Utilisateur user = (Utilisateur) query.getSingleResult();
		return user;
	}

	@Override
	public Map<String, List<Utilisateur>> getUsersByVille() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utilisateur> getUsersOfVille(String ville) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utilisateur> getAll(Class<Utilisateur> entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Utilisateur entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	

}
