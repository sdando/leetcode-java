package leetcode;

import java.util.HashSet;

import junit.framework.Assert;


public class Interleaving_String extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
		Assert.assertEquals(true, isInterleave("aa", "ab", "aaba"));
	}
    /**
     * 
     *Input:	"aa", "ab", "aaba"
     *Output:	false
     *Expected: true
     * 
     */
//    public boolean isInterleave(String s1, String s2, String s3) {
//        int len1=s1.length();
//        int len2=s2.length();
//        int len3=s3.length();
//        if((len1+len2)!=len3) return false;
//        HashSet<Character> set=new HashSet<Character>();
//        for(char ch:s1.toCharArray()){
//        	set.add(ch);
//        }
//        StringBuilder sb=new StringBuilder();
//        for(int i=0;i<len3;i++){
//        	if(!set.contains(s3.charAt(i))){
//        		sb.append(s3.charAt(i));
//        	}
//        }
//        if(s2.equals(sb.toString())) 
//        	return true;
//        else
//        	return false;
//    }
	//f[i][j]表示s1[1,i]和s2[1,j]是否匹配s3[1,i+j]
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1=s1.length();
        int len2=s2.length();
        int len3=s3.length();
        if((len1+len2)!=len3)
        	return false;
        boolean[][] f=new boolean[len1+1][len2+1];
        f[0][0]=true;
        for(int i=1;i<=len1;i++)
        	f[i][0]=f[i-1][0]&&s1.charAt(i-1)==s3.charAt(i-1);
        for(int j=1;j<=len2;j++)
        	f[0][j]=f[0][j-1]&&s2.charAt(j-1)==s3.charAt(j-1);
        for(int i=1;i<=len1;i++){
        	for(int j=1;j<=len2;j++)
        		f[i][j]=(s1.charAt(i-1)==s3.charAt(j+i-1)&&f[i-1][j])||
        		(s2.charAt(j-1)==s3.charAt(i+j-1)&&f[i][j-1]);
        }
        return f[len1][len2];
    }
}
