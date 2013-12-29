package leetcode;

import org.junit.Test;

import test.JunitTest;

public class Integer_to_Roman {
	
	@Test
	public void test(){
		JunitTest.Print(new Integer_to_Roman().intToRoman2(3106));
	}
	
    public String intToRoman(int num) {
        String[] roman={"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] value={1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<value.length;i++){
        	while(num>=value[i]){
        		num-=value[i];
        		sb.append(roman[i]);
        	}
        }
        return sb.toString();
    }
    
    public String intToRoman2(int num) {
        char[] roman={'M','D','C','L','X','V','I'};
        int[] value={1000,500,100,50,10,5,1};
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<value.length;i++){
        	while(num>=value[i]){
        		num-=value[i];
        		sb.append(roman[i]);
        	}
        }
        return sb.toString();
    }
}
