
public class MaxConsecutiveOnes {

	public static void main(String[] args)
	{
		int[] testArray = {1,1,0,1,1,1};
		
		System.out.println(findMaxConsecutiveOnes(testArray));
	}
	
	public static int findMaxConsecutiveOnes(int[] nums) 
	{
		
		int max = 0;
		int streak = 0;
		
		for(int i = 0; i < nums.length; i++)
		{
			streak++;
			
			if(streak + nums[i] == streak)
			{
				streak = 0;
			}
			
			max = streak > max ? streak : max;
			
		}
		
		return max;
		
    }
	
}
