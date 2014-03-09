package leetcode;

import junit.framework.Assert;

public class Longest_Common_Prefix extends TestCase{
	@Override
	public void test() {
		// TODO Auto-generated method stub
		String ret=longestCommonPrefix(new String[]{"aa","aab","ccc"});
		return;
	}
	
    public String longestCommonPrefix(String[] strs) {
        String prefix="";
        if(strs.length==0)
        	return prefix;
        char common='\0';
        int index=1;
        for(int cur=0;cur<strs.length;cur++){
        	if(index>strs[cur].length())
        		return prefix;
        	if(cur==0){
        		common=strs[cur].charAt(index-1);
        	}
        	else if(strs[cur].charAt(index-1)!=common)
			    return prefix;
        	if(cur==strs.length-1){
        		prefix+=common;
        		cur=-1;
        		index++;
        	}
        }
        return prefix;
    }
}
