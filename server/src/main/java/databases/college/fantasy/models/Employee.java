package databases.college.fantasy.models;

import java.util.Date;

//Represents an employee in the Company DB
//All methods auto-generated by Eclipse
public class Employee {

	private String fname;
	private Character minit;
	private String lname;
	private String ssn;
	private Date bdate;
	private String address;
	private Character sex;
	private Double salary;
	private String superssn;
	private Integer dno;

	public Employee(String fname, Character minit, String lname, String ssn, Date bdate, String address, Character sex,
			Double salary, String superssn, Integer dno) {
		super();
		this.fname = fname;
		this.minit = minit;
		this.lname = lname;
		this.ssn = ssn;
		this.bdate = bdate;
		this.address = address;
		this.sex = sex;
		this.salary = salary;
		this.superssn = superssn;
		this.dno = dno;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public Character getMinit() {
		return minit;
	}

	public void setMinit(Character minit) {
		this.minit = minit;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public Date getBdate() {
		return bdate;
	}

	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Character getSex() {
		return sex;
	}

	public void setSex(Character sex) {
		this.sex = sex;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getSuperssn() {
		return superssn;
	}

	public void setSuperssn(String superssn) {
		this.superssn = superssn;
	}

	public Integer getDno() {
		return dno;
	}

	public void setDno(Integer dno) {
		this.dno = dno;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ssn == null) ? 0 : ssn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (ssn == null) {
			if (other.ssn != null)
				return false;
		} else if (!ssn.equals(other.ssn))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [fname=" + fname + ", minit=" + minit + ", lname=" + lname + ", ssn=" + ssn + ", bdate="
				+ bdate + ", address=" + address + ", sex=" + sex + ", salary=" + salary + ", superssn=" + superssn
				+ ", dno=" + dno + "]";
	}


}
