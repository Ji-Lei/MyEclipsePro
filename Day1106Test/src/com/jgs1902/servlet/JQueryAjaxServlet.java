package com.jgs1902.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * Servlet implementation class JQueryAjaxServlet
 */
@WebServlet("/mobile")
public class JQueryAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JQueryAjaxServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		
		String mobile=request.getParameter("mobile");
		
		PrintWriter out = response.getWriter();
		
//		String[] str= {"1","2","3","4","5"};
		
		
		if(("17754057991").equals(mobile)) {
			out.write("true");
		}else {
			out.write(mobile);
		}
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
