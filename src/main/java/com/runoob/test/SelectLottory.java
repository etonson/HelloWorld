package com.runoob.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.jdom.Document;
import org.jdom.input.SAXBuilder;

import connsql.DBObject;
import log4j2.Log4j2;

/**
 * Servlet implementation class SelectLottory
 */
@WebServlet("/SelectLottory")
public class SelectLottory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectLottory() {
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
		response.setCharacterEncoding("GBK");
		response.getWriter().append("Served at: ").append(request.getContextPath() + "\n");
		ArrayList<String> new_Rs = new ArrayList<String>();
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\eton.lin\\eclipse-workspace\\apconf\\datasource.xml");
			Document doc = new SAXBuilder().build(new InputStreamReader(fis, "utf-8"));
			DBObject.init(doc.getRootElement(),null);
			Connection cn = DBObject.getConnection();
			Statement stmt = cn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM dbo.lottory_winning");
			while (rs.next()) {
				new_Rs.add(rs.getString("result"));
				response.getWriter().write(rs.getString("result") + "\n");
			}


		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("連線失敗！");
		}

		for (int i = 0; i < new_Rs.size(); i++) {
			LogManager.getFormatterLogger("LogName").info(new_Rs.get(i));

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}
