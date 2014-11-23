package leetcode;

import junit.framework.Assert;

public class Find_Minimum_in_Rotated_Sorted_Array extends TestCase{
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		Assert.assertEquals(1, findMin(new int[]{2,3,4,5,1}));
	}
	
  public int findMin(int[] num) {
    int index1=0;
    int index2=num.length-1;
    if(index2 == 0)
    	return num[index2];
    int mid = index1;
    while(num[index1]>=num[index2]){
    	if(index2-index1==1){
    		mid= index2;
    		break;
    	}
    	mid = index1 + ((index2-index1)>>1);
    	if(num[mid] >= num[index1]){
    		index1 = mid;
    	}
    	else if(num[mid] <= num[index2]){
    		index2 = mid;
    	}
    }
    return num[mid];
  }
}
