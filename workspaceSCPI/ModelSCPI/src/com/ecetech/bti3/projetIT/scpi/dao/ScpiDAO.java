package com.ecetech.bti3.projetIT.scpi.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ecetech.bti3.projetIT.scpi.beans.Scpi;
import com.ecetech.bti3.projetIT.scpi.common.ConnectionDB;

public class ScpiDAO {

	/**
	 * Recuperation d'une scpi par son id
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public static Scpi getscpiById (String id) throws SQLException {
		Scpi scpiTmp = new Scpi();
		//Requete
		String req = "SELECT * FROM scpi WHERE identifiant = '"+id+"'";
		ConnectionDB.DBConnexion();
		//Récupération d'un resultat après execution
		ConnectionDB.setRes(ConnectionDB.getStm().executeQuery(req));

		//Assignation des valeurs dans l'ordre
		while (ConnectionDB.getRes().next()) {
			scpiTmp.setIdentifiant(ConnectionDB.getRes().getString("identifiant"));
			scpiTmp.setRue(ConnectionDB.getRes().getString("rue"));
			scpiTmp.setCp(ConnectionDB.getRes().getString("cp"));
			scpiTmp.setVille(ConnectionDB.getRes().getString("ville"));
			scpiTmp.setPays(ConnectionDB.getRes().getString("pays"));
			scpiTmp.setType(ConnectionDB.getRes().getString("type"));
		}

		//Fermeture de la connection
		ConnectionDB.DBClose();
		return scpiTmp;
	}

	/**
	 * Retourne toute les scpis disponibles
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<Scpi> getscpis() throws SQLException {
		Scpi scpiTmp = new Scpi();
		String req = "SELECT * FROM scpi";
		ConnectionDB.DBConnexion();
		ConnectionDB.setRes(ConnectionDB.getStm().executeQuery(req));

		ArrayList<Scpi> scpis = new ArrayList<Scpi>();
		while (ConnectionDB.getRes().next()) {
			scpiTmp.setIdentifiant(ConnectionDB.getRes().getString("identifiant"));
			scpiTmp.setRue(ConnectionDB.getRes().getString("rue"));
			scpiTmp.setCp(ConnectionDB.getRes().getString("cp"));
			scpiTmp.setVille(ConnectionDB.getRes().getString("ville"));
			scpiTmp.setPays(ConnectionDB.getRes().getString("pays"));
			scpiTmp.setType(ConnectionDB.getRes().getString("type"));
			scpis.add(scpiTmp);
		}
		//Fermeture de la connection
		ConnectionDB.DBClose();
		return scpis;
		
	}

	/**
	 * Delete scpi par un id
	 * @param id
	 * @return : 1 ou 0  (le nbr d'scpi supprimées) sinon le (-) code d'erreur  
	 */
	public static int deletescpiById(String id) {
		int result = -1;
		ConnectionDB.DBConnexion();

		String req = "DELETE FROM scpi WHERE identifiant = '"+id+"' ";
		try {
			result = ConnectionDB.getStm().executeUpdate(req);	
		} catch (SQLException ex)
		{
			result = - ex.getErrorCode();
			System.out.println(ex.getMessage());

		}
		//System.out.println("["+req+"] Suppression : Valeur de result == "+result);
		ConnectionDB.DBClose();
		return result;
	}

	/**
	 * Mise à jour d'une scpi par l'identifiant
	 * @param adr
	 * @param id
	 * @return
	 */
	public static int updatescpiById(Scpi scpi, String id) 
	{
		int result = -1;
		ConnectionDB.DBConnexion();

		String rue = scpi.getRue();
		String cp = scpi.getCp();
		String ville = scpi.getVille();
		String pays = scpi.getPays();
		String type = scpi.getType();


		String req = "UPDATE scpi SET rue = '"+rue+"', cp = '"+cp+"', ville = '"+ville+"', "
				+ "pays = '"+pays+"', type = '"+type+"' "
				+ "WHERE identifiant ='"+id+"' ";
		try {
			result = ConnectionDB.getStm().executeUpdate(req);
		} catch (SQLException ex)
		{
			result = - ex.getErrorCode();
		}
		ConnectionDB.DBClose();
		return result;
	}

	/**
	 * Ajout d'une scpi
	 * @param identifiant
	 * @param rue
	 * @param cp
	 * @param ville
	 * @param pays
	 * @param ascenseur
	 * @param etage
	 * @return
	 */
	public static int addscpi(String identifiant, String rue, String cp, String ville, String pays, String type) 
	{
		int result = -1;
		ConnectionDB.DBConnexion();

		String req = "INSERT INTO scpi (identifiant, rue, cp, ville, pays, type) "
				+ "VALUES ('"+identifiant+"','"+rue+"',"+cp+",'"+ville+"','"+pays+"','"+type+"') ";
		try {
			result = ConnectionDB.getStm().executeUpdate(req);
		} catch (SQLException ex)
		{
			result = - ex.getErrorCode();
			System.out.println(ex.getMessage());
		}//System.out.println("["+req+"] Valeur de result == "+result);
		//DBAction.DBClose();
		return result;
	}


}
