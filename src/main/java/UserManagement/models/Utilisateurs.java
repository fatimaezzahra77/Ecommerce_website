package UserManagement.models;

public class Utilisateurs {
	
	private int idUtilisateurs;
	private String nom;
	private String prenom;
	private int age;
	private String email;
	private String password;
    private Role role;
	
	public Utilisateurs(int idUtilisateurs, String nom, String prenom, int age, String email , String password, Role role) {
		this.idUtilisateurs = idUtilisateurs;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.email = email;
		this.password = password;
		this.role = role;
	}
    
	public Utilisateurs( String nom, String prenom, int age, String email, String password, Role role) {
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	public int getIdUtilisateurs() {
		return idUtilisateurs;
	}
	
	public void setIdUtilisateurs(int idUtilisateurs) {
		this.idUtilisateurs = idUtilisateurs;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	

	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
	@Override
	public String toString() {
		return "Utilisateurs [idUtilisateurs=" + idUtilisateurs + ", nom=" + nom + ", prenom=" + prenom + ", password="
				+ password + ", age=" + age + "]";
	}
	

}
