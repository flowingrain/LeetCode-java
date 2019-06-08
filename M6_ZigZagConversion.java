package LeetCode;

public class M6_ZigZagConversion {
    public String convert(String s, int numRows) {
        char[] cStr=s.toCharArray();
        int len=s.length();
        StringBuffer[] sb=new StringBuffer[numRows];
        for(int i=0;i<numRows;i++)
            sb[i]=new StringBuffer();
        int flag=1;//flag为true，从上往下，一整列，下一个值在下方;flag为false，从下往上，每个值占一列，下一个值在右上方
        int row=0,d=1;//row、col表示当前值位置
        if(numRows==1)
            return s;
        for(int i=0;i<len;i++){
            sb[row].append(cStr[i]);//不考虑z字型填充时的空白
            if(i%(numRows-1)==0)//最上行或最下行
            {
                if(flag==1){//向下，
                    d=1;
                }else{//向上
                    d=-1;
                }
                flag=1-flag;
            }
            row+=d;
        }
        for(int i=1;i<numRows;i++){
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
    public static void main(String[] args){
        M6_ZigZagConversion m6=new M6_ZigZagConversion();
        String s= "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(m6.convert(s,numRows));
    }
}
