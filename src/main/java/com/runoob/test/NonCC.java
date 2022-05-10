package com.runoob.test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cryp.Cryp;

/**
 * Servlet implementation class NonCC
 */
@WebServlet("/NonCC")
public class NonCC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NonCC() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String[] PayInformation = new String[6];
		
		String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		
		String amount = String.valueOf(request.getParameter("amount"));
		PayInformation[0]="amount="+amount;
				
		String merchantnumber = request.getParameter("merchantnumber");
		PayInformation[1] = "merchantnumber="+merchantnumber;
		
		String ordernumber = request.getParameter("ordernumber");
		PayInformation[2] = "ordernumber="+(ordernumber);
		
		String paymenttype = request.getParameter("paymenttype");
		PayInformation[3] = "paymenttype="+(paymenttype);
		
		String paytitle = request.getParameter("paytitle");
		PayInformation[4] = "paytitle="+(paytitle);
		
		PayInformation[5]  = "timestamp="+time;
		
		String InformationStr;
		InformationStr = String.join("&", PayInformation);
		
		Cryp sha= new Cryp();
		String InformationStrSHA = sha.getSHA256StrJava((InformationStr+"RYEGS53726"));
		
		request.setAttribute("merchantnumber", merchantnumber);
		request.setAttribute("amount", amount);
		request.setAttribute("ordernumber", ordernumber);
		request.setAttribute("paytitle", paytitle);
		request.setAttribute("timestamp", time);
		request.setAttribute("checksum", InformationStrSHA);
		request.setAttribute("paymenttype", paymenttype);
		request.getRequestDispatcher("/NonCCRedirect.jsp").forward(request, response);
		 
	}

}
