package leetcode;

public class Sort_Colors {
    public void sortColors(int[] A) {
        if(A.length<2)
        	return;
        //i指向red的最后一个元素，j指向blue的第一个元素
        int t,i=0;
        int j=A.length-1;
        int cur=i;
        while(cur<=j){
        	if(A[cur]==0){
        		if(cur>i){
        			t=A[cur];
        			A[cur]=A[i];
        			A[i++]=t;
        		}
        		else {
					i++;
					cur++;
				}
        	}
        	else if(A[cur]==2){
        		if(cur<j){
        			t=A[cur];
        			A[cur]=A[j];
        			A[j--]=t;
        		}
        		else {
                    break;
				}
        	}
        	else {
				cur++;
			}
        }
        return;
    }
}
