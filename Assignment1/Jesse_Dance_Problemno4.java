Problem 4:

import java.util.Scanner;
import java.util.ArrayList;

public class Jesse_Dance_Problemno4
{
    public static ArrayList<String> filterListContructively(int size, ArrayList<String> words) {
        
        ArrayList<String> newList = new ArrayList<String>();
        
        for(String word: words) {
            if(word.length() <= size) {
                newList.add(word);
            }
        }
    return newList;
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
		
		System.out.println("\nList of words: ");
		for(String word: words) {
		    System.out.printf("%s ", word);
		}
		
		ArrayList<String> filteredList = filterListContructively(size, words);
		
		System.out.println("\n\nList of words after filtering for size: ");
		for(String word: filteredList) {
		    System.out.printf("%s ", word);
		}
		
		System.out.println("\n\nOriginal list of words: ");
		for(String word: words) {
		    System.out.printf("%s ", word);
		}
		
	}
}
