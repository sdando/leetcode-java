package leetcode;

import junit.framework.Assert;

public class Scramble_String extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
		Assert.assertEquals(true, isScramble("great", "rgeat"));
	}
	//DP,f[k][i][j]代表从s1[i,i+k-1]和s2[j,j+k-1]是否为Scramble String
    public boolean isScramble(String s1, String s2) {
        int len1=s1.length();
        int len2=s2.length();
        if(len1!=len2) return false;
        boolean[][][] f=new boolean[len1+1][len1][len2];
        for(int i=0;i<len1;i++)
        	for(int j=0;j<len2;j++)
        		f[1][i][j]=(s1.charAt(i)==s2.charAt(j)?true:false);
        
        for(int k=2;k<len1+1;k++)
        	for(int i=0;i<=len1-k;i++)
        		for(int j=0;j<=len2-k;j++){
        			f[k][i][j]=false;
        			for(int division=1;division<k&&!f[k][i][j];division++){
        				f[k][i][j]=(f[division][i][j]&&f[k-division][i+division][j+division])||
        				(f[division][i][j+k-division]&&f[k-division][i+division][j]);
        			}
        		}
        return f[len1][0][0];
    }
}
