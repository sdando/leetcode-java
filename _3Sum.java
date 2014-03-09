package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class _3Sum extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> ret=threeSum(new int[]{-1,0,1,2,-1,-4});
		return;
	}
	
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> ret=new ArrayList<ArrayList<Integer>>();
        if(num==null||num.length<3) return ret;
        Arrays.sort(num);
        ArrayList<Integer> input=new ArrayList<Integer>();
        for(int i:num){input.add(i);}
        int a,b,c;
        int length=input.size();
        for(int i=0; i<length-2; i=input.lastIndexOf(a)+1){
        	a=num[i];
        	for(int j=i+1 ; j<length-1; j=input.lastIndexOf(b)+1){
        		b=num[j];
        		ArrayList<Integer> one=new ArrayList<Integer>();
        		c=0-a-b;
        		one.add(a);one.add(b);one.add(c);
        		int pos=Arrays.binarySearch(num, j+1, length ,c);
        		if(pos>=0&&pos<length){
        			ret.add(new ArrayList<Integer>(one));
        		}
        	}
        }
        return ret;
    }

}
