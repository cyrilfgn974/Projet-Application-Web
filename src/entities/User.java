package entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_USER")
@DiscriminatorValue("USER")
public class User {
	private String username;
	private String password;
	private String first_name;
	private String last_name;
	private String email;
	private String phone_number;
    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public enum Status {
		ONLINE, OFFLINE, DONT_DISTURB
	}
	private Status status;
	private String description;

	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<User> friends;


	@ManyToMany(mappedBy = "demandesAmisRecues", fetch = FetchType.EAGER)
	private Collection<User> demandesAmisEnvoyees;

	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<User> demandesAmisRecues;

	@OneToMany(mappedBy = "from", fetch = FetchType.EAGER)
	private Collection<Donation> donations;



	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private Collection<Post> posts;


	public User(String user, String pass, String first, String last, String mail, String phone) {
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

	public User() {}

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

	public Collection<User> getDemandesAmisEnvoyees() {
        return demandesAmisEnvoyees;
    }

    public void setDemandesAmisEnvoyees(Collection<User> demandesAmisEnvoyees) {
        this.demandesAmisEnvoyees = demandesAmisEnvoyees;
    }

	public Collection<User> getDemandesAmisRecues() {
        return demandesAmisRecues;
    }

    public void setDemandesAmisRecuees(Collection<User> demandesAmisRecuees) {
        this.demandesAmisRecues = demandesAmisRecuees;
    }

	public Collection<Donation> getDonations() {
        return donations;
    }

    public void setDonations(Collection<Donation> donations) {
        this.donations = donations;
    }



	public Collection<Post> getPosts () {
		return posts;
	}

	public void setPosts (Collection<Post> posts) {
		this.posts =posts;
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

	public Donation getDonation(Artist a) {
		for (Donation d : this.donations) {
			if (d.getTo().equals(a)) {
				return d;
			}
		}
		return null;
	}
}
