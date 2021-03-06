package com.revature.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Player implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int api_player_id;
	private String name;
	private String type;
	
	public Player() {
		super();
		
	}

	public Player(int id) {
		super();
		this.id = id;
	}

	public Player(int api_player_id, String name, String type) {
		super();
		this.api_player_id = api_player_id;
		this.name = name;
		this.type = type;
	}

	public Player(int id, int api_player_id, String name, String type) {
		super();
		this.id = id;
		this.api_player_id = api_player_id;
		this.name = name;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getApi_player_id() {
		return api_player_id;
	}

	public void setApi_player_id(int api_player_id) {
		this.api_player_id = api_player_id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + api_player_id;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Player other = (Player) obj;
		if (api_player_id != other.api_player_id)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
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
		return "Player [id=" + id + ", api_player_id=" + api_player_id + ", name=" + name + ", type=" + type + "]";
	}
	
}
