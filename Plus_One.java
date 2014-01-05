package leetcode;

import org.junit.Test;


public class Plus_One {
	@Test
	public void test(){
		int[] n=plusOne(new int[]{9,9,9});
		return;
	}
    public int[] plusOne(int[] digits) {
    	int t,length=digits.length;
        int adding=(digits[length-1]+1)/10;
        digits[length-1]=(digits[length-1]+1)%10;
        for(int i=length-2;i>=0;i--){
        	t=adding;
        	adding=(digits[i]+adding)/10;
        	digits[i]=(digits[i]+t)%10;
        }
        if(adding!=0){
        	int[] nDigits=new int[length+1];
        	System.arraycopy(digits, 0, nDigits, 1, length);
        	nDigits[0]=adding;
            return nDigits;
        }
        return digits;
    }
}
