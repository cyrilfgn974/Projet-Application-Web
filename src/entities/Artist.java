package entities;

import java.util.Collection;

import javax.persistence.*;

@Entity
@DiscriminatorValue("ARTIST")
public class Artist extends User {

	@ManyToMany(mappedBy = "artistes", fetch = FetchType.EAGER)
	Collection<Muse> muses;
	@Id
	private Long id;

	public Artist(String user, String pass, String first, String last, String mail, String phone) {
		super(user, pass, first, last, mail, phone);
	}

	public Artist() {
		super();
	}

	public Collection<Muse> getMuses() {
		return muses;
	}

	public void setMuses(Collection<Muse> muses) {
		this.muses = muses;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
}

// Comment ajouter @Id étant donné que username est un attribut hérité ??
