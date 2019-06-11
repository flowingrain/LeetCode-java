package LeetCode;

public class M8_StringToInteger {
    public int myAtoi(String str) {
        str=str.trim();
        int len=str.length();
        if(len==0)
            return 0;
        int start=0;
        int flag=1;
        if(!Character.isDigit(str.charAt(start)))//非空白的首位字符为字母
        {
            if(str.charAt(start)=='-'||str.charAt(start)=='+') {
                if(str.charAt(start)=='-')
                    flag = -1;
                start++;
                if(start==len||!Character.isDigit(str.charAt(start)))//负号后边没有内容负号后边不是数字
                    return 0;
            }else
                return 0;
        }
        while(start<len-1&&str.charAt(start)=='0'){
            start++;
        }
        if(!Character.isDigit(str.charAt(start)))
            return 0;
        int end=start+1;
        while(end<len){
            if(Character.isDigit(str.charAt(end)))
                end++;
            else
                break;
        }
        //System.out.println(start+","+end);
        if(end-start>10||(end-start==10&&Long.valueOf(str.substring(start,end))>Integer.MAX_VALUE)){//可能溢出
            if(flag==1)
                return Integer.MAX_VALUE;
            else
                return Integer.MIN_VALUE;
        }else
            return flag*Integer.parseInt(str.substring(start,end));
    }
    public static void main(String[] args){
        M8_StringToInteger m8=new M8_StringToInteger();
        String input="    +0a32";
        System.out.println(m8.myAtoi(input));
    }
}