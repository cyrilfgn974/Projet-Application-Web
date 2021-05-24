package servlet;

import entities.*;

import java.util.Collection;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.catalina.User;


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

	@POST
	@Path("/ajoutuser")
	@Consumes({"application/json"})
	public void ajoutUser(User u) {
		em.persist(u);
	}

	@GET
	@Path("/signin")
	@Produces({"application/json"})
	public User signIn(String pseudo, String password) {
		User loggedUser = em.find(User.class, pseudo);
		if (loggedUser.getPassword() == pseudo) return loggedUser;
		return null;
	}


	// Gestion des amis de l'utilisateur

	@POST
	@Path("/demanderami")
	@Consumes({"application/json"})
	public boolean demanderAmi(User u, String pseudoFriend) {
		User newFriend = em.find(User.class, pseudoFriend);
		if (newFriend != null && !u.getFriends().contains(newFriend)) {
			u.getDemandesAmisEnvoyees().add(newFriend);
			return true;
		}
		return false;
	}

	@POST
	@Path("/accepterami")
	@Consumes({"application/json"})
	public boolean accepterAmi(User u, String pseudoFriend) {
		User newFriend = em.find(User.class, pseudoFriend);
		if (newFriend != null && u.getDemandesAmisRecues().remove(newFriend)) {
			Chat chat = new Chat (u, newFriend);
			em.persist(chat);
			u.getFriends().add(newFriend);
			return true;
		}
		return false;
	}

	@POST
	@Path("/fairedonation")
	@Consumes({"application/json"})
	public boolean faireDonation(User u, String pseudoArtist, Money value, String freq) {
		try {
			Artist artist = em.find(Artist.class, pseudoArtist);
			Donation.Frequence f = Enum.valueOf(Donation.Frequence, freq);
			if (artist != null && u.getDonation(artist) == null) {
				em.persist(value);
				Donation d = new Donation(u, artist, value, f);
				em.persist(d);
				u.getDonations().add(d);
				return true;
			}
			return false;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}

	@POST
	@Path("/arreterdonation")
	@Consumes({"application/json"})
	public void arreterDonation(User u, String pseudoArtist) {
		Artist artist = em.find(Artist.class, pseudoArtist);
		if (artist != null) {
			Donation donationArtist = u.getDonation(artist);
			if (donation != null) u.donations.remove();
		}
	}


	// Gestion du Chat

	@GET
	@Path("/getmessages")
	@Produces({"application/json"})
	public List<Message> getMessages(User u, String pseudoFriend) {
		User friend = em.find(User.class, pseudoFriend);
		TypedQuery<Chat> query = em.createQuery("select chat from Chat chat"
				+ "where chat.user1.pseudonyme = :pseudoUser and chat.user2.pseudonyme = :pseudoFriend"
				+ "or chat.user1.pseudonyme = :pseudoFriend and chat.user2.pseudonyme = :pseudoUser");
		Chat chat = query
			.setParameter("pseudoUser", u.getPseudonyme())
			.setParameter("pseudoFriend", pseudoFriend)
			.getSingleResult();
		return chat.getMessages();
	}

	@POST
	@Path("/sendmessage")
	@Consumes({"application/json"})
	public void sendMessage(User u, String pseudoFriend, String message) {
		User friend = em.find(User.class, pseudoFriend);
		if (friend != null && u.getFriends().contains(friend)) {
			List<Message> messages = this.getMessages(u, pseudoFriend);
			messages.remove(0);
			messages.add(message);
		}
	}
}

//Comment rédiger une requête SQL ?
