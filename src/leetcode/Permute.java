package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sesame
 * @createTime 2019/7/20
 * @description
 */
public class Permute {

    private static List<List<Integer>> lists = new ArrayList<>();

    public static void main(String[] args) {
        Permute p = new Permute();
        int[] nums = {1, 2, 3};
        p.permute(nums);
        System.out.println(lists.toString());
    }

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            permuteCore(nums, i, list, visited);
        }
        return lists;
    }

    private void permuteCore(int[] nums, int i, List<Integer> list, boolean[] visited) {
        if (!visited[i]) {
            //把当前元素加入list
            list.add(nums[i]);
            //标记访问
            visited[i] = true;
            //遍历数组，找到不是当前元素且没有被访问过的元素递归加入list
            for (int j = 0; j < nums.length; j++) {
                if (j != i && !visited[j]) {
                    permuteCore(nums, j, list, visited);
                }
            }
            //全部加入后把组合深拷贝到lists
            if (list.size() == nums.length) {
                lists.add(new ArrayList<>(list));
            }
            //去除当前元素的标记，并且从list删除
            visited[i] = false;
            //需要把nums[i]装箱成Integer，否则会调用remove(int index)，而不是remove(Object o)方法
            list.remove(Integer.valueOf(nums[i]));
        }
    }

}
