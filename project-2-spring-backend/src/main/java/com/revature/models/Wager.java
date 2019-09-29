package com.revature.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Wager implements Serializable{
	
	private static final long serialVersionUID = 1L;
	//Wager
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private double amt;
	@ManyToOne
	private User initiating;
	@ManyToOne
	private User recieving;
	private int api_game_id;
	private int guess;
	private boolean accepted;
	private int resolution;
	
	public Wager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Wager(int id) {
		super();
		this.id = id;
	}

	public Wager(double amt, User initiating, User recieving, int api_game_id, int guess, boolean accepted,
			int resolution) {
		super();
		this.amt = amt;
		this.initiating = initiating;
		this.recieving = recieving;
		this.api_game_id = api_game_id;
		this.guess = guess;
		this.accepted = accepted;
		this.resolution = resolution;
	}

	public Wager(int id, double amt, User initiating, User recieving, int api_game_id, int guess, boolean accepted,
			int resolution) {
		super();
		this.id = id;
		this.amt = amt;
		this.initiating = initiating;
		this.recieving = recieving;
		this.api_game_id = api_game_id;
		this.guess = guess;
		this.accepted = accepted;
		this.resolution = resolution;
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

	public User getInitiating() {
		return initiating;
	}

	public void setInitiating(User initiating) {
		this.initiating = initiating;
	}

	public User getRecieving() {
		return recieving;
	}

	public void setRecieving(User recieving) {
		this.recieving = recieving;
	}

	public int getApi_game_id() {
		return api_game_id;
	}

	public void setApi_game_id(int api_game_id) {
		this.api_game_id = api_game_id;
	}

	public int getGuess() {
		return guess;
	}

	public void setGuess(int guess) {
		this.guess = guess;
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
		result = prime * result + guess;
		result = prime * result + id;
		result = prime * result + ((initiating == null) ? 0 : initiating.hashCode());
		result = prime * result + ((recieving == null) ? 0 : recieving.hashCode());
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
		if (guess != other.guess)
			return false;
		if (id != other.id)
			return false;
		if (initiating == null) {
			if (other.initiating != null)
				return false;
		} else if (!initiating.equals(other.initiating))
			return false;
		if (recieving == null) {
			if (other.recieving != null)
				return false;
		} else if (!recieving.equals(other.recieving))
			return false;
		if (resolution != other.resolution)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Wager [id=" + id + ", amt=" + amt + ", initiating=" + initiating + ", recieving=" + recieving
				+ ", api_game_id=" + api_game_id + ", guess=" + guess + ", accepted=" + accepted + ", resolution="
				+ resolution + "]";
	}
}
