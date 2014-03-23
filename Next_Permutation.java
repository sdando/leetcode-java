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
 * �ڵ�ǰ�����У���β����ǰѰ����������Ԫ�أ�ǰһ����Ϊ*i����һ����Ϊ*ii����������*i < *ii��
 * Ȼ���ٴ�β��Ѱ����һ��Ԫ��*j���������*i < *j��������i��Ԫ�����j��Ԫ�ضԵ���
 * ������ii��Ԫ��֮�󣨰���ii��������Ԫ�صߵ����򣬼������һ�������ˡ�
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
