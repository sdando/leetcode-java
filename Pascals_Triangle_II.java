package leetcode;

import java.util.ArrayList;

import org.junit.Test;

public class Pascals_Triangle_II {
	
	@Test
	public void test(){
		getRow(1);
	}
	
    public ArrayList<Integer> getRow(int rowIndex) {
    	ArrayList<Integer> ret=new ArrayList<Integer>();
    	ret.add(1);
    	if(rowIndex==0)
    		return ret;
    	//temp1：前一个位置计算前的值
    	int temp1,temp2,i,j=0;
    	ret.add(0);
    	for(i=1;i<=rowIndex;i++){
    		temp1=ret.get(0);
    		for(j=1;j<=i;j++){
    			temp2=ret.get(j);
    			ret.set(j, ret.get(j)+temp1);
    			temp1=temp2;
    		}
    		ret.add(j, 0);
    	}
    	ret.remove(j);
    	return ret;
    }
}
