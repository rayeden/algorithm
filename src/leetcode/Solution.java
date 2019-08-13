package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sesame
 * @createTime 2019/7/21
 * @description
 */
class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] dominoes = {
                {1, 2}, {2, 1}, {3, 4}, {5, 6}
        };
        System.out.println(s.numEquivDominoPairs(dominoes));
    }


    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Domino, Integer> map = new HashMap<>();
        for (int i = 0; i < dominoes.length; i++) {
            Domino d = new Domino(dominoes[i][0], dominoes[i][1]);
            map.put(d, map.get(d) == null ? 1 : map.get(d));
        }
        Integer sum = 0;
        for (Map.Entry<Domino, Integer> entry : map.entrySet()) {
            Integer count = entry.getValue();
            sum += count / 2;
        }
        return sum;
    }

    class Domino {
        private Integer a;
        private Integer b;

        public Domino(Integer a, Integer b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Domino) {
                Domino oo = (Domino) o;
                return oo.a.equals(this.a) && oo.b.equals(this.b) ||
                        oo.a.equals(this.b) && oo.b.equals(this.a);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return a.hashCode() + b.hashCode();
        }
    }


}

