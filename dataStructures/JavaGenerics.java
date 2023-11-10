package dataStructures;
/*Generic methods are a very efficient way to handle multiple data types using a single method. This problem will test your knowledge on Java Generic methods.
Let's say you have an integer array and a string array. You have to write a single method printArray that can print all the elements of both arrays. The method should be able to accept both integer arrays or string arrays.
You are given code in the editor. Complete the code so that it prints the following lines:
1
2
3
Hello
World
Do not use method overloading because your answer will not be accepted.*/

class Printer{

	public <T> void printArray(T[] array) {
		
		for(T a : array) {
			System.out.println(a);
		}
	}
}
public class JavaGenerics {
	
	public static void main(String[] args) {
		Printer myPrinter = new Printer();
		Integer arr[]= {1,2,3};
		String arr1[]= {"Hello","World"};
		
		myPrinter.printArray(arr);
		myPrinter.printArray(arr1);
		System.out.println();	
	}
}
