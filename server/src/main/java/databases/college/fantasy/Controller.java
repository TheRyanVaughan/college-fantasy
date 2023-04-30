package databases.college.fantasy;

import databases.college.fantasy.models.*;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class Controller
{
	private Service service;
	public Controller(Service service) {
		this.service = service;
	}
	@GetMapping("/hello")
	public ResponseEntity<List<Employee>> hello() throws SQLException
	{
		// TODO: Add error handling
		return ResponseEntity.ok(service.basicQuery());
	}

	@GetMapping("/teams")
	public ResponseEntity<List<Team>> getTeamsInLeague(@RequestParam int leagueID) {
		try {
			List<Team> teams = service.getTeamsInLeague(leagueID);
			return ResponseEntity.ok(teams);
		}
		catch (SQLException e)
		{
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping("/players")
	public ResponseEntity<List<PlayerOnTeam>> getPlayersOnTeam(@RequestParam int teamID) {
		try {
			List<PlayerOnTeam> players = service.getPlayersOnTeam(teamID);
			return ResponseEntity.ok(players);
		}
		catch (SQLException e)
		{
			return ResponseEntity.internalServerError().build();
		}

	}

	@GetMapping("/user/teams")
	public ResponseEntity<List<Team>> getTeamsOfUser(@RequestParam int userID) {
		try {
			List<Team> teams = service.getUsersTeams(userID);
			return ResponseEntity.ok(teams);
		}
		catch (SQLException e)
		{
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping("/player")
	public ResponseEntity<Player> getPlayerByName(@RequestParam String firstName, @RequestParam String lastName) {
		try {
			return ResponseEntity.ok(service.getPlayerByName(firstName, lastName));
		}
		catch (SQLException e)
		{
			return ResponseEntity.internalServerError().build();
		}
	}

	@PostMapping("/team")
	public ResponseEntity<Team> addTeam(@RequestBody Team team) {
		// TODO: Add error handling
		// Adds a team to a league specified in the requestBody
		System.out.println(team);
		try {
			team = service.addTeam(team);
			return ResponseEntity.ok(team);
		}
		catch (SQLException e) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@DeleteMapping("/team")
	public ResponseEntity<?> deleteTeam(@RequestParam int teamID) {
		System.out.println("delete team " + teamID);
		try {
			service.deleteTeam(teamID);
			return ResponseEntity.ok().build();
		}
		catch (SQLException e)
		{
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/league")
	public ResponseEntity<League> addLeague(@RequestBody League league) {
		System.out.println("Adding a league " + league.toString());
		try {
			return ResponseEntity.ok(service.addLeague(league));
		}
		catch (SQLException e)
		{
			return ResponseEntity.internalServerError().build();
		}

	}

	@DeleteMapping("/league")
	public ResponseEntity<?> deleteLeague(@RequestParam int leagueID) {
		try {
			service.deleteLeague(leagueID);
			return ResponseEntity.ok().build();
		}
		catch (SQLException e)
		{
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/leagues")
	public ResponseEntity<List<League>> getLeagues() {
		try {
			return ResponseEntity.ok(service.getLeagueNames());
		}
		catch (SQLException e)
		{
			return ResponseEntity.ok(new ArrayList<League>());
		}
	}

	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		try {
			return ResponseEntity.ok(service.getAllUsers());
		}
		catch (SQLException e)
		{
			return ResponseEntity.ok(new ArrayList<User>());
		}
	}

	@PostMapping("/rosters/addPlayer")
	public ResponseEntity<?> addPlayerToTeam(@RequestParam int teamID, @RequestParam int playerID) {
		try {
			service.addPlayerToTeam(teamID, playerID);
			return ResponseEntity.ok().build();
		}
		catch (SQLException e) {
			return ResponseEntity.internalServerError().build();
		}
	}

}