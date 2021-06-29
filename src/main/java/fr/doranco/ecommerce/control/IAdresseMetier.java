package fr.doranco.ecommerce.control;

import java.util.Set;

import fr.doranco.ecommerce.entity.Adresse;

public interface IAdresseMetier {

	//CRUD
	Adresse addAdresse(Adresse adresse, Integer idUtilisateur) throws Exception;
	Adresse getAdresse(Integer id) throws Exception;
	void updateAdresse(Adresse adresse) throws Exception;
	void removeAdresse(Integer id) throws Exception;
	
	Set<Adresse> getAdressesUtilisateur(Integer idUtilisateur) throws Exception;

}
