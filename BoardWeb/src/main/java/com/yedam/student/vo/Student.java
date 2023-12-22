package com.yedam.student.vo;
//학생정보저장 => Student.java
// 학생번호(23-001, 23-002) studNo (getStuNo)
// 학생이름(홍길동, 박씨) 
// 영어
// 수학
// method: showInfo() 학생이름, 영어, 수학 

public class Student {
	// 속성(필드)
	private String studentNumber; // 오라클에서...Student_Number 할거임 자바에서도 바꾸자!
	private String studentName;
	private int englishScore;
	private int mathmaticScore;
	
	//생성자
	public Student(){
		
	}

	public Student(String studentNumber, String studentName, int englishScore, int mathmaticScore) {		
		this.studentNumber = studentNumber;
		this.studentName = studentName;
		this.englishScore = englishScore;
		this.mathmaticScore = mathmaticScore;
	}
	
	//기능 (메소드)
	public void showInfo() {
		System.out.println("학생 이름은 " + studentName + ", 영어 점수는 " + englishScore + ", 수학 점수는 " + mathmaticScore + "입니다.");
	}

	
	//setter
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public void setEnglishScore(int englishScore) {
		this.englishScore = englishScore;
	}

	public void setMathmaticScore(int mathmaticScore) {
		this.mathmaticScore = mathmaticScore;
	}

	
	//getter
	public String getStudentNumber() {
		return studentNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public int getEnglishScore() {
		return englishScore;
	}

	public int getMathmaticScore() {
		return mathmaticScore;
	}

	


	
	//getter
	
	
	
	

} //end of class
