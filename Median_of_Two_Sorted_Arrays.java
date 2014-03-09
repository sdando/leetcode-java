package leetcode;

import java.util.Arrays;

import junit.framework.Assert;

public class Median_of_Two_Sorted_Arrays extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
        Assert.assertEquals(2.0, findMedianSortedArrays(new int[]{1,3}, new int[]{0,2,4}));
	}
	
    public double findMedianSortedArrays(int A[], int B[]) {
        int total=A.length+B.length;
        if((total&0x1)!=0){
        	return findKth(A, 0, B, 0, total/2+1);
        }
        else{
        	return (double)(findKth(A, 0, B, 0, total/2)+findKth(A, 0, B, 0, total/2+1))/2;
        }
    }
    
    public double findKth(int A[],int lowA,int B[],int lowB,int k){
    	int a=A.length-lowA;
    	int b=B.length-lowB;
    	if(a>b) return findKth(B,lowB,A,lowA,k);
    	if(a==0) return B[lowB+k-1];
    	if(k==1) return Math.min(A[lowA], B[lowB]);
    	int pa=Math.min(k/2, a);
    	int pb=k-pa;
    	//A的k/2不可能包含k.
    	if(A[lowA+pa-1]<B[lowB+pb-1]){
    		return findKth(A,lowA+pa,B,lowB,k-pa);
    	}
    	else if(A[lowA+pa-1]>B[lowB+pb-1])
    		return findKth(A,lowA,B,lowB+pb,k-pb);
    	else {
			return A[lowA+pa-1];
		}
    }
}
