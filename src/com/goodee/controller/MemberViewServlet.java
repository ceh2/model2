package com.goodee.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goodee.dto.MemberVO;
import com.goodee.dto.UserPointLog;

/**
 * Servlet implementation class MemberViewServlet
 */
@WebServlet({"/MemberViewServlet", "/memberview.do"})
public class MemberViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
	    System.out.println(uid + "의 회원정보를 얻어와서 dispatcher 하면됨");
	     
	    try {
	    	ActionFactory af = ActionFactory.getInstance();
	    	MemberVO member = af.getMember(uid);
	    	
	    	// 회원의 포인트 내역
	    	List<UserPointLog> pointLog = af.getPointLog(uid);
	    	
	    	
	    	request.setAttribute("member", member);
	    	request.setAttribute("pointLog", pointLog);
	    	
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("admin/manageMember.jsp");
	    	dispatcher.forward(request, response);
	    	
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
