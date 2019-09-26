package com.revature.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Wager {
	//Wager
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private double amt;
	private User initiating_user_id;
	private User recieving_user_id;
	private int api_game_id;
	private boolean accepted;
	private int resolution;
	
	public Wager(int id, double amt, User initiating_user_id, User recieving_user_id, int api_game_id, boolean accepted,
			int resolution) {
		super();
		this.id = id;
		this.amt = amt;
		this.initiating_user_id = initiating_user_id;
		this.recieving_user_id = recieving_user_id;
		this.api_game_id = api_game_id;
		this.accepted = accepted;
		this.resolution = resolution;
	}

	public Wager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmt() {
		return amt;
	}

	public void setAmt(double amt) {
		this.amt = amt;
	}

	public User getInitiating_user_id() {
		return initiating_user_id;
	}

	public void setInitiating_user_id(User initiating_user_id) {
		this.initiating_user_id = initiating_user_id;
	}

	public User getRecieving_user_id() {
		return recieving_user_id;
	}

	public void setRecieving_user_id(User recieving_user_id) {
		this.recieving_user_id = recieving_user_id;
	}

	public int getApi_game_id() {
		return api_game_id;
	}

	public void setApi_game_id(int api_game_id) {
		this.api_game_id = api_game_id;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	public int getResolution() {
		return resolution;
	}

	public void setResolution(int resolution) {
		this.resolution = resolution;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (accepted ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(amt);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + api_game_id;
		result = prime * result + id;
		result = prime * result + ((initiating_user_id == null) ? 0 : initiating_user_id.hashCode());
		result = prime * result + ((recieving_user_id == null) ? 0 : recieving_user_id.hashCode());
		result = prime * result + resolution;
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
		Wager other = (Wager) obj;
		if (accepted != other.accepted)
			return false;
		if (Double.doubleToLongBits(amt) != Double.doubleToLongBits(other.amt))
			return false;
		if (api_game_id != other.api_game_id)
			return false;
		if (id != other.id)
			return false;
		if (initiating_user_id == null) {
			if (other.initiating_user_id != null)
				return false;
		} else if (!initiating_user_id.equals(other.initiating_user_id))
			return false;
		if (recieving_user_id == null) {
			if (other.recieving_user_id != null)
				return false;
		} else if (!recieving_user_id.equals(other.recieving_user_id))
			return false;
		if (resolution != other.resolution)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Wager [id=" + id + ", amt=" + amt + ", initiating_user_id=" + initiating_user_id
				+ ", recieving_user_id=" + recieving_user_id + ", api_game_id=" + api_game_id + ", accepted=" + accepted
				+ ", resolution=" + resolution + "]";
	}
	
	
}
