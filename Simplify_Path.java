package leetcode;

import java.util.ArrayList;

import junit.framework.Assert;

public class Simplify_Path extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
		Assert.assertEquals(simplifyPath("/./aa/../bb/"), "/bb");
	}
	
  public String simplifyPath(String path) {
    ArrayList<String> ret = new ArrayList<String>();
    path += "/";
    for(int i = 0; i < path.length() - 1 ; ){
    	int j = path.indexOf("/", i+1);
    	String subPath = path.substring(i+1, j);
    	if(!subPath.isEmpty() && !subPath.equals(".")){
    		if(subPath.equals("..")){
    			if(!ret.isEmpty()){
    				ret.remove(ret.size()-1);
    			}
    		}
    		else {
					ret.add(subPath);
				}
    	}
    	i = j;
    }
    if(ret.isEmpty()){
    	return "/";
    }
    else {
			StringBuilder sb = new StringBuilder();
			for(String s: ret){
				sb.append("/");
				sb.append(s);
			}
			return sb.toString();
		}
  }
}
