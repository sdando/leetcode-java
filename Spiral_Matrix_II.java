package leetcode;


import org.junit.Test;


public class Spiral_Matrix_II {
	@Test
	public void test(){
		int[][] ret=generateMatrix(4);
		return;
	}
    public int[][] generateMatrix(int n) {
        int[][] ret=new int[n][n];
        if(n==0)
        	return ret;
        int baser=0;
        int basec=0;
        int i,count=1;
        for(int level=n;level>0;level-=2){
        	if(level==1){
        		ret[baser][basec]=count;
        		continue;
        	}
        	for(i=0;i<level-1;i++)
        		ret[baser][basec+i]=count++;
        	for(i=0;i<level-1;i++)
        		ret[baser+i][basec+level-1]=count++;
        	for(i=level-1;i>0;i--)
        		ret[baser+level-1][basec+i]=count++;
        	for(i=level-1;i>0;i--)
        		ret[baser+i][basec]=count++;
            baser++;
            basec++;
        }
        return ret;
    }
}
