package LeetCode;

public class L67_AddBinary {
    private static String getSum(String a,String b){//a比b长
        int len1=a.length();
        int len2=b.length();
        int[] res=new int[len1+1];//比a多一位，以备进位
        StringBuilder str=new StringBuilder();
        //StringBuilder res=new StringBuilder();
        int flag=0;//表示进位
        //int len=Math.min(len1,len2);//求和部分长度
        for(int i=0;i<len2;i++){//求和部分长度
            int aNum=a.charAt(len1-1-i)-'0';//从数字低位，即数组高位起逐位相加
            int bNum=b.charAt(len2-1-i)-'0';
            int remainder=(aNum+bNum+flag)%2;
            res[len1-i]=remainder;
            flag=(aNum+bNum+flag)/2;
        }
        for(int i=0;i<len1-len2;i++){//与b求和后多余部分
            int aNum=a.charAt(len1-len2-1-i)-'0';//从数字低位，即数组高位起逐位相加
            int remainder=(aNum+flag)%2;
            res[len1-len2-i]=remainder;
            flag=(aNum+flag)/2;
        }
        if (flag==1){
            res[0]=1;
        }
        if (flag==1){
            str.append("1");
            for(int i=0;i<len1;i++){
                str.append(res[i+1]);
            }
        }else{
            for(int i=0;i<len1;i++){
                str.append(res[i+1]);
            }
        }
        return str.toString();
    }
    public String addBinary(String a, String b) {
        int len1=a.length();
        int len2=b.length();
        if(len1>len2)
            return getSum(a,b);
        else
            return getSum(b,a);
    }

    public static void main(String[] args){
        String a1="11";
        String b1="1";
        String a2="100";
        String b2="110010";
        L67_AddBinary l67=new L67_AddBinary();
        System.out.println(l67.addBinary(a2,b2));
    }
}