package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Merge_k_Sorted_Lists extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    LinkedList<ListNode> list = new LinkedList<ListNode>();
    list.add(node1);
    list.add(node2);
    ListNode headnode = mergeKLists(list);
    while(headnode != null){
    	System.out.println(headnode.val);
    	headnode = headnode.next;
    }
	}
	
	public void heapAdjust(ListNode[] nodes, int size, int i){
		int left = 2 * i;
		int right = 2 * i + 1;
		int max = i;
		if(left <= size && nodes[left].val < nodes[max].val){
			max = left;
		}
		if(right <= size && nodes[right].val < nodes[max].val){
			max = right;
		}
		if(max != i){
			ListNode t = nodes[i];
			nodes[i] = nodes[max];
			nodes[max] = t;
			heapAdjust(nodes, size, max);
		}		
	}
	
	public void createHeap(ListNode[] nodes, int size){
		for(int i = size/2; i >= 1; i--){
			heapAdjust(nodes, size, i);
		}
	}
	
	public ListNode mergeKLists(List<ListNode> lists) {
		if(lists == null || lists.size() == 0)
			return null;
		int heapSize = lists.size();
		ListNode[] nodes = new ListNode[heapSize + 1];
		ListNode min, cur;
		int i = 0;
    for(ListNode node: lists){
    	if(node != null)
    		nodes[++i] = node;
    }
    heapSize = i;
    createHeap(nodes, heapSize);
    cur = min = new ListNode(0);
    while(heapSize != 0){
    	cur.next = nodes[1];
    	cur = cur.next;
    	if(nodes[1].next != null){
    		nodes[1] = nodes[1].next;
    	}
    	else{
    		nodes[1] = nodes[heapSize];
    		heapSize--;
    	}
    	heapAdjust(nodes, heapSize, 1);
    }
    return min.next;
  }
}
