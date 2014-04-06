package leetcode;

import junit.framework.Assert;

public class Jump_Game extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
       Assert.assertEquals(false, canJump(new int[]{3,2,1,0,4}));
       Assert.assertEquals(true, canJump(new int[]{2,3,1,1,4}));
	}
	
    public boolean canJump(int[] A) {
        if(A==null) return false;
        int length=A.length;
        for(int i=0;i<length; ){
        	if(A[i]==0&&i==length-1) return true;
        	if(A[i]==0&&i!=length-1) break;
        	if(i+A[i]<length-1) 
        		i+=A[i];
        	else
        		return true;
        }
        return false;
    }

}
