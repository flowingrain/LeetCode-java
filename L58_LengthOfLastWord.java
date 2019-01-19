package LeetCode;

public class L58_LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] strs;
        strs=s.split(" ");
        if(strs.length==0)
            return 0;
        else
            return strs[strs.length-1].length();
    }
}