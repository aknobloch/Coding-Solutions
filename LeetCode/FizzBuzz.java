import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

	public static void main(String[] args) {
		
		System.out.println(fizzBuzz(15));
		
	}
	
	public static List<String> fizzBuzz(int n) {
        
		ArrayList<String> returnList = new ArrayList<String>();
		String solution;
		
		for(int i = 1; i <= n; i++)
		{
			solution = "";
			
			boolean threeDivisible = i % 3 == 0 ? true : false;
			boolean fiveDivisible = i % 5 == 0 ? true : false;
			
			if(threeDivisible && fiveDivisible)
			{
				solution = "FizzBuzz";
			}
			else if(threeDivisible)
			{
				solution = "Fizz";
			}
			else if(fiveDivisible)
			{
				solution = "Buzz";
			}
			else 
			{
				solution = "" + i;
			}
			
			returnList.add(solution);
		}
		
		return returnList;
		
    }
	
}
