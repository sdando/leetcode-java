package leetcode;

import junit.framework.Assert;

public class Maximum_Product_Subarray extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
    Assert.assertEquals(maxProduct(new int[]{-2,3,-4}), 2);
	}
	
  public int maxProduct(int[] A) {
  	int max = 1, min = 1, result = Integer.MIN_VALUE;
  	for(int i = 0; i < A.length; i++){
        int a = max*A[i];
        int b = min*A[i];
        max = Math.max(Math.max(a, b), A[i]);
        min = Math.min(Math.min(a, b), A[i]);
        result = Math.max(max, result);
  	}
  	return result;
  }
}
