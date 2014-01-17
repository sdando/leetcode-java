package leetcode;

public class Container_With_Most_Water {
    public int maxArea(int[] height) {
        if(height.length<2)
        	return 0;
        int i=0;
        int j=height.length-1;
        int area,max=Integer.MIN_VALUE;
        while(i<j){
        	//height[i]小时，经过i，j(j可以任意移动)的最大面积为height[i]*(j-i)
        	if(height[i]<height[j]){
        		area=height[i]*(j-i);
        		i++;
        	}
        	else{
        		area=height[j]*(j-i);
        		j--;
        	}
        	if(area>max)
        		max=area;
        }
        return max;
    }
}
