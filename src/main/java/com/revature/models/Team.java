package com.revature.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Team implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int api_team_id;
	private int api_league_id;
	private String name;
	private String type;
	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Player> players;
	
	public Team() {
		super();
	}

	public Team(int id) {
		super();
		this.id = id;
	}

	public Team(int api_team_id, int api_league_id, String name, String type, List<Player> players) {
		super();
		this.api_team_id = api_team_id;
		this.api_league_id = api_league_id;
		this.name = name;
		this.type = type;
		this.players = players;
	}
	
	public Team(int id, int api_team_id, int api_league_id, String name, String type, List<Player> players) {
		super();
		this.id = id;
		this.api_team_id = api_team_id;
		this.api_league_id = api_league_id;
		this.name = name;
		this.type = type;
		this.players = players;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getApi_team_id() {
		return api_team_id;
	}

	public void setApi_team_id(int api_team_id) {
		this.api_team_id = api_team_id;
	}

	public int getApi_league_id() {
		return api_league_id;
	}

	public void setApi_league_id(int api_league_id) {
		this.api_league_id = api_league_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		result = prime * result + api_league_id;
		result = prime * result + api_team_id;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((players == null) ? 0 : players.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		if (api_league_id != other.api_league_id)
			return false;
		if (api_team_id != other.api_team_id)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
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
		return true;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", api_team_id=" + api_team_id + ", api_league_id=" + api_league_id + ", name=" + name
				+ ", type=" + type + ", players=" + players + "]";
	}
	
}
