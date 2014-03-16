package leetcode;

import java.util.Arrays;

public class Valid_Sudoku extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub

	}
	
    public boolean isValidSudoku(char[][] board) {
        boolean[] used=new boolean[9];
        int i,j;
        for(i=0;i<9;i++){
        	Arrays.fill(used, false);
        	for(j=0;j<9;j++)
        		if(!check(board[i][j], used)) return false;
        	Arrays.fill(used, false);
        	for(j=0;j<9;j++)
        		if(!check(board[j][i], used)) return false;
        }
        for(int row=0;row<3;row++)
        	for(int col=0;col<3;col++){
        		Arrays.fill(used, false);
        		for(i=3*row;i<3*row+3;i++)
        			for(j=3*col;j<3*col+3;j++)
        				if(!check(board[i][j], used)) return false;
        	}
        return true;
    }
    
    boolean check(char ch, boolean[] used){
    	if(ch=='.') return true;
    	if(used[ch-'1']) return false;
    	used[ch-'1']=true;
    	return true;
    }
}
