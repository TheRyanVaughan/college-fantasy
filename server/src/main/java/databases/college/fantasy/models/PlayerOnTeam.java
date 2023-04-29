package databases.college.fantasy.models;

import java.util.Objects;

public class PlayerOnTeam
{
		int playerID;
	
		int teamID;

		int userID;

		int leagueID;
		
		public PlayerOnTeam(int playerID, int teamID, int userID, int leagueID) {
			this.playerID = playerID;
			this.teamID = teamID;
			this.userID = userID;
			this.leagueID = leagueID;
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

		@Override
		public int hashCode() {
			return Objects.hash(leagueID, playerID, teamID, userID);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			PlayerOnTeam other = (PlayerOnTeam) obj;
			return leagueID == other.leagueID && playerID == other.playerID && teamID == other.teamID
					&& userID == other.userID;
		}

		@Override
		public String toString() {
			return "Player [playerID=" + playerID + ", teamID=" + teamID + ", userID=" + userID + ", leagueID="
					+ leagueID + "]";
		}
}
