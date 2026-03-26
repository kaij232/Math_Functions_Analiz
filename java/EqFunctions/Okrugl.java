package EqFunctions;
public class Okrugl{
	public static float okrugl(float num, int degree) {
//		степень с учётом точки, то есть то жл которого округлят + 1
		String res = "";
		char[] chnum = ("" + num).toCharArray();
		
		for(int i = 0 ; i < degree-1; i++) {
		
			res+= chnum[i];
			
//			if((chnum[i] + "").equals(".")) {
//				
//				for(int j = i+1 ; j < degree + i; j++ ) {
//					res += chnum[i];
//				}
//				
//				break;
//			}
		}
		
		if(Integer.parseInt(chnum[degree]+"") >= 5) {
			res += (Integer.parseInt(chnum[degree-1]+"") + 1);
		}else {
			res += chnum[degree-1];
		}
		
		return Float.parseFloat(res);
	}
	
	
	public static float okruglAfterToch1(float num, int degree) {
//		System.out.println((num+"").split("\\.")[0]);
		String res = (num+"").split("\\.")[0] + ".";
		char[] chnum = ("" + num).split("\\.")[1].toCharArray();
		if(chnum.length <= degree) {
			for(char i : chnum) {
				res += i;
			}
		}else {
		for(int i = 0 ; i < degree-1; i++) {
		
			res+= chnum[i];
			
//			if((chnum[i] + "").equals(".")) {
//				
//				for(int j = i+1 ; j < degree + i; j++ ) {
//					res += chnum[i];
//				}
//				
//				break;
//			}
		}
		
		if(Integer.parseInt(chnum[degree]+"") >= 5) {
			res += (Integer.parseInt(chnum[degree-1]+"") + 1);
		}else {
			res += chnum[degree-1];
		}
		}
		
		return Float.parseFloat(res);
	}
	
	
	
	
	
	
	public static float okruglAfterToch(float num, int degree) {
		char[] drobnum = (num+"").split("\\.")[1].toCharArray();
		String res = "";
		if(drobnum.length <= degree) {
			res += num;
		}else {
		if(Integer.parseInt(drobnum[degree]+"") >= 5) {
			num += Math.pow(10, -degree);
			drobnum = (num+"").split("\\.")[1].toCharArray();
			res += (num+"").split("\\.")[0] + ".";
			for(int i = 0; i < degree; i++) {
				res += drobnum[i];
			}
		}else {
			res += (num+"").split("\\.")[0] + ".";
			for(int i = 0; i < degree; i++) {
				res+= drobnum[i];
			}
		}
		}
		
		return Float.parseFloat(res);
	}
//	public static void main(String[] args) {
//		System.out.println(okruglAfterToch1(23f , 2));
//	}
//	
}
