class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        minHeap = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        /*System.out.println("Before addition of " + num );
        System.out.println("maxHeap: " + maxHeap);
        System.out.println("minHeap: " + minHeap);*/
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        /*System.out.println("After addition of " + num);
        System.out.println("maxHeap: " + maxHeap);
        System.out.println("minHeap: " + minHeap);
        */

        // balancing

       /* System.out.println("Before balancing::");
        System.out.println("size: " + maxHeap.size() + " maxHeap: " + maxHeap);
        System.out.println("size: " + minHeap.size() + " minHeap: " + minHeap);
        */

        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }

        /*System.out.println("After balancing::");
        System.out.println("size: " + maxHeap.size() + " maxHeap: " + maxHeap);
        System.out.println("size: " + minHeap.size() + " minHeap: " + minHeap);
        */

    }
    
    public double findMedian() {

        if (maxHeap.size() > minHeap.size())
            return maxHeap.peek();
        
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}
