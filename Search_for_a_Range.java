package leetcode;

import java.util.Arrays;

import junit.framework.Assert;

public class Search_for_a_Range extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
		Assert.assertEquals(true, Arrays.equals(new int[]{-1,-1}, 
			searchRange(new int[]{2,2}, 3)));

	}
    public int[] searchRange(int[] A, int target) {
        if(A==null||A.length==0) return new int[]{-1,-1}; 
        int length=A.length;
        int mid,low=0,high=length-1;
        int start,end;
        while(low<=high){
        	mid=low+(high-low)/2;
            if(A[mid]==target){
            	start=end=mid;
            	while(start>-1&&A[start]==target) start--;
            	while(end<length&&A[end]==target) end++;
            	if(start!=mid) start++;
            	if(end!=mid) end--;
            	return new int[]{start,end};
            }
            else if(A[mid]<target)
            	low=mid+1;
            else
            	high=mid-1;
        }
        return new int[]{-1,-1};
    }
}
