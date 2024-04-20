package algorithms;

import java.io.*;
import java.util.*;

class Diff {

  /*
   * Complete the 'diagonalDifference' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts 2D_INTEGER_ARRAY arr as parameter.
   */

  public static int diagonalDifference(List<List<Integer>> arr) {
	  int differance = 0;
	    int rows = arr.size();
	    int cols = arr.get(0).size();

	    int[][] array2D = new int[rows][cols];

	    for (int i = 0; i < rows; i++) {
	      List<Integer> innerList = arr.get(i);
	      for (int j = 0; j < cols; j++) {
	        array2D[i][j] = innerList.get(j);
	      }
	    }

	    int[] primaryDiagonal = new int[Math.min(rows, cols)]; //We first determine the minimum of rows and cols to get the length of the diagonal We then create an array diagonal to store the diagonal elements.

	    //Primary diagonal
	    for (int i = 0; i < Math.min(rows, cols); i++) {
	      //We use a single for loop to iterate through the diagonal and extract its elements by accessing array2D[i][i]
	      primaryDiagonal[i] = array2D[i][i];
	    }
	    int primarySum = 0;
	    for (int i = 0; i < primaryDiagonal.length; i++) {
	      primarySum += primaryDiagonal[i];
	    }
	    System.out.println("primarySum sum is = " + primarySum);

	    int[] secondarydiagonal = new int[Math.min(rows, cols)];
	    //Secondary diagonal
	    for (int i = 0; i < Math.min(rows, cols); i++) {
	      secondarydiagonal[i] = array2D[i][cols - 1 - i];  
	    }

	    int secondarySum = 0;
	    for (int i = 0; i < secondarydiagonal.length; i++) {
	      secondarySum += secondarydiagonal[i];
	    }
	    System.out.println("Secondary sum is = " + secondarySum);
	    differance = Math.abs(primarySum - secondarySum);

	    return differance;
  }
}

public class DiagonalDifference {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter Number's of Rows and Columns : ");
    int n = Integer.parseInt(bufferedReader.readLine().trim());

    System.out.println("Enter 2D Array : ");
    List<List<Integer>> arr = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      String[] arrRowTempItems = bufferedReader
        .readLine()
        .replaceAll("\\s+$", "")
        .split(" ");

      List<Integer> arrRowItems = new ArrayList<>();

      for (int j = 0; j < n; j++) {
        int arrItem = Integer.parseInt(arrRowTempItems[j]);
        arrRowItems.add(arrItem);
      }

      arr.add(arrRowItems);
    }

    int result = Diff.diagonalDifference(arr);
    System.out.print(result);
    bufferedReader.close();
  }
}
