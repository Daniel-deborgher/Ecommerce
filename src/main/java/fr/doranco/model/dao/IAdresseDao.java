package fr.doranco.model.dao;

import java.util.Set;

import fr.doranco.ecommerce.entity.Adresse;

public interface IAdresseDao {
	//CRUD
		Adresse addAdresse(Adresse adresse, Integer idUtilisateur) throws Exception;
		Adresse getAdresse(Integer id) throws Exception;
		void updateAdresse(Adresse adresse) throws Exception;
		void removeAdresse(Integer id) throws Exception;
		
		Set<Adresse> getAdressesUtilisateur(Integer idUtilisateur) throws Exception;
		Set<String> getNomsVillesUtilisateurs() throws Exception;
}
