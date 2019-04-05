package LeetCode;

import java.util.Arrays;

public class L345_ReverseVowelsofaString {
    //使用哈希集合存储元音字母，sb构造返回的字符串
    /*public String reverseVowels(String s) {
        Set<Character> vowelSet=new HashSet<>();
        vowelSet.add('a');
        vowelSet.add('e');
        vowelSet.add('i');
        vowelSet.add('o');
        vowelSet.add('u');
        vowelSet.add('A');
        vowelSet.add('E');
        vowelSet.add('I');
        vowelSet.add('O');
        vowelSet.add('U');
        StringBuilder sb=new StringBuilder();
        int len=s.length();
        sb.append(s);
        for(int i=0,j=len-1;i<j;){
            if(!vowelSet.contains(s.charAt(i)))
                i++;
            else if(!vowelSet.contains(s.charAt(j)))
                j--;
            else {
                //交换前后的元音字母
                char temp=s.charAt(i);
                sb.setCharAt(i,sb.charAt(j));
                sb.setCharAt(j,temp);
                i++;
                j--;
            }
        }
        return sb.toString();
    }*/

    //使用字符串存储元音字母，sb构造返回的字符串
    /*public String reverseVowels(String s) {
        String vowels="aeiouAEIOU";
        StringBuilder sb=new StringBuilder();
        int len=s.length();
        sb.append(s);
        for(int i=0,j=len-1;i<j;){
            if(vowels.indexOf(s.charAt(i))==-1)
                i++;
            else if(vowels.indexOf(s.charAt(j))==-1)
                j--;
            else {
                //交换前后的元音字母
                char temp=s.charAt(i);
                sb.setCharAt(i,sb.charAt(j));
                sb.setCharAt(j,temp);
                i++;
                j--;
            }
        }
        return sb.toString();
    }*/

    //使用字符串存储元音字母，字符数组构造返回的字符串
    /*public String reverseVowels(String s) {
        String vowels="aeiouAEIOU";
        int len=s.length();
        char[] sb=s.toCharArray();
        for(int i=0,j=len-1;i<j;){
            if(vowels.indexOf(sb[i])==-1)
                i++;
            else if(vowels.indexOf(sb[j])==-1)
                j--;
            else {
                //交换前后的元音字母
                char temp=sb[i];
                sb[i]=sb[j];
                sb[j]=temp;
                i++;
                j--;
            }
        }
        return new String(sb);
    }*/

    //使用while实现上述功能
    public String reverseVowels(String s) {
        String vowels="aeiouAEIOU";
        int len=s.length();
        char[] sb=s.toCharArray();
        int i=0,j=len-1;
        while(i<j){
            while(i<j&&vowels.indexOf(sb[i])==-1)//之前自己写的在内层循环扫了i<j
                i++;
            while(i<j&&vowels.indexOf(sb[j])==-1)
                j--;
            //交换前后的元音字母
            char temp=sb[i];
            sb[i]=sb[j];
            sb[j]=temp;
            i++;
            j--;
        }
        return new String(sb);
    }

    public static void main(String[] args){
        L345_ReverseVowelsofaString l345=new L345_ReverseVowelsofaString();
        //String s="hello";
        String s="aA";
        System.out.println(l345.reverseVowels(s));
    }
}
