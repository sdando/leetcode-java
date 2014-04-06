package leetcode;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.LinkedList;

import junit.framework.Assert;

public class Word_Ladder extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
		HashSet<String> dict=new HashSet<String>();
		String[] ssStrings={"hot","dot","dog","lot","log"};
		for(String s:ssStrings){
			dict.add(s);
		}
        Assert.assertEquals(5, ladderLength("hit", "cog", dict));
	}
	
    public int ladderLength(String start, String end, HashSet<String> dict) {
        if(start.isEmpty()||end.isEmpty()) return 0;
        if(dict.size()==0) return 0;
        String head;
        int distance=1;
        LinkedList<String> queuePop=new LinkedList<String>();
        LinkedList<String> queuePush=new LinkedList<String>();
        queuePop.add(start);
        while(!queuePop.isEmpty()){
        	while(!queuePop.isEmpty()){
        		head=queuePop.pollFirst();
        		char[] cArray=head.toCharArray();
                for(int i=0;i<head.length();i++){
                	for(char ch='a';ch<='z';ch++){
                		if(cArray[i]==ch) continue;
                		char t=cArray[i];
                        cArray[i]=ch;
                        String s=new String(cArray);
                        if(end.equals(s)){
                        	return distance+1;
                        }
                        if(dict.contains(s)){
                            queuePush.add(s);
                            dict.remove(s);
                        }
                        cArray[i]=t;
                	}
                }
        	}
        queuePop=new  LinkedList<String>(queuePush);
        queuePush.clear();
        distance++;
        }
        return 0;
    }
}
