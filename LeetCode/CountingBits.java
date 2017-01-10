import java.util.Arrays;

public class CountingBits {

	public static void main(String[] args) {
		
		System.out.println(Arrays.toString((countBits(5))));

	}
	
	public static int[] countBits(int num) {
        
        int[] counts = new int[num + 1];
        
        for(int i = 0; i <= num; i++) {
            
            String binary = Integer.toBinaryString(i);
            int thisNumCount = 0;
            
            for(int j = 0; j < binary.length(); j++) {
                if(binary.charAt(j) == '1') {
                    thisNumCount = thisNumCount + 1;
                }
            }
            
            counts[i] = thisNumCount;
            
        }
        
        return counts;
        
    }

}
