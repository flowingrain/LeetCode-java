package LeetCode;

public class L5_LongestPalindromicSubstring {
   /* public String longestPalindrome(String s) {//Manacher算法
        // Insert '#'
        if(s.length()<=1)
            return s;
        String t = "$#";
        for (int i = 0; i < s.length(); i++) {
            t += s.charAt(i);
            t += "#";
        }
        // Process t
        int[] p=new int[t.length()];//p[i]保存以i为中心的最长回文串的长度
        int mx = 0, id = 0, resLen = 0, resCenter = 0;
        //id为能延伸到最右端的位置的那个回文子串的中心点位置，
        // mx是回文串能延伸到的最右端的位置
        for (int i = 0; i < t.length(); i++) {
            p[i] = mx > i ? Math.min(p[2 * id - i], mx - i) : 1;
            while (i - p[i]>=0&&i + p[i]<t.length()&&t.charAt(i + p[i]) == t.charAt(i - p[i]))//i的左右两侧对称，注意边界条件
                p[i]++;
            if (mx < i + p[i]) {
                mx = i + p[i];
                id = i;
            }
            if (resLen < p[i]) {//resLen为最大回文串的长度.
                resLen = p[i];
                resCenter = i;//最大回文串的中心
            }
        }
        //return s.substring((resCenter - resLen) / 2, resLen - 1);//resLen-1是原串中最长回文子串的长度，不是最右端下标
        return s.substring((resCenter - resLen) / 2, (resCenter +resLen) /2-1);
    }*/
    private int lo, maxLen;
    private void extendPalindrome(String s, int j, int k) {//以j、k为中心的回文串的最大长度
        // loop until meet invalid match
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            //从对称中心向两边扩展回文串
            j--;
            k++;
        }
        if (maxLen < k - j -1) {//正常理解下，maxLen长度k-j+1，但跳出循环时的s.charAt(j) != s.charAt(k),k多加了1次，j多减了1次。maxLen=(k-j+1)-2
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;
        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //假设最大回文串长度为奇数
            extendPalindrome(s, i, i+1); //假设最大回文串长度为偶数
        }
        return s.substring(lo, lo + maxLen);//maxLen为字符串实际长度，作为subString第二个参数不包含在子串中
    }

    public static void main(String[] args){
        L5_LongestPalindromicSubstring l5=new L5_LongestPalindromicSubstring();
        //String s="babad";
        String s="abcdbbfcba";
        System.out.println(l5.longestPalindrome(s));
    }
}