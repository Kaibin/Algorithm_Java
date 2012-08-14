package algorithm.string;


/**
 * 给一个字符串s1,和一个小串s2，求算法能在s1中找到包含s2里所有字符的最小子串
 *
 */
public class MinSusString {

    /**
     * @param s1 document string 
     * @param s2 key string
     * 设置两个指针p1,p2，初始化指向s1串的开头。
     * 当p1, p2指针之间的s1子串字母包含s2全部字符时，p1++，
     * 当两个指针之间的子不完全包含s2中的全部字符时p2++（增加指针间距），
     * 与此同时记录合法包含子串的的最小串的起始位置。
     * 
     * 在进行上述伸缩时，如何快速的记录s2串的包含情况？使用一个hash 表，
     * 记录字符的出现次数，当p1++时，将对应字母的计数减1，当p2++时，将对应字母的计数加1。
     */
    public static int findMinSubString(String s1, String s2) {
        int hash_table[] = new int[256];
        
        /**
         * 初始化hash表，s2中出现的字符标记位0，其他标记为负数
         */
        for (int i=0;i<hash_table.length;i++) {
            hash_table[i] = -1;
        }
        for (int i=0;i<s2.length();i++) {
            hash_table[s2.charAt(i)] = 0;
        }
        
        int p1 = 0;
        int p2 = 0;
        
        //最短长度  
        int min_len = s1.length();
        
        //最小串的起止位置
        int min_p1 = 0;
        int min_p2 = 0;
        
        //记录p1 p2之间的合法字符总数，当count==s2_len时s1包含s2
        int count = 0;
        int s2_len = s2.length();
        
        while (p2 < s1.length()) {
            //[p1...p2]之间不包含s2
            if (count < s2_len) {
                //属于s2中出现的字符
                if (hash_table[s1.charAt(p2)] == 0) {
                    count++;//第一次出现
                    hash_table[s1.charAt(p2)] ++;
                } else if (hash_table[s1.charAt(p2)] > 0) {
                    hash_table[s1.charAt(p2)] ++;
                }
                p2++;
            }
            //此时s1包含s2
            if (count == s2_len) {
                if (p2-p1 < min_len) {
                    min_p1 = p1;
                    min_p2 = p2;
                    min_len = p2 - p1;
                }
                //收缩
                hash_table[s1.charAt(p1)]--;
                p1++;
                
                //0表示没出现过，count减1
                if (hash_table[s1.charAt(p1)] == 0) {
                    count--;
                }
            }
        }
        
        if (min_p1 < min_p2) {
            System.out.println(s1.substring(min_p1, min_p2));
        }
        
        return min_len;
        
    }
    
    public static void main(String[] args) {
        String s1 = "ADOBECODEBANC";
        String s2 = "ABC";
        findMinSubString(s1, s2);
    }
}
