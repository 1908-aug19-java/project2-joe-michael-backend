package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Streak {
	//streak
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int current_streak;
	private int longest_streak;
	
	public Streak() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Streak(int id) {
		super();
		this.id = id;
	}

	public Streak(int current_streak, int longest_streak) {
		super();
		this.current_streak = current_streak;
		this.longest_streak = longest_streak;
	}

	public Streak(int id, int current_streak, int longest_streak) {
		super();
		this.id = id;
		this.current_streak = current_streak;
		this.longest_streak = longest_streak;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + current_streak;
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
		if (current_streak != other.current_streak)
			return false;
		if (id != other.id)
			return false;
		if (longest_streak != other.longest_streak)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Streak [id=" + id + ", current_streak=" + current_streak + ", longest_streak=" + longest_streak + "]";
	}

	
}
