package leetcode;

import java.util.Arrays;

public class Max_Points_on_a_Line {
	
	class Point {
		int x;
		int y;
		Point() {
			x = 0;
			y = 0;
		}
		Point(int a, int b) {
			x = a;
			y = b;
		}
	}
	
	public class Solution {
	    public int maxPoints(Point[] points) {
	        boolean[] flag=new boolean[points.length];
	        Arrays.fill(flag, false);
	        
	    }
	    
	    double cos(Point p1,Point p2){
	    	double x1=p1.x;
	        double x2=p2.x;
	        double y1=p1.x;
	        double y2=p2.y;
	    	double ret=(x1*x2+y1*y2)/(Math.sqrt(x1*x1+y1*y1)*Math.sqrt(x2*x2+y2*y2));
	    	return ret;
	    }
	}
}
