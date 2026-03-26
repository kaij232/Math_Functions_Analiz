package Servlets;

import II_Functions.IICreate;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class SaveIIParameters extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		@SuppressWarnings("resource")
		BufferedReader rd = new BufferedReader(new FileReader(new File("D:\\DevelopingPrograms\\eclipse\\workspace\\MathAndDataSciensTools.web\\src\\main\\java\\II_Functions\\Binder.txt")));
		String params = rd.readLine();
		rd.close();
		
		BufferedWriter br = new BufferedWriter(new FileWriter(new File(request.getParameter("Path to Parameters"))));
		br.write(params);
		br.flush();
		br.close();
//		int[] IIPower = new int[params.length];
//		for(int lay = 0; lay < params.length; lay++) {
//			IIPower[lay] = params[lay].split(",").length;
//		}
//		
//		
//		IICreate II = new IICreate(IIPower);
//		System.out.println("huihkl" + request.getParameter("Path to Parameters"));
//		II.setParameters("D:\\DevelopingPrograms\\eclipse\\workspace\\MathAndDataSciensTools.web\\src\\main\\java\\II_Functions\\Binder.txt");
//		if(request.getParameter("Path to Parameters").equals("")) {
//			II.saveParameters("D:\\DevelopingPrograms\\eclipse\\workspace\\MathAndDataSciensTools.web\\src\\main\\java\\II_Functions\\ParemetersFolder\\MainParameters.txt");
//		}else {
//			II.saveParameters(request.getParameter("Path to Parameters"));
//		}
		
		response.sendRedirect("/MathAndDataSciensTools.web/PatternII/IIParameters.html?");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
