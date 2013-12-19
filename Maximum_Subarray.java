package leetcode;

import org.junit.Test;

import test.JunitTest;

public class Maximum_Subarray {
	
	@Test
	public void test(){
		JunitTest.Print(new Maximum_Subarray().maxSubArray(new int[]{
			-2,1,-3,4,-1,2,1,-5,4})+"");
	}
	
    public int maxSubArray(int[] A) {
        int max=0;
        int thisSum=0;
        for(int i=0;i<A.length;i++){
        	thisSum+=A[i];
        	if(thisSum<0){
				thisSum=0;
				continue;
			}
        	if(thisSum>max){
        		max=thisSum;
        	}
        }
        if(max>0){
        	return max;
        }
        max=Integer.MIN_VALUE;
        for(int j=0;j<A.length;j++){
            if(A[j]==0){
            	return 0;
            }
            if(A[j]>max){
            	max=A[j];
            }
        }
        return max;
    }
}
