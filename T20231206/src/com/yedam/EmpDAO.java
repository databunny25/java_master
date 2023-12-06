package com.yedam;

import java.util.ArrayList;

public class EmpDAO {

	private ArrayList<Employee> employees;

	EmpDAO() {
		employees = new ArrayList<Employee>();
		employees.add(new Employee("23-11", "홍길동", "943-1234", "2020-10-01", 300));
		employees.add(new Employee("23-12", "김길동", "943-1244", "2020-12-07", 500));
		employees.add(new Employee("23-13", "홍길동", "943-1254", "2020-12-08", 500));
		employees.add(new Employee("23-19", "김신입", "943-1251", "2023-12-01", 200));
		employees.add(new Employee("23-20", "박신입", "943-1252", "2023-12-01", 200));
		employees.add(new Employee("23-21", "최신입", "943-1253", "2023-12-01", 200));
	}

	// 1. 등록
	boolean addEmp(Employee employee) {
		return employees.add(employee);
	}

	// 2. 목록
	ArrayList<Employee> getEmployeeList() {
		return employees;
	}

	// 3. 수정(급여)
	boolean modifyEmployee(String code, int salary) {
		for (Employee emp : employees) {
			if (emp.getEmpCode().equals(code)) {
				emp.setEmpSalary(salary);
				return true;
			}
		}
		return false;
	}

	// 4. 삭제
	boolean removeEmployee(String code) {
		for (int i = 0; i < employees.size(); i++) {
			if (employees.get(i) != null && employees.get(i).getEmpCode().equals(code)) {
				employees.remove(i);
				return true;
			}
		}
		return false;
	}

	// 5. 조회(조건:입사일자)
	
		ArrayList<Employee> getDateList(String date) {
			ArrayList<Employee> dateList = new ArrayList<>();
			for(int i=0; i<employees.size();i++) {
				if(employees.get(i).getEmpDate().equals(date)) {
					dateList.add(employees.get(i));					
				}					
			}
			return dateList;
		}
	
}
