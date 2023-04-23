package databases.college.fantasy;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
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
	@RequestMapping("/")
	public ResponseEntity<List<Employee>> hello() throws SQLException
	{
		return ResponseEntity.ok(service.basicQuery());
	}


}