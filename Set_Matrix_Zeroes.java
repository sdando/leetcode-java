package leetcode;

public class Set_Matrix_Zeroes {
    public void setZeroes(int[][] matrix) {
        int zeror=0;
        int zeroc=0;
        int row=matrix.length;
        int col=matrix[0].length;
        int i,j;
        //find if first row and first column has zero, 
        //we can use this two special to record matrix rows and columns have zero. 
        for(i=0;i<col;i++)
        	if(matrix[0][i]==0){
        		zeror=1;
        		break;
        	}
        for(j=0;j<row;j++)
        	if(matrix[j][0]==0){
        		zeroc=1;
        		break;
        	}
        //find other rows and columns have zero.
        for(i=1;i<row;i++)
        	for(j=1;j<col;j++){
        		if(matrix[i][j]==0){
        			matrix[0][j]=0;
        			matrix[i][0]=0;
        		}
        	}
        //set rows and columns have zero
        for(i=1;i<row;i++)
        	for(j=1;j<col;j++){
        		if(matrix[0][j]==0||matrix[i][0]==0)
        			matrix[i][j]=0;
        	}
        //set first row and first column
        if(zeror==1){
            for(i=0;i<col;i++)
            	matrix[0][i]=0;
        }
        if(zeroc==1){
            for(j=0;j<row;j++)
            	matrix[j][0]=0;
        }
        return;
    }
}
