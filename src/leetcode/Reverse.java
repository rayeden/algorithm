package leetcode;

/**
 * @author BG289522
 * @createTime 2019/7/23
 * @description
 */
public class Reverse {

    public static void main(String[] args) {
        Reverse rs = new Reverse();
        System.out.println(rs.reverse(-123));
        System.out.println(Integer.MIN_VALUE);
        long a = 122;
        System.out.println((int)a);
    }

    public int reverse(int x) {
        int signal = 1;
        if(x < 0){
            signal = -1;
            x = -x;
        }
        int reverse = 0;
        while(x > 0){
            int mod = x % 10;
            reverse = reverse * 10 + mod;
            x /= 10;
        }
        return reverse * signal;
    }
}
