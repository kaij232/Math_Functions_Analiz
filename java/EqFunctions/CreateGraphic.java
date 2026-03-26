package EqFunctions;

import org.apache.tomcat.jakartaee.commons.lang3.ArrayUtils;

public class CreateGraphic{
//	Return a String with all lines of system coordinates
	public static String createBasicParts(){
		String res = "";
	res += "<div style=\"position: absolute; width: 1px; height: 100%; left: 660px; top: 0px; background: black;\"></div>\r\n"
			+ "	<div style=\"position:absolute; background-color: black; width: 100%; height: 1px; top: 320px; left:0px; \"></div>\r\n"
			+ "	<div style=\"position:absolute; background-color: black; width: 5px; height:5px; top: 318px; left:658px; border-radius: 50%;\"></div>";
	
	
//	Vertikal lines
	res+= "<div class=\"VerticalLines\">";
	for(int x = 20; 1310-x > 20; x+= 20){
//		if( x != 655){
		res += "<div style=\"position: absolute; background-color: black; width: 1px; height: 9px; top: 316px; left: " + (x) + "px;\"></div>";
		res+="<div style=\"position: absolute; width: 1px; height: 100%; left: " + (x) + "px; top: 0px; background: black; opacity: 0.2;\"></div>";
//	}
	}
	res+="</div>";
	
	res+= "<div class=\"HorizontalLines\">";
//	Horizontal lines
	for(int y = 20; 644-y >13; y+=20){
//		if( y != 321){
		res+="<div style=\"position: absolute; background-color: black; width: 9px; height: 1px; top: " +(y) + "px; left:656px;\"></div>";
		res+="	<div style=\"position:absolute; background-color: black; width: 100%; height: 1px; top: " + (y) + "px; left:0px; opacity: 0.2; \"></div>";
//	}
	}
	res+="</div>";
	
	return res;
	}
	
	
//	return all points of Graphic by Powers and Koeficients (k), Coordinate of center X (centerCoordinateX),  Coordinate of center Y (centerCoordinateY), Mosshtaba - how much is 1 strike (scale), and size of points (size)
	public static String createGraphic(String[][] k, double centerCoordinateX, double centerCoordinateY, double scale,double size) {
		String res = "";
		res+= "<div class=\"GaphicPoints\">";
		for(double x = (-33 + centerCoordinateX*scale); x < (33 + centerCoordinateX*scale); x += 0.05) {
//			x = Okrugl.okruglAfterToch(x, 2);
			double nres = 0;
			for(int i = 0; i< k.length;i++) {
				nres += (double)(Double.parseDouble(k[i][1]))*(double)Math.pow(x/scale, Double.parseDouble(k[i][0]));
			}
			nres*=scale;
			nres -= centerCoordinateY*scale;
			if(nres >16 || nres < -16 ) {
				continue;
			}
			double yres = nres;
			
//			if(scale>=3 && x%(0.05*scale) == 0) {
//			System.out.println("x: " + x + "; 		nres: " + nres + ";      y: " + yres);
//			}

			

			res+="<div style=\"position: absolute; background-color: black; width: "+size+ "px; height: "+size+"px; top: " + Math.abs(yres-16)*20 + "px; left:" + (x+33 + centerCoordinateX*scale)*20 + "px;\"></div>";
		}
		res+="</div>";
		return res;
	}
	
	
//	Returns a String with all points in Points{} in size with scale with center in (X,Y)
	public static String printPoints(double[][] Points, String[] Names ,double scale , double size, double X, double Y, String[][] k) {
		String res = "";
//		double nres = 0;
		for(double[] i : Points) {
//			if(!(i[0]*20*scale < 1310)) {
			
			
//		for(int j = 0; j< k.length;j++) {
//			nres += (double)(Double.parseDouble(k[j][1]) * (double)Math.pow(i[0], Double.parseDouble(k[j][0])));
//		}
//		nres*=scale;
//		nres -= Y*scale;
//		if(nres >16 || nres < -16 ) {
//			continue;
//		}
//		i[1] = nres;
//			if(((X +i[0])*scale+33)*20<1230 && Math.abs((i[1]-Y)*scale-16)*20 < 660) {
			if(-33<(i[0]+X)*scale && (i[0]+X)*scale<33 && -16<(i[1]+Y)*scale && (i[1]+Y)*scale<16) {
				res+= "<div class=\"Point_"+ Names[ArrayUtils.indexOf(Points, i)] + "\" >";
				res+= "<div style=\"position: absolute; background-color: red;  width: "+(size+1)+"px; height: "+(size+1)+"px; top: " + Math.abs((i[1]-Y)*scale-16)*20 + "px; left:" + ((X +i[0])*scale+33)*20 + "px;\"></div>";
				res+="<div style=\"position: absolute; top: " + Math.abs((i[1]-Y)*scale-16)*20 + "px; left:" + (((X +i[0])*scale+33)*20+10) + "px;\">"+Names[ArrayUtils.indexOf(Points, i)]+"</div>";
				res+="</div>";
			}
//		res+= "<div style=\"position: absolute; background-color: red;  width: "+(size+1)+"px; height: "+(size+1)+"px; top: " + Math.abs(i[1]-16)*20 + "px; left:" + ((X +i[0])*scale+33)*20 + "px;\"></div>";
//			}
		}
		
		
		return res;
	}
	
	
	
}
