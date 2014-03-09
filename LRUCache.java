package leetcode;

import java.util.LinkedList;
import java.util.HashMap;

import junit.framework.Assert;

public class LRUCache extends TestCase{
	
	class Pair{
		int key;
		int value;
	}
	
	class CycleList{
        CycleList prev;
        Pair value;
        CycleList next;
	}
	HashMap<Integer, CycleList> cacheMap;
	CycleList head;
	int capacity;
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		LRUCache cache=new LRUCache();
		cache.set(1, 2);
		cache.set(3, 4);
		cache.get(1);
		cache.set(4, 5);
		Assert.assertEquals(-1, cache.get(3));
		
	}
	
    public LRUCache() {
        head=new CycleList();
        head.prev=head;
        head.next=head;
        cacheMap=new HashMap<Integer, CycleList>();
        this.capacity=2;
    }
    
    
    public int get(int key) {
        if(cacheMap.containsKey(key)){
        	CycleList pos=cacheMap.get(key);
        	pos.prev.next=pos.next;
        	pos.next.prev=pos.prev;
        	pos.prev=head.prev;
        	head.prev.next=pos;
        	pos.next=head;
        	head.prev=pos;
        	return pos.value.value;
        }
        else{
        	return -1;
        }
    }
    
    public void set(int key, int value) {
    	if(cacheMap.containsKey(key)){
        	CycleList pos=cacheMap.get(key);
        	pos.value.key=key;
        	pos.value.value=value;
        	pos.prev.next=pos.next;
        	pos.next.prev=pos.prev;
        	pos.prev=head.prev;
        	head.prev.next=pos;
        	pos.next=head;
        	head.prev=pos;
        	return;
    	}
    	if(cacheMap.size()>=capacity){
    		cacheMap.remove(head.next.value.key);
    		head.next.next.prev=head;
    		head.next=head.next.next;
    	}
        CycleList node=new CycleList();
        node.value=new Pair();
        node.value.key=key;
        node.value.value=value;
        head.prev.next=node;
        node.prev=head.prev;
        node.next=head;
        head.prev=node;
        cacheMap.put(key, node);
    }
}
