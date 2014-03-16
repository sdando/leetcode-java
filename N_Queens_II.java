package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class N_Queens_II extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
		totalNQueens(1);

	}
	
	int[] CFlg;
	int[] DiagFlg;
	int[] MDiagFlg;
	int count;
	
    public int totalNQueens(int n) {
        count=0;
        if(n<=0) return count;
        CFlg=new int[n];
        DiagFlg=new int[2*n];
        MDiagFlg=new int[2*n];
        int[] C=new int[n];
        dfs(0, C);
        return count;
    }
    
    private void dfs(int row,int[] C){
    	if(row==C.length){
            count++;
    		return;
    	}
    	boolean flg;
    	for(int j=0;j<C.length;j++){
    		flg=(CFlg[j]==0)&&(DiagFlg[row+j]==0)&&
    		  (MDiagFlg[row-j+C.length]==0);
    		if(flg==true){
    			C[row]=j;
    			DiagFlg[row+j]=MDiagFlg[row-j+C.length]=CFlg[j]=1;
    			dfs(row+1,C);
    			C[row]=0;
    			DiagFlg[row+j]=MDiagFlg[row-j+C.length]=CFlg[j]=0;
    		}
    	}
    }
}
