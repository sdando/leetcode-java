package leetcode;

public class Remove_Duplicates_from_Sorted_Array_II {
    public int removeDuplicates(int[] A) {
    	if(A==null||A.length==0)
    		return 0;
    	int num=1;
    	int key=A[0];
    	int count=1;
    	for(int i=1;i<A.length;i++){
    		if(key==A[i]){
    			count++;
    			if(count<=2)
    				A[num++]=A[i];
    		}
    		else{
    			A[num++]=A[i];
    			key=A[i];
    			count=1;
    		}
    	}
    	return num;
    }
}
