package advanced;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

class Add {

  public void add(int... numbers) {
    /*The add method in the Add class takes variable arguments (int... numbers), allowing it to accept any number of integers. Inside this method:It iterates through each number passed in the arguments.
	  For each number, it adds it to the sum.
	  It prints the current number.
	  If the current number is not the last one in the list, it prints a "+" sign to denote addition.
	  Finally, it prints the current sum.*/
    int sum = 0;
    for (int num : numbers) {
      sum += num;
      System.out.print(num);
      if (num != numbers[numbers.length - 1]) {
        System.out.print("+");
      }
    }
    System.out.print("=" + sum + "\n");
  }
}

/*Expected Output
1+2=3
1+2+3=6
1+2+3+4+5=15
1+2+3+4+5+6=21*/
public class JavaVarargs {

  public static void main(String[] args) {
    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("Enters numbers to add :");
      int n1 = Integer.parseInt(br.readLine());
      int n2 = Integer.parseInt(br.readLine());
      int n3 = Integer.parseInt(br.readLine());
      int n4 = Integer.parseInt(br.readLine());
      int n5 = Integer.parseInt(br.readLine());
      int n6 = Integer.parseInt(br.readLine());
      Add ob = new Add();
      ob.add(n1, n2);
      ob.add(n1, n2, n3);
      ob.add(n1, n2, n3, n4, n5);
      ob.add(n1, n2, n3, n4, n5, n6);
      Method[] methods = Add.class.getDeclaredMethods();
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
      e.printStackTrace();
    }
  }
}
