package leetcode;

/**
 * @author Sesame
 * @createTime 2019/7/14
 * @description
 */
public class ValidUtf8 {

    public static void main(String[] args) {
        ValidUtf8 validUtf8 = new ValidUtf8();
//        System.out.println(validUtf8.toBinary(197));
        int[] data = {145};
        for (int i = 0; i < data.length; i++) {
            System.out.print(Integer.toBinaryString(data[i]) + " ");
        }
        System.out.println(validUtf8.validUtf8(data));
    }

    private boolean validUtf8(int[] data) {
        if (null == data || data.length > 4) {
            return false;
        }
        if(data.length == 0){
            return true;
        }
        int count = 0;
        for (int aData : data) {
            if (count == 0) {
                int mask1 = 128, mask2 = 64;
                if(((aData & mask1) == mask1) && ((aData & mask2) == 0)){
                    return false;
                }
                while (count < 8 && (aData & mask1) == mask1) {
                    count++;
                    mask1 >>= 1;
                }
                if (count > 4) {
                    return false;
                }
                if (count > 0) {
                    count--;
                }
            } else {
                int mask1 = 128, mask2 = 64;
                if ((aData & mask1) != mask1 || (aData & mask2) != 0) {
                    return false;
                }
                count--;
            }
        }
        return count == 0;
    }

    private String getBinaryStr(int n) {
        return Integer.toBinaryString(n).length() > 8 ?
                Integer.toBinaryString(n).substring(0, 8) :
                "00000000".substring(0, Integer.toBinaryString(n).length() % 8) + Integer.toBinaryString(n);
    }


    private String toBinary(int n) {
        StringBuilder sb = new StringBuilder();
        int bytes = 0;
        while (n >= 0 && bytes < 8) {
            sb.append(n % 2);
            n /= 2;
            bytes++;
        }
        return sb.reverse().toString();
    }

}
