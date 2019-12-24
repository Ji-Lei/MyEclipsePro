package com.jgs1902.servlet;

import com.jgs1902.jdbctest.Util;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class RegiServlet extends HttpServlet {
    private static final long serialVersionUID=1L;

    public RegiServlet(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//请求格式
        response.setCharacterEncoding("utf-8");//响应编码
        response.setContentType("text/html; charset=utf-8");//响应类型

        String userid=request.getParameter("userid");
        String pwd=request.getParameter("password");
        String email=request.getParameter("email");
        String name=request.getParameter("name");
        String sex=request.getParameter("sex");
        String hobbies=request.getParameter("hobbies");

        PrintWriter out = response.getWriter();

        String uname=Util.getName(userid);
        
        request.setAttribute("name",uname);
        String user= Util.getUserid(userid);
        String uemail=Util.getEmail(email);
        if(user!=null){
            out.write("true");
        }else if(uemail!=null){
            out.write("exit");
        }else {
            out.write("false");//servlet以输出流的形式将信息返回给客户端
            Util.insertRegi(userid,pwd,email,name,sex,hobbies);
        }
        
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
