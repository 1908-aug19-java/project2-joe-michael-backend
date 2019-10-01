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
api_player_id: int,
name: string,
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
  current_streak: int,
  longest_streak: int,
  api_game_id: int,
  guess: [0 = home team loss, 1 = home team win, 2 = home team tie] int
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

### team get requests
getAll  /teams
getTeamById  /teams/{team id}
### team post requests
Request parameter required   "user_id": {user id}
addTeam  /teams
JSON body:{
"api_team_id": {team api id}int,
"api_league_id": {league api id}int,
"name": {team name}string,
"type": {[followed, favorite, fantasy]} string
}
### team put requests
updateTeam  /teams/{team id}
JSON body:{
   updated info
}
### team delete requests
deleteTeam  /teams/{team id}

##UserController

Auth Headers required except for addUser and login
token = {generated token}
user_id = {user id}

### user get requests
getAll  /users
getUserById  /users/{user id}
### user post requests
addUser  /users
JSON body:{
   "email": string,
   "password": string,
   "acct_level": int,
   "name": String
}
### user put requests
updateUser  /users/{user id}
JSON body:{
   updated information
}

loginUser  /users
JSON body:{
   "email": {user email} string,
   "password": {users password} string
}

### user delete requests
deleteUser users/{user id} 

##WagerController

Auth Headers required
token = {generated token}
user_id = {user id}

### wager get methods
getAll  /wagers
provide request parameter "user_id": {user id} to get all wagers associated with a particuliar user
getWagerById /wagers/{wager id}
### wager post methods
addWager /wagers
JSON Body:{
   "amt": double,
   "initiating": {initiating user object},
   "recieving": {receiving user object},---->spelled receiving incorrectly for attribute
   "api_game_id": {game api id},
   "guess": [0..2, 0 means home team loses, 1 means home team wins, 2 means tie]
}
### wager put methods
updateWager  /wagers/{wager id}
json body:{
   updated info
}
### wager delete methods
deleteWager wagers/{id}

