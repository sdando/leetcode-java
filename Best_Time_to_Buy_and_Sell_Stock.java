package leetcode;

import org.junit.Test;

import test.JunitTest;

public class Best_Time_to_Buy_and_Sell_Stock {
	
	@Test
	public void test(){
		JunitTest.Print(new Solution().maxProfit(new int[]{2,1})+"");
	}
	
	public class Solution {
		
	    public int maxProfit(int[] prices) {
	    	if(prices==null||prices.length==0){
	    		return 0;
	    	}
	        int min=Integer.MAX_VALUE;
	        int max=Integer.MIN_VALUE;
	        for(int i:prices){
	        	if(i>max){
	        		max=i;
	        	}
	        	if(i<min){
	        		min=i;
	        	}
	        }
	        return max-min;
	    }
	}
}
