package pack;

import java.util.Collection;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


@Singleton
@Path("/")
public class Facade {

	@PersistenceContext
	EntityManager em;

	@POST
	@Path("/ajoutartiste")
	@Consumes({"application/json"})
	public void ajoutArtiste(Artist a) {
		em.persist(a);
	}

	@POST
	@Path("/ajoutmuse")
	@Consumes({"application/json"})
	public void ajoutMuse(Muse m) {
		em.persist(m);
	}

	@GET
	@Path("/getuser")
	@Produces({"application/json"})
	public User getUser(String pseudo)) {
		return em.find(User.class, pseudo);
	}
}
