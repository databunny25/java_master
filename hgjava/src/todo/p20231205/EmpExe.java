package todo.p20231205;

import java.util.ArrayList;

public class EmpExe {
	
		private ArrayList<Emp> employer;
		
		EmpExe(){
			employer = new ArrayList<Emp>();
			employer.add(new Emp("A001", "도레미", "010-1234-1234", "2023-08-01", 3000000));
		}
		
		//1. 등록		
		boolean addEmp(Emp emp) {
			return employer.add(emp);
		}
		
		//2. 목록		
		ArrayList<Emp> getEmpList(){
			return employer;
		}
		
		//3. 수정(급여)
		boolean modifySalary(String empNum, int empSalary) {
			for(Emp emp:employer) {
				if(emp.getEmpNum().equals(empNum)) {
					emp.setEmpSalary(empSalary);
					return true;
				}
			}
			return false;
		}
				
		//4. 삭제
		boolean removeEmp(String empNum) {
			for(int i=0; i<employer.size(); i++) {
				if(employer.get(i) != null && employer.get(i).getEmpNum().equals(empNum)) {
					employer.remove(i);
					return true;
				}
			}
			return false;
		}
		//5. 조회(조건:입사일자)
		Emp getEmp(String join) {
			for(int i=0; i<employer.size(); i++) {
				if(employer.get(i) !=null && employer.get(i).getEmpJoin().equals(join)){
					//출력해보자ㅠㅠㅠㅠ
				}
			}
			return null;
		}
}
