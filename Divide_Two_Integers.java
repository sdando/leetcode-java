package leetcode;

import junit.framework.Assert;

public class Divide_Two_Integers extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
		Assert.assertEquals(-3, divide(-2147483648, 1));
	}
	//��ת����long������abs(Integer.MIN_VALUE)ʱ������
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
    //��һ�ж�2^31,2^30,2^29...2^0��b��a�ܷ��������ֹ�����a���ƶ���b����,(a+b)/c = a/c + b/c
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
