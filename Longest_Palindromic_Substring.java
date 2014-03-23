package leetcode;

public class Longest_Palindromic_Substring extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub

	}
    public String longestPalindrome(String s) {
    	if(s==null||"".equals(s)) return "";
        int length=s.length();
        boolean[][] f=new boolean[length][length];
        int maxLength=1,start=0;
        for(int i=0;i<length;i++){
        	f[i][i]=true;
        	for(int j=0;j<i;j++){
        		f[j][i]=s.charAt(j)==s.charAt(i)&&(i-j<2||f[j+1][i-1]);
				if (f[j][i]&&maxLength < i - j + 1) {
					start = j;
					maxLength = i - j + 1;
				}
        	}
        }
        return s.substring(start,start+maxLength);
    }
}
