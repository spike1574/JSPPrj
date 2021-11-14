package com.newlecture.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculator")
public class Calculator extends HttpServlet{
	
	/*
	// service 함수가 없으면 알아서 doGet, doPost 호출
	// service 라우팅해주는 느낌으로 사용 또는 공통적으로 필요한 내용 작성
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get을 가져올때 대문자로 가져옴
		if(request.getMethod().equals("GET")) {
			System.out.println("GET 요청이 왔습니다.");
		} else if (request.getMethod().equals("POST")) {
			System.out.println("POST 요청이 왔습니다.");
		}
		
		// 서비스 메소드는 요청에 따른 doGet() 또는 doPost()를 호출함
		super.service(request, response);
		
		// 404오류 : 요청한 url이 없다
		// 405오류 : 요청한 url 은 있지만 요청하고 있는 메소드를 처리할 로직이없다.
		
	}
	*/
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("POST 메소드가 호출되었씁니다.");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("POST 메소드가 호출되었씁니다.");
	}

}
