package dataStructures;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class JavaHashset {	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the values to store in the Hash Set : ");
		HashSet<Integer> set = new HashSet<>();
		LinkedHashSet<Integer> set3 = new LinkedHashSet<>();
		/*Java LinkedHashSet class is non-synchronized.
          Java LinkedHashSet class maintains insertion order.*/
		for (int i = 0; i < 10 ; i++) {
			int values= sc.nextInt();
			set.add(values);
			set3.add(values);	
		}
		System.out.println("Values in Hash Set is : ");		
		for(Integer i : set) {
			System.out.println(i);		
			}
		System.out.println("Values in Linked Hash set is : ");		
		for(Integer k : set3) {
			System.out.println(k);		
			}
		HashSet<Integer> set1 = new HashSet<>(set);
//		set1.add(24);
		set1.add(45);	
//		set1.removeAll(set1);
//      set.removeIf(str->str.equals(1));
//		set1.clear();
//		set1.addAll(set);
		System.out.println("Values After adding set 2 : ");
		for(Integer j:set1) {
			System.out.println(j);
		}
// .............................................................................................................................
// Hacker Rank Solution :-
		
		System.err.println("Enter the Number of Paires : ");
		int t = sc.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];
        System.out.println("Enter the Pairs : ");
        for (int i = 0; i < t; i++) {
            pair_left[i] = sc.next();
            pair_right[i] = sc.next();
        }
        
        HashSet<String> set4 = new HashSet<>();
        System.out.println("Unique Pairs are : ");
        for(int i = 0 ;i < t; i++){
        set4.add(pair_left[i]+" "+pair_right[i]);
        // set.add(pair_right[i]);  
        System.out.println(set4.size());
        }
		
		
		sc.close();	
	}
}