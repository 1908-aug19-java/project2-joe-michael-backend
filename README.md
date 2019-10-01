# project2-joe-michael-backend
Project2 backend repository for Joe Gallagher and Michael Zhang

## Player Controller

Headers required
token = {generated token}
user_id = {user id}

### get requests for players
getAll /players
getPlayerById /players/{player id}
### post requests for players
addPlayer /players 
if adding to a team team_id request parameter must be added
if adding to a user user_id request parameter must be added(along with user_id header)
dont include both.

JSON body:{
api_player_id: ...,
name: ...,
type: [followed, favorite, fantasy]
}

### put requests for players
updatePlayer /players{id}
JSON body:{
   updated info
}
### delete requests for players
deletePlayer /players/{id}
if removing from a team team_id request parameter required
if removing from a user user_id request parameter required(along with user_id header)
dont include both

## StreakController

Auth Headers required
token = {generated token}
user_id = {user id}

### get requests for streaks
getAll /streaks  -should never have to be used
getStreakById /streaks/{streak id}
### post requests for streaks
addStreak /streaks - should never have to be used(a streak is created when a user is created)
JSON body{
  current_streak: ...,
  longest_streak: ...,
  api_game_id: ...,
  guess: [0 = home team loss, 1 = home team win, 2 = home team tie]
}
### put requests for streaks
updateStreak  /streaks/{streak id}
JSon body{
  updated information
}
### delete requests for streaks
deleteStreak /streaks/{streak id}- should never be called unless user is removed and streak is orphaned


##TeamController

Auth Headers required
token = {generated token}
user_id = {user id}


getAll
getTeamById
addTeam
updateTeam
deleteTeam

UserController

Auth Headers required except for addUser and login
token = {generated token}
user_id = {user id}

getAll
getUserById
addUser
updateUser
deleteUser
loginUser

WagerController

Auth Headers required
token = {generated token}
user_id = {user id}

getAll
getWagerById
addWager
updateWager
deleteWager

