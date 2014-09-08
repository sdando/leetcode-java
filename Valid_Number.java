package leetcode;

import junit.framework.Assert;

public class Valid_Number extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
		Assert.assertEquals(isNumber("84656e656D"), true);

	}
	
  public boolean isNumber(String s) {
    try{
    	int num1 = Integer.parseInt(s);
    } 
    catch (Exception e) {
			// TODO: handle exception
    	try {
      	double num2 = Double.parseDouble(s);
			} catch (Exception e2) {
				// TODO: handle exception
				return false;
			}
		}
    if(s.indexOf("f") != -1 || s.indexOf("D") != -1)
    	return false;
    return true;
  }
}
