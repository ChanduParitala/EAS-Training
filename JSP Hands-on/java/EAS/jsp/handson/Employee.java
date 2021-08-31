package EAS.jsp.handson;

import java.time.LocalDate;
import java.util.Date;

public class Employee {
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	private int empId, salary;
	private String empName, gender, fulltimeEmployee, department;
	private LocalDate dob;
	public Employee(int empId, String empName, String gender, LocalDate dob, String fulltimeEmployee, String department, int salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.gender = gender;
		this.dob=dob;
		this.fulltimeEmployee=fulltimeEmployee;
		this.department=department;
		this.salary=salary;
	}
	public String getGender() {
		return gender;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", salary=" + salary + ", empName=" + empName + ", gender=" + gender
				+ ", fulltimeEmployee=" + fulltimeEmployee + ", department=" + department + ", dob=" + dob + "]";
	}
	public String getFulltimeEmployee() {
		return fulltimeEmployee;
	}
	public void setFulltimeEmployee(String fulltimeEmployee) {
		this.fulltimeEmployee = fulltimeEmployee;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

}
