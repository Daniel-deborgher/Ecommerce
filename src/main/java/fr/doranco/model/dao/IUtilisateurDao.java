package fr.doranco.model.dao;

import fr.doranco.ecommerce.entity.Utilisateur;

public interface IUtilisateurDao extends IEntityFacade<Utilisateur> {

	Utilisateur getUtilisateurByEmail(String email) throws Exception;

}
