package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class L113Others {
    List<List<Integer>> results;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        results = new ArrayList<List<Integer>>();
        if (root == null)
            return results;
        ArrayList<Integer> result = new ArrayList<Integer>();
        pathSum(root, 0, sum, result);
        return results;
    }

    public void pathSum(TreeNode root, int res, int sum, ArrayList<Integer> result) {
        if (root == null)
            return;
        else if (root.left == null && root.right == null) {
            if (res + root.val == sum) {
                result.add(root.val);
                results.add(new ArrayList<Integer>(result));
                result.remove(result.size()-1);
            }
        } else {
            result.add(root.val);
            pathSum(root.left, res + root.val, sum, result);
            pathSum(root.right, res + root.val, sum, result);
            result.remove(result.size()-1);
        }
    }
}