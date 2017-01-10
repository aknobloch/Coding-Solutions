
public class HammingDifference {

	public static void main(String[] args)
	{
		
		System.out.println(hammingDistance(1, 4));
		
	}
	
	public static int hammingDistance(int x, int y) {
        
        int c = x ^ y;
        int numberDifferent = 0;
        
        for(int i = 0; i < 31; i++) 
        {
        	int startingNum = 1 << i;
        	if(startingNum > c)
        	{
        		break;
        	}
        	numberDifferent += ((startingNum & c) >> i);
        }
        
        return numberDifferent;
        
    }
	
}
