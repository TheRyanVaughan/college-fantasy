package databases.college.fantasy;

import databases.college.fantasy.models.Employee;
import databases.college.fantasy.models.Team;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
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
		return ResponseEntity.ok(service.getTeamsInLeague(leagueID));
	}


}