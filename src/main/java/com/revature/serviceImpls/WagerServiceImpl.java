package com.revature.serviceImpls;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.models.User;
import com.revature.models.Wager;
import com.revature.repositories.WagerRepository;
import com.revature.services.WagerService;

@Service
public class WagerServiceImpl implements WagerService{
	
	Logger logger = LoggerFactory.getLogger(WagerService.class);

	@Autowired 
	private WagerRepository wagerRepository;
	
	@Override
	public List<Wager> findAllWagers() {
		
		logger.warn("wagers pulled");
		
		return wagerRepository.findAll();
	}

	@Override
	public Wager findWagerById(Integer id) {
		
		logger.warn("wager pulled by id");
		
		return wagerRepository.getOne(id);
	}

	@Override
	public Wager addWager(Wager wager) {
		
		logger.warn("wager added");
		
		return wagerRepository.save(wager);
	}

	@Override
	public Wager updateWager(Wager wager) {
		
		logger.warn("wager updated");
		
		return wagerRepository.save(wager);
	}

	@Override
	public Wager deleteWager(Wager wager) {
		
		logger.warn("wager deleted");
		
		wagerRepository.delete(wager);
		return wager;
	}

	@Override
	public List<Wager> findAllWagersByInitiatingOrRecieving(User initiating, User recieving) {
		
		logger.warn("wager pulled by initiating or receiving");
		
		return wagerRepository.findWagerByInitiatingOrRecieving(initiating, recieving);
	}

}
