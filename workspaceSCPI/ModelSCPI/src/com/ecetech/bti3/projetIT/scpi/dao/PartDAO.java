package com.ecetech.bti3.projetIT.scpi.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ecetech.bti3.projetIT.scpi.beans.PartSCPI;
import com.ecetech.bti3.projetIT.scpi.common.ConnectionDB;

public class PartDAO {
	
	/**
	 * Récupération d'un Part par son id
	 * @param num
	 * @return
	 * @throws SQLException
	 */
	public static PartSCPI getPartById(int id) throws SQLException {
		PartSCPI PartTmp = null;
		//Requete
		String req = "SELECT * FROM part WHERE id = '"+id+"'";
		ConnectionDB.DBConnexion();
		//Récupération d'un resultat après execution
		ConnectionDB.setRes(ConnectionDB.getStm().executeQuery(req));

		//Assignation des valeurs dans l'ordre
		while (ConnectionDB.getRes().next()) {
			PartTmp = new PartSCPI();
			PartTmp.setId(ConnectionDB.getRes().getInt("id"));
			PartTmp.setSCPI(ConnectionDB.getRes().getString("SCPI"));
			PartTmp.setNombre(ConnectionDB.getRes().getDouble("nombre"));
			PartTmp.setValeur(ConnectionDB.getRes().getDouble("valeur"));
			PartTmp.setStatut(ConnectionDB.getRes().getInt("statut"));
			PartTmp.setCompte(ConnectionDB.getRes().getString("compte"));
		}
		//Fermeture de la connection
		ConnectionDB.DBClose();
		return PartTmp;
	}

	/**
	 * Récupération de la liste des Parts
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<PartSCPI> getAllParts() throws SQLException {
		
		String req = "SELECT * FROM Part";
		ConnectionDB.DBConnexion();
		ConnectionDB.setRes(ConnectionDB.getStm().executeQuery(req));
		ArrayList<PartSCPI> Parts = new ArrayList<PartSCPI>(ConnectionDB.getRes().getFetchSize());
		while (ConnectionDB.getRes().next()) {	
			PartSCPI PartTmp = new PartSCPI();
			PartTmp.setId(ConnectionDB.getRes().getInt("id"));
			PartTmp.setSCPI(ConnectionDB.getRes().getString("SCPI"));
			PartTmp.setNombre(ConnectionDB.getRes().getDouble("nombre"));
			PartTmp.setValeur(ConnectionDB.getRes().getDouble("valeur"));
			PartTmp.setStatut(ConnectionDB.getRes().getInt("statut"));
			PartTmp.setCompte(ConnectionDB.getRes().getString("compte"));
			Parts.add(PartTmp);
		}
//		for(int i=0; i<Parts.size(); i++)
//		{
//			System.out.println("Parts["+i+"] : "+Parts.get(i).toString());
//		}
		//Fermeture de la connection
		ConnectionDB.DBClose();
		return Parts;
	}
	
	/**
	 * Récupération de la liste des Parts en vente
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<PartSCPI> getAllPartsEnVente() throws SQLException {
		PartSCPI PartTmp = null;
		String req = "SELECT * FROM Part WHERE statut = 1";
		ConnectionDB.DBConnexion();
		ConnectionDB.setRes(ConnectionDB.getStm().executeQuery(req));

		ArrayList<PartSCPI> PartsVentes = new ArrayList<PartSCPI>();
		while (ConnectionDB.getRes().next()) {
			PartTmp = new PartSCPI();
			PartTmp.setId(ConnectionDB.getRes().getInt("id"));
			PartTmp.setSCPI(ConnectionDB.getRes().getString("SCPI"));
			PartTmp.setNombre(ConnectionDB.getRes().getDouble("nombre"));
			PartTmp.setValeur(ConnectionDB.getRes().getDouble("valeur"));
			PartTmp.setStatut(ConnectionDB.getRes().getInt("statut"));
			PartTmp.setCompte(ConnectionDB.getRes().getString("compte"));
			PartsVentes.add(PartTmp);
		}
//		for(int i=0; i<PartsVentes.size(); i++)
//		{
//			System.out.println("PartsVentes["+i+"] : "+PartsVentes.get(i).toString());
//		}
		//Fermeture de la connection
		ConnectionDB.DBClose();
		return PartsVentes;
	}
	
	/**
	 * Récupération de la liste des Parts ordonner par statut
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<PartSCPI> getAllPartsClasseParVente() throws SQLException {
		PartSCPI PartTmp = null;
		String req = "SELECT * FROM Part ORDER BY statut";
		ConnectionDB.DBConnexion();
		ConnectionDB.setRes(ConnectionDB.getStm().executeQuery(req));

		ArrayList<PartSCPI> PartsVentes = new ArrayList<PartSCPI>();
		while (ConnectionDB.getRes().next()) {
			PartTmp = new PartSCPI();
			PartTmp.setId(ConnectionDB.getRes().getInt("id"));
			PartTmp.setSCPI(ConnectionDB.getRes().getString("SCPI"));
			PartTmp.setNombre(ConnectionDB.getRes().getDouble("nombre"));
			PartTmp.setValeur(ConnectionDB.getRes().getDouble("valeur"));
			PartTmp.setStatut(ConnectionDB.getRes().getInt("statut"));
			PartTmp.setCompte(ConnectionDB.getRes().getString("compte"));
			PartsVentes.add(PartTmp);
		}
//		for(int i=0; i<PartsVentes.size(); i++)
//		{
//			System.out.println("PartsVentes["+i+"] : "+PartsVentes.get(i).toString());
//		}
		//Fermeture de la connection
		ConnectionDB.DBClose();
		return PartsVentes;
	}

	/**
	 * Supression d'un Part
	 * @param num
	 * @return
	 */
	public static int deletePartById(int id) {
		int result = -1;
		ConnectionDB.DBConnexion();

		String req = "DELETE FROM Part WHERE id = '"+id+"'";
		try {
			result = ConnectionDB.getStm().executeUpdate(req);	
		} catch (SQLException ex)
		{
			result = - ex.getErrorCode();
			System.out.println(ex.getMessage());

		}
		ConnectionDB.DBClose();
		return result;
	}

	/**
	 * Mise à jour d'un Part
	 * @param Part
	 * @param num
	 * @return
	 */
	public static int updatePartById(PartSCPI Part, int id) 
	{
		int result = -1;
		ConnectionDB.DBConnexion();


		String scpi = Part.getSCPI();
		double nombre = Part.getNombre();
		double valeur = Part.getValeur();
		int statut = Part.getStatut();

		String req = "UPDATE Part SET SCPI = '"+scpi+"', nombre = '"+nombre+"',valeur = '"+valeur+"', "
				+ "statut = '"+statut+"' "+ "WHERE id ='"+id+"' ";
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
	 * Mise à jour du statut d'un Part (vendu
	 * @param Part
	 * @param num
	 * @return
	 */
	public static int PartVendu(PartSCPI Part, int id) 
	{
		int result = -1;
		ConnectionDB.DBConnexion();

		int statut = 0;

		String req = "UPDATE Part SET statut = '"+statut+"' WHERE id = '"+id+"'";
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
	 * Mise à jour du statut d'un Part (mise en vente)	
	 * @param Part
	 * @param num
	 * @return
	 */
	public static int PartAVendre(PartSCPI Part, int id) 
	{
		int result = -1;
		ConnectionDB.DBConnexion();

		int statut = 1;

		String req = "UPDATE Part SET statut = '"+statut+"' WHERE id = '"+id+"'";
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
	 * Ajout d'un Part
	 * @param scpi
	 * @param nombre
	 * @param valeur
	 * @param statut
	 * @return
	 */
	public static int addPart(int id, String scpi, Double nombre, Double valeur, int statut) 
	{
		int result = -1;
		ConnectionDB.DBConnexion();

		String req = "INSERT INTO Part (id, SCPI, nombre, valeur, statut) "
				+ "VALUES ('"+id+"','"+scpi+"','"+nombre+"','"+valeur+"','"+statut+"') ";
		try {
			result = ConnectionDB.getStm().executeUpdate(req);
		} catch (SQLException ex)
		{
			result = - ex.getErrorCode();
			System.out.println(ex.getMessage());
		}//System.out.println("["+req+"] Valeur de result == "+result);
		ConnectionDB.DBClose();
		return result;
	}

}
