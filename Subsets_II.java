package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets_II {
	
	ArrayList<ArrayList<Integer>> ret;
	ArrayList<Integer> one;
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ret=new ArrayList<ArrayList<Integer>>();
        one=new ArrayList<Integer>();
        ret.add(one);
        Arrays.sort(num);
        doSubset(num, 0);
        return ret; 
    }
    
    private void doSubset(int[] S,int pos){
    	for(int i=pos;i<S.length;i++){
    		one.add(S[i]);
    		ret.add(new ArrayList<Integer>(one));
    		doSubset(S, i+1);
    		one.remove(one.size()-1);
    		while(i<S.length-1&&S[i]==S[i+1]) i++;
    	}
    }
}
