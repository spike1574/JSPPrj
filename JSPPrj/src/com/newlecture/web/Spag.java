package com.newlecture.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/spag")
public class Spag extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = 0;
		String num_ = request.getParameter("n");
		if(num_ != null && !num_.equals(""))
			num = Integer.parseInt(num_);
		
		String result;
		
		if(num%2 != 0) { 
			result = "홀수";
		} else { 
			result = "짝수";
		}
		
		
		/*
		pageContext : 페이지내에서 공유하는 저장소
		request : forward관계에 있는 둘 사이에 공유할수 있는 저장소
		session : 세션내 공유하는 저장소
		application : 전체 공유 저장소
		*/
		
		request.setAttribute("result", result);
		
		//redirect
		//forward 공유하는게있음
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("spag.jsp");
		
		
		//request와 response가 이어짐
		dispatcher.forward(request, response);
	}
}
