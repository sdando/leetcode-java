package leetcode;

public class Remove_Element {
    public int removeElement(int[] A, int elem) {
        int num=0;
        for(int i=0;i<A.length;i++){
        	if(A[i]!=elem)
        		A[num++]=A[i];
        }
        return num;
    }
}
