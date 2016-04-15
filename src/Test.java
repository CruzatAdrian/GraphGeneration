
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Graph ajay = new Matrix(300, 100000, 0.5);
		Edge[] sorted = ajay.QuickSort();
		Edge[] kruskal = ajay.Kruskal(sorted);
		int weight = 0;
		for (Edge e: kruskal){
			weight += e.getWeight();
			System.out.println(e);
		}
		System.out.println(weight);
	}

}
