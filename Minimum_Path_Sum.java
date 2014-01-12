package leetcode;

import org.junit.Test;

public class Minimum_Path_Sum {
	@Test
	public void test(){
		minPathSum(new int[][]{{1,1},{1,2}});
	}
	
    public int minPathSum(int[][] grid) {
        int[][] path=new int[grid.length][grid[0].length];
        path[0][0]=grid[0][0];
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++)
        	for(int j=0;j<n;j++){
        		if(i==0&&j==0)
        			continue;
        		else if(i==0)
        			path[i][j]=path[i][j-1]+grid[i][j];
        		else if(j==0)
        			path[i][j]=path[i-1][j]+grid[i][j];
        		else
        			path[i][j]=Math.min(path[i-1][j], path[i][j-1])+grid[i][j];
        	}
        return path[m-1][n-1];
    }
}
