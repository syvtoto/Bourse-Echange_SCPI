package com.ecetech.bti3.projetIT.scpi.control;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecetech.bti3.projetIT.scpi.dao.*;
import com.ecetech.bti3.projetIT.scpi.beans.*;

/**
 * Servlet implementation class ControleurPrincipal
 */
@WebServlet("/controleur")
public class ControleurPrincipal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControleurPrincipal() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			processRequest(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			processRequest(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String forward = "index.jsp";
		HttpSession session = request.getSession();
		if(request.getParameter("action") != null)
		{
			String action = request.getParameter("action");
			switch(action)
			{
			case "auth" : // test de connection
				forward = authentifier(request);
				break;
			case "listParts" :
				ArrayList<PartSCPI> allParts = PartDAO.getAllParts();
				request.setAttribute("parts", allParts);
				forward = "admin/pages/gerer_mes_parts.jsp";
				break;
			case "dashboard" :
				ArrayList<PartSCPI> PartsPoss = PartDAO.getPartByCompte((String) session.getAttribute("nom"));
				request.setAttribute("partsPoss", PartsPoss);
				ArrayList<PartSCPI> PartsVentes = PartDAO.getAllPartsEnVente();
				request.setAttribute("partsVente", PartsVentes);
				forward = "admin/pages/dashboard.jsp";
				break;
			case "partsEnVente" :
				ArrayList<PartSCPI> PartsEnVentes = PartDAO.getAllPartsEnVente();
				request.setAttribute("parts", PartsEnVentes);
				forward = "admin/pages/parts_en_vente.jsp";
				break;
			case "index" :
				forward = "index.jsp";
				break;
			case "login" :
				forward = "login.jsp";
				break;
			case "encherir" :
				forward = "admin/pages/encherir.jsp";
				break;
			case "detail" :
//				forward = "admin/pages/details_parts.jsp";
				break;
			case "profil" :
				Client client = ClientDAO.getClientByLogin((String) session.getAttribute("nom"));
				System.out.println(client.toString());
				request.setAttribute("client", client);
				forward = "admin/pages/mon_profil.jsp";
				break;
			default : 
				forward="index.jsp";
				break;
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
        dispatcher.forward(request, response);
	}
	
	private String authentifier(HttpServletRequest request) {
        String forward = "login.jsp";
        String login = request.getParameter("lg_username");
		String pass = request.getParameter("lg_password");
		CompteUtilisateurDAO c = new CompteUtilisateurDAO();
		CompteUtilisateur nUser = null;
		try {
			nUser = c.getCompteByLogin(login, pass);
//			System.out.println(nUser.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		if(nUser != null)
//		{
	        if (!(nUser.getLogin().isEmpty())) {
	            forward = "controleur?action=dashboard";
//	            System.out.println("Bravo tu es connecté");
	            HttpSession session = request.getSession();
	            session.setAttribute("nom", nUser.getLogin());
	//            if (nUser.isAdmin()) {  // methode à définir
	//                session.setAttribute("role", "admin");
	//            } else {
	//                session.setAttribute("role", "user");
	//            }
	        } else {
	//            forward = "Error.jsp";
	        	forward = "index.jsp";
	        	System.out.println("Couple login/password incorrect");
	   //         request.setAttribute("erreur", ressource.getString("auth.erreur"));
	        }
//		}
        return forward;
    }

}
