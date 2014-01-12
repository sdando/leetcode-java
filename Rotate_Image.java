package leetcode;

import org.junit.Test;

public class Rotate_Image {
	
	@Test
	public void test(){
		int[][] matrix=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		rotate(matrix);
		return;
	}
    public void rotate(int[][] matrix) {
        if(matrix.length==1)
        	return;
        int row=matrix.length;
        int baser=0;
        int basec=0;
        int temp;
        for(int level=row;level>=2;level-=2){
        	for(int i=0;i<level-1;i++){
        		temp=matrix[baser][basec+i];
        		matrix[baser][basec+i]=matrix[baser+level-1-i][basec];
        		matrix[baser+level-1-i][basec]=matrix[baser+level-1][basec+level-1-i];
        		matrix[baser+level-1][basec+level-1-i]=matrix[baser+i][basec+level-1];
        		matrix[baser+i][basec+level-1]=temp;
        	}
        	basec++;
        	baser++;
        }
        return;
    }
}
