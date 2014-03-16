package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.Assert;

public class _3Sum_Closest extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
        Assert.assertEquals(2, threeSumClosest(new int[]{-1,2,1,-4}, 1));
	}
	
    public int threeSumClosest(int[] num, int target) {
        int a,b,c,i,j,k;
        Arrays.sort(num);
        ArrayList<Integer> input=new ArrayList<Integer>();
        for(int d:num) input.add(d);
        int gap=Integer.MAX_VALUE;
        int sum,sumCloset=0;
        for(i=0;i<num.length-2;i=input.lastIndexOf(a)+1){
        	a=num[i];
        	j=i+1;
        	k=num.length-1;
        	while(j<k){
            	b=num[j];
            	c=num[k];
        		sum=a+b+c;
        		if(gap>Math.abs(sum-target)){
        			sumCloset=sum;
        			gap=Math.abs(sum-target);
        		}
        		if(sum<target) j++;
        		else k--;
        	}
        }
        return sumCloset;
    }
}
