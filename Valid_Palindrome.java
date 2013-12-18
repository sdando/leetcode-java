package leetcode;

import org.junit.Test;

import test.JunitTest;



public class Valid_Palindrome {
	
    @Test
    public void test(){
    	JunitTest.Print(Solution.isPalindrome("1a2")+"");
    }
	
	static class Solution {
	    static boolean isPalindrome(String s) {
	    	if(s==""){
	    		return true;
	    	}
	        StringBuilder sb=new StringBuilder();
	        for(int i=0;i<s.length();i++){
	        	char ch=s.charAt(i);
	        	if((ch>='A'&&ch<='Z')||(ch>='a'&&ch<='z')||(ch>='0'&&ch<='9')){
	        		sb.append(ch);
	        	}
	        }
	        String origin=String.copyValueOf(sb.toString().toCharArray());
	        String reverse=sb.reverse().toString();
	        if(reverse.equalsIgnoreCase(origin)){
	        	return true;
	        }
	        else{
	        	return false;
	        }
	    }
	}
}
