package leetcode;

public class Best_Time_to_Buy_and_Sell_Stock_II {
    public int maxProfit(int[] prices) {
        if(prices.length<2)
        	return 0;
        int startIndex=0;
        int sum=0;
        int i;
        for(i=1;i<prices.length;i++){
        	if(prices[i-1]>prices[i]){
        		sum+=(prices[i-1]-prices[startIndex]);
        		startIndex=i;
        	}
        }
        if(prices[i-1]>prices[startIndex])
        	sum+=(prices[i-1]-prices[startIndex]);
        return sum;
    }
}
