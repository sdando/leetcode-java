package leetcode;

import java.util.Arrays;

import org.junit.Test;

import test.JunitTest;

class Node implements Comparable<Node>{
	public int number;
	public int position;
	
	public Node(int number,int position){
		this.number=number;
		this.position=position;
	}
	
	public int compareTo(Node o) {
		if(this.number<o.number)
			return -1;
		else if(this.number==o.number)
		    return 0;
		else
			return 1;
	}
}

public class Two_Sum {
	@Test
	public void test(){
		int[] result=new Two_Sum().twoSum(new int[]{0,4,3,0}, 0);
		for(int i:result){
			JunitTest.Print(i+"");
		}
	}
	
    public int[] twoSum(int[] numbers, int target) {
    	int[] index=new int[2];
        Node[] nodes=new Node[numbers.length];
        for(int i=0;i<numbers.length;i++){
        	nodes[i]=new Node(numbers[i],i+1);
        }
        Arrays.sort(nodes);
        int i,j,sum;
        for(i=0,j=nodes.length-1;i<j;){
        	sum=nodes[i].number+nodes[j].number;
        	if(sum>target)
        		j--;
        	else if(sum<target)
        		i++;
        	else{
        		if(nodes[i].position>nodes[j].position){
        			index[0]=nodes[j].position;
        			index[1]=nodes[i].position;
        		}
        		else {
        			index[0]=nodes[i].position;
        			index[1]=nodes[j].position;
				}
        		break;
        	}
        }
        return index;
    }	
    
}
