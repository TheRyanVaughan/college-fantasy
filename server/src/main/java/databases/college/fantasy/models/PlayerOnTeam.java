package databases.college.fantasy.models;

import java.util.Objects;

public class PlayerOnTeam
{
		int playerID;

	String firstname;
	String lastname;
	
		int teamID;

		int userID;

		int leagueID;


		
		public PlayerOnTeam(int playerID, int teamID, int userID, int leagueID, String firstname, String lastname) {
			this.playerID = playerID;
			this.teamID = teamID;
			this.userID = userID;
			this.leagueID = leagueID;
			this.firstname = firstname;
			this.lastname = lastname;
		}

		public int getPlayerID() {
			return playerID;
		}

		public void setPlayerID(int playerID) {
			this.playerID = playerID;
		}

		public int getTeamID() {
			return teamID;
		}

		public void setTeamID(int teamID) {
			this.teamID = teamID;
		}

		public int getUserID() {
			return userID;
		}

		public void setUserID(int userID) {
			this.userID = userID;
		}

		public int getLeagueID() {
			return leagueID;
		}

		public void setLeagueID(int leagueID) {
			this.leagueID = leagueID;
		}

	public String getFirstname()
	{
		return firstname;
	}

	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}

	public String getLastname()
	{
		return lastname;
	}

	public void setLastname(String lastname)
	{
		this.lastname = lastname;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		PlayerOnTeam that = (PlayerOnTeam) o;
		return playerID == that.playerID && teamID == that.teamID && userID == that.userID && leagueID == that.leagueID
				&& firstname.equals(that.firstname) && lastname.equals(that.lastname);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(playerID, teamID, userID, leagueID, firstname, lastname);
	}

	@Override
	public String toString()
	{
		return "PlayerOnTeam{" + "playerID=" + playerID + ", teamID=" + teamID + ", userID=" + userID + ", leagueID="
				+ leagueID + ", firstname='" + firstname + '\'' + ", lastname='" + lastname + '\'' + '}';
	}
}
