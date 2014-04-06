package leetcode;

import junit.framework.Assert;

public class Minimum_Window_Substring extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
		Assert.assertEquals("BANC", minWindow("ADOBECODEBANC", "ABC"));
	}
	//num为匹配字符串的字符数，双指针，i与j之间的字符能匹配T后，在增加i缩小窗口
    public String minWindow(String S, String T) {
        int sLength=S.length();
        int tLength=T.length();
        if(tLength==0||sLength<tLength) return "";
        int[] s=new int[256];
        int[] t=new int[256];
        int left=0,right=0,i,j;
        for(i=0;i<tLength;i++){
        	t[T.charAt(i)]++;
        }
        int num=0;
        int min=Integer.MAX_VALUE;
        for(i=0,j=0;j<sLength;j++){
        	s[S.charAt(j)]++;
        	if(num<tLength){
        		if(s[S.charAt(j)]<=t[S.charAt(j)]){
        			num++;
        		}
        	}
        	if(num==tLength){
        		//i在增加时，若S[i]不在T内也可增加
        		while(i<j&&(t[S.charAt(i)]==0||s[S.charAt(i)]>t[S.charAt(i)])){
        			s[S.charAt(i)]--;
        			i++;
        		}
        		if(min>(j-i+1)){min=j-i+1;left=i;right=j;}
        	}
        }
        if(min!=Integer.MAX_VALUE)
        	return S.substring(left,right+1);
        else
        	return "";
    }
}
