package com.newlecture.web.controller.admin.notice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@MultipartConfig(
		fileSizeThreshold = 1024*1024,
		maxFileSize = 1024*1024*50,
		maxRequestSize = 1024*1024*50*5
)
@WebServlet("/admin/board/notice/reg")
public class RegController extends HttpServlet{
	 
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request
		.getRequestDispatcher("/WEB-INF/view/admin/board/notice/reg.jsp")
		.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String isOpen = request.getParameter("open");
		
		// multi-part로 전송해서 part의 이름으로 바이너리 형식으로 value값을 가져옴
		Part filePart = request.getPart("file");
		// 바이너리value값에서 파일명을 가져옴
		String fileName = filePart.getSubmittedFileName();
		InputStream fis = filePart.getInputStream();
		
		// 파일이 저장되는 실제 경로를 나타냄
		String realPath = request.getServletContext().getRealPath("/upload");
		System.out.println(realPath);
		
		// read는 바이트씩 단위로 읽어드림 끝까지 다 읽었을경우 -1 반환 
		//int b = fis.read();
		
		// File.spparator를 사용하는 이유 : 윈도우나 유닉스 os별로  파일구분하는 (ex: '\') 구분자가 달라 separator함수 사용
		String filePath = realPath + File.separator + fileName;
		
		FileOutputStream fos = new FileOutputStream(filePath);
		
		// read()는 바이트 단위로 읽어드림 다 읽었을경우 -1 반환
		// read()는 효율적이지 못해 오버로드 함수인 byte[]로 받는 함수를 사용
		byte[] buf = new byte[1024];
		int size = 0;
		while((size = fis.read(buf)) != -1) {
			//fos.write(buf) 는 1555 바이트를 예로 든다면 한번돌고 나머지 531바이트때 문제가 생김
			//그래서 0~size만큼으로 사용
			fos.write(buf, 0, size);
		}
		
		fos.close();
		fis.close();
		
		
		
		boolean pub = false;
		if(isOpen != null) {
			pub = true;
		}
		
		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setContent(content);
		notice.setPub(pub);
		notice.setWriterId("newlec");
		
		NoticeService service = new NoticeService();
		//int result = service.insertNotice(notice);
		
		response.sendRedirect("list");
	}
}
