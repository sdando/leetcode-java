package leetcode;

public class Reverse_Integer {

	class Solution {
		public int reverse(int x) {
			boolean flag = false;
			if (x == 0) {
				return x;
			} else if (x < 0) {
				x = -x;
				flag = true;
			}
			StringBuffer sb = new StringBuffer(String.valueOf(x));
			sb.reverse();
			x = Integer.parseInt(sb.toString());
			if (flag) {
				x = -x;
			}
			return x;
		}
	}

}