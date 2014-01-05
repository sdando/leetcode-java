package leetcode;

public class Search_Insert_Position {
    public int searchInsert(int[] A, int target) {
    	int i;
        for(i=A.length-1;i>=0;i--){
        	if(A[i]==target) break;
        	if(A[i]<target) break;
        }
        if(i==-1) return 0;
        if(A[i]==target) return i;
        return i+1;
    }
}
