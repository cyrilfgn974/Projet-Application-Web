package entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class User {
	private String username;
	private String password;
	private String first_name;
	private String last_name;
	private String email;
	private String phone_number;

	public enum Status {
		ONLINE;
		OFFLINE;
		DONT_DISTURB;
	}
	private Status status;
	private String description;

	@ManyToMany(mappedBy = "friends", fetch = FetchType.EAGER)
	private Collection<User> friends;
	
	protected User(String user, String pass, String first, String last, String mail, String phone) {
		this.username = user;
		this.password = pass;
		this.first_name = first;
		this.last_name = last;
		this.email = mail;
		this.phone_number = phone;
		// L'utilisateur n'est pas connecté quand il crée son compte
		this.status = Status.OFFLINE;
		// L'utilisateur pourra modifier à tout moment sa description
		this.description = "";
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	@Basic
    @Column(name = "username", nullable = false, length = 200)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 200)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "first_name", nullable = false, length = 200)
    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String firstName) {
        this.first_name = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = false, length = 200)
    public String getLastName() {
        return last_name;
    }

    public void setLastName(String lastName) {
        this.last_name = lastName;
    }
	
	@Basic
    @Column(name = "email", nullable = false, length = 200)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	@Basic
    @Column(name = "status", nullable = false, length = 200)
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

	@Basic
    @Column(name = "description", nullable = false, length = 200)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<User> getFriends() {
        return friends;
    }

    public void setFriends(Collection<User> friends) {
        this.friends = friends;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return  Objects.equals(username, user.username); //&&
				//pseudos choisis de manière unique !?
                //Objects.equals(password, user.password) &&
                //Objects.equals(first_name, user.first_name) &&
                //Objects.equals(last_name, user.last_name);
    }
}
