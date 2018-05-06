package controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import models.BeanUser;
import services.UserService;

import static Utils.HtmlUtils.buildResponseForm;

/**
 * Servlet implementation class FormController
 */
@WebServlet("/FormController")
public class FormController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		BeanUser user = new BeanUser();
		
		try {
		
		   // Fill the bean with the request parmeters
		   BeanUtils.populate(user, request.getParameterMap());
		   
		   if (user.isComplete()) {
			   System.out.println("INSERTING USER into DB");
			   UserService.insertUser(user.getUser());
			   response.getWriter().append(buildResponseForm(UserService.getUsers()));
		   } 
		   else {
			   // Put the bean into the request as an attribute
			   request.setAttribute("user",user);
			   RequestDispatcher dispatcher = request.getRequestDispatcher("/RegisterForm.jsp");
			   dispatcher.forward(request, response);
		   }
	    } 
		catch (Exception exception) {
			exception.printStackTrace();
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
