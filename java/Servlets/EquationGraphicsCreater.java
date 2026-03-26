package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import EqFunctions.SplitToXes;
import EqFunctions.CreateGraphic;
import EqFunctions.GetStringEquationHtml;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EquationGraphicsCreater extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String eq = req.getParameter("EquationForGraphic");
		int size = Integer.parseInt(req.getParameter("EquationForGraphicSize"));
		double centerCoordinateX = -Double.parseDouble(req.getParameter("CenterCoordinateX"));
		double centerCoordinateY = Double.parseDouble(req.getParameter("CenterCoordinateY"));
		double scale = 1/Double.parseDouble(req.getParameter("Scale"));
		
		
		out.println("<html><head>");
		out.print("<script src=\"JSFunctions.js\"></script>");
		out.println("</head>");
		out.print("<body onclick=\"getCoordinates(event,"+scale+"," + centerCoordinateX+","+centerCoordinateY+")\">");
		out.print(CreateGraphic.createBasicParts());
		
		
		
//		out.println("<div style=\"position: absolute; width: 1px; height: 100%; left: 660px; top: 0px; background: black;\"></div>\r\n"
//				+ "	<div style=\"position:absolute; background-color: black; width: 100%; height: 1px; top: 320px; left:0px; \"></div>\r\n"
//				+ "	<div style=\"position:absolute; background-color: black; width: 5px; height:5px; top: 318px; left:658px; border-radius: 50%;\"></div>");
////		if(centerCoordinateX < 65 && centerCoordinateX > -65 && centerCoordinateY < 32 && centerCoordinateY > -32) {
////			out.print("<div style=\"position:absolute; background-color: grey; width: 5px; height:5px; top: "+(centerCoordinateY*20 + 318)+"px; left:"+ (centerCoordinateX*20 + 658)+"px; border-radius: 50%;\"></div>");
////		}
//		for(int x = 20; 1310-x > 20; x+= 20){
////			if( x != 655){
//			out.println("<div style=\"position: absolute; background-color: black; width: 1px; height: 9px; top: 316px; left: " + (x) + "px;\"></div>");
//			out.println("<div style=\"position: absolute; width: 1px; height: 100%; left: " + (x) + "px; top: 0px; background: black; opacity: 0.2;\"></div>");
////		}
//		}
//		for(int y = 20; 644-y >13; y+=20){
////			if( y != 321){
//			out.println("<div style=\"position: absolute; background-color: black; width: 9px; height: 1px; top: " +(y) + "px; left:656px;\"></div>");
//			out.println("	<div style=\"position:absolute; background-color: black; width: 100%; height: 1px; top: " + (y) + "px; left:0px; opacity: 0.2; \"></div>");
////		}
//		}

		
		
		
		
		
//		int plusesNum = 0;
//		int minusesNum = 0;
//		int multiplicatsNum = 0;
//		
//		for(int i = 0; i < eqs.length; i++){
//			eqs[i] = eqc[i] + "";
//			if(eqs[i].equals(" ")){
//				eqs[i] = "" ;
//			}
//			if(eqs[i].equals("+")){
//				plusesNum++;
//			}else if(eqs[i].equals("-")){
//				minusesNum++;
//			}else if(eqs[i].equals("*")){
//				multiplicatsNum++;
//			}
//		}
//		
//		
//		// slozhenie
//		eq = "";
//		for(int i = 0; i < eqs.length; i++){
//		if(eqs[i].equals("+")){
//			String fs = "";
//			double fsD = 0;
//			String sc = "";
//			double scD = 0;
//			int Fid = 0;
//			
//			
//			// vichislenie pervogo slagaemogo
//			for(int j = i-1; j >= 0; j--){
//				if(eqs[j].equals(".")){
//				}else{
//				try{
//					Double.parseDouble(eqs[j]);
//					
//				}catch(Error e){ // error when cant parse
//					Fid = (j+1);
//					break;
//				}
//				}
//			}
//			for(int j = Fid; j < i; j++){
//				fs = fs + eqs[j];
//			}
//		
//		
//		
//		// vichislenie vtorogo slagaemogo
//		for(int j = i+1; j < eqs.length; j++){
//			if(eqs[j].equals(".")){
//			}else{
//			try{
//				Double.parseDouble(eqs[j]);
//				sc = sc + eqs[j];
//			}catch(Error e){ // error when cant parse
//				break;
//			}
//			}
//		}
//		fsD = Double.parseDouble(fs);
//		scD = Double.parseDouble(sc);
//		eq = eq + (fsD + scD);
//		}else{
//			eq = eq + eqs[i];
//		}
//		}
//		eqc = eq.toCharArray();
//		eqs = new String[eqc.length];
		
		
		
		
		
		String[][] k = SplitToXes.SplitToXesKoifcent(eq);
//		for(String[] i :k) {
//			System.out.println("pow: " + i[0] + ";		koef: " + i[1]);
//		}
		
		
		
		
		
		
//		for(float x = -33f; x < 33; x += 0.05) {
//			double nres = 0;
//			for(int i = 0; i< k.length;i++) {
//				nres += (double)(Double.parseDouble(k[i][1]) * (double)Math.pow(x, Double.parseDouble(k[i][0])));
//			}
//			double yres = 16;
//			for(float y = 15.5f; y > -15.5; y-= 0.05 ) {
//				if(Math.abs(nres-y) < Math.abs(nres-yres)) {
//					yres = y; 
//				}
//			}
//			System.out.println("x: " + x + "; 		nres: " + nres + ";      y: " + yres);
//			if((x<0)&&(yres>0)) {
//			out.println("<div style=\"position: absolute; background-color: black; width: 1px; height: 1px; top: " + (yres)*20 + "px; left:" + (33+x)*20 + "px;\"></div>");
//			}else if((x>0)&&(yres>0)){
//				out.println("<div style=\"position: absolute; background-color: black; width: 1px; height: 1px; top: " + (yres)*20  + "px; left:" + x*20 + 660 + "px;\"></div>");
//			}else if((x<0)&&(yres<0)) {
//				out.println("<div style=\"position: absolute; background-color: black; width: 1px; height: 1px; top: " + (-yres)*20 + 310  + "px; left:" + (33+x)*20 + "px;\"></div>");
//			}else if((x>0)&&(yres<0)) {
//				out.println("<div style=\"position: absolute; background-color: black; width: 1px; height: 1px; top: " + (-yres)*20 +310  + "px; left:" + x*20 + 660 + "px;\"></div>");
//			}
//		}
		
	
		
		
	
		
//	for(double x = (-33 + centerCoordinateX)*scale; x < (33 + centerCoordinateX)*scale; x += 0.05*scale) {
////		x = Okrugl.okruglAfterToch(x, 2);
//		double nres = 0;
//		for(int i = 0; i< k.length;i++) {
//			nres += (double)(Double.parseDouble(k[i][1]) * (double)Math.pow(x, Double.parseDouble(k[i][0])));
//		}
//		nres*=scale;
//		nres -= centerCoordinateY*scale;
//		if(nres >16 || nres < -16 ) {
//			continue;
//		}
//		double yres = nres;
//		
//		if(scale>=3 && x%(0.05*scale) == 0) {
//		System.out.println("x: " + x + "; 		nres: " + nres + ";      y: " + yres);
//		}
//
//		out.println("<div style=\"position: absolute; background-color: black; width: "+size+ "px; height: "+size+"px; top: " + Math.abs(yres-16)*20 + "px; left:" + (x+33 + centerCoordinateX)*20 + "px;\"></div>");
//	}
	out.print(CreateGraphic.createGraphic(k, centerCoordinateX, centerCoordinateY, scale, size));
	
	
	
	
	if(centerCoordinateX*scale < 65 && centerCoordinateX*scale > -65 && centerCoordinateY*scale < 32 && centerCoordinateY*scale > -32) {
		out.print("<div style=\"position:absolute; background-color: grey; width: 5px; height:5px; top: "+(centerCoordinateY*scale*20 + 318)+"px; left:"+ (centerCoordinateX*20*scale + 658)+"px; border-radius: 50%;\"></div>");
	}
	
	
	

	out.print("<div style=\"position: absolute; width: 300px; height: 160px; top: 470px; left: 1000; background-color: white;\">"
			+ GetStringEquationHtml.getEquationHTMLWithEquationString(eq)
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