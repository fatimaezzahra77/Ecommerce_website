package UserManagement.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import UserManagement.DAO.*;
import UserManagement.models.*;

@WebServlet("/insert")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        this.userDAO = new UserDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath() ;
		
		switch(action) {
		case "/insert" :
				insertuser(request, response);
			break;	
		}
	}

	private void insertuser(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
	    
	    String name = request.getParameter("nom");
	    String prenom = request.getParameter("prenom");
	    String ageint = request.getParameter("age");
	    int age = Integer.parseInt(ageint);
	    String email = request.getParameter("email");
	    String mot_de_pass = request.getParameter("mot_de_pass");
	    String idroleStr = request.getParameter("idrole");
	    
	    try {
	    	int idrole = Integer.parseInt(idroleStr);
	    	Role role = new Role(idrole);

	        Utilisateurs newUtilisateur = new Utilisateurs(name, prenom, age, email, mot_de_pass, role);
	        
	        UserDAO userDAO = new UserDAO();
	        userDAO.insertUser(newUtilisateur);
	        
	        response.getWriter().println("success idrole");
	    } 
	    catch (NumberFormatException e) {
	        response.getWriter().println("Invalid idrole");
	    } 
	    catch (SQLException e) {
	    	e.printStackTrace();
	        response.getWriter().println("Error inserting user");
	    }
	}

	
}



	
	
	
	

