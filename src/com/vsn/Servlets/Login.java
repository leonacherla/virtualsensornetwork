package com.vsn.Servlets;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vsn.Storage.CacheManager;


/**
 * Servlet implementation class home
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    @Override
    public void init() {
        
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//idm.userLogin(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("email")!="" && request.getParameter("password")!=""){
			CacheManager cm = new CacheManager();
			if(cm.login(request.getParameter("email"),request.getParameter("password"))){
				response.getWriter().write("Login Successful");
			}
			else{
				response.getWriter().write("Incorrect Userid or Password.");
			}
		}
		else{
			response.getWriter().write("Incomplete Request.");
		}
	}

}
