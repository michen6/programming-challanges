import java.util.Arrays;


public class Quick {

  public static boolean less(int a, int b) {
		return a < b;
	}
	
	public static void swap(int[] data, int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
	
	public static int partition (int[] data, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		int v = data[lo];
		
		while(true) {
			System.out.println(Arrays.toString(data));

			while (less(data[++i], v)) if (i == hi) break;
			while (less(v, data[--j])) if (j == lo) break;
			if (i >=j) break;
			System.out.println("swap(" + i + ", " + j + ")" );
			swap(data, i, j);
		}
		System.out.println("final swap(" + lo + ", " + j + ")" );
		swap(data, lo, j);
		return j;
	}
	
	public static void sort(int[] data, int lo, int hi) {
		System.out.println("sort(" + lo + ", " + hi + ")");
		if (hi <= lo) return;
		int j = partition(data, lo, hi);
		sort(data, lo, j-1);
		sort(data, j+1, hi);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = new int[] {5, 4, 6, 8, 1, 0, 2, 9, 3, 7};
		
		sort(data, 0, data.length - 1);
		
		System.out.println(Arrays.toString(data));
	}

}
