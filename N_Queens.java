package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class N_Queens extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
        ArrayList<String[]> ret=solveNQueens(8);
        return;
	}
	
	int[] CFlg;      //列是否安全
	int[] DiagFlg;   //主对角线
	int[] MDiagFlg;  //辅对角线
	
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> ret=new ArrayList<String[]>();
        if(n<=0) return ret;
        CFlg=new int[n];
        DiagFlg=new int[2*n];
        MDiagFlg=new int[2*n];
        int[] C=new int[n];
        dfs(0, C, ret);
        return ret;
    }
    
    private void dfs(int row,int[] C,ArrayList<String[]> ret){
    	if(row==C.length){
    		String[] one=new String[C.length];
    		for(int i=0;i<row;i++){
    			char[] oneR=new char[C.length];
    			Arrays.fill(oneR, '.');
    			oneR[C[i]]='Q';
    			one[i]=new String(oneR);
    		}
    		ret.add(one);
    		return;
    	}
    	boolean flg;
    	for(int j=0;j<C.length;j++){
    		flg=(CFlg[j]==0)&&(DiagFlg[row+j]==0)&&
    		  (MDiagFlg[row-j+C.length]==0);
    		if(flg==true){
    			C[row]=j;
    			DiagFlg[row+j]=MDiagFlg[row-j+C.length]=CFlg[j]=1;
    			dfs(row+1,C,ret);
    			C[row]=0;
    			DiagFlg[row+j]=MDiagFlg[row-j+C.length]=CFlg[j]=0;
    		}
    	}
    }
}
