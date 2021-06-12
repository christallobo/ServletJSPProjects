package com.fileupload;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
		try {
			List<FileItem> multiFiles = sf.parseRequest(request);

			for (FileItem item : multiFiles) {
				item.write(new File("E:/_PROJECT PRACTICE/ServletJSP/FileUploadDemo/images/" + item.getName()));
			}
			
			System.out.println("file uploaded");
			PrintWriter out=response.getWriter();
			out.println("file uploaded");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
