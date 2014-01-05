package leetcode;

public class Remove_Duplicates_from_Sorted_List_II {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null)
        	return head;
        ListNode preHead=new ListNode(0);
        preHead.next=head;
        ListNode pre=preHead;
        ListNode begin=head;
        ListNode end=begin;
        while(end!=null){
        	while(end.next!=null){
        		if(end.next.val!=begin.val)
        			break;
        		end=end.next;
        	}
        	if(begin==end){
        		pre.next=begin;
        		pre=begin;
        	}
    		begin=end=end.next;
        }
        pre.next=null;
        return preHead.next;
    }
}
