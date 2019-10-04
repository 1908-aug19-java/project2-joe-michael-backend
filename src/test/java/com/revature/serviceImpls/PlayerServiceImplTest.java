package com.revature.serviceImpls;

import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import com.revature.controllers.PlayerController;
import com.revature.models.Player;
import com.revature.repositories.PlayerRepository;
import com.revature.services.PlayerService;

@RunWith(MockitoJUnitRunner.class)
public class PlayerServiceImplTest {
	
	@InjectMocks
	private PlayerServiceImpl service;
	
	@Mock
	private PlayerRepository repo;
	
	@Mock
	private PlayerController pc;
	
	@Before
	public void setup() {
		
	 Player player = new Player(1);
		
		when(repo.getOne(1)).thenReturn(player);
	
		
	}
	
	
	@Test
	public void playRepoFindById() {
		Player player = new Player(1);
		
		assertEquals(service.findPlayerById(1), player);
	}
	
	
}

