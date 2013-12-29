package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class Permutations {
	private int maxDepth;
	private boolean[] used;
	private ArrayList<Integer> pmt;
	ArrayList<ArrayList<Integer>> ret;
	
	@Test
	public void test(){
		permute(new int[]{0,1});
	}
	
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ret=new ArrayList<ArrayList<Integer>>();
        if(num==null||num.length==0)
        	return ret;
        maxDepth=num.length;
        used=new boolean[num.length];
        pmt=new ArrayList<Integer>();
        Arrays.fill(used, false);
        Arrays.sort(num);
        dfs(0, num);
        return ret;
    }
    
    private void dfs(int depth,int[] num){
    	if(depth==maxDepth){
    		ArrayList<Integer> one=new ArrayList<Integer>(pmt);
    		ret.add(one);
    		return;
    	}
    	for(int i=0;i<num.length;i++){
    		if(!used[i]){
    			if(i!=0&&num[i]==num[i-1]&&used[i-1])
    				continue;
    			used[i]=true;
    			pmt.add(num[i]);
    			dfs(depth+1, num);
    			pmt.remove((Integer)num[i]);
    			used[i]=false;
    		}
    	}
    }
}
