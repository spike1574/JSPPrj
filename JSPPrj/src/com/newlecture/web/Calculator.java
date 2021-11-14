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
	// service �Լ��� ������ �˾Ƽ� doGet, doPost ȣ��
	// service ��������ִ� �������� ��� �Ǵ� ���������� �ʿ��� ���� �ۼ�
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get�� �����ö� �빮�ڷ� ������
		if(request.getMethod().equals("GET")) {
			System.out.println("GET ��û�� �Խ��ϴ�.");
		} else if (request.getMethod().equals("POST")) {
			System.out.println("POST ��û�� �Խ��ϴ�.");
		}
		
		// ���� �޼ҵ�� ��û�� ���� doGet() �Ǵ� doPost()�� ȣ����
		super.service(request, response);
		
		// 404���� : ��û�� url�� ����
		// 405���� : ��û�� url �� ������ ��û�ϰ� �ִ� �޼ҵ带 ó���� �����̾���.
		
	}
	*/
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("POST �޼ҵ尡 ȣ��Ǿ����ϴ�.");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("POST �޼ҵ尡 ȣ��Ǿ����ϴ�.");
	}

}
