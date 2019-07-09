package jzoffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Sesame
 * @createTime 2019/6/27
 * @description
 */
public class FirstAppearingOnce {

    public static void main(String[] args) {
        FirstAppearingOnce fa = new FirstAppearingOnce();
        fa.Insert('g');
        System.out.println(fa.FirstAppearingOnce());
        fa.Insert('o');
        System.out.println(fa.FirstAppearingOnce());
        fa.Insert('o');
        System.out.println(fa.FirstAppearingOnce());
        fa.Insert('g');
        System.out.println(fa.FirstAppearingOnce());
        fa.Insert('l');
        System.out.println(fa.FirstAppearingOnce());
        fa.Insert('e');
        System.out.println(fa.FirstAppearingOnce());

    }

    private int[] cs = new int[256];
    private Queue<Character> queue = new LinkedList<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (cs[(int) ch] == 0) {
            cs[(int) ch] = 1;
            queue.add(ch);
        } else {
            cs[(int) ch] = -1;
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        while (!queue.isEmpty()) {
            char c = queue.peek();
            if (cs[(int) c] == 1) {
                return c;
            }else {
                queue.poll();
            }
        }
        return '#';
    }
}
