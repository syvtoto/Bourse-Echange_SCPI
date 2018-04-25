package com.ecetech.bti3.projetIT.scpi.beans;

import com.mysql.jdbc.StringUtils;

public class Adresse {
	
	private String identifiant;
	private String rue;
	private String cp;
	private String ville;
	private String pays;
	private int ascensseur;
	private int etage;
	
	public Adresse(String identifiant, String rue, String cp, String ville, String pays, int ascensseur,
			int etage) {
		super();
		this.identifiant = identifiant;
		this.rue = rue;
		this.cp = cp;
		this.ville = ville;
		this.pays = pays;
		this.ascensseur = ascensseur;
		this.etage = etage;
	}
	
	

	public Adresse() {
		this ("", "", "", "", "", 0, 0);
	}



	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public int getAscensseur() {
		return ascensseur;
	}

	public void setAscensseur(int ascensseur) {
		this.ascensseur = ascensseur;
	}

	public int getEtage() {
		return etage;
	}

	public void setEtage(int etage) {
		this.etage = etage;
	}
}
