package databases.college.fantasy.models;

import java.util.Objects;

public class Team
{
	int teamID;

	int userID;

	int leagueID;

	String name;

	int wins;

	int losses;

	int draws;

	public Team(int teamID, int userID, int leagueID, String name, int wins, int losses, int draws)
	{
		this.teamID = teamID;
		this.userID = userID;
		this.leagueID = leagueID;
		this.name = name;
		this.wins = wins;
		this.losses = losses;
		this.draws = draws;
	}


	public int getTeamID()
	{
		return teamID;
	}

	public void setTeamID(int teamID)
	{
		this.teamID = teamID;
	}

	public int getUserID()
	{
		return userID;
	}

	public void setUserID(int userID)
	{
		this.userID = userID;
	}

	public int getLeagueID()
	{
		return leagueID;
	}

	public void setLeagueID(int leagueID)
	{
		this.leagueID = leagueID;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getWins()
	{
		return wins;
	}

	public void setWins(int wins)
	{
		this.wins = wins;
	}

	public int getLosses()
	{
		return losses;
	}

	public void setLosses(int losses)
	{
		this.losses = losses;
	}

	public int getDraws()
	{
		return draws;
	}

	public void setDraws(int draws)
	{
		this.draws = draws;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Team team = (Team) o;
		return teamID == team.teamID && userID == team.userID && leagueID == team.leagueID && wins == team.wins
				&& losses == team.losses && draws == team.draws && name.equals(team.name);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(teamID, userID, leagueID, name, wins, losses, draws);
	}

	@Override
	public String toString()
	{
		return "Team{" + "teamID=" + teamID + ", userID=" + userID + ", leagueID=" + leagueID + ", name='" + name + '\''
				+ ", wins=" + wins + ", losses=" + losses + ", draws=" + draws + '}';
	}
}
