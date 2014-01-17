package leetcode;

import java.util.HashSet;

public class Longest_Consecutive_Sequence extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
        int ret=longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
        return;
	}
	
	HashSet<Integer> set;
    public int longestConsecutive(int[] num) {
        if(num.length<2)
        	return num.length;
        int i;
        set=new HashSet<Integer>();
        for(i=0;i<num.length;i++){
        	set.add(num[i]);
        }
        int max=Integer.MIN_VALUE;
        int count;
        for(i=0;i<num.length;i++){
        	count=doCount(num[i]);
        	max=max>count? max:count;
        }
        return max;
    }
    
    private int doCount(int num){
    	int count=0;
    	int cur=num;
    	while(set.contains(cur)){
    		count++;
    		set.remove(cur);
    		cur++;
    	}
    	cur=num-1;
    	while(set.contains(cur)){
    		count++;
    		set.remove(cur);
    		cur--;
    	}
    	return count;
    }

}
