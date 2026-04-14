class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        

        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];

        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        for (int num: map.keySet())
            pq.offer(num);
        


        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }

        return res;


    }
}
