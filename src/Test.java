
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		PriorityQ q = new PriorityQ(8);
//		q.addElement(3,3);
//		q.addElement(2,2);
//		q.addElement(1,2);
//		q.addElement(4,2);
//		q.addElement(6,4);
//		q.addElement(5,2);
//		q.heapify();
		
		Graph ajay = new Matrix(9, 100000, 0.5);
		ajay.Prim();
//		Edge[] sorted = ajay.QuickSort();
//		Edge[] kruskal = ajay.Kruskal(sorted);
//		int weight = 0;
//		for (Edge e: kruskal){
//			weight += e.getWeight();
//			System.out.println(e);
//		}
//		System.out.println(weight);
	}

}
