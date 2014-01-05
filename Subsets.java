package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class Subsets {
	
	ArrayList<ArrayList<Integer>> ret;
	ArrayList<Integer> one;
	
	@Test
	public void test(){
		subsets(new int[]{1,2});
	}
	
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ret=new ArrayList<ArrayList<Integer>>();
        one=new ArrayList<Integer>();
        ret.add(one);
        Arrays.sort(S);
        doSubset(S, 0);
        return ret;       
    }
    
    private void doSubset(int[] S,int pos){
    	for(int i=pos;i<S.length;i++){
    		one.add(S[i]);
    		ret.add(new ArrayList<Integer>(one));
    		doSubset(S, i+1);
    		one.remove(one.size()-1);
    	}
    }
}
