package leetcode;


import java.util.HashMap;
import java.util.Map.Entry;

import org.junit.Test;

public class Single_Number {
	@Test
	public void test(){
	    	
	}

	class Solution {
		public int singleNumber(int[] A) {
			int ret = 0;
			HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
			for (int number : A) {
				if (count.containsKey(number)) {
					count.put(number, count.get(number) + 1);
				} else {
					count.put(number, 1);
				}
			}
			for (Entry<Integer, Integer> entry : count.entrySet()) {
				if (entry.getValue() == 1) {
					ret = entry.getKey().intValue();
					break;
				}
			}
			return ret;
		}
	}
}