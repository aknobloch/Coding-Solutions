
public class NumberComplement {

	public static void main(String[] args)
	{
		System.out.println( findComplement(2147483647) );
	}
	
	public static int findComplement(int num) {
		
		int i = 1;
		int answer = 0;
		
		while(i < num && i > 0 )
		{
			answer += (num & i) ^ i;
			
			i = i << 1;
		}
	
		return answer;
    }
}
