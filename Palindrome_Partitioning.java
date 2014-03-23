package leetcode;

import java.util.ArrayList;

public class Palindrome_Partitioning extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
        ArrayList<ArrayList<String>> ret=partition("aab");
        return;
        
	}
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> ret=new ArrayList<ArrayList<String>>();
        if(s==null||"".equals(s)) return ret;
        ArrayList<String> one=new ArrayList<String>();
        dfs(0, s, one, ret);
        return ret;
    }
    
    private void dfs(int start,String s,ArrayList<String> one,ArrayList<ArrayList<String>> ret){
    	if(start==s.length()){
    		ret.add(new ArrayList<String>(one));
    		return;
    	}
    	for(int i=start;i<s.length();i++){
    		if(isPalindrome(s, start, i)){
    			one.add(s.substring(start, i+1));
    			dfs(i+1, s, one, ret);
    			one.remove(one.size()-1);
    		}
    	}
    }
    private boolean isPalindrome(String s,int start,int end){
    	while(start<end){
    		if(s.charAt(start++)!=s.charAt(end--)) return false;
    	}
    	return true;
    }
}
