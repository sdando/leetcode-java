package leetcode;

public class Word_Search extends TestCase{
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		boolean ret=exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},
				{'A','D','E','E'}},"ABCB");
		return;
	}
	private int length;
	private String word;
    public boolean exist(char[][] board, String word) {
    	int row=board.length;
    	int col=board[0].length;
    	length=word.length();
    	if(word.length()>row*col)
    		return false;
    	this.word=word;
    	for(int i=0;i<row;i++)
    		for(int j=0;j<col;j++)
    	        if(search(board, 0, i, j))
    	        	return true;
    	return false;   	    
    }
    
    private boolean search(char[][] board,int index,int row,int col){
    	if(index==length-1){
    		if(board[row][col]==word.charAt(index))
                return true;
    		else {
				return false;
			}
    	}
    	if(board[row][col]!=word.charAt(index))
    		return false;
    	char tmp=board[row][col];
    	board[row][col]='.';
        boolean r1=false,r2=false,r3=false,r4=false;
        //down
    	if(row<board.length-1&&board[row+1][col]!='.'){
    		r1=search(board, index+1, row+1, col);
    	}
    	//right
    	if(!r1&&col<board[0].length-1&&board[row][col+1]!='.'){
    		r2=search(board, index+1, row, col+1);
    	}
    	//up
    	if(!r1&&!r2&&row>0&&board[row-1][col]!='.'){
    		r3=search(board, index+1, row-1, col);
    	}
    	//left
    	if(!r1&&!r2&&!r3&&col>0&&board[row][col-1]!='.'){
    		r4=search(board, index+1, row, col-1);
    	}
    	board[row][col]=tmp;
    	return r1||r2||r3||r4;
    }
}
