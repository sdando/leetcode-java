package leetcode;

import org.junit.Test;

import test.JunitTest;

public class Best_Time_to_Buy_and_Sell_Stock {
	
	@Test
	public void test(){
		JunitTest.Print(new Solution().maxProfit(new int[]{1,2,9})+"");
	}
	
	public class Solution {
		
	    public int maxProfit(int[] prices) {
	    	if(prices==null||prices.length<=1){
	    		return 0;
	    	}
	        int min=prices[0];
	        int max=min;
	        int ret=0;
	        for(int i=1;i<prices.length;i++){
	        	if(prices[i]<min){
	        		max=min=prices[i];
	        	}
	        	else if(prices[i]>max){
	        		int t=prices[i]-min;
	        		if(t>ret) 
	        			ret=t;
	        	}
	        }
	        return ret;	       
	    }
	}
}
