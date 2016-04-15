

import java.util.ArrayList;
import java.util.Random;


public class Matrix extends Graph{
	
	private int[][] matrix;
	private int n;
	private double p;
	private Random r1;
	private Random r2;
	
	
	public Matrix(int n, long seed, double p){
		
		matrix = new int[n][n];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				matrix[i][j] = 0;
			}
		}
		
		this.n = n;
		this.p = p;
		r1 = new Random(seed);
		r2 = new Random(seed*2);
		
		generateGraph();
		while(!this.isConnected(this)){
			generateGraph();
		}
	}
	

	public void generateGraph(){
		
		for(int i = 0; i < n; i++){
			for(int j = i + 1; j < n; j++){
				if( r1.nextDouble() <= p){
					int weight = r2.nextInt(n) + 1;
					
					matrix[i][j] = weight;
					matrix[j][i] = weight;
				}
			}
		}
	}
	
	@Override
	public String toString(){
		String str = "The graph as an adjacency matrix:\n";
		str += "- ";
		str += "\n";
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				str += matrix[i][j] + " ";
			}
			str = str.trim();
			str += "\n";
		}
		return str;
	}
	

	
	@Override
	public int size() {
		return n;
	}

	@Override
	public ArrayList<Neighbour> getNeighbourNodes(int node) {
		ArrayList<Neighbour> neighbourNodes = new ArrayList<Neighbour>();
		for (int i = 0; i < this.n; i++){
			int weight = this.matrix[node][i];
			if(weight > 0){
				neighbourNodes.add(0,new Neighbour(i, weight));
			}
		}
		
		return neighbourNodes;
	}

	public ArrayList<Edge> getEdges(){
		ArrayList<Edge> listEdges = new ArrayList<Edge>();
		
		for(int i = 0; i < this.n; i++){
			for(int j = 0; j < this.n; j++){
				if((this.matrix[i][j] > 0) && (i < j)){
					listEdges.add(new Edge(i,j,matrix[i][j]));
				}
			}
		}
		
		return listEdges;
	}


}
