
public class PriorityElement {

	private int node;
	private int priority;
	private int parent;
	


	public PriorityElement(int node, int priority, int parent){
		this.node = node;
		this.priority = priority;
		this.parent = parent;
	}
	
	public PriorityElement(PriorityElement copy){
		this.node = copy.getNode();
		this.priority = copy.getPriority();
		this.parent = copy.getParent();
	}
	
	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public void setPriority(int priority){
		this.priority = priority;
	}
	
	public int getNode() {
		return node;
	}

	public int getPriority() {
		return priority;
	}
	
	@Override
	public String toString(){
		return "Node: " + this.node + " P: " + this.priority + " Parent: " + this.parent + "||||";
	}
}
