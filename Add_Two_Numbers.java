package leetcode;

public class Add_Two_Numbers {
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null)
        	return null;
        ListNode head=new ListNode(0);
        ListNode node=head;
        int sum,adding=0;
        while(l1!=null&&l2!=null){
        	sum=l1.val+l2.val+adding;
        	adding=sum/10;
        	node.next=new ListNode(sum%10);
        	l1=l1.next;
        	l2=l2.next;
        	node=node.next;
        }
        while(l1!=null){
        	sum=l1.val+adding;
        	adding=sum/10;
        	node.next=new ListNode(sum%10);
        	l1=l1.next;
        	node=node.next;
        }
        while(l2!=null){
        	sum=l2.val+adding;
        	adding=sum/10;
        	node.next=new ListNode(sum%10);
        	l2=l2.next;
        	node=node.next;
        }
        if(l1==null&&l2==null&&adding!=0){
        	node.next=new ListNode(adding);
        	node=node.next;
        }
        node.next=null;
        return head.next;
    }
}
