import java.util.Scanner;

public class JesseDance_ProblemNo1 {

	//If I wanted to store the primes for later access, I would probably use an ArrayList or LinkedList
	//I assumed that 2 is the first prime

	//I learned about this method in Discrete Math
	//I am using a method called the Sieve of Eratosthenes
	//this marks each number as prime or a multiple of a prime(ie not prime)
    public static int sumPrimesBelow(int limit) {
        boolean[] isPrime = new boolean[limit];
        //boolean array to store the case for each number
        for (int i = 2; i < limit; i++) {
            isPrime[i] = true;
        }

        //here we set each multiple to not prime
        for (int i = 2; i * i < limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        //sum all remaining non-multiples (primes)
        int sum = 0;
        for (int i = 2; i < limit; i++) {
            if (isPrime[i]) {
                sum += i;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);

    	System.out.println("Hello, this program will find the sum of all prime numbers that are less than a given limit.");
    	System.out.println("Please enter a limit: ");

        int limit = Integer.parseInt(in.nextLine().trim());
        int sum = sumPrimesBelow(limit);
        System.out.println("The sum of all prime numbers below " + limit + " is: " + sum);
    }
}
