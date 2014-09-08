package leetcode;

import junit.framework.Assert;

public class Divide_Two_Integers extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
		Assert.assertEquals(-3, divide(-2147483648, 1));
	}
	//先转换成long，否则abs(Integer.MIN_VALUE)时有问题
    public int divide(int dividend, int divisor) {
        if(dividend==0) return 0;
        long a=dividend;
        long b=divisor;
        int sign=1;
        if((a>0&&b<0)||(a<0&&b>0))
        	sign=-1;
        long ans=(long)mydivide(Math.abs(a), Math.abs(b));
        if(sign==-1) ans=-ans;
        return (int)ans;
    }
    //逐一判断2^31,2^30,2^29...2^0个b是a能否减掉，防止溢出，a左移而非b右移
    private long mydivide(long a,long b){
    	long ans=0;
    	for(int i=31;i>=0;i--){
    		if((a>>i)>=b){
    			a-=(b<<i);
    			ans+=1<<i;
    		}
    		if(a==0) break;
    	}
    	return ans;
    }
}
