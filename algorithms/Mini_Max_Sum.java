package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers. Then print the respective minimum and maximum values as a single line of two space-separated long integers.*/

class Sum {

  public static void miniMaxSum(List<Integer> arr) {
	  int minSum=0,maxSum=0;
	  Collections.sort(arr); 
	  for(int i =0 ;i<arr.size()-1;i++) {
		  minSum+=arr.get(i);
	  }							
	  for(int i = 1;i<arr.size();i++) {
		  maxSum+=arr.get(i);
	  }
	  
	  System.out.println(minSum);
	  System.out.println(maxSum);
	  
}
}
public class Mini_Max_Sum {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter the array : ");
    String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    List<Integer> arr = new ArrayList<>();

    for (int i = 0; i < 5; i++) {
      int arrItem = Integer.parseInt(arrTemp[i]);
      arr.add(arrItem);
    }

    Sum.miniMaxSum(arr);

    bufferedReader.close();
  }
}
