package com.revature.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Team {
	//team
	private int user_id;
	@Id
	private int api_team_id;
	private String type;
	@OneToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Player> players;

	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Team(int api_team_id) {
		super();
		this.api_team_id = api_team_id;
		
	}

	public Team(int user_id, int api_team_id, String type, List<Player> players) {
		super();
		this.user_id = user_id;
		this.api_team_id = api_team_id;
		this.type = type;
		this.players = players;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getApi_team_id() {
		return api_team_id;
	}

	public void setApi_team_id(int api_team_id) {
		this.api_team_id = api_team_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + api_team_id;
		result = prime * result + ((players == null) ? 0 : players.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + user_id;
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
		Team other = (Team) obj;
		if (api_team_id != other.api_team_id)
			return false;
		if (players == null) {
			if (other.players != null)
				return false;
		} else if (!players.equals(other.players))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Team [user_id=" + user_id + ", api_team_id=" + api_team_id + ", type=" + type + ", players=" + players
				+ "]";
	}
	
}
