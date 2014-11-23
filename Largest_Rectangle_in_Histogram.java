package leetcode;

import java.util.Stack;

import junit.framework.Assert;

public class Largest_Rectangle_in_Histogram extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
       Assert.assertEquals(12, largestRectangleArea(new int[]{5,5,1,7,1,1,5,2,7,6}));
	}
	//ʵ�����󾭹�ÿ�����ε�������
	//heigthStack��������ĳ������У����ڵ����ĳ������У����������ɴ����Ҷ�����ȡ
    public int largestRectangleArea(int[] height) {
        if(height==null||height.length==0) return 0;
        if(height.length<2) return height[0];
        Stack<Integer> indexStack=new Stack<Integer>();
        Stack<Integer> heightStack=new Stack<Integer>();
        int max=height[0];
        int h,t,lastIndex=0;
        
        indexStack.push(0);
        heightStack.push(height[0]);
        
        for(int i=1;i<height.length;i++){
        	if(heightStack.isEmpty()||height[i]>=heightStack.peek()){
        		indexStack.push(i);
        		heightStack.push(height[i]);
        	}
        	else {
				while(!heightStack.isEmpty()&&heightStack.peek()>height[i]){
					lastIndex=indexStack.pop();
					h=heightStack.pop();
					t=i-lastIndex;
					max=Math.max(max, t*h);
				}
				//�����ĸ߶ȶ���heigtht[i]������ӦΪlastIndex
				indexStack.push(lastIndex);
				heightStack.push(height[i]);
			}
        }
        
        while(!heightStack.isEmpty()){
        	lastIndex=indexStack.pop();
        	h=heightStack.pop();
        	max=Math.max(max, h*(height.length-lastIndex));
        }
        return max;
    }
}
