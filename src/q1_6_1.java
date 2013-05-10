import java.io.*;

public class q1_6_1 {
  public static int cycleLength (int n) {
		int count = 0;
		while (n != 1) {
			if (n % 2 == 0) {
				n /= 2;
				count += 1;
			} else {
				n = n * 3 + 1;
				count += 1;
			}
		}
		return ++count;
	}
	
	public static int pair(int i, int j) {
		int count = 0;
		int max = 0;
		
		for (i = i; i <= j; i += 1) {
			count += cycleLength(i);
			if (count > max) {
				max = count;
			}
			count = 0;
		}
		return max;
	}
	
	public static void main (String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
			String line;
			String[] number;
			
			while ((line = br.readLine()) != null) {
				number = line.split(" ");
				System.out.println(line + " " + pair(Integer.parseInt(number[0]), Integer.parseInt(number[1])));
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
