package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Solution {

  public static void plusMinus(List<Integer> arr) {
    int plusCount = 0, minusCount = 0, zeroCount = 0;

    int arraySize = arr.size();
    for (int number : arr) {
      if (number == 0) {
        zeroCount++;
      } else if (number < 0) {
        minusCount++;
      } else {
        plusCount++;
      }
    }
    double plusRatio = (double) plusCount / arraySize;
    double minusRatio = (double) minusCount / arraySize;
    double zeroRatio = (double) zeroCount / arraySize;
    System.out.printf("%.6f%n", plusRatio);
    System.out.printf("%.6f%n", minusRatio);
    System.out.printf("%.6f%n", zeroRatio);
  }
}

public class PlusMinus {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter the count of array elements : ");
    int n = Integer.parseInt(bufferedReader.readLine().trim());
    System.out.println("Enter Array Elements :");

    String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    List<Integer> arr = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      int arrItem = Integer.parseInt(arrTemp[i]);
      arr.add(arrItem);
    }
    System.out.println("Array : " + arr);
    Solution.plusMinus(arr);

    bufferedReader.close();
  }
}
