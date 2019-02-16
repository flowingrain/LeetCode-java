package LeetCode;

public class L647_PalindromicSubstrings {
    /*public boolean isPalindromic(String s){//字符串是否为回文串
        if(s.length()==1)
            return true;
        int len=s.length();
        for(int i=0;i<len/2;i++)
        {
            if(s.charAt(i)!=s.charAt(len-1-i))
                return false;
        }
        return true;
    }
    public int countOfAnEnd(String s,int index){//以下标为index的字符结尾的回文子串的数目
        int result=0;//下标为index的字符本身构成回文串
        for(int j=index;j>=0;j--){
            if (isPalindromic(s.substring(j,index+1))){//substring取不到第二个参数所表示的字符
                //System.out.println(s.substring(j,index+1));
                result++;
            }
        }
        return result;
    }
    //求字符串中的回文子串数目
    public int countSubstrings(String s) {
        int num=0;
        for(int i=0;i<s.length();i++)
            num+=countOfAnEnd(s,i);
        return num;
    }*/
    //求字符串中的回文子串数目
    //private int  count;
    private int extendPalindrome(String s, int j, int k) {//以j、k为中心的回文串的最大长度
        int count=0;
        // loop until meet invalid match
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            //从对称中心向两边扩展回文串
            j--;
            k++;
            count++;
        }
        return count;
    }
    public int countSubstrings(String s) {
        int len = s.length();
        int odds=0,even=0,count=0;
        if (len < 2)
            return 1;
        for (int i = 0; i < len-1; i++) {
            odds+=extendPalindrome(s, i, i);  //假设最大回文串长度为奇数
            even+=extendPalindrome(s, i, i+1); //假设最大回文串长度为偶数
        }
        count=odds+1+even;//+1因为之前没有考虑最后一个字符作为对称中心的情况
        return count;
    }
    public static void main(String[] args){
        L647_PalindromicSubstrings l647=new L647_PalindromicSubstrings();
        String s="abc";
        //String s="aaa";
        //Input: "aaa"
        //Output: 6
        //Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
        System.out.println(l647.countSubstrings(s));
    }
}