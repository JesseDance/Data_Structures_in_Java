Problem 3:

import java.util.Scanner;
import java.util.ArrayList;

public class Jesse_Dance_Problemno3
{
    public static void filterList(int size, ArrayList<String> words) {
        
        words.removeIf(word -> word.length() > size);

    }
    
    
	public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    ArrayList<String> words = new ArrayList<String>();
	    
		System.out.println("Hello, please enter the maximum size of your words");
		int size = in.nextInt();
		in.nextLine();
		
		System.out.println("Now enter your words, and use '-1' to finish");
		String input;
		while (true) {
		  input = in.next();
		  
		  if(input.equals("-1")){
		      break;
		  }
		  words.add(input);
		}
		
		System.out.println("List of words: ");
		for(String word: words) {
		    System.out.printf("%s ", word);
		}
		
		filterList(size, words);
		System.out.println("\nList of words after filtering for size: ");
		for(String word: words) {
		    System.out.printf("%s ", word);
		}
		
	}
}
