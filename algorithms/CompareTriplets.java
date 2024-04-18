package algorithms;

import java.io.*;
import java.util.*;

class Results {

  /*
   * Complete the 'compareTriplets' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY a
   *  2. INTEGER_ARRAY b
   *  
   *  The task is to find their comparison points by comparing a[0] with b[0], a[1] with b[1], and a[2] with b[2].

		If a[i] > b[i], then Alice is awarded 1 point.
		If a[i] < b[i], then Bob is awarded 1 point.
		If a[i] = b[i], then neither person receives a point.
   */

  public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
	  
	  
	  int aliceScore =0;
	  int bobScore =0;
	  
	  
	    int[] c = new int[5];
	    int[] d = new int[5];
	    for (int i = 0; i < a.size(); i++) {
	      if (a.get(i) > b.get(i)) {
	        ++aliceScore;
	        c[0]=aliceScore;
	        
	      }else if((a.get(i) < b.get(i))){
	    	  ++bobScore;
	    	  d[0]=bobScore;
	      }
	    }

    List<Integer> s = new ArrayList<>();
    s.add(c[0]);
    s.add(d[0]);

    return s;
  }
}

public class CompareTriplets {

  public static void main(String[] args) throws IOException {
    System.out.println("Enter triplet : ");
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    String[] aTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    List<Integer> a = new ArrayList<>();

    for (int i = 0; i < 3; i++) {
      int aItem = Integer.parseInt(aTemp[i]);
      a.add(aItem);
    }

    String[] bTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    List<Integer> b = new ArrayList<>();

    for (int i = 0; i < 3; i++) {
      int bItem = Integer.parseInt(bTemp[i]);
      b.add(bItem);
    }

    List<Integer> result = Results.compareTriplets(a, b);

    System.out.println(result);
    bufferedReader.close();
  }
}
