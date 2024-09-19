import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Arrays;

public class Jesse_Dance_Problemno1
{
    
    public static int diagonalDifference(int[][] matrix) {
        int result = 0;
        int size = matrix.length;
        int sum1 = 0;
        int sum2 = 0;
        
        int j = 1;
        for (int i=0; i< size; i++) {
            sum1 += matrix[i][i];
            sum2 += matrix[i][size-j];
            j++;
        }
        
        result = Math.abs(sum1-sum2);
        return result;
    }
    
    
    
	public static void main(String[] args) {
	    //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    Scanner in = new Scanner(System.in);
        
		System.out.println("Hello, enter the size of your matrix: ");
		int matrixSize = in.nextInt();
		//System.out.println(matrixSize);
		
		if(matrixSize > 100) {
		    System.out.println("Too large, this program is only designed for sizes of 100 or less");
		    return;
		}
		
		System.out.println("Now, enter each row. If entering a row too large, you will lose data");
		
		int[][] matrix = new int[matrixSize][matrixSize];
		
		for (int i = 0; i < matrixSize; i++) {
		    for (int j = 0; j < matrixSize; j++) {
		        matrix[i][j] = in.nextInt();
		    }
		}
		
		System.out.println(Arrays.deepToString(matrix));
		int difference = diagonalDifference(matrix);
		
		System.out.println(difference);
		
	}
}

