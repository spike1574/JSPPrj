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
		
		// multi-part�� �����ؼ� part�� �̸����� ���̳ʸ� �������� value���� ������
		Part filePart = request.getPart("file");
		// ���̳ʸ�value������ ���ϸ��� ������
		String fileName = filePart.getSubmittedFileName();
		InputStream fis = filePart.getInputStream();
		
		// ������ ����Ǵ� ���� ��θ� ��Ÿ��
		String realPath = request.getServletContext().getRealPath("/upload");
		System.out.println(realPath);
		
		// read�� ����Ʈ�� ������ �о�帲 ������ �� �о������ -1 ��ȯ 
		//int b = fis.read();
		
		// File.spparator�� ����ϴ� ���� : �����쳪 ���н� os����  ���ϱ����ϴ� (ex: '\') �����ڰ� �޶� separator�Լ� ���
		String filePath = realPath + File.separator + fileName;
		
		FileOutputStream fos = new FileOutputStream(filePath);
		
		// read()�� ����Ʈ ������ �о�帲 �� �о������ -1 ��ȯ
		// read()�� ȿ�������� ���� �����ε� �Լ��� byte[]�� �޴� �Լ��� ���
		byte[] buf = new byte[1024];
		int size = 0;
		while((size = fis.read(buf)) != -1) {
			//fos.write(buf) �� 1555 ����Ʈ�� ���� ��ٸ� �ѹ����� ������ 531����Ʈ�� ������ ����
			//�׷��� 0~size��ŭ���� ���
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
