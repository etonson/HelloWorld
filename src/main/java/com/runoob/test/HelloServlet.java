package com.runoob.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connsql.LottorySQL;

/**
 * Servlet implementation class HelloServlet
 */

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HelloServlet() {
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
		response.getWriter().append("測試");
		response.getWriter().write("測試");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		int[] UserNumber = new int[6];
		String firstNumber = request.getParameter("firstNumber");
		UserNumber[0] = Integer.parseInt(firstNumber);
		String secondNumber = request.getParameter("secondNumber");
		UserNumber[1] = Integer.parseInt(secondNumber);
		String thirdNumber = request.getParameter("thirdNumber");
		UserNumber[2] = Integer.parseInt(thirdNumber);
		String forthNumber = request.getParameter("forthNumber");
		UserNumber[3] = Integer.parseInt(forthNumber);
		String fivethNumber = request.getParameter("fivethNumber");
		UserNumber[4] = Integer.parseInt(fivethNumber);
		String sixthNumber = request.getParameter("sixthNumber");
		UserNumber[5] = Integer.parseInt(sixthNumber);

		List<Integer> SixNumber = new ArrayList<>();
		SixNumber = lot(1, 49);

		List<Integer> winning_the_lottery = new ArrayList<>();
		winning_the_lottery = result(SixNumber, UserNumber);
		System.out.println("中獎號碼為:" + winning_the_lottery);
		System.out.println("中獎數為:" + winning_the_lottery.size());

		LottorySQL a = new LottorySQL("sa", "Aa123456");
		String SixNumberStr = a.ArrlisttoStr(SixNumber);
		String UserNumberSrt = a.ArrtoStr(UserNumber);
		String winning_the_lotteryStr = a.ArrlisttoStr(winning_the_lottery);
		a.lottoryResult(SixNumberStr, UserNumberSrt, winning_the_lotteryStr);
		request.getRequestDispatcher("/Select.jsp").forward(request, response);
	}

//中獎號碼
	private List<Integer> lot(int min, int Max) {
//		int[] lottory = new int[Max + 1];
		List<Integer> new_lottory = new ArrayList<>();
		List<Integer> final_lottory = new ArrayList<>();

		for (int i = min; i <= Max; i++) {
//			lottory[i] = i;
			new_lottory.add(i);
		}

		for (int j = Max; j >= 44; j--) {
			int r = ((int) (Math.random() * j));
			final_lottory.add(new_lottory.get(r));
			new_lottory.remove(r);
			System.out.println(final_lottory);
		}
		return final_lottory;
	}

	private List<Integer> result(List<Integer> sixNumber, int[] userNumber) {

		List<Integer> result_number = new ArrayList<>();
		for (int i = 0; i < userNumber.length; i++) {
			if (sixNumber.contains(userNumber[i])) {
				result_number.add(userNumber[i]);
			}
		}
		return result_number;
	}
	
	public static void main(String[] args) {
		System.out.println((int) (Math.random() * 4));
		
	}
}
