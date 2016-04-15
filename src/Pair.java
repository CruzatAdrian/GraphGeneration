

public class Pair {

	int currentNode;
	int predNode;
	
	public Pair(int curr, int pred){
		this.currentNode = curr;
		this.predNode = pred;
	}

	public int getCurrentNode() {
		return currentNode;
	}

	public int getPredNode() {
		return predNode;
	}
}
