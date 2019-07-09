package jzoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sesame
 * @createTime 2019/7/1
 * @description
 */
public class FirstNotRepeatingChar {

    public static void main(String[] args) {
        String str = "google";
        FirstNotRepeatingChar fnr = new FirstNotRepeatingChar();
        System.out.println(fnr.firstNotRepeatingChar(str));
    }

    public int firstNotRepeatingChar(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Integer count = map.get(str.charAt(i));
            map.put(str.charAt(i), count == null ? 1 : count + 1);
        }
        for (int i = 0; i < str.length(); i++) {
            if(map.get(str.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}
