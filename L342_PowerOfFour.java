package LeetCode;

public class L342_PowerOfFour {
    public boolean isPowerOfFour(int num) {
        if(num<1)
            return false;
        while(num>1){
            if(num%4!=0)
                return false;
            num/=4;
        }
        return true;
    }
    public static void main(String[] args){
        L342_PowerOfFour l342=new L342_PowerOfFour();
        int num=16;
        //int num=17;
        System.out.println(l342.isPowerOfFour(num));
    }
}