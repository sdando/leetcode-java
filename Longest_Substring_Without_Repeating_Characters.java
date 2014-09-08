package leetcode;

import junit.framework.Assert;

public class Longest_Substring_Without_Repeating_Characters extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
        Assert.assertEquals(3, lengthOfLongestSubstring("abcabca"));
	}
	//j保存不重复字符串的起始位置
    public int lengthOfLongestSubstring(String s) {
    	int length=s.length();
    	if(length==0) return 0;
        boolean[] flg=new boolean[256];
        int j=0;
        int result=0;
        char c;
        for(int i=0;i<length;i++){
        	c=s.charAt(i);
        	if(!flg[c]){
        		flg[c]=true;
        	}
        	else {
				result=Math.max(result, i-j);
				for(int k=j;k<i;k++){
					if(s.charAt(k)==c){
						j=k+1;
						break;
					}
					flg[s.charAt(k)]=false;
				}
			}
        }
        result=Math.max(length-j, result);
        return result;
    }
}
