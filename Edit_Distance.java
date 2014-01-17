package leetcode;

public class Edit_Distance extends TestCase{
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		int dis=minDistance("", "abcd");
		return;
	}
	/* dis[i][j] is first i and first j of two string
	 * if i'th of first string <> j'th of second string
	 * dis[i][j]=min{dis[i-1][j]+1,dis[i][j-1]+1,dis[i-1][j-1]+1}
	 * else
	 * dis[i][j]=dis[i-1][j-1]
	 */
    public int minDistance(String word1, String word2) {
    	if(word1.isEmpty()&&word2.isEmpty())
    		return 0;
    	int len1=word1.length();
    	int len2=word2.length();
    	int[][] dis=new int[len1+1][len2+1];
    	dis[0][0]=0;
    	int i,j;
    	for(i=1;i<=len1;i++)
    		dis[i][0]=i;
    	for(i=1;i<=len2;i++)
    		dis[0][i]=i;
    	for(i=1;i<=len1;i++){
    		for(j=1;j<=len2;j++){
    			if(word1.charAt(i-1)==word2.charAt(j-1)){
    				dis[i][j]=dis[i-1][j-1];
    			}
    			else {
    				int a=dis[i-1][j]+1;
    				int b=dis[i][j-1]+1;
					int c=dis[i-1][j-1]+1;
					dis[i][j]=a>b? b:a;
					dis[i][j]=dis[i][j]>c? c:dis[i][j];
				}
    		}
    	}
    	return dis[len1][len2];
    }
}
