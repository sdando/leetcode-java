package leetcode;

import java.util.ArrayList;

import org.junit.Test;

public class Letter_Combinations_of_a_Phone_Number {
	@Test
	public void test(){
		ArrayList<String> ret=letterCombinations("034");
		return;
	}
	
	ArrayList<String> ret;
	StringBuilder one;
	String[] encodes={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public ArrayList<String> letterCombinations(String digits) {
    	ret=new ArrayList<String>();
    	if(digits==null)
    		return ret;
    	ret.add("");
    	if(digits.isEmpty())
    		return ret;
    	ret.remove(0);
        one=new StringBuilder();
        digits=digits.replace("0", "");
        digits=digits.replace("1", "");
        doCombination(digits, 0, digits.length());
        return ret;
    }
    
    private void doCombination(String digits,int index,int length){
    	if(index==length){
    		ret.add(new String(one));
    		return;
    	}
    	String encode=encodes[digits.charAt(index)-'0'];
    	for(int i=0;i<encode.length();i++){
    		one.append((encode.charAt(i)));
    		doCombination(digits, ++index, length);
    		index--;
    		one.deleteCharAt(one.length()-1);
    	}
    	return;
    }
}
