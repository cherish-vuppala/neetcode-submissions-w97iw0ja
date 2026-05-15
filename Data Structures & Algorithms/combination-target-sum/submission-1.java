class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        String CID = "index: " + 0 + ", target: " + target + ", ans: " + "{}";
        //System.out.println("initial call " + CID);
        backtrack(nums, 0, target, new ArrayList<Integer>());
        return result;
    }

    public void backtrack(int[] nums, int i, int target, List<Integer> ans) {
        if (target == 0) {
            
            result.add(new ArrayList<>(ans));
            //System.out.println("answer found call " + result);
            return;
        }

        // invalid
        if (target < 0 || i == nums.length)
            return;

        
        
        for (int j = i; j < nums.length; j++) {
            // choose
            ans.add(nums[j]);
            String CID = "index: " + j + ", target: " + (target - nums[j]) + ", ans: " + ans;
            //System.out.println("include call " + CID);
            backtrack(nums, j, target - nums[j], ans);
            
            // undo choice
            ans.remove(ans.size()-1);
            CID = "index: " + (j + 1) + ", target: " + target + ", ans: " + ans;
            //System.out.println("backtrack call " + CID);
            
        }

    }
}
