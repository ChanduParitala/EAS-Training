package EAS.jdbc.handson;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class EmpMain {

	public static void main(String[] args) throws SQLException {
		boolean flag = true;
		Scanner in = new Scanner(System.in);
		EmployeeDAO empDao = new EmployeeDAO();
		do {
			System.out.println("1. Add employee\n2. View all Employee Data\n3. Exit");
			int choice = in.nextInt();
			switch (choice) {
			case 1: {
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
				boolean f = empDao.addEmployee(emp);
				if (f)
					System.out.println("Insertion done!");
				else
					System.out.println("Error!!!");
				break;
			}
			case 2: {
				System.out.println("returning all tuples from database..");
				ArrayList<Employee> empList = empDao.viewEmployee();
				for (Employee i : empList) {
					System.out.println(i.toString()+"\n");
				}
				break;
			}
			case 3:
			{
				flag = false;
				break;
			}
			default: {
				System.out.println("wrong selection, try again");
				break;
			}
			}

		} while (flag);

	}

}
