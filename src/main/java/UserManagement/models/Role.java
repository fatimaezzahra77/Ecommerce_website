package UserManagement.models;


public class Role {
	
	protected int idRole;
	protected String type;
	
	public Role(int idRole, String type) {
		this.idRole = idRole;
		this.type = type;
	}
	
	public Role(int idRole) {
		this.idRole = idRole;
	
	}
	
	public int getIdRole() {
		return idRole;
	}
	
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Role [idRole=" + idRole + ", type=" + type + "]";
	}

}
