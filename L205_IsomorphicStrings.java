package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class L205_IsomorphicStrings {
    public boolean isIsomorphic(String s,String t){
        if(s==null||t==null||s.length()!=t.length())
            return false;
        Map map=new HashMap();//使用map做字母映射
        char[] sArr=s.toCharArray();
        char[] tArr=t.toCharArray();
        for(int i=0;i<s.length();i++){
            if(map.get(sArr[i])==null)//键未做映射，分两种情况，值已存在，值不存在
            {
                if(map.containsValue(tArr[i]))//值映射到了其他键
                    return false;
                else
                    map.put(sArr[i],tArr[i]);
            }
            else
                if(tArr[i]!=(Character) map.get(sArr[i]))
                    return false;
        }
        return true;
    }

    public static void main(String[] args){
        L205_IsomorphicStrings l205=new L205_IsomorphicStrings();
        String s="ab";
        String t="aa";
        System.out.println(l205.isIsomorphic(s,t));
    }
}
