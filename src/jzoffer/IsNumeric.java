package jzoffer;

/**
 * @author Sesame
 * @createTime 2019/6/27
 * @description
 */
public class IsNumeric {

    public static void main(String[] args) {
        IsNumeric in = new IsNumeric();
        String s = "-.123";
        System.out.println(s.split("\\.")[0]);
        System.out.println(in.isNumeric(s.toCharArray()));
    }

    public boolean isNumeric(char[] str) {
        if (str.length == 0) {
            return false;
        }
//        String s = String.valueOf(str);
//        String[] ss = s.split("\\.");
//        if (ss.length == 2) {
//            if (!isPureNum(ss[0].toCharArray()) || isSignal(ss[1].toCharArray())) {
//                return false;
//            }
//            return isPureNum(ss[0].toCharArray()) && (isPureNum(ss[1].toCharArray()))
//                    || isPureNum(ss[0].toCharArray()) && (isScience(ss[1].toCharArray()));
//        } else if (ss.length > 2) {
//            return false;
//        }

        return isPureNum(str) || isScience(str) || isDigit(str);
    }

    private boolean isScience(char[] str) {
        String s = String.valueOf(str);
        String[] cs = s.split("e");
        if (cs.length == 2) {
            return isPureNum(cs[0].toCharArray()) && isPureNum(cs[1].toCharArray());
        }
        cs = s.split("E");
        if (cs.length == 2) {
            return isPureNum(cs[0].toCharArray()) && isPureNum(cs[1].toCharArray());
        }
        return isPureNum(str);
    }

    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isSignal(char[] str) {
        if (str.length == 0 || str.length == 1) {
            return false;
        }
        return str[0] == '+' || str[0] == '-';
    }

    private boolean isDigit(char[] str) {
        if (str.length == 0 || str.length == 1) {
            return false;
        }
        String s = String.valueOf(str);
        String[] ss = s.split("\\.");
        if (ss.length == 2) {
            if (isPureNum(ss[0].toCharArray()) || ss[0].toCharArray().length == 0) {
                if ((isPureNum(ss[1].toCharArray()) && !isSignal(ss[1].toCharArray()))
                        || isScience(ss[1].toCharArray())) {
                    return true;
                }
            }

        }
        return false;
    }

    private boolean isPureNum(char[] str) {
        if (str.length == 0) {
            return false;
        }
        if (str.length == 1 && !isNum(str[0])) {
            return false;
        }
        int index = 0;
        if (str[index] == '+' || str[index] == '-') {
            index++;
        }
        while (index < str.length) {
            if (!isNum(str[index])) {
                return false;
            }
            index++;
        }
        return true;
    }

}
