package leetcode;

import org.junit.Test;

public class Roman_to_Integer {
	@Test
	public void test(){
		int num=romanToInt("DCXXI");
		return;
	}
	
    public int romanToInt(String s) {
    	int ret=0;
    	if(s==null||s.length()==0)
    		return ret;
        String[] roman={"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] value={1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int i;
        while(!s.isEmpty()){
        	for(i=0;i<roman.length;i++)
        		if(s.startsWith(roman[i])){
        			ret+=value[i];
        			s=s.substring(roman[i].length());
        			break;
        		}
        }
        return ret;
    }
}
