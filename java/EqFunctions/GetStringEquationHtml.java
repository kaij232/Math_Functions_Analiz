package EqFunctions;
public class GetStringEquationHtml{
	
	
	public static void main(String[] args) {
		
//		System.out.println(Integer.parseInt("1.1"));
//		System.out.println(getEquationHTML(new double[][] {{0.0, 0.0},{1.0, 1.0/3.0}}));
//		System.out.println((1.0/3.0));	
//		System.out.println(SocrDrob(3.3, 3.6));
//	System.out.println(getEquationHTMLWithEquationString("4x^6-9x^2+1000x^1-6"));
//		System.out.println(SocrDrob(3,9));
//		System.out.println(isPeriodDrob("3.232353535353535359") + " d  " + getPeriod("3.232353535353535359") + " d  " + getDrobPart("3.232353535353535359"));
System.out.println(isPeriodDrob("-0.018518518518518517"));
System.out.println(getDrob("-0.018518518518518517"));
	}
	
//	-0.018518518518518517x5+14/27x4+1.537037037037037x3+1.037037037037037x2-4.518518518518518x+4.481481481481482
	public static String getEquationHTML(String[][] k) {
		String equation = "<div align=\"center\"><p>";
		
		
		for(int i = 0; i < k.length; i++) {
			if(isPeriodDrob(k[i][1])) {
				if(!getDrob(k[i][1]).equals("1/1")) {
				k[i][1] = getDrob(k[i][1]);
				}
			}else if(k[i][1].split("\\.")[1].equals("0")){
					k[i][1] = k[i][1].split("\\.")[0];
			}
//				}catch(java.lang.ArrayIndexOutOfBoundsException e) {}
		}
//		for(double[] i : k) {
//			equation +=i[1] + "x<sup>" + i[0] + "</sup>";
//		}
		if(k[0][1].equals("0") || k[0][1].equals("-0")) {
			
		}else if(k[0][1].equals("1")){
			if(k[0][0].equals("1")) {
				equation += "x";
			}else {
			equation += "x<sup>" + k[0][0] + "</sup>";
			}
		}else {
			if(k[0][0].equals("1")) {
				equation += "" + k[0][1] + "x";
			}else {
				equation += "" + k[0][1] + "x<sup>" + k[0][0] + "</sup>";
			}
		}
		
		for(int i = 1; i< k.length; i++) {
			
//			if((k[i][1].toCharArray()[k[i][1].toCharArray().length-1]+"").equals("0")) {
//				k[i][1] = k[i][1].split(".")[0];
//			}
//			pp+=k[i][1];
//			if(pp.equals("0")) {
//				
//			}else if(Double.parseDouble(pp)>0) {
//				if(k[i][0].equals("1")) {
//					equation += "" + pp + "x";
//				}else if(k[i][0].equals("0")){
//					equation += "" + pp;
//				}
//			}else {
//				if(k[i][0].equals("1")) {
//					equation += "+" + pp + "x";
//				}else if(k[i][0].equals("0")){
//					equation += "+" + pp;
//				}
//			}
			
			
			if(k[i][1].equals("0") || k[i][1].equals("-0")) {
				
			}else {
				if(k[i][0].equals("1")) {
					if(k[i][1].equals("1")){
						equation += "+x";
					}else if((k[i][1].charAt(0)+"").equals("-")){
						equation += "" + k[i][1] + "x";
					}else {
						equation += "+" + k[i][1] + "x";
					}
				}else if(k[i][0].equals("0")){
					if(k[i][1].equals("1")){
						equation += "+1";
					}else if((k[i][1].charAt(0)+"").equals("-")){
						equation += "" + k[i][1];
					}else {
						equation += "+" + k[i][1];
					}
				}else {
					if(k[i][1].equals("1")){
						equation += "+x<sup>" + k[i][0] + "</sup>";
					}else if((k[i][1].charAt(0)+"").equals("-")){
						equation += "" + k[i][1] + "x<sup>" + k[i][0] + "</sup>";
					}else {
						equation += "+" + k[i][1] + "x<sup>" + k[i][0] + "</sup>";
					}
				}
			}
			
		}
		if((equation.charAt(23)+"").equals("+")){
			char[] xx = equation.toCharArray();	
			xx[23] = " ".charAt(0);
			equation = "" + String.valueOf(xx);
		}
		equation+= "</p></div>";
		return equation;
	}
	
//	return non decimal drob(like as a/b)
	private static String getDrob(String a) {
		String res = "";
		String ceil = a.split("\\.")[0];
		System.out.println("ceil: " + ceil);
		String period = getPeriod(a);
		System.out.println("Perioed: " + period);
		String drob = getDrobPart(a);
		System.out.println("drob: " + drob);		
		String znam = "";
		for(int i = 0; i < period.length(); i++) {
			znam+= "9";
		}
		for(int i = 0; i < drob.length(); i++) {
			znam+= "0";
		}
		if(drob.equals("")) {
			drob="0";
		}
		System.out.println("znam: " + znam);
		String chisl = "" + (Integer.parseInt(drob+period) - Integer.parseInt(drob)+ (Integer.parseInt(ceil)*Integer.parseInt(znam)));
//		System.out.println(chisl + " / " + znam + " f");
		System.out.println("chisl: " + chisl);
		res = SocrDrob(Integer.parseInt(chisl) , Integer.parseInt(znam));
		
		
		return res;
	}
	
//	return non decimal drob(like as a/b), but a and b type is double
	private static String getDrob1(String a) {
		String res = "";
		String ceil = a.split("\\.")[0];
		String period = getPeriod(a);
		String drob = getDrobPart(a);
		String znam = "";
		for(int i = 0; i < period.length(); i++) {
			znam+= "9";
		}
		for(int i = 0; i < drob.length(); i++) {
			znam+= "0";
		}
		if(drob.equals("")) {
			drob="0";
		}
//		System.out.println(ceil+" " + drob+ "" + period);
		String chisl = "" + (Integer.parseInt(drob+period) - Integer.parseInt(drob)+ (Integer.parseInt(ceil)*Integer.parseInt(znam)));
//		System.out.println(chisl + " / " + znam + " f");
		
		String res_ = SocrDrob(Integer.parseInt(chisl) , Integer.parseInt(znam));
		
		res += res_.split("/")[0] + ".0/";
		res += res_.split("/")[1] + ".0";
		
		return res;
	}
	
//	return socrasonnuyu drob in format a/b
	private static String SocrDrob(double chisl_, double znam_) {
//		System.out.println("SocrDrob");
		String res = "";
		String newZnam = "";
		String newChisl = "";
		int chisl = 1;
		int znam = 1;
		
		
		boolean prov = false;
		while(prov == false && Math.abs(chisl_) < 100000 && Math.abs(znam_) < 100000) {
			System.out.println(""+chisl_);
			System.out.println(""+znam_);
			if((""+chisl_).split("\\.")[1].equals("0") && (""+znam_).split("\\.")[1].equals("0")) {
				chisl = Integer.parseInt((""+chisl_).split("\\.")[0]);
				znam = Integer.parseInt((""+znam_).split("\\.")[0]);
				prov = true;
			}else {
				chisl_*= 10;
				znam_*= 10;	
			}
		}
		
		
////		if only chislitel is period drob
//		if(isPeriodDrob(chisl_+"") && !isPeriodDrob(znam_+"")) {
//			String chislDrob = getDrob(chisl_+"");
//			chisl = Integer.parseInt(chislDrob.split("/")[0]);
//			znam = Integer.parseInt(chislDrob.split("/")[1]);
//			while(!((""+znam_).split("\\.")[1].equals("0"))) {
//				chisl_*= 10;
//				znam_*= 10;	
//			}
//			znam*=Integer.parseInt((""+znam_).split("\\.")[0]);
////			if only znamenatel is period drob
//		}else if(!isPeriodDrob(chisl_+"") && isPeriodDrob(znam_+"")) {
//			String znamDrob = getDrob(znam_+"");
//			
//			System.out.println(znamDrob);
//			chisl *= Integer.parseInt(znamDrob.split("/")[1]);
//			System.out.println(chisl);
//			znamD *= Integer.parseInt(znamDrob.split("/")[0]);
//			System.out.println(znam);
//			while(!((""+znamD).split("\\.")[1].equals("0"))) {
//				System.out.println("domnozh na 10");
//				chisl*= 10;
//				znamD*= 10;	
//			}
//			chisl*=Integer.parseInt((""+chisl_).split("\\.")[0]);
//			znam = Integer.parseInt(("" + znamD).split("\\.")[0]);
////			if and chislitel and znamenatel are period drob
//		}else if(isPeriodDrob(chisl_+"") && isPeriodDrob(znam_+"")) {
//			String chislDrob = getDrob(chisl_+"");	
//			chisl = Integer.parseInt(chislDrob.split("/")[0]);
//			znam = Integer.parseInt(chislDrob.split("/")[1]);
//			String znamDrob = getDrob(znam_+"");
//			chisl *= Integer.parseInt(znamDrob.split("/")[1]);
//			znam *= Integer.parseInt(znamDrob.split("/")[0]);
////			if there are not period drobs
//		}else {
//			while(!((""+chisl_).split("\\.")[1].equals("0") && (""+znam_).split("\\.")[1].equals("0"))) {
//				chisl_*= 10;
//				znam_*= 10;	
//			}
//			chisl = Integer.parseInt((""+chisl_).split("\\.")[0]);
//			znam = Integer.parseInt((""+znam_).split("\\.")[0]);
//		}
		
		
		
		int[] nchisl = getPeacMnozh(chisl);
		int[] nznam = getPeacMnozh(znam);
		
		
		int a = chisl;
		int b = znam;
//		System.out.println(nchisl.length + "  :  " + nznam.length);			
		for(int i = 0; i < nchisl.length; i++) {
			for(int j = 0; j < nznam.length; j++) {
//				System.out.println((boolean)(nchisl[i] == nznam[j]) + " boo" );				
				if(nchisl[i] == nznam[j]) {
					a/=nchisl[i];
					b/=nchisl[i];
					nchisl[i]=1;
					nznam[j] = -1;
				}
				}
			}

		newChisl = "" + a;
		newZnam = "" + b;
//		for(int i = 0; i < nchisl.length; i++) {
//			for(int j = 0; j < nznam.length; j++) {
//				if(nchisl[i] == nznam[j]) {
//					nchisl[i] = 1;
//					nznam[j] = -1;
//				}
//			}
//		}
//		int a = 1;
//		for(int i = 0; i < nchisl.length; i++) {
//			if(nchisl[i] != -1) {
//				a *= nchisl[i];
//			}
//		}
//		newChisl = "" + a;
//		
//		int b = 1;
//		for(int i = 0; i < nznam.length; i++) {
//			if(nznam[i] != 0) {
//				b *= nznam[i];
//			}
//		}
//		newZnam = "" + b;
		
		res+=newChisl + "/" + newZnam;
		return res;
	}
	
//	return peac mnozitels of number
	private static int[] getPeacMnozh(int a) {
		System.out.println("getPeacMnozh " + a);
		boolean am0 = false;
		if(a<0) {
			a=-a;
			am0 = true;
		}
		String res = "1,";
		int[] prostChisla = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
		while(a!=1) {
			for(int i : prostChisla) {
				if(a%i==0) {
					a/=i;
					res+=i+",";
					break;
				}
			}
		}
//		System.out.println(res);
		int[] ress = new int[res.split("\\,").length];

		for(int i = 0; i < ress.length; i++) {
			ress[i] = Integer.parseInt(res.split("\\,")[i]);
//			System.out.println(ress[i] + "  ress");
		}
//		for(int i = 5; i <= 99; i +=2) {
//			boolean check = true;
//			for(int j = 3; j < i; j++) {
//				if(i%j ==0) {
//					check = false;
//				}
//
//			}
//			if(check) {
//				res+= i+", ";
//			}
//		}
//		res+="};";
		if(am0) ress[0] = -ress[0];
		System.out.println("getPeacMnozh end");
		return ress;
	}
// 		get drob and return true if shi is periodic and false if not
	private static boolean isPeriodDrob(String a) {
		boolean res = false;
		if(a.length() > 6) {
//		if(a.charAt(a.length()-1) == a.charAt(a.length()-2) && 
//			a.charAt(a.length()-1) == a.charAt(a.length()-3) &&
//			a.charAt(a.length()-1) == a.charAt(a.length()-4)) {
//			res = true;
//		}
			for(int i = 1; i <= 5; i++) {
				String part1 = "";
				String part2 = "";
				for(int j = 0; j< i; j++ ) {
					part1 += a.charAt(a.length()-2-j);
					part2 += a.charAt(a.length()-2-j-i);
				}
				if(part1.equals(part2)) {
					res = true;
					break;
				}
			}
		}
		
		return res;
	}
	
	
//	public static String getEquationHTML(double[][] points) {
//		System.out.println("getEquationHTML");
//		String equation = "<div align=\"center\"><p>";
//		double[][] kF = SistemaUrResh.getResAsFraction(points);
//		String k[][] = new String[kF.length][2];
//		System.out.println("kf length " + kF.length);
//		for(int i = 0; i < kF.length; i++) {
//			k[i][0] = "" +(kF.length-i-1);
//			if((kF[i][0] > 0 && kF[i][1] < 0)||(kF[i][0]<0 && kF[i][0]<0)) {
//				kF[i][0] = -kF[i][0];
//				kF[i][1] = -kF[i][1];
//			}
//			
//			
//			
//			
//			k[i][1] = SocrDrob(Double.parseDouble(""+kF[i][0]),Double.parseDouble(""+kF[i][1]));
//			if(k[i][1].split("/")[1].equals("1")) {
//				k[i][1] = k[i][1].split("/")[0];
//			}else if(k[i][1].split("/")[0].equals("0") || k[i][1].split("/")[0].equals("-0")) {
//				k[i][1] = "0";	
//			}
//		}
//		
//		if(k[0][1].equals("0")) {
//			
//		}else if(k[0][1].equals("1")){
//			equation += "x<sup>" + k[0][0] + "</sup>";
//		}else {
//			equation += "" + k[0][1] + "x<sup>" + k[0][0] + "</sup>";
//		}
//		
//		for(int i = 1; i< k.length; i++) {
//			
//			
//			
//			if(k[i][1].equals("0")) {
//				
//			}else {
//				if(k[i][0].equals("1")) {
//					if(k[i][1].equals("1")){
//						equation += "+x";
//					}else if((k[i][1].charAt(0)+"").equals("-")){
//						equation += "" + k[i][1] + "x";
//					}else {
//						equation += "+" + k[i][1] + "x";
//					}
//				}else if(k[i][0].equals("0")){
//					if((k[i][1].charAt(0)+"").equals("-")){
//						equation += "" + k[i][1];
//					}else {
//						equation += "+" + k[i][1];
//					}
//				}else {
//					if(k[i][1].equals("1")){
//						equation += "+x<sup>" + k[i][0] + "</sup>";
//					}else if((k[i][1].charAt(0)+"").equals("-")){
//						equation += "" + k[i][1] + "x<sup>" + k[i][0] + "</sup>";
//					}else {
//						equation += "+" + k[i][1] + "x<sup>" + k[i][0] + "</sup>";
//					}
//				}
//			}
//			
//		}
//		if((equation.charAt(23)+"").equals("+")){
//			char[] xx = equation.toCharArray();	
//			xx[23] = " ".charAt(0);
//			equation = "" + String.valueOf(xx);
//		}
//		equation+= "</p></div>";
//		
//		
//		return equation;
//	}
	
	
	
//	public static String getEquationHTML1(double[][] points) {
//		System.out.println("getEquationHTML");
//		String equation = "<div align=\"center\"><p>";
//		String[] kF = SistemaUrResh.reshUrAsString(points);
//		String k[][] = new String[kF.length][2];
////		System.out.println("kf length " + kF.length);
////		for(int i = 0; i < kF.length; i++) {
////			k[i][0] = "" +(kF.length-i-1);
////			if((kF[i][0] > 0 && kF[i][1] < 0)||(kF[i][0]<0 && kF[i][0]<0)) {
////				kF[i][0] = -kF[i][0];
////				kF[i][1] = -kF[i][1];
////			}
//			
//			
//		for(int i =0; i < kF.length; i++) {
////			try {
////			kF[i] = SocrDrob(Double.parseDouble(kF[i].split("/")[0]), Double.parseDouble(kF[i].split("/")[1]));
////			}catch(java.lang.ArrayIndexOutOfBoundsException e) {}
//			k[i][0] = "" +(kF.length-i-1);
//			if(kF[i].split("/")[0].equals("0.0") || kF[i].split("/")[0].equals("-0.0")) {
//				k[i][1] = "0";
//			}else if(kF[i].split("/")[1].equals("1.0")) {
//				k[i][1] = kF[i].split("/")[0];
//			}
//			else {
//				k[i][1] = kF[i];
//				System.out.println("kF:  " + kF[i]);
//			}
//			}
////			
////			
////		}
////		for(int i =0; i < kF.length; i++) {
////			k[i][1] = SocrDrob(Double.parseDouble(""+kF[i][0]),Double.parseDouble(""+kF[i][1]));
////			if(k[i][1].split("/")[1].equals("1")) {
////				k[i][1] = k[i][1].split("/")[0];
////			}else if(k[i][1].split("/")[0].equals("0") || k[i][1].split("/")[0].equals("-0")) {
////				k[i][1] = "0";	
////			}
////	}
//		
//		if(k[0][1].equals("0")) {
//			
//		}else if(k[0][1].equals("1")){
//			equation += "x<sup>" + k[0][0] + "</sup>";
//		}else {
//			equation += "" + k[0][1] + "x<sup>" + k[0][0] + "</sup>";
//		}
//		
//		for(int i = 1; i< k.length; i++) {
//			
//			
//			
//			if(k[i][1].equals("0")) {
//				
//			}else {
//				if(k[i][0].equals("1")) {
//					if(k[i][1].equals("1")){
//						equation += "+x";
//					}else if((k[i][1].charAt(0)+"").equals("-")){
//						equation += "" + k[i][1] + "x";
//					}else {
//						equation += "+" + k[i][1] + "x";
//					}
//				}else if(k[i][0].equals("0")){
//					if((k[i][1].charAt(0)+"").equals("-")){
//						equation += "" + k[i][1];
//					}else {
//						equation += "+" + k[i][1];
//					}
//				}else {
//					if(k[i][1].equals("1")){
//						equation += "+x<sup>" + k[i][0] + "</sup>";
//					}else if((k[i][1].charAt(0)+"").equals("-")){
//						equation += "" + k[i][1] + "x<sup>" + k[i][0] + "</sup>";
//					}else {
//						equation += "+" + k[i][1] + "x<sup>" + k[i][0] + "</sup>";
//					}
//				}
//			}
//			
//		}
//		if((equation.charAt(23)+"").equals("+")){
//			char[] xx = equation.toCharArray();	
//			xx[23] = " ".charAt(0);
//			equation = "" + String.valueOf(xx);
//		}
//		equation+= "</p></div>";
//		
//		
//		return equation;
//	}
	private static String getPeriod_(String a) {
		a = a.split("\\.")[1];
		String res = "";
//		for(int i = 0; i < 5)
		return res;
	}
	
//	return period part of the full drob
	private static String getPeriod(String a) {
		a = a.split("\\.")[1];
		String res = "";
		
		int i = 1;
		String part1 = "";
		String part2 = "!";
		while(!part1.equals(part2)) {
			part1 = "";
			part2 = "";
			for(int j = 0; j< i; j++ ) {
				part1 += a.charAt(a.length()-2-j);
				part2 += a.charAt(a.length()-2-j-i);
			}
//			System.out.println(part1 + "  :  " + part2); -0.018518518518518517
			i++;
		}
		res = new StringBuilder(part1).reverse().toString();
		return res;
	}
	
//	return non period drob part of the number		
	private static String getDrobPart(String a) {
		String period = getPeriod(a);
		a = a.split("\\.")[1];
		String res = "";

		
		try {
			res = a.split((period+period+period))[0];
		}catch(java.lang.ArrayIndexOutOfBoundsException e) {
			
		}
		
		
//		int i = 0; 
//		String part = "";
//		while(!part.equals(period)) {
//			part = "";
//			
//			for(int j = 0; j < period.length(); j++) {
//				part += a.charAt(j);
//			}
//			
//			i++;
//		}
//		res = 
		return res;
	}

	public static String getEquationHTMLWithEquationString(String eq) {
		String equation = "<div align=\"center\"><p>";
		eq = eq.replace("+", "ppp");
		eq = eq.replace("-", "ppp-");
		eq = eq.replace("^", "vvv");
		String[] eqs = eq.split("ppp");
//		System.out.println(eq);
		for(String eqpart : eqs) {
			eqpart = eqpart.replace("x", "");
			if(eqpart.contains("vvv")) {
//				System.out.println(eqpart.split("vvv")[1]);
				if(eqpart.split("vvv")[1].equals("1")) {
					equation+=eqpart.split("vvv")[0] +"x";
				}else {
				equation+=eqpart.split("vvv")[0] +"x<sup>"  + eqpart.split("vvv")[1]+ "</sup>";
				}
			}else {
				if((eqpart.charAt(0)+"").equals("-")) {
					equation+=eqpart;
				}else {
					equation+="+"+eqpart;	
				}
			}
		}
//			eq.replaceAll("^", "<sup>");
//			String[] eqspl = eq.split("<sup>");
//			equation+=eqspl[0] + "<sup>";
//			for(int i = 1; i < eqspl.length;i++) {
//				while()
//			}
		
//		String[][] k = new String[eq.split][];
		
//		return getEquationHTML();
		return equation;
	}

	
}