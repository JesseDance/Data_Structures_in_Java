import java.util.Scanner;

public class Jesse_Dance_ProblemNo2_single {

	public static void main(String args[]) {

		Scanner in = new Scanner(System.in);

		System.out.println("Please enter the integers into the list one at a time <type int + enter key>, use <-1 + enter key> to end input");
		LinkedListFromScratch list = new LinkedListFromScratch();
		
		
		while (true) {
            int listInput = in.nextInt();
            if (listInput == -1) 
            {
                break;  
            } 
            list.addToEnd(listInput); 
        }
        
        
        
		/* test data
        list.addToEnd(1);
        
        list.addToEnd(2);
        
        list.addToEnd(3);
        
        list.addToEnd(4);
        */
        

        
        if (list.isEmpty()) {
        	System.out.println("No list created");
        	return;
        }
		System.out.println("List before reversal: ");
		list.printLinkedListFromScratch();
		list.reverseList();
		System.out.println("List after reversing: ");
		list.printLinkedListFromScratch();
		

	}

}