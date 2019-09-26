package com.revature.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Player {
//	Player
	@Id
	private int api_player_id;
	private int user_id;
	private int team_id;
	private String type;
	
	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Player(int api_player_id) {
		super();
		this.api_player_id = api_player_id;
	}

	public Player(int api_player_id, int user_id, int team_id, String type) {
		super();
		this.api_player_id = api_player_id;
		this.user_id = user_id;
		this.team_id = team_id;
		this.type = type;
	}

	public int getApi_player_id() {
		return api_player_id;
	}

	public void setApi_player_id(int api_player_id) {
		this.api_player_id = api_player_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getTeam_id() {
		return team_id;
	}

	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + api_player_id;
		result = prime * result + team_id;
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
		Player other = (Player) obj;
		if (api_player_id != other.api_player_id)
			return false;
		if (team_id != other.team_id)
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
		return "Player [api_player_id=" + api_player_id + ", user_id=" + user_id + ", team_id=" + team_id + ", type="
				+ type + "]";
	}
	
	
	
}
