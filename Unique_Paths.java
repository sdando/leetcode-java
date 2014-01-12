package leetcode;

public class Unique_Paths {
    public int uniquePaths(int m, int n) {
        if(m==1&&n==1)
        	return 1;
        int[][] path=new int[m][n];
        for(int i=0;i<m;i++){
        	for(int j=0;j<n;j++){
        		if(i==0)
        			path[i][j]=1;
        		else if(j==0)
        			path[i][j]=1;
        		else 
        			path[i][j]=path[i-1][j]+path[i][j-1];
        	}
        }
        return path[m-1][n-1];
    }
}
