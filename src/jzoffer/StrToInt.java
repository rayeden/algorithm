package jzoffer;

/**
 * @author Sesame
 * @createTime 2019/6/27
 * @description
 */
public class StrToInt {

    public static void main(String[] args) {
        StrToInt sti = new StrToInt();
        System.out.println(sti.strToInt("123"));
    }

    public int strToInt(String str) {
        if(null == str || str.length() == 0
                || str.length() == 1 && !isNum(str.charAt(0))){
            return 0;
        }
        char[] cs = str.toCharArray();
        int sign = 1;
        int num = -1;
        for(int i = 0; i < str.length(); i++){
            if(i == 0 && cs[i] == '-'){
                sign = -1;
                continue;
            }else if(i == 0 && cs[i] == '+'){
                continue;
            }
            if(!isNum(cs[i])){
                return 0;
            }
            if(num == -1){
                num = cs[i] - '0';
            }else{
                num = num * 10 + (cs[i] - '0');
            }
        }
        return num * sign;
    }

    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

}
