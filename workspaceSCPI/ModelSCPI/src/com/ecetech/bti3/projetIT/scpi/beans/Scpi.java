package com.ecetech.bti3.projetIT.scpi.beans;

import com.mysql.jdbc.StringUtils;

public class Scpi {
	
	private String identifiant;
	private String rue;
	private String cp;
	private String ville;
	private String pays;
	private String type;
	
	public Scpi(String identifiant, String rue, String cp, String ville, String pays, int ascensseur,
			String type) {
		super();
		this.identifiant = identifiant;
		this.rue = rue;
		this.cp = cp;
		this.ville = ville;
		this.pays = pays;
		this.type = type;
	}
	
	

	public Scpi() {
		this ("", "", "", "", "", 0, "");
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
