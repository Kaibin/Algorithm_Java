package algorithm.string;


/**
 * ��һ���ַ���s1,��һ��С��s2�����㷨����s1���ҵ�����s2�������ַ�����С�Ӵ�
 *
 */
public class MinSusString {

    /**
     * @param s1 document string 
     * @param s2 key string
     * ��������ָ��p1,p2����ʼ��ָ��s1���Ŀ�ͷ��
     * ��p1, p2ָ��֮���s1�Ӵ���ĸ����s2ȫ���ַ�ʱ��p1++��
     * ������ָ��֮����Ӳ���ȫ����s2�е�ȫ���ַ�ʱp2++������ָ���ࣩ��
     * ���ͬʱ��¼�Ϸ������Ӵ��ĵ���С������ʼλ�á�
     * 
     * �ڽ�����������ʱ����ο��ٵļ�¼s2���İ��������ʹ��һ��hash ��
     * ��¼�ַ��ĳ��ִ�������p1++ʱ������Ӧ��ĸ�ļ�����1����p2++ʱ������Ӧ��ĸ�ļ�����1��
     */
    public static int findMinSubString(String s1, String s2) {
        int hash_table[] = new int[256];
        
        /**
         * ��ʼ��hash��s2�г��ֵ��ַ����λ0���������Ϊ����
         */
        for (int i=0;i<hash_table.length;i++) {
            hash_table[i] = -1;
        }
        for (int i=0;i<s2.length();i++) {
            hash_table[s2.charAt(i)] = 0;
        }
        
        int p1 = 0;
        int p2 = 0;
        
        //��̳���  
        int min_len = s1.length();
        
        //��С������ֹλ��
        int min_p1 = 0;
        int min_p2 = 0;
        
        //��¼p1 p2֮��ĺϷ��ַ���������count==s2_lenʱs1����s2
        int count = 0;
        int s2_len = s2.length();
        
        while (p2 < s1.length()) {
            //[p1...p2]֮�䲻����s2
            if (count < s2_len) {
                //����s2�г��ֵ��ַ�
                if (hash_table[s1.charAt(p2)] == 0) {
                    count++;//��һ�γ���
                    hash_table[s1.charAt(p2)] ++;
                } else if (hash_table[s1.charAt(p2)] > 0) {
                    hash_table[s1.charAt(p2)] ++;
                }
                p2++;
            }
            //��ʱs1����s2
            if (count == s2_len) {
                if (p2-p1 < min_len) {
                    min_p1 = p1;
                    min_p2 = p2;
                    min_len = p2 - p1;
                }
                //����
                hash_table[s1.charAt(p1)]--;
                p1++;
                
                //0��ʾû���ֹ���count��1
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
