import java.util.Scanner;

public class Jesse_Dance_ProblemNo1 {

	public static void main(String args[]) {

		Scanner in = new Scanner(System.in);
		int count = 0;

		System.out.println("Please enter the integers into the list one at a time <type int + enter key>, use <-1 + enter key> to end input");
		LinkedListFromScratch list = new LinkedListFromScratch();

		while (true) {
            int listInput = in.nextInt();
            if (listInput == -1) 
            {
                break;  
            }
            count++; 
            list.addToEnd(listInput); 
        }

        if (list.isEmpty()) {
        	System.out.println("No list created");
        	return;
        }
		System.out.println("List before rotating: ");
		list.printLinkedListFromScratch();
		for (int i = 1; i <=count; i++) {
			list.rotateList();
			System.out.printf("List after rotating %d time(s) ", i);
			list.printLinkedListFromScratch();
			}

	}

}