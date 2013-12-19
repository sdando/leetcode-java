package leetcode;

import org.junit.Test;

import test.JunitTest;

public class Merge_Sorted_Array {
	
	@Test
	public void test(){
		int[] array=new int[4];
		array[0]=1;
		array[1]=3;
		Solution.merge(array, 2, new int[]{2,4}, 2);
		for (int i : array) {
			JunitTest.Print(i+"");
		}	
	}

	static class Solution {
	    static void merge(int A[], int m, int B[], int n) {
	    	int i,j,k;
	        for(j=0;j<n;j++){
	        	for(i=m-1+j;i>=0;i--){
	        		if(B[j]>=A[i])
	        			break;
	        	}
	        	for(k=m-1+j;k>i;k--){
	        		A[k+1]=A[k];
	        	}
	        	A[i+1]=B[j];
	        }
	    }
	}
}
