

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Random;

public class AdjacencyList extends Graph{
	
	private Map<Integer, ArrayList<Neighbour>> List = new TreeMap<Integer, ArrayList<Neighbour>>();
	
	private int n;
	private double p;
	private Random r1;
	private Random r2;
	private TreeMap<Integer,Integer> predMap;
	
	
	
	
	public AdjacencyList(int n, long seed, double p){
		this.n = n;
		this.p = p;
		r1 = new Random(seed);
		r2 = new Random(seed*2);
		
		
		for (int i = 0; i < n; i++){
			ArrayList<Neighbour> tempList = new ArrayList<Neighbour>();
			List.put(i, tempList);
		}
		
		generateGraph();
		while(!this.isConnected(this)){
			generateGraph();
		}
	}
	
	private void generateGraph(){
		
		
		for (int i = 0; i < n; i++){
			for (int j = i + 1; j < n; j++){
				if( r1.nextDouble() <= p){
					int weight = r2.nextInt(n) + 1;
					
					
					Neighbour Neigh = new Neighbour(j, weight);
					List.get(i).add(Neigh);
					
					Neighbour NeighB = new Neighbour(i, weight);
					List.get(j).add(NeighB);
				}
			}
		}
	}
	
	@Override
	public int size() {
		return List.size();
	}

	@Override
	public ArrayList<Neighbour> getNeighbourNodes(int n) {
		ArrayList<Neighbour> reversedList = new ArrayList<Neighbour>();
		for (Neighbour t : List.get(n)){
			reversedList.add(0,t);
		}
		return reversedList;
	}


	
	public String toString(){
		String str = "The graph as an adjacency list:\n";
		for (int key = 0; key < n; key++){
			if(List.get(key) == null){
				str += key + "-> []" + "\n";
			} else if(List.get(key).isEmpty()) {
				str += key + "-> []" + "\n";
			} else {
				str += key + "-> " + List.get(key).toString() + "\n";
			}
			
		}
		str += PredString();
		return str;
	}
	
	public String PredString(){
		String str = "\nDepth-First Search:\nVertices:\n";
		for(int i = 0; i < n; i++){
			str += i + " ";
		}
		str += "\nPredecessors:\n";
		for(int i = 0; i < n; i++){
			str += predMap.get(i) + " ";
		}
		str += "\n";
		return str;
	}
	
	@Override
	public boolean isConnected(Graph g){
		TreeMap<Integer,Integer> dfsList = DFS(g);
		if(g.size() == dfsList.size()){
			this.predMap = dfsList;
		}
		return g.size() == dfsList.size();
	}
	
	public ArrayList<Edge> getEdges(){
		
		ArrayList<Edge> listEdges = new ArrayList<Edge>();
		for (int i = 0; i < this.n; i++){
			for(Neighbour n : List.get(i)){
				if (i < n.getRightNode()){
					listEdges.add(new Edge(i, n.getRightNode(), n.getWeight()));
				}
				
			}
		}
	
		return listEdges;
	}

	
}
