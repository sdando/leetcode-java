package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Combination_Sum extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
        ArrayList<ArrayList<Integer>> ret=combinationSum(new int[]{2,2,2,2}, 6);
        return;
	}
	
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> ret=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> one=new ArrayList<Integer>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, one, ret);
        return ret;
    }
    
    public void dfs(int[] candidates, int target,int start, ArrayList<Integer>one, ArrayList<ArrayList<Integer>> ret){
    	if(target==0){
    		ret.add(new ArrayList<Integer>(one));
    		return;
    	}
    	for(int i=start;i<candidates.length;i++){
    		if(candidates[i]<=target){
    			one.add(candidates[i]);
    			dfs(candidates, target-candidates[i], i, one, ret);
    			one.remove(one.size()-1);
    		}
    	}
    }
}
