package com.revature.serviceImpls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.models.Wager;
import com.revature.repositories.WagerRepository;
import com.revature.services.WagerService;

@Service
public class WagerServiceImpl implements WagerService{

	@Autowired 
	private WagerRepository wagerRepository;
	
	@Override
	public List<Wager> findAllWagers() {
		
		return wagerRepository.findAll();
	}

	@Override
	public Wager findWagerById(Integer id) {
		return wagerRepository.getOne(id);
	}

	@Override
	public Wager addWager(Wager wager) {
		return wagerRepository.save(wager);
	}

	@Override
	public Wager updateWager(Wager wager) {
		return wagerRepository.save(wager);
	}

	@Override
	public Wager deleteWager(Wager wager) {
		wagerRepository.delete(wager);
		return wager;
	}

	@Override
	public List<Wager> findAllWagersByInitiatingOrRecieving(User initiating, User recieving) {
		
		return wagerRepository.findWagerByInitiatingOrRecieving(initiating, recieving);
	}

}
