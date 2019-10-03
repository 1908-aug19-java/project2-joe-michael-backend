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
public class Streak implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int current_streak;
	private int longest_streak;
	private int api_game_id;
	private int guess;
	
	public Streak() {
		super();
	}
	
	public Streak(int id) {
		super();
		this.id = id;
	}

	public Streak(int current_streak, int longest_streak, int api_game_id, int guess) {
		super();
		this.current_streak = current_streak;
		this.longest_streak = longest_streak;
		this.api_game_id = api_game_id;
		this.guess = guess;
	}

	public Streak(int id, int current_streak, int longest_streak, int api_game_id, int guess) {
		super();
		this.id = id;
		this.current_streak = current_streak;
		this.longest_streak = longest_streak;
		this.api_game_id = api_game_id;
		this.guess = guess;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCurrent_streak() {
		return current_streak;
	}

	public void setCurrent_streak(int current_streak) {
		this.current_streak = current_streak;
	}

	public int getLongest_streak() {
		return longest_streak;
	}

	public void setLongest_streak(int longest_streak) {
		this.longest_streak = longest_streak;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + api_game_id;
		result = prime * result + current_streak;
		result = prime * result + guess;
		result = prime * result + id;
		result = prime * result + longest_streak;
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
		Streak other = (Streak) obj;
		if (api_game_id != other.api_game_id)
			return false;
		if (current_streak != other.current_streak)
			return false;
		if (guess != other.guess)
			return false;
		if (id != other.id)
			return false;
		if (longest_streak != other.longest_streak)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Streak [id=" + id + ", current_streak=" + current_streak + ", longest_streak=" + longest_streak
				+ ", api_game_id=" + api_game_id + ", guess=" + guess + "]";
	}
	
}
