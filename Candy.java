package leetcode;

import java.util.Arrays;

import junit.framework.Assert;

public class Candy extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
        Assert.assertEquals(7, candy(new int[]{1,2,2,2,1}));
	}
    public int candy(int[] ratings) {
        if(ratings==null) return 0;
        int length=ratings.length;
        if(length<2) return length;
        int[] candy=new int[length];
        Arrays.fill(candy, 1);
        int i;
        for(i=1;i<length;i++){
        	if(ratings[i]>ratings[i-1]){
        		candy[i]=candy[i-1]+1;
        	}
        }
        int sum=candy[length-1];
        for(i=length-2;i>=0;i--){
        	if(ratings[i]>ratings[i+1]&&(candy[i]<=candy[i+1]))
        		candy[i]=candy[i+1]+1;
        	sum+=candy[i];
        }
        return sum;
    }
}
