package registration;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class Login
 */

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public Login() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = request.getParameter("email");
		String mot_de_pass = request.getParameter("mot_de_pass");
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_ecommerce", "root", "");
			
			PreparedStatement pst = con.prepareStatement("select * from utilisateur where email = ? and mot_de_pass = ? ") ;
//			PreparedStatement pst2 = con.prepareStatement("select idrole from utilisateur where idrole = 1 ") ;
			
			pst.setString(1, email);
			pst.setString(2, mot_de_pass);
			
			ResultSet rs = pst.executeQuery();	
			if(rs.next()) {
				session.setAttribute("name", rs.getString("nom"));
				  int roleId = rs.getInt("idrole");
			        if (roleId == 1) {
			            // if it is admin user:
			            dispatcher = request.getRequestDispatcher("adminPage.jsp");
			        } else {
			            // if it was client user:
			            dispatcher = request.getRequestDispatcher("index.jsp");
			        }
//				dispatcher = request.getRequestDispatcher("index.jsp");
			}else {
				
				request.setAttribute("status", "failed");
				dispatcher = request.getRequestDispatcher("login.jsp");	
			}
			
			dispatcher.forward(request, response);
			
		} catch (Exception e){
			
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
	}

}
