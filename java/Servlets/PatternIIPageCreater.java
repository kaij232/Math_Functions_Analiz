package Servlets;

import II_Functions.IICreate;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class PatternIIPageCreater extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print("<script src=\"JSFunctions.js\"></script>");
		
		String[] LayersPowers_ = request.getParameter("LayersPowers").split(" ");
		int[] LayersPowers = new int[LayersPowers_.length];
		for(int lay = 0; lay < LayersPowers.length; lay++) {
			LayersPowers[lay] = Integer.parseInt(LayersPowers_[lay]);
		}
		
		String[] inputs_ = request.getParameter("Input").split(" ");
		double[] inputs = new double[inputs_.length];
		System.out.print("Inputs: ");
		for(int ney = 0; ney < inputs_.length; ney++) {
			System.out.print(inputs_[ney]+ " ");
			inputs[ney] = Double.parseDouble(inputs_[ney]);
		}
		

		IICreate II = new IICreate(LayersPowers);
		
//		if(request.getParameter("dataType").equals("Write data")) {
//			String Data = request.getParameter("Write data");
//			Data = Data.replace(" -- ", "_");
//			Data = Data.replace(" ; ",";");
//			Data = Data.replace(", ", ",");
//			if((Data.charAt(Data.length()-1)+"").equals(";")) {
//				Data = Data.substring(0, Data.length()-1);
//			}
//			II.setDataS(Data);
//			
//		}else if(request.getParameter("dataType").equals("Path to data")) {
//			II.setDataF(request.getParameter("Path to data"));
//		}else if(request.getParameter("dataType").equals("Path to Parameters")) {
//			II.setParameters(request.getParameter("Path to Parameters"));
//		}
		if(request.getParameter("dataType").equals("Path to Parameters")) {

				II.setParameters(request.getParameter("Path to Parameters"));	
			
		}else {
			if(request.getParameter("dataType").equals("Write data")) {
			String Data = request.getParameter("Write data");
			Data = Data.replace(" -- ", "_");
			Data = Data.replace(" ; ",";");
			Data = Data.replace(", ", ",");
			if((Data.charAt(Data.length()-1)+"").equals(";")) {
				Data = Data.substring(0, Data.length()-1);
			}
			II.setDataS(Data);
			
		}else if(request.getParameter("dataType").equals("Path to data")) {

			II.setDataF(request.getParameter("Path to data"));
			
		}
		
			try {
				out.println("Studing has been started!<br/>");
		
		String[] study = request.getParameter("Studing Parameters").split(", ");
		for(int stuNum = 0; stuNum < study.length; stuNum++) {
			II.Study(Integer.parseInt(study[stuNum].split(" ")[0]), Double.parseDouble(study[stuNum].split(" ")[1]));
		}
		
		out.println("Studing has been finished!<br/>");
		}catch(NullPointerException e) {}
			
		}

//		try {
//				out.println("Studing has been started!<br/>");
//		
//		String[] study = request.getParameter("Studing Parameters").split(", ");
//		for(int stuNum = 0; stuNum < study.length; stuNum++) {
//			II.Study(Integer.parseInt(study[stuNum].split(" ")[1]), Double.parseDouble(study[stuNum].split(" ")[0]));
//		}
//		
//		out.println("Studing has been finished!<br/>");
//		}catch(java.lang.NullPointerException e) {}

		
		out.println(II.getResult(inputs));
		
		II.saveParameters("D:\\DevelopingPrograms\\eclipse\\workspace\\MathAndDataSciensTools.web\\src\\main\\java\\II_Functions\\Binder.txt");
		
		
		out.println("<form action=\"/MathAndDataSciensTools.web/SaveIIParameters\" method=\"get\">" 
				+ "<input id=\"fileName\" type=\"file\" onchange=\"setPath()\">\r\n"
				+ "<br/>\r\n"
				+ "<textarea id=\"PathArea\"name=\"Path to Parameters\" >D:\\DevelopingPrograms\\eclipse\\workspace\\MathAndDataSciensTools.web\\src\\main\\java\\II_Functions\\ParemetersFolder\\MainParameters.txt</textarea>"
				+ "</br>"
				+ "<input type=\"submit\" value=\"submit\">"
				+ "</form>");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
