package leetcode;

import java.util.ArrayList;

public class Triangle {

    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        //ret数组保存到某一行为止每个位置的最短路径和
        int size=triangle.size();
    	if(size==0)
        	return 0;
        int[] ret=new int[size];
        ret[0]=triangle.get(0).get(0);
        for(int i=1;i<size;i++){
        	for(int j=triangle.get(i).size()-1;j>=0;j--){
        		if(j==0)
        			ret[j]=ret[j]+triangle.get(i).get(j);
        		else if(j==triangle.get(i).size()-1)
        			ret[j]=ret[j-1]+triangle.get(i).get(j);
        		else 
        			ret[j]=Math.min(ret[j-1],ret[j])+triangle.get(i).get(j);
        	}
        }
        int min=Integer.MAX_VALUE;
        for(int k=0;k<size;k++){
        	if(min>ret[k])
        		min=ret[k];
        }
        return min;
    }
}
