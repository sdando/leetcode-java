package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class Combinations {
	
	private boolean[] used;
	private ArrayList<Integer> pmt;
	ArrayList<ArrayList<Integer>> ret;
	
	@Test
	public void test(){
		combine(4, 2);
	}
	
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
    	ret=new ArrayList<ArrayList<Integer>>();
    	if(n==0||k==0)
    		return ret;
    	used=new boolean[n+1];
        pmt=new ArrayList<Integer>();
        Arrays.fill(used, false);
        dfs(0,1,n,k);
        return ret;
    }
    
    private void dfs(int depth,int start,int n,int k){
    	if(depth==k){
    		ArrayList<Integer> one=new ArrayList<Integer>(pmt);
    		ret.add(one);
    		return;
    	}
    	for(int i=start;i<=n;i++){
    		if(!used[i]){
    			used[i]=true;
    			pmt.add(i);
    			dfs(depth+1,i+1,n,k);
    			pmt.remove((Integer)i);
    			used[i]=false;
    		}
    	}
    }
}
