package databases.college.fantasy.models;

import java.util.Objects;

public class Team
{
	String leagueName;
	int leagueID;
	int managerID;
	int maxNoPlayers;

	public Team(String leagueName, int leagueID, int managerID, int maxNoPlayers)
	{
		this.leagueName = leagueName;
		this.leagueID = leagueID;
		this.managerID = managerID;
		this.maxNoPlayers = maxNoPlayers;
	}

	public String getLeagueName()
	{
		return leagueName;
	}

	public void setLeagueName(String leagueName)
	{
		this.leagueName = leagueName;
	}

	public int getLeagueID()
	{
		return leagueID;
	}

	public void setLeagueID(int leagueID)
	{
		this.leagueID = leagueID;
	}

	public int getManagerID()
	{
		return managerID;
	}

	public void setManagerID(int managerID)
	{
		this.managerID = managerID;
	}

	public int getMaxNoPlayers()
	{
		return maxNoPlayers;
	}

	public void setMaxNoPlayers(int maxNoPlayers)
	{
		this.maxNoPlayers = maxNoPlayers;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Team team = (Team) o;
		return leagueID == team.leagueID && managerID == team.managerID && maxNoPlayers == team.maxNoPlayers
				&& leagueName.equals(team.leagueName);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(leagueName, leagueID, managerID, maxNoPlayers);
	}

	@Override
	public String toString()
	{
		return "Team{" + "leagueName='" + leagueName + '\'' + ", leagueID=" + leagueID + ", managerID=" + managerID
				+ ", maxNoPlayers=" + maxNoPlayers + '}';
	}
}
