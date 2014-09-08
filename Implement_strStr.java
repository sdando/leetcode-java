package leetcode;

import junit.framework.Assert;

public class Implement_strStr extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
		Assert.assertEquals("", strStr("mississippi", "issip"));

	}
	//next数组这样理解，当第j个字符不相等时，应在比较目标字符串的第next[j-1]个字符。next[j-1]代表
	//到第j-1个字符前缀字符串和后缀字符串重合的最大长度
    public String strStr(String haystack, String needle) {
        int len1=haystack.length();
        int len2=needle.length();
        if(len2>len1) return null;
        if(len2==0) return haystack;
        int i=0,j=0;
        int[] next=get_next(needle);
        while(true){
        	while(i<len1&&j<len2&&haystack.charAt(i)==needle.charAt(j)){
        		i++;j++;
        	}
        	if(j==len2) return haystack.substring(i-j);
        	if(i==len1) break;
        	if(j==0) i++;
        	else j=next[j-1];
        }
        return null;
    }
    //j代表已匹配的字符串个数。假设i-1以匹配j（从开头到j）,判断到第i个字符的next值
    //abcab 
    //    ↑
    private int[] get_next(String s){
    	int len=s.length();
    	int[] next=new int[len];
    	next[0]=0;
    	for(int i=1,j=0;i<len;i++){
    		while(j>0&&s.charAt(i)!=s.charAt(j))
    			j=next[j-1]; 
    		if(s.charAt(i)==s.charAt(j))
    			j++;
    		next[i]=j;
    	}
    	return next;
    }
}
