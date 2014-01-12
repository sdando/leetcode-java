package leetcode;

import java.util.ArrayList;

import org.junit.Test;

public class Generate_Parentheses {
	
	@Test
	public void test(){
		ArrayList<String> retArrayList=generateParenthesis(3);
		return;
	}
	
	ArrayList<String> ret;
	int n;
    public ArrayList<String> generateParenthesis(int n) {
        ret=new ArrayList<String>();
        if(n==0)
        	return ret;
        this.n=n;
        doGenerate(1, 0, new StringBuilder("("));
        return ret;
    }
    private void doGenerate(int pareleft,int pareright,StringBuilder pare){
        if(pareright>pareleft)
        	return;
        if(pareleft==n&&pareright==n){
        	ret.add(new String(pare));
        	return;
        }
        if(pareleft<n){
        	pare.append("(");
        	doGenerate(++pareleft, pareright, pare);
        	pareleft--;
        	pare.deleteCharAt(pare.length()-1);
        }
        if(pareright<n){
        	pare.append(")");
        	doGenerate(pareleft, ++pareright, pare);
        	pareright--;
        	pare.deleteCharAt(pare.length()-1);
        }
    }
}
