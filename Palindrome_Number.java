package leetcode;

public class Palindrome_Number {
	//numDigits保存是几位数
    public boolean isPalindrome(int x) {
        if(x<0)
        	return false;
        int numDigits=1;
        while(x/numDigits>=10)
        	numDigits*=10;
        int highEnd,lowEnd;
        while(x!=0){
        	highEnd=x/numDigits;
        	lowEnd=x%10;
        	if(highEnd!=lowEnd)
        		return false;
        	x=(x%numDigits)/10;
        	numDigits/=100;
        }
        return true;
    }
}
