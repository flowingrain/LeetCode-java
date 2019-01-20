package LeetCode;

import java.util.Arrays;

public class L242_ValidAnagram {
    /*public boolean isAnagram(String s, String t) {
        int[] charcount1=new int[26];//考虑大小写及特殊字符
        int[] charcount2=new int[26];

        for(int i=0;i<s.length();i++){
            charcount1[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t.length();i++){
            charcount2[t.charAt(i)-'a']++;
        }
*//*        for(int i=0;i<26;i++)
            System.out.print(charcount1[i]+"\t");
        System.out.println();
        for(int i=0;i<26;i++)
            System.out.print(charcount2[i]+"\t");*//*
        if(Arrays.equals(charcount1,charcount2))
            return true;
        else
            return false;
    }*/
    public boolean isAnagram(String s, String t) {
        char[] s1=s.toCharArray();//考虑大小写及特殊字符
        char[] s2=t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        if(Arrays.equals(s1,s2))
            return true;
        else
            return false;
    }
    public static void main(String[] args){
        String s="anagram";
        String t="nagaram";
        L242_ValidAnagram l242=new L242_ValidAnagram();
        System.out.println(l242.isAnagram(s,t));

    }

}