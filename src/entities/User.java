package entities;

public abstract class User {
	private String username;
	private String password;
	private String first_name;
	private String last_name;
	private String email;
	private String phone_number;
	private String status;
	//LIST OF FRIENDS ......
	
	protected User(String user, String pass, String first, String last, String mail, String phone) {
		this.username = user;
		this.password = pass;
		this.first_name = first;
		this.last_name = last;
		this.email = mail;
		this.phone_number = phone;
	}
	public String getUsername()
	{
		return this.username;
	}
	public String getPassword()
	{
		return this.password;
	}
	public String getFirstName()
	{
		return this.first_name;
	}
	public String getLastName()
	{
		return this.last_name;
	}
	public String getEmail()
	{
		return this.email;
	}
	public String getPhoneNumber()
	{
		return this.phone_number;
	}
	public void setUsername(String change) {
		this.username = change;
	}
	public void setPassword(String change) {
		this.password = change;
	}
	public void setFirstName(String change) {
		this.first_name = change;
	}
	public void setLastName(String change) {
		this.last_name = change;
	}
	public void setMail(String change) {
		this.email = change;
	}
	public void setPhone(String change) {
		this.phone_number = change;
	}
	
}
