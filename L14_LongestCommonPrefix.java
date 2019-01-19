package LeetCode;

public class L14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder prefix=new StringBuilder();
        if(strs.length==0)
            return "";
        boolean flag=true;//当前循环是否有共同字母
        for(int i=0;i<strs[0].length();i++)
        {
            for(int j=1;j<strs.length;j++){//其他字符串当前位置字符是否与第一行字符串当前位置字符一致
                if(strs[j].length()<i+1){
                    flag=false;
                    //prefix.charAt(prefix.length()-1);//移除最后一个字符
                    break;
                }else if(strs[j].charAt(i)!=strs[0].charAt(i)){
                    flag=false;
                    break;
                }else
                    continue;
            }
            if(!flag)
                break;
            prefix.append(strs[0].charAt(i));
        }
        return  prefix.toString();
    }
}