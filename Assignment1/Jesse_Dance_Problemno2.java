Problem 2:
public class Jesse_Dance_Problemno2
{
	public static void main(String[] args) {
		int num1 = 1;
		int num2 = 2;
		int num3 = num1 + num2;
		int sum = num2;
		int temp;
		
		System.out.printf("%d", num2);
		
		while (num3 < 4000000) {
		    if (num3 <4000000) {
		   
		    if (num3%2 == 0){
		        System.out.printf(" %d", num3);
		        sum += num3;
		    }
		    temp = num3;
		    num3 += num2;
	        num2 = temp;
		    }
		}
		System.out.printf("\nSum of even values below 4 million: %d", sum);
	}
}
