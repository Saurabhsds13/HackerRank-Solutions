package dataStructures;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;

/* A Dequeue (double-ended queue) in Java can be useful for implementing a sliding window or working with sub arrays efficiently. The ArrayDeque class in Java provides a convenient implementation of a dequeue that can be used for this purpose */

public class JavaDequeue {
    
    public static void main(String[] args) {
        
    	 Scanner in = new Scanner(System.in);
    	 
         Deque<Integer> deque = new ArrayDeque<>();
        HashSet<Integer> set = new HashSet<>();
        System.out.println("Enter Number of Inputs : ");
        int n = in.nextInt();
        System.out.println("Enter Size of SubArrays : ");
        int m = in.nextInt();
        int max = Integer.MIN_VALUE;

        System.out.println("Enter Values : ");
        for (int i = 0; i < n; i++) {
            int input = in.nextInt();

            deque.add(input);
            set.add(input);
            System.out.println(deque);
			System.out.println(set);
            if (deque.size() == m) {
                if (set.size() > max)
                    max = set.size();
                System.out.println(max);
                int first = (int) deque.remove();
                if (!deque.contains(first))
                    set.remove(first);
            }
        }
        System.out.println("Maximum number of unique integers among all possible contiguous subarrays is "+max);
        
     in.close(); 
    }
}
