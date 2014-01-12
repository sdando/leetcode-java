package leetcode;

import java.util.ArrayList;

import org.junit.Test;

public class Gray_Code {
	@Test
	public void test(){
		ArrayList<Integer> result=grayCode(4);
		return;
	}
	
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> ret=new ArrayList<Integer>((int)Math.pow(2,n));
        ret.add(0);
        if(n==0)
        	return ret;
        ret.add(1);
        for(int i=1;i<n;i++){
        	int end=(int)Math.pow(2, i);
        	for(int j=end;j<end*2;j++){
        		ret.add(ret.get((int)Math.pow(2, i+1)-j-1)|1<<i);
        	}
        }
        return ret;
    }
}
