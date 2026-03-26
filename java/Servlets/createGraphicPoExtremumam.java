package Servlets;

import jakarta.servlet.ServletException;
import EqFunctions.CreateGraphic;
import EqFunctions.GetStringEquationHtml;
import EqFunctions.PointsComparing;
import EqFunctions.SistemaUrResh;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class createGraphicPoExtremumam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int size = Integer.parseInt(request.getParameter("EquationForGraphicSize"));
		double centerCoordinateX = -Double.parseDouble(request.getParameter("CenterCoordinateX"));
		double centerCoordinateY = Double.parseDouble(request.getParameter("CenterCoordinateY"));
		double scale = 1/Double.parseDouble(request.getParameter("Scale"));
		double[][] points = null;
		
		points = PointsComparing.getPoints(request.getParameter("ExtremumsforGraphic").split(";"));

		String[][] k = SistemaUrResh.getKWithDiratives(points);
		
		out.println("<html><head>");
		out.print("<script src=\"JSFunctions.js\"></script>");
		out.println("</head>"); 
		out.print("<body onclick=\"getCoordinates(event,"+scale+"," + centerCoordinateX+","+centerCoordinateY+")\">");
		out.print(CreateGraphic.createBasicParts());
		out.print(CreateGraphic.createGraphic(k, centerCoordinateX, centerCoordinateY, scale, size));
		
		String[] pointsNames = PointsComparing.getPointsNames(request.getParameter("ExtremumsforGraphic").split(";"));
		out.print(CreateGraphic.printPoints(points, pointsNames, scale, size, centerCoordinateX, centerCoordinateY, k));
		
		
		
//		Print a center of System of coordinates if it is not in (0,0)		
		if(centerCoordinateX*scale < 65 && centerCoordinateX*scale > -65 && centerCoordinateY*scale < 32 && centerCoordinateY*scale > -32) {
			out.print("<div style=\"position:absolute; background-color: grey; width: 5px; height:5px; top: "+(centerCoordinateY*scale*20 + 318)+"px; left:"+ (centerCoordinateX*20*scale + 658)+"px; border-radius: 50%;\"></div>");
		}
		out.print("<div style=\"position: absolute; width: 300px; height: 160px; top: 470px; left: 1000; background-color: white;\">"
				+ GetStringEquationHtml.getEquationHTML(k)
				+ "</br>"
				+ "<div align=\"center\">"
				+ "<div>Coordinate X: <span id=\"coordinateX\"></span></div>"
				+ "</br>"
				+ "<div>Coordinate Y: <span id=\"coordinateY\"></span></div>"
				+ "</div>"
				+ "</div>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
