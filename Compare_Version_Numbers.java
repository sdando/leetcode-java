package leetcode;

/**
 * @author zx <527668258@qq.com>
 * @version 1.0.0 <2014/12/20>
 * @since JDK 1.6.0
 */
public class Compare_Version_Numbers extends TestCase {
    @Override
    public void test() {
        junit.framework.TestCase.assertEquals(1, compareVersion("1.2.3", "1.2"));
        junit.framework.TestCase.assertEquals(0, compareVersion("01", "1"));
        junit.framework.TestCase.assertEquals(0, compareVersion("1.0", "1"));
    }

    public int compareVersion(String version1, String version2) {
        String[][] tokens = new String[2][];
        tokens[0] = version1.split("\\.");
        tokens[1] = version2.split("\\.");
        int len1 = tokens[0].length;
        int len2 = tokens[1].length;
        int len = len1 < len2 ? len1:len2;
        int max = len1 > len2 ? len1:len2;
        int maxIndex = len1 > len2 ? 0:1;
        int result = len1 > len2 ? 1:-1;
        for(int i = 0; i < len; i++) {
            long v1 = Long.parseLong(tokens[0][i]);
            long v2 = Long.parseLong(tokens[1][i]);
            if(v1 != v2) {
                return v1 > v2 ? 1:-1;
            }
        }
        if(len == max) {
            return 0;
        }
        for(int j = len; j < max; j++) {
            long n = Long.parseLong(tokens[maxIndex][j]);
            if(n != 0) {
                return result;
            }
        }
        return 0;
    }

}
