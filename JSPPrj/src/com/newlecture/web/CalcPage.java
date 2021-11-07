package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc3")
public class CalcPage extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, 
						HttpServletResponse response) 
						throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().printf("result is %d\n", result);
				
		<!DOCTYPE html>
		<html>
		<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style>
		input{
			width:50px;
			height:50px;
		}
		.output{
			height: 50px;
			background: #e9e9e9;
			font-size:24px;
			font-weight: bold;
			text-align: right;
			padding:0px 5px;
		}
		</style>
		</head>
		<body>
			<div>
				<form action="calc3" method="post">
					<table>
						<tr>
							<td class="output" colspan="4">0</td>
						</tr>
						<tr>
							<td><input type="submit" name="operator" value="CE"/></td>
							<td><input type="submit" name="operator" value="C"/></td>
							<td><input type="submit" name="operator" value="BS"/></td>
							<td><input type="submit" name="operator" value="¡À"/></td>
						</tr>
						<tr>
							<td><input type="submit" name="value" value="7"/></td>
							<td><input type="submit" name="value" value="8"/></td>
							<td><input type="submit" name="value" value="9"/></td>
							<td><input type="submit" name="operator" value="X"/></td>
						</tr>
						<tr>
							<td><input type="submit" name="value" value="4"/></td>
							<td><input type="submit" name="value" value="5"/></td>
							<td><input type="submit" name="value" value="6"/></td>
							<td><input type="submit" name="operator" value="-"/></td>
						</tr>
						<tr>
							<td><input type="submit" name="value" value="1"/></td>
							<td><input type="submit" name="value" value="2"/></td>
							<td><input type="submit" name="value" value="3"/></td>
							<td><input type="submit" name="operator" value="+"/></td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" name="value" value="0"/></td>
							<td><input type="submit" name="dot" value="."/></td>
							<td><input type="submit" name="operator" value="="/></td>
						</tr>
					</table>
				</form>
			</div>
		</body>
		</html>
		
	}
}
