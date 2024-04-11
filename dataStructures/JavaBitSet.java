package dataStructures;

import java.util.BitSet;
import java.util.Scanner;

public class JavaBitSet {
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter lenght of BitSet and Number of Operations to perform : ");
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		BitSet B1 = new BitSet(N);
		BitSet B2 = new BitSet(N);

		
		 for (int i = 0; i < M; i++) {
			 System.out.println("Enter operation to perform :");
		      String opcode = sc.next();
		      int num1 = sc.nextInt();
		      int num2 = sc.nextInt();

		      switch(opcode) {
		        case "AND":
		          if (num1 == 1 && num2 == 2) {
		            B1.and(B2);
		          } else if (num1 == 2 && num2 == 1) {
		            B2.and(B1);
		          } else if (num1 == 1 && num2 == 1) {
		            B1.and(B1);
		          } else if (num1 == 2 && num2 == 2) {
		            B2.and(B2);
		          }
		          break;
		        case "OR":
		          if (num1 == 1 && num2 == 2) {
		            B1.or(B2);
		          } else if (num1 == 2 && num2 == 1) {
		            B2.or(B1);
		          } else if (num1 == 1 && num2 == 1) {
		            B1.or(B1);
		          } else if (num1 == 2 && num2 == 2) {
		            B2.or(B2);
		          }
		          break;
		        case "XOR":
		          if (num1 == 1 && num2 == 2) {
		            B1.xor(B2);
		          } else if (num1 == 2 && num2 == 1) {
		            B2.xor(B1);
		          } else if (num1 == 1 && num2 == 1) {
		            B1.xor(B1);
		          } else if (num1 == 2 && num2 == 2) {
		            B2.xor(B2);
		          }
		          break;
		        case "FLIP":
		          if (num1 == 1) {
		            B1.flip(num2);
		          } else if (num1 == 2) {
		            B2.flip(num2);
		          }
		          break;
		        case "SET":
		          if (num1 == 1) {
		            B1.set(num2);
		          } else if (num1 == 2) {
		            B2.set(num2);
		          }
		          break;
		      }
		      System.out.println(B1.cardinality() + " " + B2.cardinality());
		    }
		 sc.close();
		    }
}
	

