package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.models.Streak;

public interface StreakRepository extends JpaRepository<Streak, Integer> {

}
