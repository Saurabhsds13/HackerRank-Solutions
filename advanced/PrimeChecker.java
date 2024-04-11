package advanced;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

class Prime {

  public boolean isPrime(int num) {
    if (num <= 1) {
      return false;
    }
    if (num <= 3) {
      return true;
    }
    if (num % 2 == 0 || num % 3 == 0) {
      return false;
    }
    int i = 5;
    while (i * i <= num) {
      if (num % i == 0 || num % (i + 2) == 0) {
        return false;
      }
      i += 6;
    }
    return true;
  }

  public void checkPrime(int... numbers) {
    StringBuilder primeNumbers = new StringBuilder();
    for (int num : numbers) {
      if (isPrime(num)) {
        primeNumbers.append(num).append(" ");
      }
    }
    if (primeNumbers.length() > 0) {
      primeNumbers.deleteCharAt(primeNumbers.length() - 1); // Remove the extra space at the end
      System.out.println(primeNumbers);
    } else {
      System.out.println(); // Print a blank line if there are no prime numbers
    }
  }
}

class PrimeChecker {

  public static void main(String[] args) {
    try {
      InputStream in = System.in;
      BufferedReader br = new BufferedReader(new InputStreamReader(in));
      
      // Go to hacker rank and Try to solve this code in java 7
      //Note: You may get a compile time error in this problem due to the statement below:
      //  BufferedReader br =new BufferedReader(new InputStreamReader(in));
      //  This was added intentionally, and you have to figure out a way to get rid of the error.

      System.out.println("Enter the Numbers : ");
      int n1 = Integer.parseInt(br.readLine());
      int n2 = Integer.parseInt(br.readLine());
      int n3 = Integer.parseInt(br.readLine());
      int n4 = Integer.parseInt(br.readLine());
      int n5 = Integer.parseInt(br.readLine());
      Prime ob = new Prime();
      ob.checkPrime(n1);
      ob.checkPrime(n1, n2);
      ob.checkPrime(n1, n2, n3);
      ob.checkPrime(n1, n2, n3, n4, n5);
      Method[] methods = Prime.class.getDeclaredMethods();
      Set<String> set = new HashSet<>();
      boolean overload = false;
      for (int i = 0; i < methods.length; i++) {
        if (set.contains(methods[i].getName())) {
          overload = true;
          break;
        }
        set.add(methods[i].getName());
      }
      if (overload) {
        throw new Exception("Overloading not allowed");
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
