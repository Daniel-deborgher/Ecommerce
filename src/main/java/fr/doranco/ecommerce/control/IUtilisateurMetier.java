package fr.doranco.ecommerce.control;

import java.util.List;

import fr.doranco.ecommerce.entity.Utilisateur;

public interface IUtilisateurMetier {

	//CRUD
	Utilisateur addUtilisateur(Utilisateur utilisateur) throws Exception;
	Utilisateur getUtilisateurById(Integer id) throws Exception;
	Utilisateur getUtilisateurByEmail(String email) throws Exception;
	void updateUtilisateur(Utilisateur utilisateur) throws Exception;
	void removeUtilisateur(Integer id) throws Exception;
	
	List<Utilisateur> getUtilisateurs() throws Exception;
	List<Utilisateur> getUtilisateursByVille(String ville) throws Exception;

}
