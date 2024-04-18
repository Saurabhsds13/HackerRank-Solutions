package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Result {

  public static int simpleArraySum(List<Integer> ar) {
    int sum = 0;
    int[] arr = new int[ar.size()];
    for (int i = 0; i < ar.size(); i++) {
      arr[i] = ar.get(i);
      sum = sum + arr[i];
    }
    return sum;
  }
}

public class SimpleArraySum {

  public static void main(String[] args) throws IOException {
    System.out.println("Enter the Size of the array : ");
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> ar = new ArrayList<Integer>();
   
    for(int i = 0; i < n;i++) {
    	ar.add(Integer.parseInt(bufferedReader.readLine().trim())) ;
    }
    
    int result = Result.simpleArraySum(ar);

    System.out.println(result);
    bufferedReader.close();
  }
}
