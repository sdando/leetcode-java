package leetcode;

import java.util.Stack;

import org.junit.Test;

public class Valid_Parentheses {
	
	@Test
	public void test(){
		boolean ret=isValid("()}");
		return;
	}
    public boolean isValid(String s) {
        if(s==null||s.isEmpty())
        	return true;
        if(s.length()==1)
        	return false;
        String left="([{";
        String right=")]}";
        Stack<Character> brakets=new Stack<Character>();
        boolean flag=true;
        for(char ch:s.toCharArray()){
        	if(left.indexOf(ch)!=-1)
        		brakets.push(ch);
        	else{
        		if(!brakets.isEmpty()){
        			char top=brakets.peek();
        			if(left.indexOf(top)!=right.indexOf(ch)){
        				flag=false;
        				break;
        			}	
        			else
        				brakets.pop();
        		}
        		else{
        			flag=false;
        			break;
        		}
        	}
        }
        if(flag&&brakets.isEmpty())
        	return true;
        else
        	return false;
    }
}
