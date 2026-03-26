package EqFunctions;

import java.util.regex.Pattern;

public class PointsComparing{
	
//	public static void main(String args[]) {
//		double[][] points = getPoints("A(11,22);".split(";"));
//		System.out.println(points[0][0] + "  " + points[0][1]);
//}
//	
	
	
	
	
//	Returen Coordinates of points
	public static double[][] getPoints(String[] pointsstring){
		double[][] points = new double[pointsstring.length][2];
		for(int i = 0; i < points.length; i++) {
//			System.out.println("aasd");
			if(pointsstring[i].equals("")) {
				break;
			}
		String pointCoords = pointsstring[i].split(Pattern.quote("("))[1];
//		if(pointCoords.equals("")) {
//			System.out.println("White space");
//		}

		pointCoords = pointCoords.replace(")", "");
//		System.out.println(pointCoords + "fggh");
		try {
		points[i][0] = (Double.parseDouble(pointCoords.split(",")[0]));
		points[i][1] = (Double.parseDouble(pointCoords.split(",")[1]));
		}catch(java.lang.NumberFormatException e) {}
		}
		return points;
	}
	
//	Returns Names of points by array of Points with coordinates
	public static String[] getPointsNames(String[] pointsstring) {
		for(int i = 0; i < pointsstring.length; i++) {
			try {
			pointsstring[i] = pointsstring[i].split("\\(")[0];
			}catch(java.lang.ArrayIndexOutOfBoundsException e) {
				
			}
		}
		return pointsstring;
	}
}