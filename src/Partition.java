import java.util.ArrayList;


public class Partition {

	private ArrayList<PartitionNode> Elements = new ArrayList<PartitionNode>();
	
	public Partition(int Size){
		for (int i = 0; i < Size; i++){
			Elements.add(new PartitionNode(i));
		}
	}
	
	public boolean sameRoot(int u, int v){
		return find(u) == find(v);
	}
	
	public int find(int u){
		if (!(Elements.get(u).isOwnRoot())){
			Elements.get(u).setRoot(find(Elements.get(u).getRoot()));
		}
		return Elements.get(u).getRoot();
	}
	
	public void union(int u, int v){
		int i = find(u);
		int j = find(v);
		if(Elements.get(i).getRank() > Elements.get(j).getRank()){
			Elements.get(j).setRoot(i);
		} else {
			Elements.get(i).setRoot(j);
			if (Elements.get(i).getRank() == Elements.get(j).getRank()){
				Elements.get(j).updateRank(1);
			}
		}
	}
}
