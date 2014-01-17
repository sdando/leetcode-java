package leetcode;

import org.junit.Test;

import test.JunitTest;

public class Search_a_2D_Matrix {
	
	@Test
	public void test(){
		JunitTest.Print(searchMatrix(new int[][]{{1, 3, 5, 7},{10, 11, 16, 20},{23, 30, 34, 50}},3)+"");
	}
	
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null)
        	return false;
    	int row=matrix.length;
    	int col=matrix[0].length;
    	int mid,low=0;
    	int high=row-1;
    	while(low<=high){
    		mid=(low+high)/2;
    		if(matrix[mid][0]==target)
    			return true;
    		else if(matrix[mid][0]<target) {
				low=mid+1;
			}
    		else {
				high=mid-1;
			}
    	}
    	//low range is [0,row]
    	int k;
        if(low==row)
        	low--;
    	if(matrix[low][0]>target)
    		k=low-1;
    	else
    		k=low;
    	if(k<0)
    		return false;
    	low=0;
    	high=col-1;
    	while(low<=high){
    		mid=(low+high)/2;
    		if(matrix[k][mid]==target)
    			return true;
    		else if(matrix[k][mid]<target) {
				low=mid+1;
			}
    		else {
				high=mid-1;
			}
    	}
    	return false;
    }
}
