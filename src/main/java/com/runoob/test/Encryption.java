package com.runoob.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cryp.Cryp;

/**
 * Servlet implementation class Encryption
 */
@WebServlet("/Encryption")
public class Encryption extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Encryption() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setCharacterEncoding("UTF-8");
		
		Cryp exCryp = new Cryp();
		String OriginWord = request.getParameter("OriginWord");
	    String encryptedString = exCryp.AESencrypt(OriginWord,request.getParameter("SECRET_KEY"));
	    String decryptedString = exCryp.AESdecrypt(encryptedString,request.getParameter("SECRET_KEY"));
	    String md5 = exCryp.getMD5(OriginWord);
	    String SH4AE = exCryp.getSHA256StrJava(OriginWord);
	    response.getWriter().write("ORIGIN WORD:    "+OriginWord + "   \n");
	    response.getWriter().write("AES256 ENCYPTEDSTRING WORD ("+encryptedString + ")  \n");
	    response.getWriter().write("AES256 DecryptedString WORD ("+decryptedString + ")\n");
	    response.getWriter().write("MD5 HASH("+md5 + ")\n");
	    response.getWriter().write("SHA256 ENCYPTEDSTRING WORD ("+SH4AE + ")  \n");
	}

}
