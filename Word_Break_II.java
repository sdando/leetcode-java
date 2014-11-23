package leetcode;

import java.util.*;

public class Word_Break_II extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
    String s="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
    String[] ss = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
    HashSet<String> set = new HashSet<String>();
    for(String one: ss){
    	set.add(one);
    }
    List<String> resultList = wordBreak(s, set);
    for(String one: resultList){
    	System.out.println(one);
    }
	}
	
  public List<String> wordBreak(String s, Set<String> dict) {
    int len = s.length();
    //f[i]代表[0,i)是否可由字典中词的表示
    int[] f=new int[len+1];
    //p[i][j]代表[j,i)是否为词典中的词
    int[][] p=new int[len+1][len];
    f[0]=1;
    for(int i = 1; i <= len; i++){
    	for(int j = 0; j < i; j++){
    		if(f[j]==1&&dict.contains(s.substring(j,i))){
    			f[i]=1;
    			p[i][j]=1; 			
    		}
    	}
    }
    ArrayList<String> path = new ArrayList<String>();
    ArrayList<String> result = new ArrayList<String>();
    dfs(s, len, p, path, result);
    return result;
  }

  private void dfs(String s,int cur,int[][] p,ArrayList<String> path,
  		ArrayList<String> result) {
  	if(cur == 0){
  		StringBuilder sb = new StringBuilder();
  		for(int i = path.size()-1; i>=0; i--){
  			sb.append(path.get(i));
  			sb.append(" ");
  		}
  		result.add(sb.substring(0,sb.length()-1));
  		return;
  	}
    for(int i = 0; i < s.length(); i++){
    	if(p[cur][i]==1){
    		path.add(s.substring(i,cur));
    		dfs(s, i, p, path, result);
    		path.remove(path.size()-1);
    	}
    }
  }
}
