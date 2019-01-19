package LeetCode;
/*
258
 */
public class AddDigits {
    public int addDigits(int num) {
        if(num==0)
            return 0;
        /*
        //对两位数
        ab=a*10+b
        ab%9=(a*9+a+b)%9
            =(a+b)%9
        //对三位数
        abc=a*100+b*10+c
        abc%9=(a*99+b*9+a+b+c)%9
            =(a+b+c)%9
        对9求余，返回0~8
        希望各位数字之和为返回1~9
        (num-1)%9+1,num为9的整数倍时不会返回0
         */
        return ((num-1)%9+1);//??
    }
    public static void main(String[] args){
        AddDigits ad=new AddDigits();
        System.out.println(ad.addDigits(12345));
    }
}