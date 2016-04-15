


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;




public class MST {

	public static void main(String[] args) {
		String filename;
		File file;
		String strN;
		String strSeed;
		String strP;
		int n;
		int seed;
		double p;
		
		try{
			if(args.length <= 0){
				throw new InsufficientArguments();
			}
			filename = args[0];
			file = new File(filename);
			if(!file.exists()){
				throw new FileNotFound();
			}
			BufferedReader br = new BufferedReader(new FileReader(file));
			strN = br.readLine();
			strSeed = br.readLine();
			strP = br.readLine();
			br.close();
			
			if(strN.matches("^-?\\d+$") && strSeed.matches("^-?\\d+$")){
				n = Integer.parseInt(strN);
				seed = Integer.parseInt(strSeed);
			} else {
				throw new NotAnInteger();
			}
			if(n < 2){
				throw new LessThanTwo();
			}
			
			p = Double.parseDouble(strP);
			
			if(p < 0 || p > 1){
				throw new PLessInvalid();
			}
			
			long startTime;
			long endTime;
			
			startTime = System.currentTimeMillis();
			AdjacencyList ajay = new AdjacencyList(n, seed, p);
			Matrix matt = new Matrix(n, seed, p);
			endTime = System.currentTimeMillis();
			
			System.out.println("TEST: n=" + n + ", seed=" + seed + ", p=" +p);
			System.out.println("Time to generate the graph " + (endTime - startTime) + " milliseconds");
			
			if(n < 10){
				System.out.println(matt);
				System.out.println(ajay);			
			} 	
			
			System.out.println("===================================");
			System.out.println("KRUSKAL WITH MATRIX USING INSERTION SORT");
			startTime = System.currentTimeMillis();
			Edge[] InsMat= matt.Kruskal(matt.InsertionSort());
			endTime = System.currentTimeMillis();
			System.out.println(edgeListToString(InsMat, startTime, endTime,n));
			System.out.println("===================================");
			System.out.println("KRUSKAL WITH MATRIX USING COUNT SORT");
			startTime = System.currentTimeMillis();
			Edge[] CntMat= InsMat= matt.Kruskal(matt.CountSort());
			endTime = System.currentTimeMillis();
			System.out.println(edgeListToString(CntMat, startTime, endTime,n));
			System.out.println("===================================");
			System.out.println("KRUSKAL WITH MATRIX USING QUICKSORT");
			startTime = System.currentTimeMillis();
			Edge[] QckMat= InsMat= matt.Kruskal(matt.QuickSort());
			endTime = System.currentTimeMillis();
			System.out.println(edgeListToString(QckMat, startTime, endTime,n));
			System.out.println("===================================");
			System.out.println("KRUSKAL WITH LIST USING INSERTION SORT");
			startTime = System.currentTimeMillis();
			Edge[] InsAjl= InsMat= ajay.Kruskal(ajay.InsertionSort());
			endTime = System.currentTimeMillis();
			System.out.println(edgeListToString(InsAjl, startTime, endTime,n));
			System.out.println("===================================");
			System.out.println("KRUSKAL WITH LIST USING COUNT SORT");
			startTime = System.currentTimeMillis();
			Edge[] CntAjl= InsMat= ajay.Kruskal(ajay.CountSort());
			endTime = System.currentTimeMillis();
			System.out.println(edgeListToString(CntAjl, startTime, endTime,n));
			System.out.println("===================================");
			System.out.println("KRUSKAL WITH LIST USING QUICKSORT");
			startTime = System.currentTimeMillis();
			Edge[] QckAjl= InsMat= ajay.Kruskal(ajay.QuickSort());
			endTime = System.currentTimeMillis();
			System.out.println(edgeListToString(QckAjl, startTime, endTime,n));
				
		} catch (NumberFormatException e){
			System.out.println("p must be a real number");
			System.exit(0);
		} catch (Exception e){
			System.out.println(e.getMessage());
			System.exit(0);
		} 
		
		
		
		
	}
	
	private static String edgeListToString(Edge[] edges, long Start, long End, int n){
		String str = "";
		int totWeight = 0;
		for (Edge e : edges){
			totWeight += e.getWeight();
			if (n < 10){
				str += e.getLeftNode() + " " + e.getRightNode() + " weight = " + e.getWeight() + "\n";
			}
			
		}
		str += "\nTotal weight of MST using Kruskal:" + totWeight + "\nRuntime: " + (End - Start) + " milliseconds\n";
		return str;
	}
	
	
}

