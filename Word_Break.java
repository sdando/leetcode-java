package leetcode;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import test.JunitTest;

public class Word_Break {
	
	@Test
	public void test(){
		String s="bb";
		HashSet<String> set=new HashSet<String>();
		set.add("a");
		set.add("b");
		set.add("bbb");
		set.add("bbbb");
		JunitTest.Print(wordBreak(s, set)+"");
	}
	
	int[][] f;
    public boolean wordBreak(String s, Set<String> dict) {
        int len=s.length();
        f=new int[len][len];
        return wordBreak(s, dict,0,len-1);
    }
    //f[i][j] represents if string from i to j can break
    public boolean wordBreak(String s,Set<String> dict,int i,int j){
    	if(f[i][j]==1) return true;
    	if(f[i][j]==-1) return false;
    	String sub=s.substring(i,j+1);
    	if(dict.contains(sub)){
    		f[i][j]=1;
    		return true;
    	}
    	for(int k=i;k<j;k++){
    		if(wordBreak(s,dict,i,k)&&
    		    wordBreak(s,dict,k+1,j)){
    			f[i][j]=1;
    			return true;
    		}
    	}
    	f[i][j]=-1;
    	return false;
    }
}
