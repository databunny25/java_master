package com.yedam.board.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class BoardFormControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		RequestDispatcher rd =  req.getRequestDispatcher("WEB-INF/board/addBoardForm.jsp");
		try {
			rd.forward(req,  resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		} 
		
		
	}

}
