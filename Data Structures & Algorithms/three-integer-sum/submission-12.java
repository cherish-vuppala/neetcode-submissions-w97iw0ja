class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<Set<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        int target = 0;

        List<List<Integer>> result = new ArrayList<>();
        try {

        
            for (int i = 0; i < nums.length-2; i++) {
                print("i: " + i);
                int start = i + 1, end = nums.length-1;
                print("start: " + start);
                print("end: " + end);
                Set<Integer> triplet = new HashSet<>();
                int sum = 0;
                while (start < end) {
                    print("nums[i] : " + nums[i]);
                    print("nums[start] : " + nums[start]);
                    print("nums[end] : " + nums[end]);
                    sum = nums[i] + nums[start] + nums[end];
                    print("sum: " + sum);
                    if (sum == target) {
                        triplet.add(nums[i]);
                        triplet.add(nums[start]);
                        triplet.add(nums[end]);

                        set.add(triplet);

                        start++;
                        end--;
                        
                        //print("triplet:" + triplet);
                    } else if (sum > target) {
                        end--;
                    } else {
                        start++;
                    }
                } 
            }
        } catch (Exception e) {
            print("Exception: " + e);
        }

        for (Set<Integer> triplet: set) {
            result.add(new ArrayList<>(triplet));
        }

        return result;
    }

    private void print(String msg) {
        System.out.println(msg);
    }
}
