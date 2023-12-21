package common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyInfoServlet
 */
@WebServlet("/MyInfoServlet")
public class MyInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet() 기본생성자...
     */
    public MyInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) 
	 */
    //deGet메소드...요청값request 응답값 response받음, "Served at: 프로젝트 경로" 가 출력됨!
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=utf-8"); //content 타입 : txt, html, json (컨텐트의 타입 지정)
		
		// 파라미터 확인
		// ?sno=23-010&sname=황철수&escore=80&mscore=85
		String sno = request.getParameter("sno");
		String sname = request.getParameter("sname");
		String escore = request.getParameter("escore");
		String mscore = request.getParameter("mscore");
		
		System.out.println("sno: " + sno + ",snmae: " + sname + ",escore: "+ escore + ",mscore: " + mscore);
		
		// db 저장
		Student std = new Student(sno, sname, Integer.parseInt(escore), Integer.parseInt(mscore));
		StudentDAO dao = new StudentDAO();
		boolean done = dao.addStudent(std);
		
		
		PrintWriter out= response.getWriter();
		//out.append("Served at: ").append(request.getContextPath());
		out.println("<h3>Welcome Servlet, 안녕...!</h3>");
		out.println("<a href='index.html'>인덱스 이동<a>");
		
		if(done) {
			out.println("<script>alert('OK'); location.href='student/studentList.jsp'; </script>");
		}else {
			out.println("<script>alert('Fail'); location.href='index.html'; </script>");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) doPost는 doGet을 호출하네...
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
