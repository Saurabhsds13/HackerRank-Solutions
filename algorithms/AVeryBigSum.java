package algorithms;

import java.io.*;
import java.util.*;

class Bigsum {

  /*
   * Complete the 'aVeryBigSum' function below.
   *
   * The function is expected to return a LONG_INTEGER.
   * The function accepts LONG_INTEGER_ARRAY ar as parameter.
   */

  public static long aVeryBigSum(List<Long> ar) {
    long result = 0;
    for (int i = 0; i < ar.size(); i++) {
      result += ar.get(i);
    }
    return result;
  }
}

public class AVeryBigSum {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter the Number count and Numbers :");
    int arCount = Integer.parseInt(bufferedReader.readLine().trim());

    String[] arTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    List<Long> ar = new ArrayList<>();

    for (int i = 0; i < arCount; i++) {
      long arItem = Long.parseLong(arTemp[i]);
      ar.add(arItem);
    }

    long result = Bigsum.aVeryBigSum(ar);
    System.out.println(result);
    bufferedReader.close();
  }
}
