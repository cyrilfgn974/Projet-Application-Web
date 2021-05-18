package entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Artist extends User {

	@ManyToMany(mappedBy = "artistes", fetch = FetchType.EAGER)
	Collection<Muse> muses;

	protected Artist(String user, String pass, String first, String last, String mail, String phone) {
		super(user, pass, first, last, mail, phone);
	}

	public Collection<Muses> getMuses() {
		return muses;
	}

	public void setMuses(Collection<Muse> muses) {
		this.muses = muses;
	}

}

// Comment ajouter @Id étant donné que username est un attribut hérité ??
