package EqFunctions;
//import EqFunctions.GetStringEquationHtml;
public class SistemaUrResh{
	static double m[][];
//	public static void main(String[] args) {
//		 double[] rees = reshUr(new double[][]{{7,6},{4,3}});
//		 for(double i: rees) {
//			 System.out.println(i);
//		 }
//		 String[][] res = getK(new double[][]{{7,6},{4,3}});
////		 System.out.println(res[1].length);
//		 for(int i = 0; i < res.length; i++) {
//			 System.out.println("res:    " + res[1][i] + " : " +res[1][i]);
//			 System.out.println("res:    " + res[0][i] + " : " +res[0][i]);
//			 
//		 }
		
//		String[][] k = getK(new double[][] {{0,1.0},{1,(3.0+(1.0/3.0))},{-1,(3.0-(1.0/3.0))}});
//		System.out.println(GetStringEquationHtml.getEquationHTML(k));
//		System.out.println(3-(1.0/3.0));
//		 }
	
	
	
	
//		возвращаует массив решение системы cоответственно перед x(n-1), x(n-2),...,x3,x2,x1,x0  где n - количество точек
	public static double[] reshUr(double[][] toch) {
		double[] res = new double[toch.length];
		double[][] matrix = new double[toch.length][toch.length];
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				matrix[i][j] = Math.pow(toch[i][0], matrix.length-1-j);
			}
		}
			
		
		return solveMatrix(matrix, toch);
	}
	
	
//	возвращаует массив решение системы cоответственно перед x(n-1), x(n-2),...,x3,x2,x1,x0  где n - количество точек
public static double[] reshUrWithDiratives(double[][] toch) {
	double[][] matrix = new double[toch.length*2][toch.length*2];
	for(int i = 0; i < toch.length; i++) {
		String[] ur = new String[2];
		for(int j = 0; j < matrix.length; j++) {
			matrix[i][j] = Math.pow(toch[i][0], matrix.length-1-j);
			matrix[toch.length+i][j] = Math.pow(toch[i][0], matrix.length-2-j)*(matrix.length-1-j);
			ur[0] += matrix[i][j] + " - [" + i + "][" + j + "]" + " ";
			ur[1] += matrix[toch.length+i][j] + " - [" + (toch.length+i) + "][" + j + "]" + " ";
		}
		System.out.println(ur[0] + "\n" + ur[1]);
	}
	
return solveMatrix(matrix, toch);
}
	
//	возвращаует массив решение системы cоответственно перед x(n-1), x(n-2),...,x3,x2,x1,x0  где n - количество точек в формате строки-дроби
public static String[] reshUrAsString(double[][] toch) {
	String[] res = new String[toch.length];
	double[][] matrix = new double[toch.length][toch.length];
	for(int i = 0; i < matrix.length; i++) {
		for(int j = 0; j < matrix.length; j++) {
			matrix[i][j] = Math.pow(toch[i][0], matrix.length-1-j);
		}
	}
	
		double delta = determinant(matrix, matrix.length);
//		System.out.println("Delta: " + delta);
		
		double[] deltaN = new double[matrix.length];
		double[][] matrixN = new double[matrix.length][matrix.length];
		
	for(int i = 0; i < matrix.length; i++) {
		for(int j = 0; j < matrix.length; j++) {
			matrixN[i][j] = matrix[i][j];
		}
	}



		for(int i = 0; i < matrixN.length; i++) {
//			matrix = new double[][]{{1,1,1},{4,2,1},{9,3,1}};
			for(int k = 0; k < matrix.length; k++) {
				for(int j = 0; j < matrix.length; j++) {
					matrixN[k][j] = matrix[k][j];
				}
			}
			
			for(int j = 0; j < matrixN.length; j++) {
				matrixN[j][i] = toch[j][1]; 
			}

			
			
			deltaN[i] = determinant(matrixN, matrixN.length);
//			System.out.println(deltaN[i]);
			
			
			res[i] = deltaN[i] + "/" + delta;
		}
	
//	System.out.println("final matrix:");
//	for(double[] f : matrix) {
//		for(double g : f) {
//			System.out.print(g + "  ");
//		}
//		System.out.println("");
//	}
	
	
	return res;
}


private static double[] solveMatrix(double[][] matrix, double[][] toch) {
	double[] res = new double[matrix.length];
	double delta = determinant(matrix, matrix.length);
		
		double[] deltaN = new double[matrix.length];
		double[][] matrixN = new double[matrix.length][matrix.length];
		
	for(int i = 0; i < matrix.length; i++) {
		for(int j = 0; j < matrix.length; j++) {
			matrixN[i][j] = matrix[i][j];
		}
	}


		for(int i = 0; i < matrixN.length; i++) {
			for(int k = 0; k < matrix.length; k++) {
				for(int j = 0; j < matrix.length; j++) {
					matrixN[k][j] = matrix[k][j];
				}
			}
			if(matrix.length == toch.length*2) {
				String zamen = "";
				System.out.println("Diratives");
				for(int j = 0; j < toch.length; j++) {
					matrixN[j][i] = toch[j][1]; 
					matrixN[toch.length + j][i] = 0; 			
					zamen+= toch[j][1] + "\n0\n";
		 		}
				System.out.println(zamen);
			}else {
				for(int j = 0; j < matrixN.length; j++) {
					matrixN[j][i] = toch[j][1]; 
				}
			}
			
			
			deltaN[i] = determinant(matrixN, matrixN.length);
			
			
			res[i] = (double)(deltaN[i]/delta);
		}
	
	
	
	return res;
}
	
//	return array [kol-vo of points][2], where [n][0] = deltaN, [n][1] = delta 
public static double[][] getResAsFraction(double[][] toch){
	double[][] res = new double[toch.length][2];
	double[][] matrix = new double[toch.length][toch.length];
	
	for(int i = 0; i < matrix.length; i++) {
		for(int j = 0; j < matrix.length; j++) {
			matrix[i][j] = Math.pow(toch[i][0], matrix.length-1-j);
		}
	}
	
		double delta = determinant(matrix, matrix.length);
		for(int i = 0; i < res.length; i++) {
			res[i][1] = delta;
		}
		
		double[] deltaN = new double[matrix.length];
		double[][] matrixN = new double[matrix.length][matrix.length];
		
	for(int i = 0; i < matrix.length; i++) {
		for(int j = 0; j < matrix.length; j++) {
			matrixN[i][j] = matrix[i][j];
		}
	}


		for(int i = 0; i < matrixN.length; i++) {
			for(int k = 0; k < matrix.length; k++) {
				for(int j = 0; j < matrix.length; j++) {
					matrixN[k][j] = matrix[k][j];
				}
			}
			
			for(int j = 0; j < matrixN.length; j++) {
				matrixN[j][i] = toch[j][1]; 
			}

			deltaN[i] = determinant(matrixN, matrixN.length);
			
			for(int  j = 0; j < res.length; j++) {
				res[i][0] = deltaN[i];
			}
		}
	return res;
}
	
//	relate Power and koeficients in array {{Power1, Koeficient1},{Power2, Koeficient2}, ...}
	public static String[][] getK(double[][] points){
		String[][] k;
//		if(params == null) {
		k = new String[points.length][2];
		double[] resh = reshUr(points);
//		System.out.println(jj[0] + " " +jj[1]);
		for(int i = 0; i < k.length;i++) {
			System.out.println((points.length-1-i) + "  "  +  resh[i]);
			k[i][0] = "" + (points.length-1-i);
			k[i][1] = ""+resh[i] ;
		}
		
		
//		}else{
//		k = new String[params.length][2];
//		points = getPointsWithParams(points, params);
//		double[] resh = reshUr(points);
//		for(int i = 0; i < k.length; i++) {
//			k[i][0] = "" + (points.length-1-i);
//			if(params[i] == "--") {
//				k[i][1] = ""+ resh[i];
//			}
//			else {
//				k[i][1] = ""+ params[i];
//			}
//			}
//		}
		return k;
	}
	
//	relate Power and koeficients in array {{Power1, Koeficient1},{Power2, Koeficient2}, ...}
	public static String[][] getKWithDiratives(double[][] points){
		String[][] k;
		k = new String[points.length*2][2];
		double[] resh = reshUrWithDiratives(points);
		for(int i = 0; i < k.length;i++) {
			System.out.println(((points.length*2)-1-i) + "  "  +  resh[i]);
			k[i][0] = "" + ((points.length*2)-1-i);
			k[i][1] = ""+resh[i] ;
		}
		
		return k;
	}
	
	
//	public static double[][] getPointsWithParams(double[][] oldpoints, String[] params){
//		double[][] newpoints = oldpoints;
//		double delta = 0;
//		for(int i = 0; i < newpoints.length; i++) {
//			if(params[i]!="--") {
////			newpoints[i][]
//			}
//		}
//		
//		return newpoints;
//	}

	
	
	
//	Generate Minors for the Determinant
	public static double[][] generateSubArray (double A[][], int N, int j1){
        m = new double[N-1][];
        for (int k=0; k<(N-1); k++)
                m[k] = new double[N-1];

        for (int i=1; i<N; i++){
              int j2=0;
              for (int j=0; j<N; j++){
                  if(j == j1)
                        continue;
                  m[i-1][j2] = A[i][j];
                  j2++;
              }
          }
        return m;
}
	
//	Solve Determinant
	 public static double determinant(double A[][], int N){
		 	
	        double res;

	        // Trivial 1x1 matrix
	        if (N == 1) res = A[0][0];
	        // Trivial 2x2 matrix
	        else if (N == 2) res = A[0][0]*A[1][1] - A[1][0]*A[0][1];
	        // NxN matrix
	        else{
	            res=0;
	            for (int j1=0; j1<N; j1++){
	                 m = generateSubArray (A, N, j1);
	                 res += Math.pow(-1.0, 1.0+j1+1.0) * A[0][j1] * determinant(m, N-1);
	            }
	        }
	        return res;
	    }

	}
