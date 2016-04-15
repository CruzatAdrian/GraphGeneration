
public class Edge implements Comparable<Edge>{

	private int leftNode;
	private int rightNode;
	private int weight;
	
	public Edge(int leftNode, int rightNode, int w){
		this.leftNode = leftNode;
		this.rightNode = rightNode;
		this.weight = w;
	}
	
	public Edge(Edge e){
		this.leftNode = e.getLeftNode();
		this.rightNode = e.getRightNode();
		this.weight = e.getWeight();
	}
	
	public int getLeftNode() {
		return leftNode;
	}

	public int getRightNode() {
		return rightNode;
	}

	public int getWeight() {
		return weight;
	}

	public int compareTo(Edge compare){
		if(this.weight != compare.getWeight()){
			return this.weight - compare.getWeight();
		} else if (this.leftNode != compare.getLeftNode()){
			return this.leftNode - compare.getLeftNode();
		} else if (this.rightNode != compare.getRightNode()){
			return this.rightNode - compare.getRightNode();
		} else {
			return 0;
		}
	}
	
	public boolean isLessThan(Edge Compare){
		if(this.weight != Compare.getWeight()){
			return this.weight < Compare.getWeight();
		} else if(this.leftNode != Compare.getLeftNode()){
			return this.leftNode < Compare.leftNode;
		} else{
			return this.rightNode < Compare.rightNode;
		}
	}
	
	public String toString(){
		return this.weight + "(" + this.leftNode + "," + this.rightNode + ") ";
	}
}
