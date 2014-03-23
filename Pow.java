package leetcode;

import junit.framework.Assert;

public class Pow extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
        Assert.assertEquals(36.0, pow(1.00000, -2147483648));
	}
	public double power(double x, int n) {
		if (n == 0)
			return 1;
	 
		double v = power(x, n / 2);
	 
		if (n % 2 == 0) {
			return v * v;
		} else {
			return v * v * x;
		}
	}
	 
	public double pow(double x, int n) {
		if (n < 0) {
			return 1 / power(x, -n);
		} else {
			return power(x, n);
		}
	}
}
