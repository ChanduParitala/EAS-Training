package EAS.jdbc.handson;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class EmpMain {

	public static void main(String[] args) throws SQLException {
		
		Scanner in = new Scanner(System.in);
		System.out.println("empid: ");
		int empId = in.nextInt();
		System.out.println("empName: ");
		String empName = in.next();
		System.out.println("DOB(yyyy-MM-dd): ");
		String date = in.next();
		DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dob = LocalDate.parse(date, sdf);
		System.out.println("salary: ");
		int salary = in.nextInt();
		Employee emp = new Employee(empId, empName, dob, salary);
		
		System.out.println("adding to database..");
		EmployeeDAO empDao = new EmployeeDAO();
		boolean flag = empDao.addEmployee(emp);
		if(flag)
			System.out.println("Insertion done!");
		else
			System.out.println("Error!!!");
		
		System.out.println("returning all tuples from database..");
		ArrayList<Employee> empList = empDao.viewEmployee();
		for(Employee i : empList)
		{
			System.out.println(i.toString());
		}
	}

}
