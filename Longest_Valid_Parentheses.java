package leetcode;

import java.util.ArrayList;

import junit.framework.Assert;

public class Longest_Valid_Parentheses extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
    Assert.assertEquals(longestValidParentheses(")(())"), 4);
	}
  public int longestValidParentheses(String s) {
  	if(s == null || "".equals(s))
  		return 0;
    ArrayList<Integer> stack = new ArrayList<Integer>();
    //last is the last non-matching ')'
    int last = -1;
    int max = 0;
    for(int i = 0; i < s.length(); i++){
    	if(s.charAt(i) == '('){
    		stack.add(i);
    	}
    	else {
				if(stack.isEmpty()){
					last = i;
				}
				else{
					stack.remove(stack.size() - 1);
					if(stack.isEmpty()){
						max = Math.max(max, i - last);
					}
					else {
						max = Math.max(max, i - stack.get(stack.size() - 1));
					}
				}
			}
    }
    return max;
  }
}
