package leetcode;

public class Container_With_Most_Water {
    public int maxArea(int[] height) {
        if(height.length<2)
        	return 0;
        int i=0;
        int j=height.length-1;
        int area,max=Integer.MIN_VALUE;
        while(i<j){
        	//height[i]Сʱ������i��j(j���������ƶ�)��������Ϊheight[i]*(j-i)
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
