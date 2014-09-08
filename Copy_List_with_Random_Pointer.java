package leetcode;

class RandomListNode {
	int label;
	RandomListNode next, random;
	RandomListNode(int x) { this.label = x; }
};

public class Copy_List_with_Random_Pointer extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub

	}
  //将新链表与原链表链成一链，然后在分割
  public RandomListNode copyRandomList(RandomListNode head) {
    RandomListNode newHead = null;
    if(head == null)
    	return newHead;
    for(RandomListNode cur = head; cur != null; ) {
    	RandomListNode node = new RandomListNode(cur.label);
    	node.next = cur.next;
    	cur.next = node;
    	cur = node.next;
    }
    for(RandomListNode cur = head; cur != null; ) {
    	if(cur.random != null) {
    		cur.next.random = cur.random.next;
    	}
  		cur = cur.next.next;
    }
    newHead = new RandomListNode(-1);
    for(RandomListNode cur = head, newCur = newHead; cur != null; ) {
    	newCur.next = cur.next;
    	newCur = newCur.next;
    	cur.next = cur.next.next;
    	cur = cur.next;
    }
    return newHead.next;
  } 
}
