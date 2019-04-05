package LeetCode;

import java.util.Arrays;

public class L344_ReverseString {
    public void reverseString(char[] s) {
        //char temp;
        int len=s.length;
        for(int i=0;i<len/2;i++){
            char temp=s[i];
            s[i]=s[len-1-i];
            s[len-1-i]=temp;
        }
    }
    public static void main(String[] args){
        L344_ReverseString l344=new L344_ReverseString();
        char[] input={'h','e','l','l','o'};
        l344.reverseString(input);
        System.out.println(Arrays.toString(input));
    }
}