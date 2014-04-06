package leetcode;

import junit.framework.Assert;

public class Jump_Game_II extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
        int ret=jump(new int[]{1,2});
        Assert.assertEquals(2, ret);
	}
    //倒着走进行贪心
    public int jump(int[] A) {
        int n=A.length;
        int pre=0;
        int cur=n-1;
        int step=0;
        if(cur==pre) return 0;
        while(true){
        	step++;
        	pre=cur;
        	for(int i=cur-1;i>=0;i--){
        		if(i+A[i]>=pre){
        			if(cur>i){
        				cur=i;
        			}
        		}
        	}
        	if(cur==0)
        		return step;
        }
    }
}
