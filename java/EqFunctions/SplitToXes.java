package EqFunctions;

import org.apache.tomcat.jakartaee.commons.lang3.ArrayUtils;

public class SplitToXes {
public static String[][] SplitToXesKoifcent(String eq) {
	int mainDegry = 0;
	eq = eq.replace(" ", "");
	eq = eq.replace("-", "+-");
	char[] eqc = eq.toCharArray();
	if(("" + eqc[0]).equals("+")) {
		eqc = ArrayUtils.remove(eqc, 0);
		eq = "";
		for(char i : eqc) {
			eq += i;
		}
	}
	
//	Sdelat chtob mojno bilo bez +
	
//	System.out.println(eq);
	String[] eqs = eq.split("\\+");
//	for(int i = 0; i < eqc.length;i++) {
//		if((""+eqc[i]).equals("^")) {
//			for(int j = i+1; j < eqc.length; j++) {
//				if(!(eqc[j]+"").equals("+")) {
//					mainDegry += "" + eqc[j];
//				}else {
//					break;
//				}
//			}
//			break;
//		}
//	}
	
	// нахождение степени старшего члена 
	for(int i = 0; i < eqc.length;i++) {
		if((eqc[i]+"").equals("x")) {
			mainDegry++;
		}
	}
	if(mainDegry == 0) {
		for(char i :eqc) {
			if((i+"").equals("x")) {
				mainDegry=1;
				break;
			}
		}
	}
	
	
//	System.out.println(mainDegry);
	
	
	
	String[][] res = new String[eq.length() - eq.replace("+", "").length()+1][2];
	
	
	for(int i = 0; i< eqs.length;i++) {
		res[i][0] = "";
		res[i][1] = "";
		String pow = "";
//		System.out.println(eqs[i]);
		for(int j = 0; j< eqs[i].length(); j++) {
			char[] p = eqs[i].toCharArray();
			if((p[j]+"").equals("x")) {
				for(int k = j+2; k < p.length; k++) {
					pow += p[k];
					
				}
				break;
			}
//			System.out.println();
			res[i][1] += p[j];
			
		}
		if(pow.length()-pow.replace("/", "").length() == 0) {
		res[i][0] = pow;
		}else {
			pow = ((float)(Integer.parseInt(pow.split("/")[0]) / Integer.parseInt(pow.split("/")[1]))+"");
		}
		
		
		
		if(res[i][0].equals("")) {
			res[i][0] = "0";
		}
		if(res[i][1].equals("")) {
			res[i][1] = "1";
	}
		
	}
//	res[i][0] - degree
//	res[i][1] - koeficient
	return res;
}
	
//public static void main(String[] args) {
//	for(String[] i : SplitToXesKoifcent("x^1/3")) {
//	System.out.println(i[0] + " : " + i[1]);
//	}
}

