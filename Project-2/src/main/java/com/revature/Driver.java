package com.revature;



import com.revature.dao.PlayerDao;
import com.revature.dao.StreakDao;
import com.revature.dao.TeamDao;
import com.revature.dao.UserDao;
import com.revature.dao.WagerDao;
import com.revature.daoImpl.PlayerDaoImpl;
import com.revature.daoImpl.StreakDaoImpl;
import com.revature.daoImpl.TeamDaoImpl;
import com.revature.daoImpl.UserDaoImpl;
import com.revature.daoImpl.WagerDaoImpl;
import com.revature.model.Player;
import com.revature.model.Streak;
import com.revature.model.Team;
import com.revature.model.User;
import com.revature.model.Wager;

public class Driver {

	public static void main(String[] args) {
		UserDao ud = new UserDaoImpl();
		PlayerDao pd = new PlayerDaoImpl();
		StreakDao sd = new StreakDaoImpl();
		TeamDao td = new TeamDaoImpl();
		WagerDao wd = new WagerDaoImpl();
		
		User user = new User();
		User user1 = new User();
		//User user2 = new User();
		Player player = new Player(1);
		Player player1 = new Player(2);
		//Player player2 = new Player(3);
		Streak streak = new Streak();
		Streak streak1 = new Streak();
		//Streak streak2 = new Streak();
		Team team = new Team(1);
		Team team1 = new Team(2);
		//Team team2 = new Team(3);
		Wager wager = new Wager();
		Wager wager1 = new Wager();
		//Wager wager2 = new Wager();
		//create
		ud.createUser(user);
		ud.createUser(user1);
		pd.createPlayer(player);
		pd.createPlayer(player1);
		sd.createStreak(streak);
		sd.createStreak(streak1);
		td.createTeam(team);
		td.createTeam(team1);
		wd.createWager(wager);
		wd.createWager(wager1);
		//get
		System.out.println(ud.getUserById(1));
		System.out.println(pd.getPlayerById(1));
		System.out.println(sd.getStreakById(1));
		System.out.println(td.getTeamById(1));
		System.out.println(wd.getWagerById(1));
		//getAll
		System.out.println(ud.getAllUsers());
		System.out.println(pd.getAllPlayers());
		System.out.println(sd.getAllStreaks());
		System.out.println(td.getAllTeams());
		System.out.println(wd.getAllWagers());
		//update
		System.out.println(ud.getUserById(1));
		User user2 = new User(1, "email", null, 0, null, null, null, null, null, null, null, null);
		ud.updateUser(user2);
		System.out.println(ud.getUserById(1));
		
		System.out.println(pd.getPlayerById(1));
		Player player2 = new Player(1,0, 0, "name");
		pd.updatePlayer(player2);
		System.out.println(pd.getPlayerById(1));
		
		System.out.println(sd.getStreakById(1));
		Streak streak2 = new Streak(1, 0, 0, 1);
		sd.updateStreak(streak2);
		System.out.println(sd.getStreakById(1));
		
		System.out.println(td.getTeamById(1));
		Team team2 = new Team(0,1, "words", null);
		td.updateTeam(team2);
		System.out.println(td.getTeamById(1));
		
		System.out.println(wd.getWagerById(1));
		Wager wager2 = new Wager(1,1, null, null, 0, false, 0);
		wd.updateWager(wager2);
		System.out.println(wd.getWagerById(1));
		//delete
		
		ud.deleteUser(user);
		pd.deletePlayer(player);
		sd.deleteStreak(streak);
		td.deleteTeam(team);
		wd.deleteWager(wager);
		
		System.out.println(ud.getAllUsers());
		System.out.println(pd.getAllPlayers());
		System.out.println(sd.getAllStreaks());
		System.out.println(td.getAllTeams());
		System.out.println(wd.getAllWagers());
		
	}

}
