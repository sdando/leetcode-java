package leetcode;

import org.junit.Test;

public class Remove_Nth_Node_From_End_of_List {
	
	@Test
	public void test(){	
	}
	
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preHead=new ListNode(0);
        preHead.next=head;
        ListNode pre=preHead;
        ListNode cur1=head;
        ListNode cur2=head;
        for(int i=0;i<n-1;i++)
        	cur1=cur1.next;
        while(cur1.next!=null){
        	cur1=cur1.next;
        	cur2=cur2.next;
        	pre=pre.next;
        }
        pre.next=cur2.next;
        return preHead.next;
    }
}
