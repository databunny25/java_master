package remind6;
//학생정보저장 => Student.java
// 학생번호(23-001, 23-002) studNo (getStuNo)
// 학생이름(홍길동, 박씨) 
// 영어
// 수학
// method: showInfo() 학생이름, 영어, 수학 

public class Student {
	// 속성(필드)
	private String no;
	private String name;
	private int eng;
	private int mat;
	
	//생성자
	Student(){
		
	}

	public Student(String no, String name, int eng, int mat) {
		
		this.no = no;
		this.name = name;
		this.eng = eng;
		this.mat = mat;
	}
	
	//기능 (메소드)
	void showInfo() {
		System.out.println("학생 이름은 " + name + ", 영어 점수는 " + eng + ", 수학 점수는 " + mat + "입니다.");
	}

	//setter

	public void setNo(String no) {
		this.no = no;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}


	
	//getter
	
	String getNo() {
		return no;
	}

	String getName() {
		return name;
	}

	int getEng() {
		return eng;
	}

	int getMat() {
		return mat;
	}
	
	
	
	
	

} //end of class
