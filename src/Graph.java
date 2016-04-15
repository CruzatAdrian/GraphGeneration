

import java.util.ArrayList;
import java.util.Stack;
import java.util.TreeMap;

public abstract class Graph {

	public abstract int size();
	public abstract ArrayList<Neighbour> getNeighbourNodes(int n);
	public abstract ArrayList<Edge> getEdges(); 

	
	public boolean isConnected(Graph g){
		TreeMap<Integer,Integer> dfsList = DFS(g);
//		for(int key : dfsList.keySet()){
//			System.out.println(key + "<--" + dfsList.get(key));
//		}
		return g.size() == dfsList.size();
	}
	
	
	public TreeMap<Integer,Integer> DFS(Graph g){
		TreeMap<Integer, Integer> Visited = new TreeMap<Integer, Integer>();
		Stack<Pair> toVisit = new Stack<Pair>();
		

		Visited.put(0, -1);
		for (Neighbour n : g.getNeighbourNodes(0)){
			toVisit.push(new Pair(n.getRightNode(), 0));
		}
		
		Pair pair;
		int currNode;
		int predNode;
		
		while (!toVisit.isEmpty()){
			
			pair = toVisit.pop();
			currNode = pair.getCurrentNode();
			predNode = pair.getPredNode();
			if(!Visited.containsKey(currNode)){
				Visited.put(currNode, predNode);
			}
			
			
			for (Neighbour n : g.getNeighbourNodes(currNode)){
				int nextNode = n.getRightNode();
				if (!Visited.containsKey(nextNode)){
					toVisit.push(new Pair(nextNode, currNode));
				}
			}			
		}
		return Visited;
	}
	
	private Edge[] InsertionSortHelper(ArrayList<Edge> toSort){
		Edge[] sortedList = new Edge[toSort.size()];
		for(int i = 0; i < toSort.size(); i++){
			sortedList[i] = toSort.get(i);
		}
		for(int i = 0; i < toSort.size(); i++){
			Edge currentEdge = toSort.get(i);
			for(int j = i -1; j >= 0; j--){
				if(currentEdge.isLessThan(sortedList[j])){
					Exchange(sortedList, j+1,j);
				} else {
					break;
				}
			}
		}
		return sortedList;
	}
	
	private Edge[] CountSortHelper(ArrayList<Edge> toSort){
		int N = toSort.size();
		int R = this.size();
		int[] count = new int[R + 2];
		Edge[] sorted = new Edge[N];
		for(Edge e : toSort){
			count[e.getWeight() + 1]++;
		}
		for(int r = 0; r < R + 1; r++){
			count[r+1] += count[r];
		}
//		for (int i : count){
//			System.out.println(i);
//		}
		for(Edge e: toSort){
			sorted[count[e.getWeight()]] = e;
			count[e.getWeight()]++;
		}
		return sorted;
	}
	
	private ArrayList<Edge> QuickSortHelper(ArrayList<Edge> toSort){
		if (toSort.size() < 2){
			return toSort;
		} else {
			Edge Pivot = toSort.get(0); //Call first element as pivot
			ArrayList<Edge> lessThan = new ArrayList<Edge>();
			ArrayList<Edge> greaterThan = new ArrayList<Edge>();
			ArrayList<Edge> sorted = new ArrayList<Edge>();
			for (int i = 1; i < toSort.size(); i++){
				Edge Current = toSort.get(i);
				if (Current.isLessThan(Pivot)){
					lessThan.add(Current);
				} else {
					greaterThan.add(Current);
				}
			}
			sorted.addAll(QuickSortHelper(lessThan));
			sorted.add(Pivot);
			sorted.addAll(QuickSortHelper(greaterThan));
			return sorted;
		}
	}
	
	private void Exchange(Edge[] list, int indexA, int indexB){
//		System.out.println("Before Change list for index " + indexA + " " + indexB);
//		for(Edge e : list){
//			System.out.println(e);
//		}
		Edge A = new Edge(list[indexA]);
		Edge B = new Edge(list[indexB]);
		list[indexA] = B;
		list[indexB] = A;
//		System.out.println("After Change list for index" + indexA + " " + indexB);
//		for(Edge e : list){
//			System.out.println(e);
//		}
//		System.out.println("Done\n");
	}
	
	
	public Edge[] InsertionSort(){
		return InsertionSortHelper(this.getEdges());
	}
	
	public Edge[] CountSort(){
		return CountSortHelper(this.getEdges());
	}
	
	public Edge[] QuickSort(){
		ArrayList<Edge> Array = QuickSortHelper(this.getEdges());
		Edge[] edges = new Edge[Array.size()];
		for (int i = 0; i < Array.size(); i++){
			edges[i] = Array.get(i);
		}
		return edges;
	}
	
	public Edge[] Kruskal(Edge[] edgesSorted){
		Edge[] edgesMST = new Edge[this.size() -1];
		Partition part = new Partition(this.size());
		int count = 0;
		for (Edge e : edgesSorted){
			int rootU = part.find(e.getLeftNode());
			int rootV = part.find(e.getRightNode());
			if (rootU != rootV){
				edgesMST[count] = e;
				count++;
				part.union(rootU, rootV);
			}
			if(count >= this.size() -1){
				break;
			}
		}
		return edgesMST;
	}
	
}
