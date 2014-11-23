package leetcode;

import java.util.Stack;

import junit.framework.Assert;

public class Min_Stack extends TestCase {

	Stack<Integer> value;
	Stack<Integer> index;
	int top;
	@Override
	public void test() {
		// TODO Auto-generated method stub
		//push(2147483646),push(2147483646),push(2147483647),top,pop,getMin,pop,getMin,pop,push(2147483647),top,getMin,push(-2147483648),top,getMin,pop,getMin
    Min_Stack min_Stack = new Min_Stack();
    min_Stack.push(2);
    min_Stack.push(1);
    min_Stack.push(0);
    min_Stack.push(3);
    Assert.assertEquals(0, min_Stack.getMin());
    min_Stack.pop();
    min_Stack.pop();
    Assert.assertEquals(1, min_Stack.getMin());   
	}
	
	public Min_Stack() {
		// TODO Auto-generated constructor stub
		value = new Stack<Integer>();
		index = new Stack<Integer>();
		top = -1;
	}
		
  public void push(int x) {
    value.push(x);
    top++;
    if(top!=0){
    	int topValue = value.get(index.peek());
    	if(topValue > x){
    		index.push(top);
    	}else{
    		index.push(index.peek());
    	}
    }
    else {
			index.push(top);
		}
  }

  public void pop() {
  	  top--;
      value.pop();
      index.pop();
  }

  public int top() {
      return value.peek();
  }

  public int getMin() {
      return value.get(index.peek());
  }

}
