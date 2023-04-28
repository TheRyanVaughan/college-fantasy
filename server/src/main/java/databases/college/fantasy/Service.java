package databases.college.fantasy;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import databases.college.fantasy.models.Employee;
import databases.college.fantasy.models.League;
import databases.college.fantasy.models.Player;
import databases.college.fantasy.models.Team;
import oracle.jdbc.pool.OracleDataSource;
import org.springframework.web.bind.annotation.CrossOrigin;

@org.springframework.stereotype.Service

public class Service
{
	private Connection connection = null;

	//local Oracle XE
	private final static String DB_URL_LOCAL_XE = "jdbc:oracle:thin:@localhost:1521/XE";

	private final static String DB_URL_CSDB2 = "jdbc:oracle:thin:@csdb.csc.villanova.edu:1521/orcl.villanova.edu";

//	private final static String username = "cmagoo01";
//	private final static String password = "Sp02267831";
	
	private final static String username = "rvelasq1";
	private final static String password = "Sp02248298";

	
	public static void main(String[] args) throws Exception {
		Service service = new Service();
		service.examples();
	}
	
//	public void examples() throws Exception {
//		Connection connection = null;
//
//		try {
//			connection = openConnection();
//			
//			
//			
//		}
//		catch (SQLException e) {
//			System.out.println("Trouble opening connection or executing SQL: " + e.getMessage());
//			throw e;
//		}
//		finally {
//			if (connection != null) {
//				connection.close();
//			}
//		}
//
//	}
	
	public Service() throws SQLException {
		Properties connectionProps = getProperties();

		OracleDataSource dataSource = new OracleDataSource();
		dataSource.setURL(DB_URL_CSDB2);
		dataSource.setConnectionProperties(connectionProps);

		connection = dataSource.getConnection();
	}

	private Properties getProperties() {
		Properties connProps = new Properties();
		connProps.put("user", username);
		connProps.put("password", password);
		return connProps;
	}

	public List<Employee> basicQuery() throws SQLException {
		System.out.println("*****Retrieve All Employees*****");
		List<Employee> employees = retrieveAllEmployees();
		return employees;
	}

	private List<Employee> retrieveAllEmployees() throws SQLException {
		List<Employee> employees = new ArrayList<Employee>();

		Statement statement = null;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM EMPLOYEE");

			if (resultSet != null) {
				while (resultSet.next()) {
					Employee emp = map(resultSet);
					employees.add(emp);
				}
			}

		}
		catch (SQLException e) {
			System.out.println("An exception occurred when executing a statement: " + e.getMessage());
			throw e;
		}
		finally {
			if (statement != null) {
				statement.close();
			}
		}

		return employees;
	}

	private Employee map(ResultSet resultSet) throws SQLException {
		String fname = resultSet.getString("fname");
		String minitStr = resultSet.getString("minit");
		Character minit = convertToSingleChar(minitStr);
		String lname = resultSet.getString("lname");
		String ssn = resultSet.getString("ssn");
		Date bdate = resultSet.getDate("bdate");
		String address = resultSet.getString("address");
		String sexStr = resultSet.getString("sex");
		Character sex = convertToSingleChar(sexStr);
		Double salary = resultSet.getDouble("salary");
		if (resultSet.wasNull()) {
			salary = null;
		}
		String superssn = resultSet.getString("superssn");
		Integer dno = resultSet.getInt("dno");
		if (resultSet.wasNull()) {
			dno = null;
		}

		Employee emp = new Employee(fname, minit, lname, ssn, bdate, address, sex, salary, superssn, dno);
		return emp;
	}

	private Character convertToSingleChar(String raw) {
		Character single = null;
		if (raw != null && raw.length() > 0) {
			single = Character.valueOf(raw.charAt(0));
		}
		return single;
	}

	public List<Team> getTeamsInLeague(Connection connection, int leagueID)
	{
		// TODO: Retrieve the teams in a given league from the database
		
		List<Team> teams = new ArrayList<Team>();
		
		Statement statement = null;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM FANTASY_TEAM WHERE LEAGUEID = " + leagueID);
			
			if(resultSet != null) {
				while(resultSet.next()) {
					Team t = map(resultSet);
					teams.add(t);
				}
			}
		}
		catch(SQLException e) {
			System.out.println("An exception occurred when executing a statement: " + e.getMessage());
			throw e;
		}
		finally {
			if (statement != null) {
				statement.close();
			}
		}
		
		return teams;
		
	} // end function


	public List<Team> getUsersTeams(Connection connection, int userID)
	{
		// TODO: Retrieve a user's teams from the database
		
		List<Team> usersTeam = new ArrayList<Team>();
		
		Statement statement = null;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM fantasy_team WHERE userID = " + userID);
			
			if(resultSet != null) {
				while(resultSet.next()) {
					Team ut = map(resultSet);
					usersTeam.add(ut);
				}
			}
		}
		catch(SQLException e) {
			System.out.println("An exception occurred when executing a statement: " + e.getMessage());
			throw e;
		}
		finally {
			if (statement != null) {
				statement.close();
			}
		}
		
		return usersTeam;
	}

	public List<Player> getPlayersOnTeam(int teamID)
	{
		// TODO: Get the players on a given team
		
		List<Player> playersOnTeam = new ArrayList<>();
		
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM players WHERE teamID = " + userID);
			
			while(resultSet.next()) {
				Player p = map(resultSet);
				playersOnTeam.add(p);
			}
		}
		catch(SQLException e) {
			System.out.println("An exception occurred when executing a statement: " + e.getMessage());
			throw e;
		}
		finally {
			if (statement != null) {
				statement.close();
			}
		}
		
		return playersOnTeam;
	}

	public Team addTeam(Team team)
			throws SQLException
	{
		
		PreparedStatement prepStatement = null;
		
		try {

			prepStatement = connection.prepareStatement("INSERT INTO fantasy_team (TeamID, UserID, LeagueID, teamName, wins, losses, draws) " +
					" VALUES (?, ?, ?, ?, ?, ?, ?)" );


			String getNextTID = "seqTID.nextval";
			prepStatement.setString(1, getNextTID);
			prepStatement.setInt(2, team.getUserID());
			prepStatement.setInt(3, team.getLeagueID());
			prepStatement.setString(4, team.getName());
			prepStatement.setInt(5, team.getWins());
			prepStatement.setInt(6, team.getLosses());
			prepStatement.setInt(7, team.getDraws());
			
			prepStatement.executeUpdate();
		}
		catch(SQLException e) {
			System.out.println("An exception occurred when executing a statement: " + e.getMessage());
			throw e;
		}
		finally {
			if (prepStatement != null) {
				prepStatement.close();
			}
		}
	}

	public Team deleteTeam(int teamID)
	{
		// TODO: Remove a team from the DB
		
		Statement statement = null;
		
		try {
			statement = connection.createStatement();
			
			String query = ("DELETE FROM fantasy_team WHERE teamID = " + teamID);
			
			statement.executeUpdate(query);
		}
		catch(SQLException e) {
			System.out.println("An exception occurred when executing a statement: " + e.getMessage());
			throw e;
		}
		finally {
			if (statement != null) {
				statement.close();
			}
		}
	}

	public League addLeague(League league)
	{
		// TODO: Create a league
		return null;
	}

	public League deleteLeague(int leagueID)
	{
		// TODO: Delete a League
		return null;
	}
}
