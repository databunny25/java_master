package com.yedam;

public class Employee {
	private String empCode;
	private String empName;
	private String empPhone;
	private String empDate;
	private int empSalary;

	Employee() {

	}

	public Employee(String empCode, String empName, String empPhone, String empDate, int Salary) {
		this.empCode = empCode;
		this.empName = empName;
		this.empPhone = empPhone;
		this.empDate = empDate;
		this.empSalary = empSalary;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpPhone() {
		return empPhone;
	}

	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}

	public String getEmpDate() {
		return empDate;
	}

	public void setEmpDate(String empDate) {
		this.empDate = empDate;
	}

	public int getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}

	void showInfo() {
		System.out.println(empCode + " " + empName + " " + empPhone);
	}
	
	void showDateInfo() {
		System.out.println(empCode + " " + empName + " " + empDate);
	}
	

}// end of class
