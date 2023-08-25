package registration;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public RegistrationServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		PrintWriter out = response.getWriter();
//		out.print("working...");
		int defaultRoleId = 2;
		String nom = request.getParameter("name");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String mot_de_pass = request.getParameter("pass");
//		String age = request.getParameter("age");
		String ageParam = request.getParameter("age");
		int age = Integer.parseInt(ageParam);
		RequestDispatcher dispatcher = null;
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_ecommerce", "root", "");
			PreparedStatement pst = con.prepareStatement("insert into utilisateur(nom, prenom, age, email, mot_de_pass, idrole) values(?, ?, ?, ?, ?, ?)");
			pst.setString(1, nom);
			pst.setString(2, prenom);
			pst.setInt(3, age);
			pst.setString(4, email);
			pst.setString(5, mot_de_pass);
			pst.setInt(6, defaultRoleId);
			
			int rowCount = pst.executeUpdate();
			dispatcher = request.getRequestDispatcher("registration.jsp");
			
			if(rowCount > 0) {
				
				request.setAttribute("status", "success");
				
			}else {
				request.setAttribute("status", "failed");
			}
			
			dispatcher.forward(request, response);
			
		} catch (Exception e){
			
			e.printStackTrace();
		}finally {
	
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
	}

}
