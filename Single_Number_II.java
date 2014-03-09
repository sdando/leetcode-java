package leetcode;

import org.junit.Test;

import test.JunitTest;

public class Single_Number_II {
	
	@Test
	public void test(){
		JunitTest.Print(new Single_Number_II().singleNumber(new int[]{1,1,1,3})+"");
	}
	//count统计所有数在某一位上1的个数，若恰好是3的倍数，则出现次数为1的数在这一位上为0，否则，则为1
    public int singleNumber(int[] A) {
        int ret=0;
    	int count;
    	for(int i=0;i<32;i++){
    		count=0;
    		for(int j=0;j<A.length;j++){
    			if((A[j]&(1<<i))!=0){
    				count++;
    			}
    		}
    		ret|=(count%3)<<i;
    	}
    	return ret;
    }
}
