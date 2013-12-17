package leetcode;

import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation {

	class Solution {
	    public int evalRPN(String[] tokens) {
	    	int a,b,c;
	    	Stack<String> stack=new Stack<String>();
	    	for(String s:tokens){
	    		if(!"+".equals(s)&&!"-".equals(s)&&
	    				!"*".equals(s)&&!"/".equals(s)){
	    			stack.push(s);
	    		}
	    		else {
	    			a=Integer.parseInt(stack.pop());
	    			b=Integer.parseInt(stack.pop());
					switch (s.charAt(0)) {
					case '+':
						c=b+a;
						break;
					case '-':
						c=b-a;
						break;
					case '*':
						c=b*a;
						break;
					default:
						c=b/a;
						break;
					}
					stack.push(String.valueOf(c));
				}
	    	}
	    	return Integer.parseInt(stack.pop());        
	    }
	}
}

