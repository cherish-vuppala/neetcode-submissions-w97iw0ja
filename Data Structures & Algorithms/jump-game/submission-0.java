class Solution {
    public boolean canJump(int[] nums) {
        return canJump(nums, 0);
    }

    public boolean canJump(int[] nums, int i) {
        if (i >= nums.length - 1) return true;

        if (nums[i] == 0) return false;

        int maxJump = nums[i];

        for (int jump = 1; jump <= maxJump; jump++) {
            if (canJump(nums, i + jump)) {
                return true;
            }
        }

        return false;

    } 
}
