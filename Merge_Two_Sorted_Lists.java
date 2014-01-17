package leetcode;

public class Merge_Two_Sorted_Lists extends TestCase{
	@Override
	public void test() {
		// TODO Auto-generated method stub
		ListNode l=new ListNode(1);
		l.next=null;
		ListNode m=new ListNode(2);
		m.next=null;
	    ListNode head=mergeTwoLists(l, m);
	    return;
	}
	
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode tmp;
        if(l1==null){
        	tmp=l2;
        	l2=l1;
        	l1=tmp;
        }
        ListNode head=new ListNode(0);
        head.next=l1;
        ListNode pre1=head;
        ListNode cur1=l1;
        ListNode cur2=l2;
        while(cur1!=null&&cur2!=null){
        	if(cur1.val>cur2.val){
        		tmp=cur2.next;
        		cur2.next=cur1;
        		pre1.next=cur2;
        		pre1=cur2;
        		cur2=tmp;
        	}
        	else{
        		pre1=pre1.next;
        	    cur1=cur1.next;
        	}
        }
        if(cur2!=null){
        	if(cur1!=null){
        	    cur1.next=cur2;
        	}
        	else {
        		pre1.next=cur2;
			}
        }
        return head.next;
    }
}
