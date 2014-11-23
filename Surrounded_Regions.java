package leetcode;

import java.util.LinkedList;

public class Surrounded_Regions extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
    char[][] board = {{'X','X','X'},{'X','O','X'},{'X','O','X'}};
    solve(board);
    return;
	}
	//将问题转化为求与边界上为O的点相邻的那些点
  public void solve(char[][] board) {
    if(board == null || board.length == 0 || board[0].length == 0)
    	return;
    int row = board.length;
    int col = board[0].length;
    for(int i = 0; i < col; i++){
    	bfs(board, 0, i);
    	bfs(board, row-1, i);
    }
    for(int i = 1; i < row - 1; i++){
    	bfs(board, i, 0);
    	bfs(board, i, col-1);
    }
    for(int i = 0; i < row; i++){
    	for(int j = 0; j < col; j++){
    	  if(board[i][j] == 'O')
    	  	board[i][j] = 'X';
    	  if(board[i][j] == '+')
    	  	board[i][j] = 'O';
    	}
    }
    return;
  }
  int[][] stepArr = {{-1,0},{0,-1},{1,0},{0,1}};
  private void bfs(char[][] board, int i, int j){
  	LinkedList<Integer> queue = new LinkedList<Integer>();
  	int length = board[0].length;
  	if(visit(board, i, j))
  		queue.add(i*length+j);
  	while(!queue.isEmpty()){
  		int n = queue.pollFirst();
  		int row = n / length;
  		int col = n % length;
  		for(int k =0; k < 4; k++){
  			if(visit(board, row+stepArr[k][0], col+stepArr[k][1]))
  				queue.add((row+stepArr[k][0])*length+col+stepArr[k][1]);
  		}
  	}
  }
  
  private boolean visit(char[][] board, int i, int j){
  	int row = board.length;
  	int col = board[0].length;
  	if(i < 0 || i >= row || j < 0 || j >= col || board[i][j] != 'O')
  		return false;
  	board[i][j] = '+';
  	return true;
  }
}
