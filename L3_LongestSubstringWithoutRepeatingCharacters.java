package LeetCode;

import java.util.HashSet;

public class L3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashSet hs=new HashSet();
        int maxlen=0,count=0;
        for(int i=0;i<s.length();i++){
            if(!hs.contains(s.charAt(i)))
            {
                hs.add(s.charAt(i));
                count++;
                if(count>maxlen)
                    maxlen=count;
            }
            else{
                //找到重复字符在子串中的位置，在整个字符串中的位置
                int pos=s.substring(i-count,i).indexOf(s.charAt(i));
                //System.out.println("i:\t"+i+";\n"+"count:\t"+count+";\n"+"pos:\t"+pos+";\n");
                String temp=s.substring(i-count,i-count+pos);//substring不包括endindex
                for (int j=0;j<temp.length();j++)
                    hs.remove(temp.charAt(j));//从哈希表中去掉重复字符之前的字符
                count=count-pos;
            }
        }
        return maxlen;
    }

    public static void main(String[] args){
        //String s="tmmzuxt";
        String s="abcabcbb";
        //String s="pwwt";
        L3_LongestSubstringWithoutRepeatingCharacters l3=new L3_LongestSubstringWithoutRepeatingCharacters();
        System.out.println(l3.lengthOfLongestSubstring(s));
    }
}