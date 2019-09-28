package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Wager;

public interface WagerRepository extends JpaRepository<Wager, Integer>{

}
