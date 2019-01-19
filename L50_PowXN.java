package LeetCode;

public class L50_PowXN {
    public double Pow(double x, int n) {
        double result=1;
        double temp=x;
        String binN = Integer.toBinaryString(n);
        int len=binN.length();
        //System.out.println(binN);
        for(int i=0;i<len;i++){
            int pos=len-1-i;
            //从低位到高位开始计算
            if(binN.charAt(pos)=='1'){
                result*=temp;//指数位上的求和，相当于底数位上的乘积
            }
            temp*=temp;//当前位表示的大小
        }
        return result;
    }
    public double myPow(double x, int n) {
        double result=0;
        if(n==0)
            return 1;
        if(n<0)
            result=1/Pow(x,-n);
        else
            result=Pow(x,n);
        return result;
    }
    public static void main(String[] args){
        double x=2.0;
        int n=-2;
        L50_PowXN l50=new L50_PowXN();
        System.out.println(l50.myPow(x,n));
    }
}
