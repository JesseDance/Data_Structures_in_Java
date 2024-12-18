import java.util.Scanner;

public class JesseDance_ProblemNo2 {

	//I could use a more sophisticated approach by using a formula for the sum of multiples of a number below a limmit,
	//and then write a recurrsive method to add multiples until the limit, but it was more complicated
	//I am more comfortable with the simple yet inefficient approach of checking every number

	public static int sumMultiplesOf3And5(int limit) {
        int sum = 0;

        for (int i = 1; i < limit; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i; 
            }
        }
        
        return sum;
    }

    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);

    	System.out.println("Hello, this program will find the sum of all multiples of 3 and 5 that are less than a given limit.");
    	System.out.println("Please enter a limit: ");

        int limit = Integer.parseInt(in.nextLine().trim());
        int sum = sumMultiplesOf3And5(limit);
        System.out.println("The sum of all multiples of 3 and 5 below " + limit + " is: " + sum);
    }
}