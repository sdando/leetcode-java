package leetcode;

import java.util.Arrays;
import java.util.Collections;

public class Next_Permutation extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
		int[] array=new int[]{1,3,2};
        nextPermutation(array);
        return;
	}
/*
 * 在当前序列中，从尾端往前寻找两个相邻元素，前一个记为*i，后一个记为*ii，并且满足*i < *ii。
 * 然后再从尾端寻找另一个元素*j，如果满足*i < *j，即将第i个元素与第j个元素对调，
 * 并将第ii个元素之后（包括ii）的所有元素颠倒排序，即求出下一个序列了。
 */
    public void nextPermutation(int[] num) {
        if(num==null||num.length<2) return;
        int i,ii,j,temp,t,k;
        for(i=num.length-1;;){
        	ii=i;
        	i--;
        	if(num[i]<num[ii]){
        		j=num.length;
                while(!(num[i]<num[--j]));
                temp=num[i];num[i]=num[j];num[j]=temp;
                t=ii;k=num.length-1;
                while(t<k){
            	    temp=num[t];
            	    num[t]=num[k];
            	    num[k]=temp;
            	    t++;k--;
                }
                return;
            }
        	if(i==0){
        		Arrays.sort(num);
        		return;
        	}
        }
    }
}
