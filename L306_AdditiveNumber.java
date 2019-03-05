package LeetCode;

public class L306_AdditiveNumber {
    private boolean isAdditiveNumber(String num,long num1,long num2){
        System.out.println("\t"+num1+"\t"+num2);
        long sum=num1+num2;
        String sumStr=String.valueOf(sum);
        if(num.startsWith(sumStr)) {
            if(sumStr.equals(num))
                return true;
            else
                return isAdditiveNumber(num.substring(sumStr.length()), num2, sum);
        }
        return false;
    }
    public boolean isAdditiveNumber(String num){
        long temp1,temp2;
        int len=num.length();
        if(num.length()<3)
            return false;
        for(int i=1;i<=num.length()/2;i++)
        {
            System.out.println("i:"+i);
            if(num.charAt(0)=='0'&&i>1)//i>1即第一个数位数>=2且以0开头
                return false;
            temp1=Long.valueOf(num.substring(0,i));
            for(int j=i+1;j<=Math.min(len-i,(len+i)/2);j++){//len-j>=i&&len-j>=j-i
                System.out.println("\tj:"+j);
                if(num.charAt(i)=='0'&&j-i>=2)//个位数的话，可以为2；多位数的话，不能以2开头。下同
                    break;
                if(num.charAt(j)=='0'&&len-j>=2)
                    continue;
                temp2=Long.valueOf(num.substring(i,j));
                if(isAdditiveNumber(num.substring(j),temp1,temp2))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        L306_AdditiveNumber l306=new L306_AdditiveNumber();
        //String num="112358";//true
        //String num="199100199";//true
        //String num="101";//true
        String num="000";//true
        System.out.println(l306.isAdditiveNumber(num));
    }
}
