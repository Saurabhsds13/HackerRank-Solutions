package advanced;

import java.io.*;
import java.util.*;

interface PerformOperation {
  boolean check(int a);
}

class MyMath {

  public boolean checker(PerformOperation p, int num) {
    return p.check(num);
  }

  PerformOperation isOdd() {
   return n -> {
	   if( (n % 2 == 0) )return false;
return true;
    };
  }

  PerformOperation isPrime() {
    return n -> {
      if (n <= 1) return false;
      for (int i = 2; i <= Math.sqrt(n); i++) {
        if (n % i == 0) return false;
      }
      return true;
    };
  }

  PerformOperation isPalindrome() {
    return num -> {
      int reversed = 0, original = num;
      while (num != 0) {
        int digit = num % 10;
        reversed = reversed * 10 + digit;
        num /= 10;
      }
      return original == reversed;
    };
  }
}

public class JavaLambadaExpression {

  public static void main(String[] args) throws IOException {
    MyMath ob = new MyMath();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Enter the Numbers : ");
    int T = Integer.parseInt(br.readLine());
    PerformOperation op;
    boolean ret = false;
    String ans = null;
    while (T-- > 0) {
      String s = br.readLine().trim();
      StringTokenizer st = new StringTokenizer(s);
      int ch = Integer.parseInt(st.nextToken());
      int num = Integer.parseInt(st.nextToken());
      if (ch == 1) {
        op = ob.isOdd();
        ret = ob.checker(op, num);
        ans = (ret) ? "ODD" : "EVEN";
      } else if (ch == 2) {
        op = ob.isPrime();
        ret = ob.checker(op, num);
        ans = (ret) ? "PRIME" : "COMPOSITE";
      } else if (ch == 3) {
        op = ob.isPalindrome();
        ret = ob.checker(op, num);
        ans = (ret) ? "PALINDROME" : "NOT PALINDROME";
      }
      System.out.println(ans);
    }
  }
}
/*input - 5
		  1 4
		  2 5
		  3 898
		  1 3
		  2 12
output - EVEN
		 PRIME
		 PALINDROME
		 ODD
		 COMPOSITE
*/