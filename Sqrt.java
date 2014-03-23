package leetcode;

import junit.framework.Assert;

public class Sqrt extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
        Assert.assertEquals(2, sqrt(2147395599));
	}
	
    public int sqrt(int x) {
    	if(x<2) return x;
        int low=1;
        int high=x/2;
        int mid;
        int low_mid=0;
        while(low<=high){
        	mid=low+(high-low)/2;
        	if(x/mid>mid) {low=mid+1; low_mid=mid;}
        	else if(x/mid<mid) high=mid-1;
        	else return mid;
        }
        return low_mid;
    }
}
