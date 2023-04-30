package databases.college.fantasy;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import databases.college.fantasy.models.Employee;
import databases.college.fantasy.models.League;
import databases.college.fantasy.models.PlayerOnTeam;
import databases.college.fantasy.models.Team;
import oracle.jdbc.pool.OracleDataSource;
import org.springframework.http.ResponseEntity;

@org.springframework.stereotype.Service

public class Service
{
	private Connection connection = null;

	//local Oracle XE
	private final static String DB_URL_LOCAL_XE = "jdbc:oracle:thin:@localhost:1521/XE";

	private final static String DB_URL_CSDB2 = "jdbc:oracle:thin:@csdb.csc.villanova.edu:1521/orcl.villanova.edu";

//	private final static String username = "cmagoo01";
//	private final static String password = "Sp02267831";
	
	private final static String username = "rvaugha4";
	private final static String password = "Sp02269960";


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

	public List<Team> getTeamsInLeague(int leagueID) throws SQLException
	{
		// TODO: Retrieve the teams in a given league from the database
		
		List<Team> teams = new ArrayList<Team>();
		
		Statement statement = null;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM FANTASY_TEAM WHERE LEAGUEID = " + leagueID);
			
			if(resultSet != null) {
				while(resultSet.next()) {
					Team t = teamMap(resultSet);
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

	private Team teamMap(ResultSet resultSet) throws SQLException
	{
		Integer teamID = resultSet.getInt("teamid");
		Integer userID = resultSet.getInt("userid");
		Integer leagueID = resultSet.getInt("leagueid");
		String name = resultSet.getString("teamname");
		Integer wins = resultSet.getInt("wins");
		Integer losses = resultSet.getInt("losses");
		Integer draws = resultSet.getInt("draws");

		return new Team(teamID, userID, leagueID, name, wins, losses, draws);
	}

	public List<Team> getUsersTeams(int userID) throws SQLException
	{
		// TODO: Retrieve a user's teams from the database
		
		List<Team> usersTeam = new ArrayList<Team>();
		
		Statement statement = null;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM fantasy_team WHERE userID = " + userID);
			
			if(resultSet != null) {
				while(resultSet.next()) {
					Team ut = teamMap(resultSet);
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

	public List<PlayerOnTeam> getPlayersOnTeam(int teamID) throws SQLException
	{
		// TODO: Get the players on a given team
		
		List<PlayerOnTeam> playersOnTeam = new ArrayList<>();

		Statement statement = null;

		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM players WHERE teamID = " + teamID);
			
			while(resultSet.next()) {
				PlayerOnTeam p = playerMap(resultSet);
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

	private PlayerOnTeam playerMap(ResultSet resultSet) throws SQLException
	{
		Integer playerID = resultSet.getInt("playerid");
		Integer teamID = resultSet.getInt("teamid");
		Integer userid = resultSet.getInt("userid");
		Integer leagueID = resultSet.getInt("leagueid");

		return new PlayerOnTeam(playerID, teamID, userid, leagueID);
	}

	public Team addTeam(Team team)
			throws SQLException
	{
		
		PreparedStatement prepStatement = null;
		
		try {

			prepStatement = connection.prepareStatement("INSERT INTO fantasy_team (TeamID, UserID, LeagueID, teamName, wins, losses, draws) " +
					" VALUES (seqTID.nextval, ?, ?, ?, ?, ?, ?)" );

			prepStatement.setInt(1, team.getUserID());
			prepStatement.setInt(2, team.getLeagueID());
			prepStatement.setString(3, team.getName());
			prepStatement.setInt(4, team.getWins());
			prepStatement.setInt(5, team.getLosses());
			prepStatement.setInt(6, team.getDraws());
			
			prepStatement.executeUpdate();

			return team;
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

	public void deleteTeam(int teamID) throws SQLException
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

	public List<League> getLeagueNames() throws SQLException
	{
		List<League> leagues = new ArrayList<>();

		Statement statement = null;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM LEAGUE");

			if(resultSet != null) {
				while(resultSet.next()) {
					League league = leagueMap(resultSet);
					leagues.add(league);
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

		return leagues;
	}

	private League leagueMap(ResultSet resultSet) throws SQLException
	{
		String leagueName = resultSet.getString("leagueName");
		Integer leagueID = resultSet.getInt("leagueid");
		Integer managerid = resultSet.getInt("managerID");
		Integer max_no_players = resultSet.getInt("max_no_players");
		return new League(leagueName, leagueID, managerid, max_no_players);
	}
}
