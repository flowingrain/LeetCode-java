package LeetCode;

import java.util.HashMap;

public class L290_WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] strs=str.split(" ");
        if(pattern.length()!=strs.length)
            return false;
        HashMap<Character,String> hm=new HashMap<Character, String>();
        for(int i=0;i<strs.length;i++){
            if(!hm.containsKey(pattern.charAt(i))){//添加键值对
                if(hm.containsValue(strs[i]))//添加后将会使不同键对应相同值。
                    return false;
                else
                    hm.put(pattern.charAt(i),strs[i]);
            }else {//hm.containsKey(pattern.charAt(i))
                if(!hm.get(pattern.charAt(i)).equals(strs[i]))//与模式不匹配
                    return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        L290_WordPattern l290=new L290_WordPattern();
        String pattern = "abba", str = "dog cat cat dog";
        System.out.println(l290.wordPattern(pattern,str));
    }
}