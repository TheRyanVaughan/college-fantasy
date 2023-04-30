package databases.college.fantasy.models;
import java.util.Date;
import java.util.Objects;

public class User
{
	private int userid;

	private String firstname;

	private Character minit;

	private String lastname;

	private String username;

	private Date Bdate;

	public User(int userid, String firstname, Character minit, String lastname, String username, Date bdate)
	{
		this.userid = userid;
		this.firstname = firstname;
		this.minit = minit;
		this.lastname = lastname;
		this.username = username;
		Bdate = bdate;
	}

	public int getUserid()
	{
		return userid;
	}

	public void setUserid(int userid)
	{
		this.userid = userid;
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

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public Date getBdate()
	{
		return Bdate;
	}

	public void setBdate(Date bdate)
	{
		Bdate = bdate;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		User user = (User) o;
		return userid == user.userid && firstname.equals(user.firstname) && Objects.equals(minit, user.minit)
				&& lastname.equals(user.lastname) && username.equals(user.username) && Bdate.equals(user.Bdate);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(userid, firstname, minit, lastname, username, Bdate);
	}

	@Override
	public String toString()
	{
		return "User{" + "userid=" + userid + ", firstname='" + firstname + '\'' + ", minit=" + minit + ", lastname='"
				+ lastname + '\'' + ", username='" + username + '\'' + ", Bdate=" + Bdate + '}';
	}
}
