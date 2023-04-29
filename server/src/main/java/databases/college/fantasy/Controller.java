package databases.college.fantasy;

import databases.college.fantasy.models.Employee;
import databases.college.fantasy.models.League;
import databases.college.fantasy.models.PlayerOnTeam;
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
			return ResponseEntity.ok(service.getPlayersOnTeam(teamID));
		}
		catch (SQLException e)
		{
			return ResponseEntity.internalServerError().build();
		}

	}

	@GetMapping("/user/teams")
	public ResponseEntity<List<Team>> getTeamsOfUser(@RequestParam int userID) {
		try {
			List<Team> teams = service.getTeamsInLeague(userID);
			return ResponseEntity.ok(teams);
		}
		catch (SQLException e)
		{
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping("/player")
	public ResponseEntity<PlayerOnTeam> getPlayerByName(@RequestParam String firstName, @RequestParam String lastName) {
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
	public ResponseEntity<?> deleteTeam(@RequestParam int teamID) {
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
	public ResponseEntity<League> AddLeague(@RequestBody League league) {
		return ResponseEntity.ok(service.addLeague(league));
	}

	@DeleteMapping("/league")
	public ResponseEntity<League> AddLeague(@RequestParam int leagueID) {
		return ResponseEntity.ok(service.deleteLeague(leagueID));
	}
}