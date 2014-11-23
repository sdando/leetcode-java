package leetcode;

import junit.framework.Assert;

public class Best_Time_to_Buy_and_Sell_Stock_III extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
    Assert.assertEquals(5, maxProfit(new int[]{1,2,1,5}));
	}
	//f[i]表示[0,i]区间内的最大交易，g[i]表示[i,len-1]区间内的最大交易
  public int maxProfit(int[] prices) {
    if(prices == null || prices.length < 2)
    	return 0;
    int len = prices.length;
    int[] f = new int[len];
    int[] g = new int[len];
    for(int i = 1, valley = prices[0]; i < len; i++){
    	f[i] = Math.max(f[i-1], prices[i] - valley);
    	valley = Math.min(valley, prices[i]);
    }
    for(int i = len-2, peak = prices[len - 1]; i >=0; i--){
    	g[i] = Math.max(g[i+1], peak - prices[i]);
    	peak = Math.max(peak, prices[i]);
    }
    int max = 0;
    for(int i = 0; i < len; i++){
    	max = Math.max(max, f[i]+g[i]);
    }
    return max;
  }
}
