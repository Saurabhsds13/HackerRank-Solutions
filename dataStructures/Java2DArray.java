package dataStructures;

import java.util.Scanner;

public class Java2DArray {

	// Returns maximum sum of hour glass in arr[][]
	static int findMaxSum(int [][]mat){
		// Here loop runs (R-2)*(C-2) times considering different top left cells of hour glasses.
		int max_sum = Integer.MIN_VALUE;
		System.out.println("max sum default is : "+max_sum);
		for (int i = 0; i < mat.length-2; i++)
		{
			for (int j = 0; j < mat[0].length-2; j++)
			{
				// Considering mat[i][j] as top left cell of hour glass.
				int sum = (mat[i][j] + mat[i][j + 1] + 
						   mat[i][j + 2]) + (mat[i + 1][j + 1]) + 
						  (mat[i + 2][j] + mat[i + 2][j + 1] + 
						   mat[i + 2][j + 2]);

				// If previous sum is less than current sum then update new sum in max_sum
				max_sum = Math.max(max_sum, sum);
			}
		}
		return max_sum;
	}

		// Driver code
		static public void main (String[] args)
		{
			
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter the number of rows: ");   
			 int m = sc.nextInt();   
			System.out.print("Enter the number of columns: ");
			 int n = sc.nextInt();
			 System.out.println("Enter the Elements of 2D Array : ");
			int mat[][] = new int[m][n];   
			
			for (int i = 0; i < m; i++) { // rows
				for (int j = 0; j < n; j++) { // column
					mat[i][j] = sc.nextInt(); 
				}
			}
			int res = findMaxSum(mat);
			System.out.println("Maximum sum of hour glass = "+ res);
			sc.close();
		}
		
}