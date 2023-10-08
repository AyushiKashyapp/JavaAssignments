import java.util.ArrayList;
import java.util.Comparator;

public class New_Sort_Integer_Sequential_1 {

	static void sort(ArrayList<Integer> list, Integer left, Integer right, Comparator<Integer> comp) { //Passing Comparator object
		
		if (right <= left)
			return;
		
		Integer s = part(list, left, right, comp); //Passing Comparator object
	
		sort(list, left, s - 1, comp); //Passing Comparator object
		
		sort(list, s + 1, right, comp); //Passing Comparator object
	
	}

	static Integer part(ArrayList<Integer> list, Integer left, Integer right, Comparator<Integer> comp) { //Passing Comparator object
		
		assert(left < right);
		
		Integer i = left - 1, j = right;
		
		for(;;) {
		
			while (comp.compare(list.get(++i), list.get(right))<0) //Calling compare method from Comparator
				; 
			
			while (comp.compare(list.get(right), list.get(--j))<0) //Calling compare method from Comparator
				if (j.equals(left))
					break; 
			
			if (i >= j)
				break; 
			
			swap(list, i, j); 
		
		}
		
		swap(list, i, right);
		
		return i;
	
	}

	// static boolean compare(Integer x, Integer y) {
		
	// 	return x < y;
	
	// }

	static void swap(ArrayList<Integer> list, Integer i, Integer j) {	
		
		Integer h = list.get(i);
		
		list.set(i, list.get(j));
		
		list.set(j, h);
	
	}

	public static void main(String[] args) {
		
		// We test the sorting procedure with a list of random integer objects
		
		Integer n = 100000;
		
		ArrayList<Integer> list = new ArrayList<Integer>();

		Comparator<Integer> comp = new Comparator<Integer>() { //Override Comparator method
			@Override
			public int compare(Integer x, Integer y){
				return (x).compareTo(y);
			}
		};
		
		for (int i = 0; i < n; i++)
			list.add((int) Math.ceil(Math.random() * n));

		sort(list, 0, n-1, comp); //Passing Comparator object

		for (int i = 0; i < n; i++) {
		
			System.out.print(list.get(i) + ", ");
			
			if(i > 0 && i % 20 == 0)
				System.out.println();				
			
		}
		
	}
}