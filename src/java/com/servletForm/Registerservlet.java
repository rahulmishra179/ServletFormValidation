package com.servletForm;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

public class Registerservlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
//        out.println("<h1>Welcome to my servlet</h1>");
//        out.println("<h1>this is my servlet get method</h1>");
        String name=request.getParameter("user_name");
        String password=request.getParameter("user_password");
        String Email=request.getParameter("user_email");
        String gender=request.getParameter("user_gender");
        String course=request.getParameter("user_course");
        String cond=request.getParameter("condition");
        
        if(cond!=null){
            if(cond.equals("checked")){
                out.println("<h2> Name : "+ name+"<h2>");
                out.println("<h2> Password : "+ password+"<h2>");
                out.println("<h2> Email : "+ Email+"<h2>");
                out.println("<h2> Gender : "+ gender+"<h2>");
                out.println("<h2> Course : "+ course+"<h2>");
                out.println("<h2> Cond : "+ cond+"<h2>");
                
//                insert data to jdbc
                RequestDispatcher rd=request.getRequestDispatcher("success");
                rd.forward(request, response);
                
            }
        
        }
        else{
            out.println("<h2>You are not accepted term and condition<h2>");
            RequestDispatcher rd=request.getRequestDispatcher("index.html");
            rd.include(request, response);
        }

    }

}
