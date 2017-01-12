import java.util.ArrayList;
import java.util.List;

/*
 * After thinking this problem through for a day or so, I just 
 * could not solve the problem in O(N) time and without using
 * additional storage. Therefore, I chose to limit myself to 
 * not using any extra storage, and accepted that I could not
 * solve it in O(N) time. After seeing the soltution, I understand
 * how it is done. Cleverly :)
 */

public class FindAllNumbersDisappearedInAnArray {

	public static void main(String[] args) 
	{
		int[] testArray = {4,3,2,7,8,2,3,1};
		System.out.println(findDisappearedNumbers(testArray));
	}
	
	public static List<Integer> findDisappearedNumbers(int[] nums) {
        
		// add all N to list
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i <= nums.length; i++)
		{
			list.add(i);
		}
		
		// remove all occurrences from list
		for(int i = 0; i < nums.length; i++)
		{
			if(list.contains(nums[i]))
			{
				list.remove(new Integer(nums[i]));
			}
		}
		
		
		return list;
		
    }
	
}
