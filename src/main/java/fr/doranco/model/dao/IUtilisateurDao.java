package fr.doranco.model.dao;

import java.util.List;
import java.util.Map;

import fr.doranco.ecommerce.entity.Utilisateur;

public interface IUtilisateurDao extends IEntityFacade<Utilisateur>{

	Utilisateur getUserByEmail(String email) throws Exception;
	Map<String, List<Utilisateur>> getUsersByVille() throws Exception;
	List<Utilisateur> getUsersOfVille(String ville) throws Exception;
}
