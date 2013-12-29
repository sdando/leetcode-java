package leetcode;

public class Remove_Duplicates_from_Sorted_Array {
    public int removeDuplicates(int[] A) {
    	if(A==null||A.length==0)
    		return 0;
    	int num=1;
    	for(int i=0;i<A.length-1;i++){
    		if(A[i+1]!=A[i]){
    			A[num++]=A[i+1];
    		}
    	}
    	return num;
    }
}
