package leetcode;

public class Unique_Binary_Search_Trees {
    public int numTrees(int n) {
    	if(n<=1)
    		return 1;
    	int ret=doCount(1, n);
    	return ret;
    }
    //if n is 0 ,we think is 1
    private int doCount(int start,int end){
    	if(start>=end)
    		return 1;
    	int total=0;
    	for(int i=start;i<=end;i++)
    		total+=doCount(start,i-1)*doCount(i+1, end);
    	return total;
    }
}
