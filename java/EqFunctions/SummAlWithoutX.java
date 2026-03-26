package EqFunctions;

public class SummAlWithoutX {
public static String summ(String eq) {
	char[] eqch = eq.toCharArray();
	String res = "";
	int znPl = 0;
	for( int i = 0; i< eqch.length; i++) {
		if((""+eqch[i]).equals("+")) {
			znPl++;
		}
	}while(znPl>0) {
		eqch = eq.toCharArray();
		eq = "";
	for(int i = 0; i< eqch.length; i++) {
		if(("" + eqch[i]).equals("+")) {
			
			int num1 = 0;
			String num1S = "";
			int startOfNum1 = 0;
			// указывает индекс уже первой цифры первого слагаемого
			int num2 = 0;
			String num2S = "";
			int endOfNum2 = 0;
			// указывает индекс последней цифры второго слагаемого
			
			
			// first slagaemoe
			try {
				for(int j = i-1; j>=0; j--) {
					Integer.parseInt((eqch[j] + ""));
					startOfNum1 = j;
				}
			}catch(java.lang.NumberFormatException e) {
			}
			
			for(int j = startOfNum1; j < i; j++) {
				num1S += eqch[j];
				num1 = Integer.parseInt(num1S);
			}
			
			
			
			// second slagaemoe
			try {
				for(int j = i+1; j < eqch.length; j++) {
					Integer.parseInt((eqch[j] + ""));
					num2S += eqch[j];
					endOfNum2 = j;
				}
			}catch(java.lang.NumberFormatException e) {
			}

			num2 = Integer.parseInt(num2S);
			
			
			
			
			int sum = num1 + num2;
			for(int j = 0; j < startOfNum1;j++) {
					eq+= eqch[j];
			}
				eq+= sum;
				
			for(int j = endOfNum2; j>eqch.length; j++) {
				eq+= eqch[j];
				}
			}

	}
			znPl--;	
		}
	

	
	res = eq;
	return res;
}
public static String summ2(String eq) {
	char[] eqch = eq.toCharArray();

	int plusCount = 0;
	for(int i = 0; i< eqch.length; i++) {
		if((eqch[i] + "").equals("+")) {
			plusCount++;
		}
	}
	System.out.println("plusCount: "+plusCount);
	
	int[] plusPlaces = new int[plusCount];
	for(int i = 0; i< eqch.length; i++) {
		if((eqch[i] + "").equals("+")) {
			for(int j = 0; j<plusPlaces.length; j++) {
				if((plusPlaces[j] + "").equals("")) {
					plusPlaces[j] = i;
				}
			}
 		}
	}
	String[] eqs = new String[plusCount+1];
for(int i = 0; i< plusPlaces.length; i++) {
	if(i == 0) {
	for(int j = 0; j < plusPlaces[i]; j++) {
		if((j == plusPlaces.length - 1) && !((eqch[j] + "").equals(""))) {
			for(int k = plusPlaces[i]+1; k<eqch.length; k++) {
			eqs[i+1] += eqch[k];
			}
		}else {
		eqs[i] += eqch[j];
		}
		
				// делать стобы в отдельные ячейки екус заполнялись отдельные слагаемые, а потом просто суммировались
	}
	}else if(i == plusPlaces.length-1) {
		for(int j = plusPlaces[i-1]+1; j< eqch.length; j++) {
			
		}
	}else {
for(int j = plusPlaces[i-1]+1; j< plusPlaces[i]; j++) {
			
		}
	}
}
int sum = 0;
for(int i = 0; i < eqs.length; i++) {

	sum += Integer.parseInt(eqs[i]);
	System.out.println(i);
}
	return sum+"";
}


public static void main(String args[]) {
	System.out.println(summ2("121+121+121"));
}
	
}
