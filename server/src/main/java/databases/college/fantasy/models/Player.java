package databases.college.fantasy.models;

import java.util.Objects;

public class Player
{
	private int playerID;
	private String firstname;
	private Character minit;
	private String lastname;
	private String university;

	public Player(int playerID, String firstname, Character minit, String lastname, String university)
	{
		this.playerID = playerID;
		this.firstname = firstname;
		this.minit = minit;
		this.lastname = lastname;
		this.university = university;
	}

	public int getPlayerID()
	{
		return playerID;
	}

	public void setPlayerID(int playerID)
	{
		this.playerID = playerID;
	}

	public String getFirstname()
	{
		return firstname;
	}

	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}

	public Character getMinit()
	{
		return minit;
	}

	public void setMinit(Character minit)
	{
		this.minit = minit;
	}

	public String getLastname()
	{
		return lastname;
	}

	public void setLastname(String lastname)
	{
		this.lastname = lastname;
	}

	public String getUniversity()
	{
		return university;
	}

	public void setUniversity(String university)
	{
		this.university = university;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Player player = (Player) o;
		return playerID == player.playerID && firstname.equals(player.firstname) && Objects.equals(minit, player.minit)
				&& lastname.equals(player.lastname) && university.equals(player.university);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(playerID, firstname, minit, lastname, university);
	}

	@Override
	public String toString()
	{
		return "Player{" + "playerID=" + playerID + ", firstname='" + firstname + '\'' + ", minit='" + minit + '\''
				+ ", lastname='" + lastname + '\'' + ", university='" + university + '\'' + '}';
	}
}
