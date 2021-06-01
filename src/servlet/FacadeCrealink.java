package servlet;

import entities.*;

import java.util.Collection;
import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import entities.User;


@Singleton
@Path("/")
public class FacadeCrealink {

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

	/**@POST
	@Path("/uploadimg")
	@Consumes({"application/json"})
	public void uploadImage(String image) {
		
	}*/

	@GET
	@Path("/signin")
	@Produces({"application/json"})
	public User signIn(String pseudo, String password) {
		User loggedUser = em.find(User.class, pseudo);
		if (loggedUser.getPassword() == pseudo) return loggedUser;
		return null;
	}

	@GET
	@Path("/listusers")
    	@Produces({ "application/json" })
	public Collection<User> listUsers() {
		return em.createQuery("from User", User.class).getResultList();
	}


	// Gestion des amis de l'utilisateur

	@POST
	@Path("/demanderami")
	@Consumes({"application/json"})
	public boolean demanderAmi(User u, String pseudoFriend) {
		User newFriend = em.find(User.class, pseudoFriend);
		if (newFriend != null && !u.getFriends().contains(newFriend)) {
			newFriend.getDemandesAmisRecues().add(u);
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
	public boolean faireDonation(User u, String pseudoDon, Money value, String freq) {
		try {
			User userDon = em.find(User.class, pseudoDon);
			Donation.Frequence f = Enum.valueOf(Donation.Frequence.class, freq);
			if (userDon != null && u.getDonation(userDon) == null) {
				em.persist(value);
				Donation d = new Donation(u, userDon, value, f);
				em.persist(d);
				d.setFrom(u);
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
	public void arreterDonation(User u, String pseudoDon) {
		User userDon = em.find(User.class, pseudoDon);
		if (userDon != null) {
			Donation donation = u.getDonation(userDon);
			if (donation != null) em.remove(donation);
		}
	}

	@GET
	@Path("/isdonating")
	@Consumes({"application/json"})
	public boolean isDonating(User u, String pseudoDon) {
    	User userDon = em.find(User.class, pseudoDon);
    	if (userDon != null) {
        	return u.getDonation(userDon) != null;
    	}
    	return false;
	}


	// Gestion du Chat

	
	@GET
	@Path("/getmessages")
	@Produces({"application/json"})
	public List<Message> getMessages(User u, String pseudoFriend) {
		TypedQuery<Chat> query = (TypedQuery<Chat>) em.createQuery("select chat from Chat chat"
				+ "where chat.user1.username = :pseudoUser and chat.user2.username = :pseudoFriend"
				+ "or chat.user1.username = :pseudoFriend and chat.user2.username = :pseudoUser");
		Chat chat = query
			.setParameter("pseudoUser", u.getUsername())
			.setParameter("pseudoFriend", pseudoFriend)
			.getSingleResult();
		return chat.getMessages();
	}

	@POST
	@Path("/sendmessage")
	@Consumes({"application/json"})
	public void sendMessage(User u, String pseudoFriend, String message) {
		Message mess = new Message(message);
		em.persist(mess);
		User friend = em.find(User.class, pseudoFriend);
		if (friend != null && u.getFriends().contains(friend)) {
			List<Message> messages = this.getMessages(u, pseudoFriend);
			messages.remove(0);
			messages.add(mess);
		}
	}


	// Gestion des Posts

	
	@POST
	@Path("/supprimerpost")
	@Consumes({"application/json"})
	public void supprimerPost(User u, String postId) {
		Post post = em.find(Post.class, Integer.parseInt(postId));
		em.remove(post);
	}

	@POST
	@Path("/addpost")
	@Consumes({"application/json"})
	public void addPost(User u, String title, String text) {
		Post post = new Post(u, title, text);
		em.persist(post);
		post.setUser(u);
	}

	@POST
	@Path("/like")
	@Consumes({"application/json"})
	public void like(User u, String postId) {
		Post post = em.find(Post.class, Integer.parseInt(postId));
		post.getLikeList().add(u);
	}
}
