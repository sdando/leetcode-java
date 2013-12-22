package leetcode;

import java.util.ArrayList;

import org.junit.Test;

import test.JunitTest;

public class Pascals_Triangle {
	
	@Test
	public void test(){
		JunitTest.Print(new Pascals_Triangle().generate(3)+"");
	}
	
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> array2D=new ArrayList<ArrayList<Integer>>();
        if(numRows==0)
        	return array2D;
        ArrayList<Integer> array=new ArrayList<Integer>();
        array.add(1);
        array2D.add(array);
        if(numRows==1)
        	return array2D;
        array=new ArrayList<Integer>();
        array.add(1);
        array.add(1);
        array2D.add(array);
        if(numRows==2)
        	return array2D;
        for(int i=3;i<=numRows;i++){
        	array=new ArrayList<Integer>();
        	array.add(1);
        	for(int j=2;j<i;j++){
        		array.add(array2D.get(i-2).get(j-2)+array2D.get(i-2).get(j-1));
        	}
        	array.add(1);
        	array2D.add(array);
        }
        return array2D;
    }
}
