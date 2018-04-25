package com.ecetech.bti3.projetIT.scpi.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import com.ecetech.bti3.projetIT.scpi.beans.PartSCPI;
import com.ecetech.bti3.projetIT.scpi.dao.PartDAO;

public class PartDAOTest {

	private PartDAO Part = new PartDAO(); 

	@Test
	public void testGetPartById() throws SQLException {
		PartSCPI b = Part.getPartById(2);
		if (b != null) {
			System.out.println("TestGetPartById : "+ 1);
//			System.out.println("Part : id = 2 -> "+b.toString());
		}
		else System.out.println("TestGetPartById : invalide");
	}
	
	@Test
	public void testGetAllParts() throws SQLException {
		ArrayList<PartSCPI> ar = Part.getAllParts();
		if (ar.size() > 0) {
			System.out.println("Get All Parts : "+ar.size());
		} else {
			System.out.println("GetAllParts : invalide ");
		}
	}
	
	@Test
	public void testGetAllPartsEnVente() throws SQLException {
		ArrayList<PartSCPI> ar = Part.getAllPartsEnVente();
		if (ar.size() > 0) {
			System.out.println("Get All Parts en ventes : "+ar.size());
		} else {
			System.out.println("GetAllPartsEnVentes : invalide");
		}
	}
	
	@Test
	public void testGetAllPartsClasser() throws SQLException {
		ArrayList<PartSCPI> ar = Part.getAllPartsClasseParVente();
		if (ar.size() > 0) {
			System.out.println("Get All Parts classer : "+ar.size());
		} else {
			System.out.println("GetAllPartsClasser : invalide");
		}
	}
	
	@Test
	public void testAddPart() throws SQLException {
		int id = 666;
		String scpi = "gamma";
		double nombre = 12.0;
		double valeur = 12.0;
		int statut = 0;
		int i = Part.addPart(id, scpi, nombre, valeur, statut);
		if (i == 1) {
			System.out.println("Part ajouté : "+i);
		} else {
			System.out.println("Part ajouté : invalide");
		}
	}
	
	@Test
	public void testDeletePartById() throws SQLException {
		int i = Part.deletePartById(666);
		if (i == 1) {
			System.out.println("Delete Part by id : "+i);
		} else {
			System.out.println("Delete Part by id : invalide");
		}
	}
	
	@Test
	public void testUpdatePartById() throws SQLException {
		PartSCPI b = new PartSCPI();
		b.setSCPI("gamma");
		b.setNombre(20.0);
		b.setValeur(21.0);
		b.setStatut(1);
		int i = Part.updatePartById(b, 1);
		if (i == 1) {
			System.out.println("Update by Id : "+i);
		} else {
			System.out.println("Update by Id : invalide");
		}
	}
	
	@Test
	public void testPartVendu() throws SQLException {
		PartSCPI b = new PartSCPI();
		int i = Part.PartVendu(b, 2);
		if (i > 0) {
			System.out.println("Part vendu : "+i);
		} else {
			System.out.println("Part vendu : invalide");
		}
	}
	
	@Test
	public void testPartAVendre() throws SQLException {
		PartSCPI b = new PartSCPI();
		int i = Part.PartAVendre(b, 3);
		if (i > 0) {
			System.out.println("Part à vendre : "+i);
		} else {
			System.out.println("Part à vendre : invalide"+i);
		}
	}

}
