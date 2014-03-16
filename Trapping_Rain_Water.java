package leetcode;

import junit.framework.Assert;

public class Trapping_Rain_Water extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
       Assert.assertEquals(6, trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
	}
	
    public int trap(int[] A) {
        if(A==null||A.length==0) return 0;
        int[] maxleft=new int[A.length];
        int[] maxrigth=new int[A.length];
        //maxleft store the max height on the left side of i
        for(int i=1;i<A.length;i++){
        	maxleft[i]=Math.max(maxleft[i-1],A[i-1]);
        	maxrigth[A.length-i-1]=Math.max(maxrigth[A.length-i], A[A.length-i]);
        }
        int sum=0;
        int capacity;
        for(int i=1;i<A.length;i++){
        	capacity=Math.min(maxleft[i], maxrigth[i])-A[i];
        	if(capacity>0) sum+=capacity;
        }
        return sum;
    }

}
