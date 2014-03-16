package leetcode;

public class Unique_Paths_II extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub

	}
	
	int[][] f;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null) return 0;
        int row=obstacleGrid.length;
        int col=obstacleGrid[0].length;
        if(col==0) return 0;
        f=new int[row+1][col+1];
        return dfs(obstacleGrid, row, col);
    }
    
    private int dfs(int[][] obstacleGrid,int row, int col){
    	if(row<1||col<1) return 0;
    	if(obstacleGrid[row-1][col-1]==1) 
    		return 0;
    	if(row==1&&col==1) return 1;
		return getOrUpdate(obstacleGrid, row-1, col)+getOrUpdate(obstacleGrid, row, col-1);
    }
    
    private int getOrUpdate(int[][] obstacleGrid,int row, int col){
    	if(f[row][col]!=0) return f[row][col];
    	else {
			return f[row][col]=dfs(obstacleGrid, row, col);
		}
    }
}
