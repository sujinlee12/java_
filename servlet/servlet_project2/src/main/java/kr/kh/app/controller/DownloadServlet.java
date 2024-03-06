package kr.kh.app.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uploadPath = "D:\\uploads";
		//화면에서 보낸 filename을 가져옴
		String fileName = request.getParameter("filename"); //url에 찍히는 부분이 소문자
		
		//실제 파일을 가져와서 클라이언트에 보냄(화면에 보내는 코드)
		String filePath = uploadPath + fileName.replace('/',File.separatorChar); //실제 파일경로가 포함된 문자열을 만듬
		File file = new File(filePath);//위에서 만든 파일을 찾음
		try(FileInputStream fis = new FileInputStream(new File(filePath));//파일을 염
			OutputStream os = response.getOutputStream()){
			String mimeType = getServletContext().getMimeType(filePath);
			
			response.setContentType(mimeType != null ? mimeType : "application/octet-stream");
			response.setContentLength((int)(file.length()));
			response.setHeader("Content-Disposition", "attachment : filename=\""+fileName + "\"");
			
			byte[] buffer = new byte[1024 * 4];
			int readCount;
			while((readCount = fis.read(buffer)) != -1) {
				os.write(buffer, 0, readCount);
			}		
		 }
		
	}

}
