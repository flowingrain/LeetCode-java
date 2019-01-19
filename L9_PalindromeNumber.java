package LeetCode;

public class L9_PalindromeNumber {
    public boolean isPalindrome(int x) {
        int[] nums=new int[32];
        int i=0;
        if(x<0)//负数或   最后一位为0(后半句不严谨，单独0是对称的)
            return false;
        while(x/10>0){
            nums[i]=x%10;
            i++;
            x=x/10;
        }
        nums[i]=x%10;
        int len=0;
        for(i=31;i>=0;i--){
            if(nums[i]>0){
                len=i;//数字位数
                break;
            }
        }
        for(i=0;i<=len/2;i++){
            if(nums[i]!=nums[len-i])
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        L9_PalindromeNumber l9=new L9_PalindromeNumber();
        System.out.println(l9.isPalindrome(12));
    }
}
