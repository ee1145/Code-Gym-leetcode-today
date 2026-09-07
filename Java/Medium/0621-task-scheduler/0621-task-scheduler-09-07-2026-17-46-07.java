class Solution {
    public int leastInterval(char[] tasks, int n) {
        //Four step
        //1.count freq
        //2.init a while loop for task
        //3.processing each round
        //4.return time

        //1.count freq
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }

        //need a max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) {
            if (f > 0) {
                maxHeap.offer(f);
            }
        }

        //2
        int time = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            //3.each round
            for (int i = 0; i <= n; i++) {
                if (!maxHeap.isEmpty()) {
                    int f = maxHeap.poll();

                    if (f - 1 > 0) {
                        temp.add(f - 1);
                    }
                }
                time++;
                if (maxHeap.isEmpty() && temp.isEmpty()) {
                    break;
                }
            }
            for (int f : temp) {
                maxHeap.offer(f);
            }
        }
        return time;
    }
}