package Servlets;

import java.io.IOException;
import EqFunctions.GetStringEquationHtml;
import java.io.PrintWriter;
import EqFunctions.PointsComparing;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import EqFunctions.CreateGraphic;
import EqFunctions.SistemaUrResh;

public class GraphicPoTochkamCreater extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		int size = Integer.parseInt(req.getParameter("EquationForGraphicSize"));
		double centerCoordinateX = -Double.parseDouble(req.getParameter("CenterCoordinateX"));
		double centerCoordinateY = Double.parseDouble(req.getParameter("CenterCoordinateY"));
		double scale = 1/Double.parseDouble(req.getParameter("Scale"));
		double[][] points = null;
//		try {
		points = PointsComparing.getPoints(req.getParameter("TochkiforGraphic").split(";"));
//		}catch(java.lang.ArrayIndexOutOfBoundsException e) {
//			
//		}
		String[] pointsNames = PointsComparing.getPointsNames(req.getParameter("TochkiforGraphic").split(";"));
//		System.out.println(req.getParameter("TochkiforGraphic").split(";")[0] + "  " + req.getParameter("TochkiforGraphic").split(";")[1]);
		out.println("<html><head>");
		out.print("<script src=\"JSFunctions.js\"></script>");
		out.println("</head>"); 
		out.print("<body onclick=\"getCoordinates(event,"+scale+"," + centerCoordinateX+","+centerCoordinateY+")\">");
		out.print(CreateGraphic.createBasicParts());

			String[][] k = SistemaUrResh.getK(points);
			
			out.print(CreateGraphic.createGraphic(k, centerCoordinateX, centerCoordinateY, scale, size));
			out.println(CreateGraphic.printPoints(points, pointsNames, scale, size, centerCoordinateX, centerCoordinateY, k));
			
//			Print a center of System of coordinates if it is not in (0,0)
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
			
			out.print("</body>");
			out.print("</html>");
	}
	
 	}