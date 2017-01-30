
public class AddDigits {

	public static void main(String[] args)
	{
		System.out.println(addDigits(38));
	}
	
	public static int addDigits(int num) 
	{
		
		int sum = 0;
		
		while(num != 0)
		{
			
			int trailingDigit = num % 10;
			num = num / 10;
			
			sum += trailingDigit;
			
			if(num == 0 && sum > 9)
			{
				num = sum;
				sum = 0;
			}
			
		}
		
		return sum;
		
    }
	
}
