package LeetCode;
/*
十进制转26进制
注意，z表示26，而非0
 */
public class L168_ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder sb=new StringBuilder();
        while(n>0){
            if(n%26!=0){
                sb.append((char)(n%26+64));
                n/=26;
            }
            else{
                sb.append('Z');
                n=n/26-1;
            }
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args){
        L168_ExcelSheetColumnTitle l168=new L168_ExcelSheetColumnTitle();
        System.out.println(l168.convertToTitle(52));
    }
}
