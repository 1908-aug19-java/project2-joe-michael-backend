package com.revature.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "the_user") 
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	//user specific attributes
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String email;
	private String password;
	private int acct_level;
	private String name;
	//one to many 
	@OneToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Player> followedPlayers = new ArrayList();
	@OneToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Team> followedTeams = new ArrayList();
	@OneToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Team> fantasyTeams = new ArrayList();
	@OneToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Wager> wagers = new ArrayList();
	//one to one
	@OneToOne
	private Streak streak;
	@OneToOne
	private Player favoritePlayer;
	@OneToOne
	private Team favoriteTeam;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String email, String password, int acct_level, String name, List<Player> followedPlayers,
			List<Team> followedTeams, List<Team> fantasyTeams, List<Wager> wagers, Streak streak, Player favoritePlayer,
			Team favoriteTeam) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.acct_level = acct_level;
		this.name = name;
		this.followedPlayers = followedPlayers;
		this.followedTeams = followedTeams;
		this.fantasyTeams = fantasyTeams;
		this.wagers = wagers;
		this.streak = streak;
		this.favoritePlayer = favoritePlayer;
		this.favoriteTeam = favoriteTeam;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAcct_level() {
		return acct_level;
	}

	public void setAcct_level(int acct_level) {
		this.acct_level = acct_level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Player> getFollowedPlayers() {
		return followedPlayers;
	}

	public void setFollowedPlayers(List<Player> followedPlayers) {
		this.followedPlayers = followedPlayers;
	}

	public List<Team> getFollowedTeams() {
		return followedTeams;
	}

	public void setFollowedTeams(List<Team> followedTeams) {
		this.followedTeams = followedTeams;
	}

	public List<Team> getFantasyTeams() {
		return fantasyTeams;
	}

	public void setFantasyTeams(List<Team> fantasyTeams) {
		this.fantasyTeams = fantasyTeams;
	}

	public List<Wager> getWagers() {
		return wagers;
	}

	public void setWagers(List<Wager> wagers) {
		this.wagers = wagers;
	}

	public Streak getStreak() {
		return streak;
	}

	public void setStreak(Streak streak) {
		this.streak = streak;
	}

	public Player getFavoritePlayer() {
		return favoritePlayer;
	}

	public void setFavoritePlayer(Player favoritePlayer) {
		this.favoritePlayer = favoritePlayer;
	}

	public Team getFavoriteTeam() {
		return favoriteTeam;
	}

	public void setFavoriteTeam(Team favoriteTeam) {
		this.favoriteTeam = favoriteTeam;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + acct_level;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fantasyTeams == null) ? 0 : fantasyTeams.hashCode());
		result = prime * result + ((favoritePlayer == null) ? 0 : favoritePlayer.hashCode());
		result = prime * result + ((favoriteTeam == null) ? 0 : favoriteTeam.hashCode());
		result = prime * result + ((followedPlayers == null) ? 0 : followedPlayers.hashCode());
		result = prime * result + ((followedTeams == null) ? 0 : followedTeams.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((streak == null) ? 0 : streak.hashCode());
		result = prime * result + ((wagers == null) ? 0 : wagers.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (acct_level != other.acct_level)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fantasyTeams == null) {
			if (other.fantasyTeams != null)
				return false;
		} else if (!fantasyTeams.equals(other.fantasyTeams))
			return false;
		if (favoritePlayer == null) {
			if (other.favoritePlayer != null)
				return false;
		} else if (!favoritePlayer.equals(other.favoritePlayer))
			return false;
		if (favoriteTeam == null) {
			if (other.favoriteTeam != null)
				return false;
		} else if (!favoriteTeam.equals(other.favoriteTeam))
			return false;
		if (followedPlayers == null) {
			if (other.followedPlayers != null)
				return false;
		} else if (!followedPlayers.equals(other.followedPlayers))
			return false;
		if (followedTeams == null) {
			if (other.followedTeams != null)
				return false;
		} else if (!followedTeams.equals(other.followedTeams))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (streak == null) {
			if (other.streak != null)
				return false;
		} else if (!streak.equals(other.streak))
			return false;
		if (wagers == null) {
			if (other.wagers != null)
				return false;
		} else if (!wagers.equals(other.wagers))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", acct_level=" + acct_level
				+ ", name=" + name + ", followedPlayers=" + followedPlayers + ", followedTeams=" + followedTeams
				+ ", fantasyTeams=" + fantasyTeams + ", wagers=" + wagers + ", streak=" + streak + ", favoritePlayer="
				+ favoritePlayer + ", favoriteTeam=" + favoriteTeam + "]";
	}
	
}
