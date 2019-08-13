package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author BG289522
 * @createTime 2019/7/26
 * @description
 */
public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(cs.combinationSum(candidates, target));
    }

    private List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            combinationSumCore(candidates, 0, target, list);
        }
        return lists;
    }

    public void combinationSumCore(int[] candidates, int index, int target, List<Integer> list) {
        if (index >= candidates.length || candidates[index] > target) {
            return;
        }
        list.add(candidates[index]);
        target -= candidates[index];
        if (target == 0) {
            lists.add(new ArrayList<>(list));
            return;
        } else if (target < 0) {
            return;
        }

        combinationSumCore(candidates, index, target - candidates[index], list);

        target += candidates[index];
        list.remove(list.size() - 1);
    }
}
