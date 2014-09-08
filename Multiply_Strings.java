package leetcode;

import junit.framework.Assert;

public class Multiply_Strings extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
    Assert.assertEquals(multiply("99", "99"), "9881");
	}
	
	//先反转两个字符串，然后从数位的最地位模拟乘法运算
  public String multiply(String num1, String num2) {
    String n1 = new StringBuilder(num1).reverse().toString();
    String n2 = new StringBuilder(num2).reverse().toString();
    int[] num = new int[n1.length() + n2.length()];
    for(int i = 0; i < n1.length(); i++){
    	for(int j = 0; j < n2.length(); j++){
    		num[i+j] += (n1.charAt(i) - '0')*(n2.charAt(j) - '0'); 
    	}
    }
    int carry,digit;
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < num.length; i++){
    	digit = num[i] % 10;
    	carry = num[i] / 10;
    	if(i+1 < num.length){
    		num[i+1] += carry;
    	}   
    	sb.insert(0, digit);
    }
    while(sb.charAt(0) == '0' && sb.length() > 1){
    	sb.deleteCharAt(0);
    }
    return sb.toString();
  }
}
