package leetcode;

import java.util.ArrayList;

import org.junit.Test;

public class Spiral_Matrix {
	
	@Test
	public void test(){
		ArrayList<Integer> retArrayList=spiralOrder(new int[][]{});
		return;
	}
	
	private int[][] matrix;
	private ArrayList<Integer> ret;
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ret=new ArrayList<Integer>();
        if(matrix==null)
        	return ret;
        this.matrix=matrix;
        int row=matrix.length;
        if(row==0)
        	return ret;
        int col=matrix[0].length;
        if(col==0)
        	return ret;
        flatten(0, 0, row, col);
        return ret;
    }
    
    private void flatten(int baser,int basec,int row,int col){
    	int i;
    	if(row<=0||col<=0)
    		return;
    	else if(row==1&&col==1){
    		ret.add(matrix[baser][basec]);
    	}
    	else if(row==1){
    		for(i=0;i<col;i++)
    			ret.add(matrix[baser][basec+i]);
    	}
    	else if(col==1){
    		for(i=0;i<row;i++)
    			ret.add(matrix[baser+i][basec]);
    	}
    	else {
    		for(i=0;i<col-1;i++)
    			ret.add(matrix[baser][basec+i]);
    		for(i=0;i<row-1;i++)
    			ret.add(matrix[baser+i][basec+col-1]);
    		for(i=col-1;i>0;i--)
    			ret.add(matrix[baser+row-1][basec+i]);
    		for(i=row-1;i>0;i--)
    			ret.add(matrix[baser+i][basec]);
    		row-=2;
    		col-=2;
    		flatten(++baser, ++basec, row, col);
		}
    }
}
