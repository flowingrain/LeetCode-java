package LeetCode;

import java.util.HashMap;
import java.util.Map;
/*
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
参考https://www.cnblogs.com/TenosDoIt/p/3793503.html
从最后一个字符开始，如果当前字符对应的数字比上一个数字小，那么就把结果减去当前字符对应的数字，否则加上当前字符对应数字。
 */
public class L13_Roman2Integer {
    private static Character getKey(Map<Character,Integer> map,Integer value)
    {
        Character key=null;
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            if(value.equals(entry.getValue())){
                key=entry.getKey();
            }
        }
        return key;
    }
    public int romanToInt(String s) {
        Map<Character,Integer> map=new HashMap<Character, Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int len=s.length();
        int result=map.get(s.charAt(len-1));
        for(int i=len-1;i>0;i--)
            if(map.get(s.charAt(i))>map.get(s.charAt(i-1)))
                result-=map.get(s.charAt(i-1));
            else
                result+=map.get(s.charAt(i-1));
        return result;
    }
}