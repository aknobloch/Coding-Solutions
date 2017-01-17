
public class MaxConsecutiveOnes {

	public static void main(String[] args)
	{
		int[] testArray = {1,1,0,1,1,1};
		System.out.println(findMaxConsecutiveOnes(testArray));
	}
	
	public static int findMaxConsecutiveOnes(int[] nums) 
	{
        
		int maxNums = 0;
		int currentStreak = 0;
		
		for(int i = 0; i < nums.length; i++)
		{
			if(nums[i] == 1) 
			{
				currentStreak++;
			}
			else
			{
				if(currentStreak > maxNums)
				{
					maxNums = currentStreak;
				}
				
				currentStreak = 0;
			}
		}
		
		if(currentStreak > maxNums)
		{
			maxNums = currentStreak;
		}
		return maxNums;
		
    }
	
}
