package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Substring_with_Concatenation_of_All_Words extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
    String s = "barfoothefoobarman";
    String[] L = new String[]{"foo", "bar"};
    List<Integer> resutlt = findSubstring(s, L);
    System.out.println(resutlt);
	}

	public List<Integer> findSubstring(String S, String[] L) {
		int len = L[0].length();
		int sLen = S.length();
		int sumOfLen = len * L.length;
		List<Integer> result = new ArrayList<Integer>();
		if (sLen < sumOfLen)
			return result;
		Map<String, Integer> wordCount = new HashMap<String, Integer>();
		for (String s : L) {
			if (wordCount.containsKey(s)) {
				wordCount.put(s, wordCount.get(s) + 1);
			} else {
				wordCount.put(s, 1);
			}
		}
		for (int i = 0; i <= sLen - sumOfLen; i++) {
			Map<String, Integer> unUsed = new HashMap<String, Integer>(wordCount);
			for(int j = i; j< i + sumOfLen; j += len) {
				String sub = S.substring(j, j + len);
				if(!unUsed.containsKey(sub)) 
					break;
				int count = unUsed.get(sub)-1;
				if(count==0) {
					unUsed.remove(sub);
				}else{
					unUsed.put(sub, count);
				}
			}
			if(unUsed.size() == 0)
				result.add(i);
		}
		return result;
	}

}
