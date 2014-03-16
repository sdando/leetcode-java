package leetcode;

import junit.framework.Assert;

public class Search_in_Rotated_Sorted_Array_II extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
        Assert.assertEquals(true, search(new int[]{1,3,1,1,1}, 3));
	}
	
    public boolean search(int[] A, int target) {
        if(A==null||A.length==0)
        	return false;
        int L=0;
        int R=A.length-1;
        int mid;
        while(L<=R){
        	mid=L+(R-L)/2;
            if(A[mid]==target) return true;
            if(A[L]<A[mid]){
            	if(target>=A[L]&&target<A[mid])
            		R=mid-1;
            	else
            		L=mid+1;
            }
            //if left side equals mid, according mid!=target, only can do is L++
            else if(A[L]==A[mid]){
            	L++;
            }
            else{
            	if(target>A[mid]&&target<=A[R])
            		L=mid+1;
            	else
            		R=mid-1;
            	
            }
        }
        return false;
    }
}
