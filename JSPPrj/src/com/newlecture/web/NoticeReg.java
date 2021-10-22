package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/notice-reg")
public class NoticeReg extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 사용자에게 보내는 코딩 방식 설정
		response.setCharacterEncoding("UTF-8");
		
		// 클라이언트 브라우저에서 읽을때 html형식이고 UTF-8로 읽어라
		response.setContentType("text/html; charset=UTF-8"); 
		
		// 사용자가 보내는 인코딩 방식 설정
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		/* 쿼리스트링의 경우 2가지 경우가 있음
		   ?cnt=3 => "3"
		   ?cnt=  => ""
		   ?cnt   => null
		   ?      => null
		*/
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		out.println(title);
		out.println(content);
	}

}
