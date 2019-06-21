package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class M17_LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> ans=new LinkedList<String>();
        if(digits.isEmpty())
            return ans;
        String[] digit={"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        ans.add("");
        for(int i=0;i<digits.length();i++){
            List<String> tempans=new LinkedList<>();
            String chars=digit[Character.getNumericValue(digits.charAt(i))];
            for(int j=0;j<ans.size();j++){
                for(int c=0;c<chars.length();c++){
                    tempans.add(ans.get(j)+chars.charAt(c));
                }
            }
            ans=tempans;
        }
        //System.out.println(ans);
        return ans;
    }
    public static void main(String[] args){
        M17_LetterCombinationsOfAPhoneNumber m17=new M17_LetterCombinationsOfAPhoneNumber();
        String input="23";
        System.out.println(m17.letterCombinations(input));
    }
}