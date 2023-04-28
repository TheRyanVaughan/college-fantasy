package databases.college.fantasy.models;

import java.util.Objects;

public class League
{
	String leaguename;
	
	int leagueID;
	
	int managerID;
	
	int maxNumPlayers;

	public League(String leaguename, int leagueID, int managerID, int maxNumPlayers) {
		super();
		this.leaguename = leaguename;
		this.leagueID = leagueID;
		this.managerID = managerID;
		this.maxNumPlayers = maxNumPlayers;
	}

	public String getLeaguename() {
		return leaguename;
	}

	public void setLeaguename(String leaguename) {
		this.leaguename = leaguename;
	}

	public int getLeagueID() {
		return leagueID;
	}

	public void setLeagueID(int leagueID) {
		this.leagueID = leagueID;
	}

	public int getManagerID() {
		return managerID;
	}

	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}

	public int getMaxNumPlayers() {
		return maxNumPlayers;
	}

	public void setMaxNumPlayers(int maxNumPlayers) {
		this.maxNumPlayers = maxNumPlayers;
	}

	@Override
	public int hashCode() {
		return Objects.hash(leagueID, leaguename, managerID, maxNumPlayers);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		League other = (League) obj;
		return leagueID == other.leagueID && Objects.equals(leaguename, other.leaguename)
				&& managerID == other.managerID && maxNumPlayers == other.maxNumPlayers;
	}

	@Override
	public String toString() {
		return "League [leaguename=" + leaguename + ", leagueID=" + leagueID + ", managerID=" + managerID
				+ ", maxNumPlayers=" + maxNumPlayers + "]";
	}
}
