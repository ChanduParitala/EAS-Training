package EAS.jdbc.handson;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;

import EAS.jdbc.handson.Employee;

public class EmployeeDAO {
	static Connection con;
	public void getConnection()
	{
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll", "root", "2luvuu");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public boolean addEmployee(Employee emp) throws SQLException
	{
		getConnection();
		String stmt = "insert into employee values(?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(stmt);
		pst.setInt(1, emp.getEmployeeId());
		pst.setString(2, emp.getName());
		pst.setDate(3, Date.valueOf(emp.getDateOfBirth()));
		pst.setInt(4, emp.getSalary());
		
		int rs = pst.executeUpdate();
		if(rs==1)
			return true;
		else
			return false;
	}
	
	public ArrayList<Employee> viewEmployee() throws SQLException
	{
		getConnection();
		ArrayList<Employee> empList = new ArrayList<Employee>();
		String stmt = "select * from employee";
		PreparedStatement pst = con.prepareStatement(stmt);
		ResultSet rs = pst.executeQuery();
		int empId, salary;
		String name=null;
		LocalDate dob=null;
		while(rs.next())
		{
		empId = rs.getInt(1);
		name = rs.getString(2);
		Date d = rs.getDate(3);
		dob = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(d));
		salary = rs.getInt(4);
		
		Employee e = new Employee(empId, name, dob, salary);
		empList.add(e);
		
		}
		return empList;
	}
}
