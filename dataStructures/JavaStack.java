package dataStructures;
import java.util.Scanner;
import java.util.Stack;
	
// In computer science, a stack or LIFO (last in, first out) is an abstract data type that serves as a collection of elements, with two principal operations: push, which adds an element to the collection, and pop, which removes the last element that was added.

public class JavaStack {

	public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);	
		Stack<String> stack = new Stack<>();
		int numberOfElements = sc.nextInt();
		for (int i = 0; i < numberOfElements; i++) {
		    String input = sc.next();
		    stack.push(input); // Push the input value onto the stack
		}
		while (!stack.isEmpty()) {
		    System.out.println(stack.pop()); // Pop and print elements from the stack
		}
	sc.close();
	}
}