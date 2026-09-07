class Solution {
    public int leastInterval(char[] tasks, int n) {
        //Step 1 count freqency
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) {
            if (f > 0) {
                maxHeap.offer(f);
            }
        }

        int time = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            //every round, the most n + 1 task
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