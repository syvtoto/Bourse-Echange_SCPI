package com.ecetech.bti3.projetIT.scpi.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ecetech.bti3.projetIT.scpi.beans.Client;
import com.ecetech.bti3.projetIT.scpi.common.ConnectionDB;

public class ClientDAO {
		
	/**
	 * R�cup�ration d'un client par son num�ro
	 * @param num
	 * @return
	 * @throws SQLException
	 */
	public static Client getClientByNum (String num) throws SQLException {
		Client clientTmp = new Client();
		//Requete
		String req = "SELECT * FROM client WHERE numero = '"+num+"'";
		ConnectionDB.DBConnexion();
		//R�cup�ration d'un resultat apr�s execution
		ConnectionDB.setRes(ConnectionDB.getStm().executeQuery(req));

		//Assignation des valeurs dans l'ordre
		while (ConnectionDB.getRes().next()) {
			clientTmp.setNumero(ConnectionDB.getRes().getString("numero"));
			clientTmp.setNom(ConnectionDB.getRes().getString("nom"));
			clientTmp.setPrenom(ConnectionDB.getRes().getString("prenom"));
			clientTmp.setTel(ConnectionDB.getRes().getString("tel"));
			clientTmp.setEmail(ConnectionDB.getRes().getString("email"));
			clientTmp.setIdentifiantAdresse(ConnectionDB.getRes().getString("identifiant_adresse"));
			clientTmp.setLogin(ConnectionDB.getRes().getString("login"));

		}

		//Fermeture de la connection
		ConnectionDB.DBClose();
		return clientTmp;
	}

	/**
	 * R�cup�ration de la liste des Clients
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<Client> getClients() throws SQLException {
		Client clientTmp = new Client();
		String req = "SELECT * FROM client";
		ConnectionDB.DBConnexion();
		ConnectionDB.setRes(ConnectionDB.getStm().executeQuery(req));

		ArrayList<Client> clients = new ArrayList<Client>();
		while (ConnectionDB.getRes().next()) {
			clientTmp.setNumero(ConnectionDB.getRes().getString("numero"));
			clientTmp.setNom(ConnectionDB.getRes().getString("nom"));
			clientTmp.setPrenom(ConnectionDB.getRes().getString("prenom"));
			clientTmp.setTel(ConnectionDB.getRes().getString("tel"));
			clientTmp.setEmail(ConnectionDB.getRes().getString("email"));
			clientTmp.setIdentifiantAdresse(ConnectionDB.getRes().getString("identifiant_adresse"));
			clientTmp.setLogin(ConnectionDB.getRes().getString("login"));
		}
		// ajout du client a l'array
		clients.add(clientTmp);
		//Fermeture de la connection
		ConnectionDB.DBClose();
		return clients;
	}

	/**
	 * Supression d'un Client
	 * @param num
	 * @return
	 */
	public static int deleteClientByNum(String num) {
		int result = -1;
		ConnectionDB.DBConnexion();

		String req = "DELETE FROM client WHERE numero = '"+num+"' ";
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
	 * Mise � jour d'un Client
	 * @param client
	 * @param num
	 * @return
	 */
	public static int updateClientByNum(Client client, String num) 
	{
		int result = -1;
		ConnectionDB.DBConnexion();

		String numero = client.getNumero();
		String nom = client.getNom();
		String prenom = client.getPrenom(); 
		String tel = client.getTel(); 
		String email = client.getEmail();
		String identifiantAdresse = client.getIdentifiantAdresse();
		
		
		


		String req = "UPDATE client SET numero = '"+numero+"', nom = '"+nom+"',prenom = '"+prenom+"', "
				+ "tel = '"+tel+"',email= '"+email+"', identifiant_adresse = '"+identifiantAdresse+"' "
				+ "WHERE numero ='"+num+"' ";
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
	 * Ajout d'un client
	 * @param numero
	 * @param nom
	 * @param prenom
	 * @param tel
	 * @param email
	 * @param identifiantAdresse
	 * @return
	 */
	public static int addClient(String numero, String nom, String prenom, String tel, String email, String identifiantAdresse, String login) 
	{
		int result = -1;
		ConnectionDB.DBConnexion();

		String req = "INSERT INTO client (numero, nom, prenom, tel, email, identifiant_adresse, login) "
				+ "VALUES ('"+numero+"','"+nom+"','"+prenom+"','"+tel+"','"+email+"','"+identifiantAdresse+"','"+login+"') ";
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
