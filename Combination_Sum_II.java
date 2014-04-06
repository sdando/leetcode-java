package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Combination_Sum_II extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> ret=combinationSum2(new int[]{10,1,2,7,6,1,5}, 7);
		return;
	}
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> ret=new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> one=new ArrayList<Integer>();
        Arrays.sort(num);
        dfs(num, 0, target, one, ret);
        return ret;
        
    }
    private void dfs(int[] num,int start,int gap,ArrayList<Integer> one,ArrayList<ArrayList<Integer>> ret){
    	if(gap==0){
    		ret.add(new ArrayList<Integer>(one));
    		return;
    	}
    	int previous=-1;
    	for(int i=start;i<num.length;i++){
    		if(num[i]==previous) continue;
    		if(num[i]<=gap){
    			one.add(num[i]);
    			previous=num[i];
    			dfs(num, i+1, gap-num[i], one, ret);
    			one.remove(one.size()-1);
    		}
    	}
    }
}
