package leetcode;

import junit.framework.Assert;

public class Distinct_Subsequences extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
		Assert.assertEquals(3, numDistinct("rabbbit", "rabbit"));
	}
	//the question is same as "Edit Distance",f[i][j] represents
	//the count of T appears in S until i'th character of T and j'th
	//character of S
    public int numDistinct(String S, String T) {
        if(S.isEmpty()||T.isEmpty()) return 0;
        int sLength=S.length();
        int tLength=T.length();
        if(tLength>sLength) return 0;
        int[][] f=new int[tLength+1][sLength+1];
        for(int i=0;i<=sLength;i++)
        	f[0][i]=0;
        for(int i=0;i<=tLength;i++)
        	f[i][0]=0;
        for(int i=1;i<=sLength;i++){
        	if(T.charAt(0)==S.charAt(i-1))
        		f[1][i]=f[1][i-1]+1;
        	else
        		f[1][i]=f[1][i-1];
        }
        for(int i=2;i<=tLength;i++)
        	for(int j=1;j<=sLength;j++){
        		f[i][j]=f[i][j-1];
        		//第i个字符和第j个字符相等
        		if(T.charAt(i-1)==S.charAt(j-1))
        			f[i][j]+=f[i-1][j-1];
        	}
        return f[tLength][sLength];
    }
}
