package LeetCode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/word-break/discuss/43790/Java-implementation-using-DP-in-two-ways
public class L139_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int sLen=s.length();
        boolean[] dp=new boolean[sLen+1];//dp[i]表示到第i个字符的子串是否包含可以由词典构成
        dp[0]=true;//
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(dp[j]&&wordDict.contains(s.substring(j,i)))//这样求解dp[i]不会重复
                {
                    dp[i]=true;
                }
            }
        }
        return dp[sLen];
    }
    public static void main(String[] args){
        L139_WordBreak l139=new L139_WordBreak();
        String s=s = "leetcode";
        String[] wordDict = {"leet", "code"};
        List<String> wordDictList=new ArrayList<String>();
        for(int i=0;i<wordDict.length;i++)
        {
            wordDictList.add(wordDict[i]);
        }
        System.out.println(l139.wordBreak(s,wordDictList));
    }
}
