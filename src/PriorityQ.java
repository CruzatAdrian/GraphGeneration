
public class PriorityQ {

	PriorityElement[] q;
	int[] loc;
	int totalElements = 0;
	
	public PriorityQ(int size){
		q = new PriorityElement[size];
		loc = new int[size];
	}
	
	public void addElement(int element, int priority){
		this.q[totalElements] = new PriorityElement(element, priority, element);
		this.loc[element] = totalElements;
		this.totalElements++;
	}
	
	public PriorityElement removeTop(){
		if (!isEmpty()){
			PriorityElement ret = this.q[0];
			switchElements(0, totalElements -1 );
			totalElements--;
			return ret;
		} else {
			return null;
		}
	}
	
	private void switchElements(int a, int b){
		PriorityElement newA = new PriorityElement(q[b]);
		PriorityElement newB = new PriorityElement(q[a]);
		
		q[a] = newA;
		q[b] = newB;
		
	
		loc[q[b].getNode()] = b;
		loc[q[a].getNode()] = a;
	}
	
	public boolean isEmpty(){
		return totalElements <= 0;
	}
	
	public void updatePriorityNode(int element, int priority, int parent){
		if (isHigherPriority(element, priority)){
			cheangePriority(element, priority, parent);
		}
	}
	
	public boolean isHigherPriority(int element, int priority){
		return priority < q[loc[element]].getPriority();
	}
	
	public void cheangePriority(int element, int priority, int parent){
		this.q[loc[element]].setPriority(priority);
		this.q[loc[element]].setParent(parent);
	}
	
	//input: node number, head is 1
	private void updateParentChild(int parent,int lChild,int rChild){
		
		if (lChild > this.totalElements){
			return;
		} else if ( rChild > this.totalElements){
			if (q[lChild -1].getPriority() < q[parent -1].getPriority()){
				switchElements(parent - 1, lChild - 1);
				return;
			}
		} else {
			int parentPriority = q[parent -1].getPriority();
			int leftCPriority = q[lChild -1].getPriority();
			int rightCPriority = q[rChild -1].getPriority();
			
			if (parentPriority < leftCPriority && parentPriority < rightCPriority){
				return;
			} else {
				if (leftCPriority <= rightCPriority){
					switchElements(parent - 1, lChild - 1);
					updateParentChild(lChild, lChild*2, (lChild*2) +1);
				} else {
					switchElements(parent - 1, rChild - 1);
					updateParentChild(rChild, rChild*2, (rChild*2) +1);
				}
			}
		}
		
		
	}
	
	public void heapify(){
		for (int level = (int)(Math.log(this.totalElements)/Math.log(2)); level >= 0; level--){
			for (int i = (int)Math.pow(2, level); i < (int)Math.pow(2, level + 1); i++){
				updateParentChild(i, i*2, (i*2)+1);
			}
		}
	}
	
	@Override
	public String toString(){
		String str = "";
		for (PriorityElement i : q){
			str += i.toString();
		}
		return str;
	}
}
