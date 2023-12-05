package todo.p20231205;

public class Emp {
	
	private String empNum;
	private String empName;
	private String empPhone;
	private String empJoin;
	private int empSalary;
	
	Emp(){
		
	}
	
	public Emp(String empNum, String empName, String empPhone, String empJoin, int empSalary) {
		this.empNum = empNum;
		this.empName = empName;
		this.empPhone = empPhone;
		this.empJoin = empJoin;
		this.empSalary = empSalary;
	}

	public String getEmpNum() {
		return empNum;
	}

	public void setEmpNum(String empNum) {
		this.empNum = empNum;
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

	public String getEmpJoin() {
		return empJoin;
	}

	public void setEmpJoin(String empJoin) {
		this.empJoin = empJoin;
	}

	public int getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}

	void showInfo() {
		System.out.println(empNum + " " + empName + " " + empPhone + " " + empJoin + " " + empSalary);
	}
	
	
	
}//end of class
