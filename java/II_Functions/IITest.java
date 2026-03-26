package II_Functions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class IITest {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		IITest II= new IITest(new int[]{2,2,1});
		
		String inp = "";
		String red = "";
//		double[][][] data = new double[][][] {{{0, 0}, {0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5}, {0, 6}, {0, 7}, {0, 8}, {0, 9}, {0, 10}, {1, 0}, {1, 1}, {1, 2}, {1, 3}, {1, 4}, {1, 5}, {1, 6}, {1, 7}, {1, 8}, {1, 9}, {1, 10}, {2, 0}, {2, 1}, {2, 2}, {2, 3}, {2, 4}, {2, 5}, {2, 6}, {2, 7}, {2, 8}, {2, 9}, {2, 10}, {3, 0}, {3, 1}, {3, 2}, {3, 3}, {3, 4}, {3, 5}, {3, 6}, {3, 7}, {3, 8}, {3, 9}, {3, 10}, {4, 0}, {4, 1}, {4, 2}, {4, 3}, {4, 4}, {4, 5}, {4, 6}, {4, 7}, {4, 8}, {4, 9}, {4, 10}, {5, 0}, {5, 1}, {5, 2}, {5, 3}, {5, 4}, {5, 5}, {5, 6}, {5, 7}, {5, 8}, {5, 9}, {5, 10}, {6, 0}, {6, 1}, {6, 2}, {6, 3}, {6, 4}, {6, 5}, {6, 6}, {6, 7}, {6, 8}, {6, 9}, {6, 10}, {7, 0}, {7, 1}, {7, 2}, {7, 3}, {7, 4}, {7, 5}, {7, 6}, {7, 7}, {7, 8}, {7, 9}, {7, 10}, {8, 0}, {8, 1}, {8, 2}, {8, 3}, {8, 4}, {8, 5}, {8, 6}, {8, 7}, {8, 8}, {8, 9}, {8, 10}, {9, 0}, {9, 1}, {9, 2}, {9, 3}, {9, 4}, {9, 5}, {9, 6}, {9, 7}, {9, 8}, {9, 9}, {9, 10}, {10, 0}, {10, 1}, {10, 2}, {10, 3}, {10, 4}, {10, 5}, {10, 6}, {10, 7}, {10, 8}, {10, 9}, {10, 10}}, {{0.0}, {0.05}, {0.1}, {0.15000000000000002}, {0.2}, {0.25}, {0.30000000000000004}, {0.35000000000000003}, {0.4}, {0.45}, {0.5}, {0.05}, {0.1}, {0.15000000000000002}, {0.2}, {0.25}, {0.30000000000000004}, {0.35000000000000003}, {0.4}, {0.45}, {0.5}, {0.55}, {0.1}, {0.15000000000000002}, {0.2}, {0.25}, {0.30000000000000004}, {0.35000000000000003}, {0.4}, {0.45}, {0.5}, {0.55}, {0.6000000000000001}, {0.15000000000000002}, {0.2}, {0.25}, {0.30000000000000004}, {0.35000000000000003}, {0.4}, {0.45}, {0.5}, {0.55}, {0.6000000000000001}, {0.65}, {0.2}, {0.25}, {0.30000000000000004}, {0.35000000000000003}, {0.4}, {0.45}, {0.5}, {0.55}, {0.6000000000000001}, {0.65}, {0.7000000000000001}, {0.25}, {0.30000000000000004}, {0.35000000000000003}, {0.4}, {0.45}, {0.5}, {0.55}, {0.6000000000000001}, {0.65}, {0.7000000000000001}, {0.75}, {0.30000000000000004}, {0.35000000000000003}, {0.4}, {0.45}, {0.5}, {0.55}, {0.6000000000000001}, {0.65}, {0.7000000000000001}, {0.75}, {0.8}, {0.35000000000000003}, {0.4}, {0.45}, {0.5}, {0.55}, {0.6000000000000001}, {0.65}, {0.7000000000000001}, {0.75}, {0.8}, {0.8500000000000001}, {0.4}, {0.45}, {0.5}, {0.55}, {0.6000000000000001}, {0.65}, {0.7000000000000001}, {0.75}, {0.8}, {0.8500000000000001}, {0.9}, {0.45}, {0.5}, {0.55}, {0.6000000000000001}, {0.65}, {0.7000000000000001}, {0.75}, {0.8}, {0.8500000000000001}, {0.9}, {0.9500000000000001}, {0.5}, {0.55}, {0.6000000000000001}, {0.65}, {0.7000000000000001}, {0.75}, {0.8}, {0.8500000000000001}, {0.9}, {0.9500000000000001}, {1.0}}};
//		double[][][] data = new double[][][] {{{0,0,0},{1,0,0},{0,1,0},{0,0,1},{1,1,0},{1,0,1},{0,1,1},{1,1,1}},{{0,0},{0,0},{0,1},{0,0},{0,1},{1,1},{1,1},{1,1}}};
		double[][][] data = new double[][][] {{{0,0},{0,1},{1,0},{1,1}},{{0},{1},{1},{0}}};

		//		double[][][] data = new double[2][][];
//		try {
//		BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\я\\eclipse-workspace\\workspace\\Parsing_Investing_Information\\src\\main\\dataForCriptoNeyroStudyConverted.txt")));
//		String[] data_ = br.readLine().split("_");
//		data[0] = new double[data_[1].split(";").length][10];
//		data[1] = new double[data_[1].split(";").length][1];
//		for(int set = 0; set< data[0].length; set++) {
//			for(int el = 0; el < data[0][set].length; el++) {
//				data[0][set][el] = Double.parseDouble(data_[0].split(";")[set].split(",")[el]);
//			}
//			data[1][set][0] = Double.parseDouble(data_[1].split(";")[set]);
//		}
//		}catch(IOException e) {
//			System.err.println(e);
//		}
		//		double[][][] data = new double[][][] {{{0,0,0},{1,0,0},{0,1,0},{0,0,1},{1,1,0},{1,0,1},{0,1,1},{1,1,1}},{{0,0},{0,0},{0,1},{0,0},{0,1},{1,1},{1,1},{1,1}}};
		red = scan.nextLine();
		while(!red.equals("0")) {
			if(red.equals("1")) {
				inp = scan.nextLine();
				II.updateActivations(new double[] {Double.parseDouble(inp.split(" ")[0]),Double.parseDouble(inp.split(" ")[1])});
				II.PrintNeyrons();
				double res = II.neyrons[II.Layers-1][0].activation;
				System.out.println("Res: " + res);
			}else if(red.equals("2")) {
				inp = scan.nextLine();
				System.out.println("Start Styudy!");
				II.Study(Integer.parseInt(inp.split(" ")[0]), Double.parseDouble(inp.split(" ")[1]), data);
				System.out.println("Studing is ready!");
			}else if(red.equals("3")) {
				inp = scan.nextLine();
				II.ProgressivStudyV2(Integer.parseInt(inp.split(" ")[0]), Double.parseDouble(inp.split(" ")[1]), data, II);
				System.out.println("Studing is ready!");
			}else if(red.equals("4")) {
				II.saveParameters("C:\\Users\\я\\eclipse-workspace\\workspace\\MathAndDataSciensTools.web\\src\\main\\java\\II_Functions\\Binder.txt");
			}
//			}else if(red.equals("4")) {
//				II.saveParameters();
//				System.out.println("Parameters have been saved!");
//			}else if(red.equals("5")) {
//			II.setParameters();
//			System.out.println("Parameters have been set!");
//		}
			red=scan.nextLine();
		}
		
	}
	
	
	
	private int Layers;
	private int[] LayersPower;
	private neyron[][] neyrons;
//	double[][][] data = new double[2][][];
//	private double[][] activations;
//	private double[][][] weights;
//	private double[][] bais;
	

	public IITest(int[] LayersPower_) {
		this.Layers = LayersPower_.length;
		this.LayersPower = LayersPower_;
		createNeyrons(this.Layers, this.LayersPower);
	}


private void createNeyrons(int layers, int[] layersPower) {
	neyrons = new neyron[layers][];
	
	
	neyrons[layers-1] = new neyron[layersPower[layers-1]];
	for(int  ney = 0; ney < layersPower[layers-1]; ney++) {
		neyrons[layers-1][ney] = new neyron(0);
//		neyrons[layers-1][i].printNeyron();
	}
	
	
	for(int lay = layers-2; lay >= 0;lay--) {
		neyrons[lay] = new neyron[layersPower[lay]];
		for(int ney = 0; ney < layersPower[lay]; ney++) {
			neyrons[lay][ney] = new neyron(neyrons[lay+1].length);
			
			if(lay == 0) {
				neyrons[lay][ney].bais = 0;
			}
//			neyrons[i][j].printNeyron();
		}
	}
}

private double SigmoidFunction(double x){
    return 1/(1 + Math.pow(Math.E,-x));
}

private double BackSigmoidFunction(double y){
    return -Math.log((1/y)-1);
}

private double DirativeSigmoidFunction(double x){
    return (SigmoidFunction(x)*(1-SigmoidFunction(x)));
}


private void updateActivations(double[] Input) {
	
	for(int ney = 0; ney < this.LayersPower[0]; ney++) {
		this.neyrons[0][ney].activation = Input[ney];
	}
	
	for(int lay = 1; lay < neyrons.length; lay++) {
		for(int ney = 0; ney < neyrons[lay].length; ney++) {
			neyrons[lay][ney].activation = 0;
			for(int bney = 0; bney < neyrons[lay-1].length;bney++) {
				neyrons[lay][ney].activation += neyrons[lay-1][bney].weights[ney]*neyrons[lay-1][bney].activation;
			}
			neyrons[lay][ney].activation+= neyrons[lay][ney].bais;
			neyrons[lay][ney].activation = SigmoidFunction(neyrons[lay][ney].activation);
		}
	}
	
}

//private void Error() {
//	System.out.println("Error!!!");
//}



public void Study(int Times, double speed, double[][][] data) {
	for(int time = 0; time < Times; time++) {
		backPropogation(speed, data);
	}
}


//protected void ProgressivStudy(int Times, double speed, double[][][] data, int steps, IICreate ii) {
//
//	double deltaSpeed = speed/steps;
//	for(int step = 0; step <= steps; step++) {
//		System.out.println((int)Math.round(((Times - 10)/(speed - 1))*deltaSpeed*step + ((10*speed - Times)/(speed - 1))));
//		System.out.println((double)(deltaSpeed*(double)(steps - step)));
//		ii.Study((int)Math.round(((Times - 10)/(speed - 1))*deltaSpeed*(steps - step) + ((10*speed - Times)/(speed - 1))), (double)(deltaSpeed*(double)(steps - step)), data);
//		System.out.println(step + " step is ready!");
//	}
//	
//}
public void ProgressivStudyV2(int Times, double speed, double[][][] data, IITest ii) {
//	System.out.println(Math.log10(speed));
	for(int step = 2; step <= -(int)Math.round(Math.log10(speed)); step++) {
//		System.out.println(Math.pow(10, -step));
		ii.Study(Times, Math.pow(10, -step), data);
		System.out.println(step-1 + " step is ready!");
	}
	
}

private void backPropogation(double speedA, double[][][] data) {
	for(int dataNum = 0; dataNum < data[0].length;dataNum++) {
//	int dataNum = (int) (Math.random()%10);
//	while(dataNum == 9 || dataNum == 8) {
//		dataNum = (int) (Math.random()%10);
//	}
//	int dataNum = (int) (Math.random());
		updateActivations(data[0][dataNum]);
		
		for(int ney = 0; ney < neyrons[Layers-1].length; ney++) {
			neyrons[Layers-1][ney].error = 0;
			neyrons[Layers-1][ney].error = (data[1][dataNum][ney] - neyrons[Layers-1][ney].activation)*DirativeSigmoidFunction(BackSigmoidFunction(neyrons[Layers-1][ney].activation));
		}
	
		for(int lay = (Layers-1)-1; lay >= 0; lay--) {
			for(int ney = 0; ney < neyrons[lay].length; ney++) {
				neyrons[lay][ney].error = 0;
				for(int nextLney = 0; nextLney < neyrons[lay+1].length; nextLney++) {
					neyrons[lay][ney].error += neyrons[lay+1][nextLney].error*neyrons[lay][ney].weights[nextLney];
				}
				neyrons[lay][ney].error *= DirativeSigmoidFunction(BackSigmoidFunction(neyrons[lay][ney].activation));
			}
		}
		
	
	
	
	for(int ney = 0; ney < neyrons[0].length; ney++) {
		for(int nextLney = 0; nextLney < neyrons[1].length; nextLney++) {
			neyrons[0][ney].weights[nextLney] += speedA*neyrons[0][ney].activation*neyrons[1][nextLney].error;
		}
	}
	for(int lay = 1; lay < neyrons.length-1; lay++) {
		for(int ney = 0; ney < neyrons[lay].length; ney++) {
			for(int nextLney = 0; nextLney < neyrons[lay+1].length; nextLney++) {
				neyrons[lay][ney].weights[nextLney] += speedA*neyrons[lay][ney].activation*neyrons[lay+1][nextLney].error;
				neyrons[lay][ney].bais+= speedA*neyrons[lay][ney].error;
			}
		}
	}
	for(int ney = 0; ney < neyrons[neyrons.length-1].length; ney++) {
		neyrons[neyrons.length-1][ney].bais+= speedA*neyrons[neyrons.length-1][ney].error;
	}
	}
}


public String getResult(double[] input) {
	String res = "";
	
	updateActivations(input);
	for(int ney = 0; ney < neyrons[Layers-1].length; ney++) {
		res += neyrons[Layers-1][ney] +" ";
	}
	
	return res;
}


public void saveParameters(String path) {
	try {
//	File file = new File("C:\\Users\\я\\eclipse-workspace\\workspace\\MathAndDataSciensTools.web\\src\\main\\java\\II_Functions\\Binder.txt");
		
		String weights = "";
		String Baises = "";
//		values divided by " ", neyrons by ",", layers by ";", weights and baises by "_"
		for(int lay = 0; lay < neyrons.length; lay++) {
			for(int ney = 0; ney < neyrons[lay].length; ney++) {
				for(int Nney = 0; Nney < neyrons[lay][ney].weights.length;Nney++) {
					weights += neyrons[lay][ney].weights[Nney] + " ";
				}
				Baises+=neyrons[lay][ney].bais+" ";
				weights += ",";
			}
			Baises += ";";
			weights += ";";
		}
		StringBuilder strb = new StringBuilder(weights);
		strb.deleteCharAt(weights.length()-1);
		strb.deleteCharAt(weights.length()-2);
		strb.deleteCharAt(weights.length()-3);
		weights = strb.toString();
		strb= new StringBuilder(Baises);
		strb.deleteCharAt(Baises.length()-1);
		strb.deleteCharAt(Baises.length()-2);
		Baises = strb.toString();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path)));
		bw.write(weights+"_"+Baises);
		bw.flush();
		bw.close();
		
	} catch (IOException e) {
		
		System.err.print(e);
	}
	
	}
	

//public void setParameters(String path) {
//	try {
//		BufferedReader br = new BufferedReader(new FileReader(new File(path)));
//	String params = br.readLine();
//	String weights = params.split("_")[0];
//	String Baises = params.split("_")[1];
//	br.close();
//	for(int lay = 0; lay < neyrons.length; lay++) {
//		for(int ney = 0; ney < neyrons[lay].length; ney++) {
//			for(int Nney = 0; Nney < neyrons[lay][ney].weights.length;Nney++) {
//					neyrons[lay][ney].weights[Nney] = Double.parseDouble(weights.split(";")[lay].split(",")[ney].split(" ")[Nney]);
//				}
//			neyrons[lay][ney].bais = Double.parseDouble(Baises.split(";")[lay].split(" ")[ney]);
//			}
//		}
//	
//	br.close();
//	}catch(IOException e) {
//		System.err.println(e);
//	}
//}

//get data from file where input and output divided by "_", datasets by ";", elements by ","
//public void setData(String path) {
//	try {
//	BufferedReader br = new BufferedReader(new FileReader(new File(path)));
//	String[] data_ = br.readLine().split("_");
//	br.close();
//	data[0] = new double[data_[1].split(";").length][10];
//	data[1] = new double[data_[1].split(";").length][1];
//	for(int set = 0; set< data[0].length; set++) {
//		for(int el = 0; el < data[0][set].length; el++) {
//			data[0][set][el] = Double.parseDouble(data_[0].split(";")[set].split(",")[el]);
//		}
//		data[1][set][0] = Double.parseDouble(data_[1].split(";")[set]);
//	}
//	}catch(IOException e) {
//		System.err.println(e);
//	}
//}


public void PrintNeyrons() {
	for(int i = 0; i < this.Layers; i++) {
		for(int j = 0 ; j < this.LayersPower[i]; j++) {
			this.neyrons[i][j].printNeyron();
		}
	}
}




	
private class neyron{
	private double[] weights;
	private double bais;
	private double activation;
	private double error;
	
//	public neyron(double[] weights, double bais, double activation) {
//		this.weights = weights;
//		this.bais = bais;
//		this.activation = activation;
//	}
	public neyron(int nLay) {
		if(nLay!=0) {
		this.bais = 0.2*Math.random()-0.1;
//		this.bais = 0;
		this.activation = 0;
		this.error = 0;
		weights = new double[nLay];
		for(int i = 0; i < weights.length; i++) {
			weights[i] = Math.random()-0.5;
		}
		}else {
		this.bais = 0.2*Math.random()-0.1;
//		this.bais = 0;
		this.weights = new double[] {0};
		this.activation = 0;
		this.error = 0;
		}
	}
	public void printNeyron() {
		String weights_ = "";
		for(int i = 0; i < this.weights.length; i++) {
			weights_+= ""+this.weights[i] + " ; " ;
		}
		System.out.println("Neyron: " + "\n" + "W: " + weights_ + "		A: " + this.activation+ "		B: " + this.bais + "		Err: "+ this.error);
	}
}

 }


