package leetcode;

import java.util.Arrays;


public class Permutation_Sequence extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
        String ret=getPermutation(1, 1);
        return;
	}
	
    public String getPermutation(int n, int k) {
       String ret="";
       int level,i,count=0;
       int[] array=new int[n];
       boolean[] flag=new boolean[n+1];
       Arrays.fill(flag, false);
       array[0]=1;
       for(i=1;i<n;i++)
    	   array[i]=i*array[i-1];
       for(level=1;level<=n-1;level++){
           for(i=1;i<=n;i++){
        	   if(!flag[i]){
    	           count+=array[n-level];
    	           if(count>=k){
    	        	   count-=array[n-level];
    	        	   ret+=i;
    	        	   flag[i]=true;
    	        	   break;
    	           }
    	       }
           }
       }
       for(i=1;i<=n;i++)
    	   if(!flag[i])
    		   ret+=i;
       return ret;
    }
}
