package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Permutations_II extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> ret=permuteUnique(new int[]{1,1,2});
		return;
	}
	private int n;
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> ret=new ArrayList<ArrayList<Integer>>();
        if(num==null&&num.length==0) return ret;
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
        for(int i:num){
        	if(!map.containsKey(i)){
        		map.put(i, 1);
        	}
        	else {
				map.put(i, map.get(i)+1);
			}
        }
        ArrayList<Entry<Integer, Integer>> nums=new ArrayList<Entry<Integer,Integer>>();
        for(Entry<Integer, Integer> entry:map.entrySet()){
        	nums.add(entry);
        }
        ArrayList<Integer> one=new ArrayList<Integer>();
        n=num.length;
        permute(nums,one,ret);
        return ret;
    }
    private void permute(ArrayList<Entry<Integer, Integer>> nums,
    		ArrayList<Integer> one,ArrayList<ArrayList<Integer>> ret){
    	if(one.size()==n){
    		ret.add(new ArrayList<Integer>(one));
    		return;
    	}
    	int count;
    	for(int i=0;i<nums.size();i++){
    		count=0;
    		for(int j:one){
    			if(nums.get(i).getKey()==j)
    				count++;
    		}
    		if(count<nums.get(i).getValue()){
    			one.add(nums.get(i).getKey());
    			permute(nums,one,ret);
    			one.remove(one.size()-1);
    		}
    	}
    }
}
