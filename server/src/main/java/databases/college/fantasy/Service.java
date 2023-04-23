package databases.college.fantasy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import oracle.jdbc.pool.OracleDataSource;
@org.springframework.stereotype.Service
public class Service
{
	private Connection connection = null;

	//local Oracle XE
	private final static String DB_URL_LOCAL_XE = "jdbc:oracle:thin:@localhost:1521/XE";

	private final static String DB_URL_CSDB2 = "jdbc:oracle:thin:@csdb.csc.villanova.edu:1521/orcl.villanova.edu";

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
}
