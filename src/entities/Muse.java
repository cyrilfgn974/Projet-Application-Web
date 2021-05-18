package entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Muse extends User {

	@ManyToMany(fetch = FetchType.EAGER)
	Collection<Artist> artistes;

	protected Muse(String user, String pass, String first, String last, String mail, String phone) {
		super(user, pass, first, last, mail, phone);
	}

	public Collection<Artist> getArtistes() {
		return artistes;
	}

	public void setArtistes(Collection<Artist> artistes) {
		this.artistes = artistes;
	}

}
