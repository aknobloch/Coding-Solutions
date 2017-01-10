import java.util.Arrays;

public class FindTheDifference {

	public static void main(String[] args) {
		
		System.out.println(findTheDifference("abcd", "abcde"));
		
	}
	
	public static char findTheDifference(String s, String t) {
        
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        
        for(int i = 0; i < tChars.length; i++) {
            
            try {
                if(sChars[i] != tChars[i]) {
                    return tChars[i];
                }
            } catch(ArrayIndexOutOfBoundsException aioe) {
                return tChars[i];
            }
            
        }
        
        return '0';
        
    }

}
