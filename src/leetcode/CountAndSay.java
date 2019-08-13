package leetcode;

/**
 * @author BG289522
 * @createTime 2019/7/26
 * @description
 */
public class CountAndSay {

    public static void main(String[] args) {
        CountAndSay cas = new CountAndSay();
        System.out.println(cas.countAndSay(4));
    }

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String[] strs = new String[n + 1];
        strs[1] = "1";
        for (int i = 2; i <= n; i++) {
            String s = strs[i - 1];
            StringBuilder res = new StringBuilder();
            int j = 0, k = 0;
            while (k < s.length()) {
                if (k < s.length() && s.charAt(j) == s.charAt(k)) {
                    k++;
                } else {
                    res.append(k - j);
                    res.append(s.charAt(j));
                    j = k;
                }
                if (k == s.length()) {
                    res.append(k - j);
                    res.append(s.charAt(j));
                    j = k;
                }
            }
            strs[i] = res.toString();
        }
        return strs[n];
    }
}
