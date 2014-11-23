package leetcode;

import junit.framework.Assert;

public class Regular_Expression_Matching extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
    Assert.assertEquals(isMatch("a", ".*..a*"), false);
	}
	
	public boolean isMatch(String s, String p){
		return valid(s+"\0", p+"\0");
	}

	public boolean valid(String s, String p) {
		if(p.equals("\0")) return s.equals("\0");
		if (p.charAt(1) != '*') {
			if (s.charAt(0) == p.charAt(0) || (p.charAt(0) == '.' && !s.equals("\0")))
				return valid(s.substring(1), p.substring(1));
			else
				return false;
		} else {
			int index = 0;
			while(index < s.length()-1 && (s.charAt(index) == p.charAt(0)||(p.charAt(0) == '.' && !s.equals("\0")))){
				if(valid(s.substring(index+1), p.substring(2)))
					return true;
				index++;
			}
		  return valid(s, p.substring(2));
		}
	}
}
