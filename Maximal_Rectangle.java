package leetcode;

import junit.framework.Assert;

public class Maximal_Rectangle extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
   char[][] matrix = {{'0','0','0','0'},{'0','1','1','0'},{'0','0','1','0'},{'0','1','0','0'}};
   Assert.assertEquals(2, maximalRectangle(matrix));
	}
	//dp[i][j]代表从第（i,j）开始连续为1的个数
  public int maximalRectangle(char[][] matrix) {
  	if(matrix == null || matrix.length == 0 || matrix[0].length ==0) 
  		return 0;
    int n = matrix.length;
    int m = matrix[0].length;
    int[][] dp = new int[n][m];
    for(int i = 0; i < n; i++)   
    	dp[i][m-1] = matrix[i][m-1] == '0'? 0:1;
    for(int i = 0; i < n; i++){
    	for(int j = m-2; j >= 0; j--)
    		dp[i][j] = matrix[i][j] == '0'? 0:(1 + dp[i][j+1]);
    }
    int ret = 0;
    for(int i = 0; i < n; i++){
    	for(int j = 0; j < m; j++){
    		//剪枝
    		if((n - i)*(m - j) <= ret) break;
    		int width = dp[i][j];
    		for(int k = i; k < n; k++){
      		if(width * (n - i) <= ret) break;
    			if(width > dp[k][j]) width = dp[k][j];
    			if(width * (k - i + 1) > ret) ret = width * (k - i + 1);
    		}
    	}
    }
    return ret;
  }
}
