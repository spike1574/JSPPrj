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
		
		// ����ڿ��� ������ �ڵ� ��� ����
		response.setCharacterEncoding("UTF-8");
		
		// Ŭ���̾�Ʈ ���������� ������ html�����̰� UTF-8�� �о��
		response.setContentType("text/html; charset=UTF-8"); 
		
		// ����ڰ� ������ ���ڵ� ��� ����
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		/* ������Ʈ���� ��� 2���� ��찡 ����
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
