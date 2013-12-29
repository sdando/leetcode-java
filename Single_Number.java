package leetcode;

import java.util.Map.Entry;

import org.junit.Test;

public class Single_Number {
	@Test
	public void test(){
	    	
	}

	class Solution {
		public int singleNumber(int[] A) {
			int ret = 0;
			for (int number : A) {
                ret^=number;
			}
			return ret;
		}
	}
}