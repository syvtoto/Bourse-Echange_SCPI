package com.ecetech.bti3.projetIT.scpi.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import com.ecetech.bti3.projetIT.scpi.beans.Scpi;
import com.ecetech.bti3.projetIT.scpi.dao.ScpiDAO;

public class ScpiDAOTest {

	private ScpiDAO scpi = new ScpiDAO();
	
	@Test
	public void testGetScpiById() throws SQLException {
		Scpi a = scpi.getscpiById("premier");
		if (a != null) {
			System.out.println("Scpi by id : "+ 1);
		}
		else System.out.println("Scpi by id : invalide");
	}
	
	@Test
	public void testGetScpis() throws SQLException {
		ArrayList<Scpi> ar = scpi.getscpis();
		if (ar.size() > 0) {
			System.out.println("Get All Scpis : "+ar.size());
		} else {
			System.out.println("Get All Scpis : invalide ");
		}
	}
	
	@Test
	public void testDeleteScpisById() throws SQLException {
		int i = scpi.deletescpiById("autre");
		if (i == 1) {
			System.out.println("Delete scpi by num : "+i);
		} else {
			System.out.println("Delete scpi by num : invalide");
		}
	}
	
	@Test
	public void testUpdateScpiById() throws SQLException {
		Scpi update = new Scpi();
		update.setRue("un Endroit");
		update.setCp("00001");
		update.setVille("Ville au loin");
		update.setPays("allemagne");
		update.setType("rendement");
		int i = scpi.updatescpiById(update, "update");
		if (i == 1) {
			System.out.println("Update scpi by num : "+i);
		} else {
			System.out.println("Update scpi by num : invalide"+i);
		}
	}
	
	@Test
	public void testAddScpi() throws SQLException {
		String id = "autre";
		String rue = "un autre Endroit";
		String cp = "00002";
		String ville = "Ville au loin au fond";
		String pays = "russie";
		String type = "plus-value";
		int i = scpi.addscpi(id, rue, cp, ville, pays, type);
		if (i == 1) {
			System.out.println("Scpi ajouté : "+i);
		} else {
			System.out.println("Scpi ajouté : invalide");
		}
	}
	

}
