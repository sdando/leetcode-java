package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class Anagrams extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
		ArrayList<String> ret=anagrams(new String[]{"abc","bac","abd","bad"});
		return;

	}
	
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> ret=new ArrayList<String>();
        if(strs==null||strs.length==0) return ret;
        HashMap<String, ArrayList<String>> rIndex=new HashMap<String, ArrayList<String>>();
        for(String str:strs){
        	char[] ch=str.toCharArray();
            Arrays.sort(ch);
            String key=new String(ch);
            if(rIndex.containsKey(key)){
                rIndex.get(key).add(str);
            }
            else {
            	ArrayList<String> one=new ArrayList<String>();
            	one.add(str);
				rIndex.put(key, one);
			}
        }
        for(Entry<String, ArrayList<String>> entry:rIndex.entrySet()){
        	if(entry.getValue().size()>1){
        		ret.addAll(entry.getValue());
        	}
        }
        return ret;
    }
}
