package leetcode;

import junit.framework.Assert;

public class First_Missing_Positive extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
        Assert.assertEquals(3, firstMissingPositive(new int[]{2,1}));
	}
	//把每个数放在该放的位置上，比如说A[]{1,2,3,4}
    public int firstMissingPositive(int[] A) {
        int t,length=A.length;
        int i=0;
        while(i<length){
        	if((A[i]>0&&A[i]<=length)&&A[A[i]-1]!=A[i]){
        		t=A[i];
        		A[i]=A[A[i]-1];
        		A[t-1]=t;
        	}
        	else {
				i++;
			}
        }
        for(i=0;i<length;i++){
        	if(A[i]!=i+1)
        		return i+1;
        }
        return length+1;
    }
}
