package UserManagement.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import UserManagement.models.*;


public class UserDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/gestion_ecommerce";
	private String username = "root";
	private String pw = "";
	
	private static final String Insert_user = "insert into utilisateur" + "(nom, prenom, age, email, mot_de_pass, idrole) values" +
	"(?, ?, ?, ?, ?, ?);";
	
	private static final String Select_all_user = "select * from utilisateur;" ;
	
	private static final String Update_user = " update utilisateur set nom = ?, prenom = ?, age = ?, email = ?, mot_de_pass = ?, idrole = ?"
			+ "where idutilisateur = ?;";
	
	private static final String Delete_user = "delete from utilisateur where idutilisateur = ?;" ;
	
	private static final String Select_user_by_id = "select idutilisateur, nom, prenom, age, email,  mot_de_pass, idrole"
			+ " from utilisateur where idutilisateur = ?; ";
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, username, pw);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public void insertUser(Utilisateurs u) throws SQLException {
	    try (Connection connection = getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(Insert_user)) {

	        preparedStatement.setString(1, u.getNom());
	        preparedStatement.setString(2, u.getPrenom());
	        preparedStatement.setInt(3, u.getAge());
	        preparedStatement.setString(4, u.getEmail());
	        preparedStatement.setString(5, u.getPassword());

	        // Extract idrole from the Role object and set it in the PreparedStatement
	        preparedStatement.setInt(6, u.getRole().getIdRole());

	        preparedStatement.executeUpdate();
	        connection.commit();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public void updateUser(Utilisateurs u) throws SQLException {
	    try (Connection connection = getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(Update_user)) {

	        preparedStatement.setString(1, u.getNom());
	        preparedStatement.setString(2, u.getPrenom());
	        preparedStatement.setInt(3, u.getAge());
	        preparedStatement.setString(4, u.getEmail());
	        preparedStatement.setString(5, u.getPassword());

	        // Extract idrole from the Role object and set it in the PreparedStatement
	        preparedStatement.setInt(6, u.getRole().getIdRole());

	        preparedStatement.executeUpdate();
	        connection.commit();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
//	select user by id 
	
	public Utilisateurs selectUserByID(int id) {
	
		Utilisateurs Utilisateur = null;
		try (Connection connection = getConnection();
		    PreparedStatement preparedStatement = connection.prepareStatement(Select_user_by_id);) {
			
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				int age = rs.getInt("age");
				String email = rs.getString("email");
				String mot_de_pass = rs.getString("mot_de_pass");
				int idrole = rs.getInt("idrole");
				Role role = new Role(idrole);
				Utilisateur = new Utilisateurs(nom, prenom, age, email, mot_de_pass, role);
			}	
		}
		
		catch (Exception e) {
		 
			e.printStackTrace();	
		}
		
		return Utilisateur;	
}
	
	public List <Utilisateurs> selectAllUsers(int id) {
		
		List <Utilisateurs> utilisateurs = new ArrayList<>();
		try (Connection connection = getConnection();
		    PreparedStatement preparedStatement = connection.prepareStatement(Select_all_user);) {
			
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				int age = rs.getInt("age");
				String email = rs.getString("email");
				String mot_de_pass = rs.getString("mot_de_pass");
				int idrole = rs.getInt("idrole");
				Role role = new Role(idrole);
				utilisateurs.add( new Utilisateurs(nom, prenom, age, email, mot_de_pass, role));
			}	
		}
		
		catch (Exception e) {
		 
			e.printStackTrace();	
		}
		
		return utilisateurs;	
}
	
//	Delete user 
	
	public boolean deleteUser(int id) throws SQLException {
		
		boolean rowDeleted;
		try(Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(Delete_user);){
			
			preparedStatement.setInt(1, id);
			rowDeleted = preparedStatement.executeUpdate() > 0;
			
			
		}
		return rowDeleted;
		
	}
	
	
	
	
	
	
	
	
	







}
