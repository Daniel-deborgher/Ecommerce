package fr.doranco.model.dao;

import java.util.Set;

import fr.doranco.ecommerce.entity.Adresse;

public interface IAdresseDao {
	Set<Adresse> getAdressesUtilisateur(Integer idUtilisateur) throws Exception;

}
