

public class Neighbour {

	private int rightNode;
	private int weight;
	
	public Neighbour(int rightNode, int w){
		this.rightNode = rightNode;
		this.weight = w;
	}

	public int getRightNode() {
		return rightNode;
	}

	public int getWeight() {
		return weight;
	}
	
	public String toString(){
		return "" + rightNode + "(" + weight + ")";
	}
}
