package leetcode;

import java.util.ArrayList;

import test.JunitTest;

public class LRUCache {
	
	public static void main(String[] args){
		LRUCache lruCache=new LRUCache(1);
		lruCache.set(2, 1);
		JunitTest.Print(lruCache.get(2)+"");
	}
    
	ArrayList<Integer> cacheKey;
	ArrayList<Integer> cacheValue;
	int capacity;
	
    public LRUCache(int capacity) {
        cacheKey=new ArrayList<Integer>(capacity);
        cacheValue=new ArrayList<Integer>(capacity);
        this.capacity=capacity;
    }
    
    private void 
    public int get(int key) {
    	int index=cacheKey.indexOf(key);
        if(index==-1){
        	return -1;
        }
        int size=cacheKey.size();
        

    }
    
    public void set(int key, int value) {
    	if(cache.contains(key)){
        	cache.remove(new Integer(key));
        	cache.addLast(key);
        	cacheMap.put(key, value);
        	return;
    	}
    	if(cache.size()>=capacity){
    		cache.removeFirst();
    		cacheMap.remove(key);
    	}
    	cache.addLast(key);
        cacheMap.put(key, value);
    }
}
