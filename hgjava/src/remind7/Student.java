package remind7;
//학생정보저장 => Student.java
//학생번호(23-001, 23-002) studNo (getStuNo)
//학생이름(홍길동, 박씨) 
//영어
//수학
//method: showInfo() 학생이름, 영어, 수학 
public class Student {

	//remind7의 student를 컬렉션으로 만들어보기!
	private String studentNumber;
	private String studentName;
	private int englishScore;
	private int mathmaticScore;
	
	//생성자정의
	Student(){
		
	}
	
	public Student(String student) {
		this.studentNumber = studentNumber;
		this.studentName = studentName;
		this.englishScore = englishScore;
		this.mathmaticScore = mathmaticScore;
	}

	//getter , setter
	
	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getEnglishScore() {
		return englishScore;
	}

	public void setEnglishScore(int englishScore) {
		this.englishScore = englishScore;
	}

	public int getMathmaticScore() {
		return mathmaticScore;
	}

	public void setMathmaticScore(int mathmaticScore) {
		this.mathmaticScore = mathmaticScore;
	}
	
	
	
	
} //end of class
