import java.util.Stack;

public class IslandPerimeter {

	/*
	 * Unfortunately, I'm pretty ashamed of this one. Although
	 * the algorithm itself was solid on paper, the implementation felt
	 * messy and unorganized. Furthermore, the solution was only
	 * a hair more optimized than a strict brute force implementation.
	 * The only saving grace was "hopping" to land masses rather than 
	 * strictly running a nested for loop. 
	 * 
	 * This runtime only placed me in the 5% percentile in LeetCode,
	 * which is among the worst of my implementations. Due to school
	 * being overbearing, it took me three days to finally have the 
	 * time to sit down and finish coding my first draft (seen here). 
	 * Instead of optimizing from there like usual, I'm ready to move
	 * onto a new problem ASAP. I do like the problem though, and will
	 * probably revist it in the future. 
	 */
	
	
	public static void main(String[] args)
	{
		
		// answer is 16
		int[][] testArray = {{0,1,0,0},
		                     {1,1,1,0},
		                     {0,1,0,0},
		                     {1,1,0,0}};
		
		
		System.out.println(islandPerimeter(testArray));
	}
	
	public static int islandPerimeter(int[][] grid) {
        
		int totalCount = 0;
		
		Stack<int[]> land = new Stack<>();
		
		// find first num
		findFirstNum(grid, land);
		
		while( ! land.isEmpty())
		{
			int[] nextLand = land.pop();
			int row = nextLand[0];
			int col = nextLand[1];
			
			totalCount += searchLand(row, col, grid, land);
			
			grid[row][col] = 2;
			
		}
		
		return totalCount;
		
    }

	private static int searchLand(int row, int col, int[][] grid, Stack<int[]> land) {
		
		int borderCount = 0;
		
		// check left
		if(col != 0)
		{
			borderCount += handleBorderCase(row, col - 1, grid, land);
		}
		else 
		{
			// on the edge, add one
			borderCount++;
		}
		
		// check top
		if(row != 0)
		{
			borderCount += handleBorderCase(row - 1, col, grid, land);
		}
		else 
		{
			// on the edge, add one
			borderCount++;
		}
		
		// check right
		if(col != grid[0].length - 1)
		{
			borderCount += handleBorderCase(row, col + 1, grid, land);
		}
		else 
		{
			// on the edge, add one
			borderCount++;
		}
		
		// check bottom
		if(row != grid.length - 1)
		{
			borderCount += handleBorderCase(row + 1, col, grid, land);
		}
		else 
		{
			// on the edge, add one
			borderCount++;
		}
		return borderCount;
		
	}

	private static int handleBorderCase(int row, int column, int[][] grid, Stack<int[]> land) {
	
		int number = grid[row][column];
		
		if(number == 0) 
		{
			return 1;
		}
		
		if(number == 1)
		{
			land.add(new int[]{row, column});
			grid[row][column] = 2;
		}
		
		return 0;
		
	}

	private static void findFirstNum(int[][] grid, Stack<int[]> land) {
		
		for(int r = 0; r < grid.length; r++)
		{
			for(int c = 0; c < grid[0].length; c++)
			{
				if(grid[r][c] == 1)
				{
					land.add(new int[]{r, c});
					return;
				}
			}
		}
		
	}
	
}
