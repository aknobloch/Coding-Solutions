/**
https://leetcode.com/problems/pyramid-transition-matrix/

You are stacking blocks to form a pyramid. Each block has a color, which is 
represented by a single letter. Each row of blocks contains one less block 
than the row beneath it and is centered on top.

To make the pyramid aesthetically pleasing, there are only specific triangular 
patterns that are allowed. A triangular pattern consists of a single block 
stacked on top of two blocks. The patterns are given as a list of three-letter 
strings allowed, where the first two characters of a pattern represent the 
left and right bottom blocks respectively, and the third character is the top block.

    For example, "ABC" represents a triangular pattern with a 'C' block stacked 
    on top of an 'A' (left) and 'B' (right) block. Note that this is different 
    from "BAC" where 'B' is on the left bottom and 'A' is on the right bottom.

You start with a bottom row of blocks bottom, given as a single string, that you 
must use as the base of the pyramid. Given bottom and allowed, return true if you 
can build the pyramid all the way to the top such that every triangular pattern 
in the pyramid is in allowed, or false otherwise.
*/

package pyramidtransition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/*
 * This is a backtracking solution which works by recursively iterating on possible brick
 * solutions, then backtracking when a dead-end is found. This solution works,
 * but isn't the most optimal. I believe we could use dynamic programming to
 * optimize away unnecessary paths. I don't have enough interest in this particular
 * problem to continue down that rabbit hole, though.
 */
class Solution {

    public static void main(String[] args) {

        Map<String, List<String>> positiveTestCases = new HashMap<>();
        positiveTestCases.put("BCD", Arrays.asList("BCC","CDE","CEA","FFF"));
    
        Map<String, List<String>> negativeTestCases = new HashMap<>();
        negativeTestCases.put("AAAA", Arrays.asList("AAB","AAC","BCD","BBE","DEF"));
    
        Solution test = new Solution();
        positiveTestCases.forEach((key, value) -> {
            if(!test.pyramidTransition(key, value)) {
                String errorMessage =  
                    String.format("Excepted true, but returned false!\n" + 
                        "Base was %s with accepted patterns: %s", key, String.join(",", value));
                throw new RuntimeException(errorMessage);
            }
        });
    
        negativeTestCases.forEach((key, value) -> {
            if(test.pyramidTransition(key, value)) {
                String errorMessage =  
                    String.format("Excepted false, but returned true!\n" + 
                        "Base was %s with accepted patterns: %s", key, String.join(",", value));
                throw new RuntimeException(errorMessage);
            }
        });
    
        System.out.println("All test cases returned successfully.");
    }

    Map<String, List<Character>> allowedStacks;

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        
        allowedStacks = new HashMap<>();
        for(String allowedCombo : allowed) {
            String allowedBase = allowedCombo.substring(0,2);
            Character allowedTop = allowedCombo.charAt(2);

            List<Character> allowedTops = 
                allowedStacks.getOrDefault(allowedBase, new ArrayList<>());
            allowedTops.add(allowedTop);
            allowedStacks.put(allowedBase, allowedTops);
        }

        return pyramidTransitionHelper(allowedStacks, bottom, "");
    }

    public boolean pyramidTransitionHelper(Map<String, List<Character>> allowedStacks,
                                        String lowerLayer,
                                        String currentLayer) {
        // base case, handle top brick
        if(lowerLayer.length() == 2) {
            return allowedStacks.containsKey(lowerLayer);
        }

        int nextBrickToLay = currentLayer.length() + 1;

        // If we've exceeded the last brick for this layer, move to the next layer
        if(nextBrickToLay >= lowerLayer.length()) {
            return pyramidTransitionHelper(allowedStacks, currentLayer, "");
        }

        String baseBricks = 
            lowerLayer.substring(nextBrickToLay - 1, nextBrickToLay + 1);
        List<Character> possibleBricks = allowedStacks.getOrDefault(baseBricks, new ArrayList<>());

        for(Character potentialBrick : possibleBricks) {
            String potentialLayer = currentLayer + potentialBrick;
            if(pyramidTransitionHelper(allowedStacks, lowerLayer, potentialLayer)) {
                return true;
            }
        }

        return false;
    }
}