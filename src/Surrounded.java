
public class Surrounded {
	
	final static int N = 5;
	static int[][] grid = new int[N][N];
	
	public static boolean surrounded(int i, int j) {
		
		if(i == 0 || j == 0 || i == (N-1) || j == (N-1)) 
		{ 
			return false;
		} 
		else 
		{
			int num; 
			if(grid[i][j] == 1) 
				num = 2; 
			else 
				num = 1; 
			for(int n = i-1; n <= i+1; n++) 
			{ 
				for(int k = j-1; k <= j+1; k++) 
				{ 
					if(n!=i && k!=j) 
					{ 
						if(grid[n][k]!=num) 
						{ 
							return false;
						} 
						
					} 
					
				}
				
			} 
			return true; 
		} 
		
	}
	
}
