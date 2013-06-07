import java.util.Arrays;


public class Select {

  public static Comparable select(Comparable[] a, int i) {
		return select(a, 0, a.length - 1, i);
	}
	
	public static Comparable select(Comparable[] a, int lo, int hi, int i) {
		System.out.println("select(" + lo + "," + hi + "," + i + ")");
		if (hi <= lo) {
			return lo;
		}
		
		int q = partition(a, lo, hi);
		System.out.println("pivot: " + q);
		
		int k = q - lo + 1;
		
		if (i == k) {
			return q;
		} else if (i < k) {
			return select(a, lo, q - 1, i);
		} else {
			return select(a, q + 1, hi, i - k);
		}
	}
	
	public static int partition(Comparable[] a, int lo, int hi) {
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
		System.out.println(select(data, 4));
	}

}
