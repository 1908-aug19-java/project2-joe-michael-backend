package com.revature.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.stereotype.Component;

@Component
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
	private List<Player> players = new ArrayList<>();
	@OneToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Team> teams = new ArrayList<>();
	//one to one
	@OneToOne
	private Streak streak;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id) {
		super();
		this.id = id;
	}

	public User(String email, String password, int acct_level, String name, List<Player> players, List<Team> teams,
			Streak streak) {
		super();
		this.email = email;
		this.password = password;
		this.acct_level = acct_level;
		this.name = name;
		this.players = players;
		this.teams = teams;
		this.streak = streak;
	}

	public User(int id, String email, String password, int acct_level, String name, List<Player> players,
			List<Team> teams, Streak streak) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.acct_level = acct_level;
		this.name = name;
		this.players = players;
		this.teams = teams;
		this.streak = streak;
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

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public Streak getStreak() {
		return streak;
	}

	public void setStreak(Streak streak) {
		this.streak = streak;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + acct_level;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((players == null) ? 0 : players.hashCode());
		result = prime * result + ((streak == null) ? 0 : streak.hashCode());
		result = prime * result + ((teams == null) ? 0 : teams.hashCode());
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
		if (players == null) {
			if (other.players != null)
				return false;
		} else if (!players.equals(other.players))
			return false;
		if (streak == null) {
			if (other.streak != null)
				return false;
		} else if (!streak.equals(other.streak))
			return false;
		if (teams == null) {
			if (other.teams != null)
				return false;
		} else if (!teams.equals(other.teams))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", acct_level=" + acct_level
				+ ", name=" + name + ", players=" + players + ", teams=" + teams + ", streak=" + streak + "]";
	}

}
