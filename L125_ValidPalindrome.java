package LeetCode;

public class L125_ValidPalindrome {
    /*public boolean isAlphaNumeric(char c){
        if((c>='0'&&c<='9')||(c>='A'&&c<='Z')||(c>='a'&&c<='z'))
            return true;
        else
            return false;
    }
    //Runtime: 6 ms, faster than 72.53% of Java online submissions for Valid Palindrome.
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        if(s.length()<=1)
            return true;
        Character.isLetterOrDigit(s.charAt(0));
        int head=0,tail=s.length()-1;
        while(head<=tail){
            if(!isAlphaNumeric(s.charAt(head)))
            {
                head++;
                continue;
            }
            if(!isAlphaNumeric(s.charAt(tail)))
            {
                tail--;
                continue;
            }
            if(s.charAt(head)==s.charAt(tail))
            {
                head++;
                tail--;
            }else
                return false;
        }
        return true;
    }*/
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        if(s.length()<=1)
            return true;
        int head=0,tail=s.length()-1;
        while(head<=tail){
            if(!Character.isLetterOrDigit(s.charAt(head)))
            {
                head++;
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(tail)))
            {
                tail--;
                continue;
            }
            if(s.charAt(head)==s.charAt(tail))
            {
                head++;
                tail--;
            }else
                return false;
        }
        return true;
    }
    public static void main(String[] args){
        L125_ValidPalindrome l125=new L125_ValidPalindrome();
        String s="A man, a plan, a canal: Panama";
        //String s="race a car";
        System.out.println(l125.isPalindrome(s));
    }
}
