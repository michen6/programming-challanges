import java.util.Arrays;


public class Quick_Comparable {
	
	public static void sort(Comparable[] a) {
		sort(a, 0, a.length - 1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi) {
		System.out.println("sort("+lo+","+hi+")");
		if (hi <= lo) return;
		int j = partition(a, lo, hi);
		sort(a, lo, j-1);
		sort(a, j+1, hi);
	}
	
	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo, j = hi+1;
		Comparable v= a[lo];
		while (true) {
			while (less(a[++i], v)) if (i == hi) break;
			while (less(v, a[--j])) if (j == lo) break;
			if (i >=j) break;
			System.out.println("exch("+i+","+j+")");
			exch(a, i, j);
			System.out.println(Arrays.toString(a));
		}
		System.out.println("exch("+lo+","+j+")");
		exch(a, lo, j);
		System.out.println(Arrays.toString(a));
		return j;
	}
	
	private static boolean less(Comparable a, Comparable b) {
		if (a.compareTo(b) < 0) {
			return true;
		} else {
			return false;
		}
	}
	
	private static void exch(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] data = new Integer[] {7, 5, 6, 4, 3, 8, 9, 1, 2, 0};
		sort(data);
		System.out.println(Arrays.toString(data));
	}

}
