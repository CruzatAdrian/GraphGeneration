
public class PartitionNode {

	private int root;
	private int id;
	private int rank = 0;
	
	public PartitionNode(int id){
		this.id = id;
		this.root = id;
	}
	
	public boolean isOwnRoot(){
		return this.id == this.root;
	}
	
	public void setRoot(int root){
		this.root = root;
	}
	
	public int getId(){
		return this.id;
	}
	
	public int getRoot(){
		return this.root;
	}
	
	public int getRank(){
		return this.rank;
	}
	
	public void updateRank(int add){
		this.rank += add;
	}
}
