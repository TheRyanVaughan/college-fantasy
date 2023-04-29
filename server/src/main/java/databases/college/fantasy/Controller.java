package databases.college.fantasy;

import databases.college.fantasy.models.Employee;
import databases.college.fantasy.models.League;
import databases.college.fantasy.models.Player;
import databases.college.fantasy.models.Team;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
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
		// TODO: Add error handling
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
	public ResponseEntity<List<Player>> getPlayersOnTeam(@RequestParam int teamID) {
		// TODO: Add error handling
		return ResponseEntity.ok(service.getPlayersOnTeam(teamID));
	}

	@GetMapping("/user/teams")
	public ResponseEntity<List<Team>> getTeamsOfUser(@RequestParam int userID) {
		// TODO: Add error handling
		return ResponseEntity.ok(service.getUsersTeams(userID));
	}

	@GetMapping("/player")
	public ResponseEntity<Player> getPlayerByName(@RequestParam String firstName, @RequestParam String lastName) {
		// TODO: Add error handling
		// what if multiple players have same name? Add university? Return list? discuss
		return null;
	}

	@PostMapping("/team")
	public ResponseEntity<Team> addTeam(@RequestBody Team team) {
		// TODO: Add error handling
		// Adds a team to a league specified in the requestBody
		try {
			team = service.addTeam(team);
			return ResponseEntity.ok(service.addTeam(team));
		}
		catch (SQLException e) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@DeleteMapping("/team")
	public ResponseEntity<Team> deleteTeam(@RequestParam int teamID) {
		return ResponseEntity.ok(service.deleteTeam(teamID));
	}

	@PostMapping("/league")
	public ResponseEntity<League> AddLeague(@RequestBody League league) {
		return ResponseEntity.ok(service.addLeague(league));
	}

	@DeleteMapping("/league")
	public ResponseEntity<League> AddLeague(@RequestParam int leagueID) {
		return ResponseEntity.ok(service.deleteLeague(leagueID));
	}
}