package leetcode;


public class Remove_Duplicates_from_Sorted_List {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null)
        	return head;
        int key=head.val;
        ListNode pre=head;
        ListNode cur=head.next;
        while(cur!=null){
        	if(key==cur.val){
        		pre.next=cur.next;
        	}
        	else{
        		key=cur.val;
        		pre=cur;
        	}
        	cur=cur.next;
        }
        return head;
    }
}
