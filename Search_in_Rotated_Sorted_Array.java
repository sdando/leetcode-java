package leetcode;

import org.junit.Test;

public class Search_in_Rotated_Sorted_Array {
	
	@Test
	public void test(){
		int ret=search(new int[]{1,3}, 3);
		return;
	}
	
    public int search(int[] A, int target) {
        if(A==null||A.length==0)
        	return -1;
        int L=0;
        int R=A.length-1;
        int mid;
        while(L<=R){
        	mid=L+(R-L)/2;
            if(A[mid]==target) return mid;
            //either bottom is order,or upper is order 
            if(A[L]<=A[mid]){
            	if(target>=A[L]&&target<A[mid])
            		R=mid-1;
            	else
            		L=mid+1;
            }
            else{
            	if(target>A[mid]&&target<=A[R])
            		L=mid+1;
            	else
            		R=mid-1;
            	
            }
        }
        return -1;
    }
}
