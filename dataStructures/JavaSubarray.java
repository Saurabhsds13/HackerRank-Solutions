package dataStructures;
 // Given an array of n integers, find and print its number of negative sub-arrays on a new line.
//Note: Sub-arrays are contiguous chunks of the main array. For example if the array is {1,2,3,5} then some of the sub-arrays are {1}, {1,2,3}, {2,3,5}, {1,2,3,5} etc. But {1,2,5} is not an sub-array as it is not contiguous.
import java.util.Scanner;

public class JavaSubarray {
	
	 public static void main(String[] args) {
	        
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter the Length of the array : ");
	        int n=sc.nextInt();
	        System.out.println("\nEnter the array Elements : ");
	        int arr[]=new int[n];

	        for(int l=0;l<n;l++){
	            arr[l] =sc.nextInt();
	        }
	        
	        int count = 0;
	        
	        for(int i = 0;i<n;i++) {
	        	int sum =0;
	        	for(int j = i;j<n;j++) {
	        		sum+=arr[j];
	        			if(sum<0) {
	        				count++;
	        			}
	        	}
	        }
	        System.out.println("\n"+count);
	    sc.close();
	}
}