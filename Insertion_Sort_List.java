package leetcode;

import org.junit.Test;

import test.JunitTest;


public class Insertion_Sort_List {
	
	@Test
	public void test(){
		ListNode l1=new ListNode(3);
		ListNode l2=new ListNode(4);
		ListNode l3=new ListNode(1);
		l1.next=l2;
		l2.next=l3;
		l3.next=null;
		ListNode head=new Insertion_Sort_List().insertionSortList(l1);
		ListNode p=head;
		while(p!=null){
			JunitTest.Print(p.val+"");
			p=p.next;
		}
		
	}
	
    public ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null){
        	return head;
        }
        ListNode preedH=new ListNode(0);
        preedH.next=head;
        //q is the inserted node and p is the cursor
        ListNode q=head.next;
        ListNode p,preedP;
        while(q!=null){
        	head.next=q.next;
        	preedP=preedH;
        	p=preedH.next;
        	while(p!=head&&p.val<=q.val){
        		preedP=p;
        		p=p.next;
        	}
        	if((p.val<=q.val)&&(head.val<=q.val)){
        		q.next=head.next;
        		head.next=q;
        		head=q;
        	}
        	else {
				q.next=p;
				preedP.next=q;
			}
        	q=head.next;
        }
        return preedH.next;
    }
}
