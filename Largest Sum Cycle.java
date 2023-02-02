//All test cases are pased 
//TC O(n)
//SC O(n)
/*

1 ≤ N ≤ 105
-1 < Edge[i] < N
Edge[i] != i

*/


class Solution {
    public long largesSumCycle(int N, int[] Edge) {
        boolean[] visited = new boolean [N];
        int [] indegree = new int[N];
        for (int node : Edge) {
            if (node != -1) {
                indegree [node]++;
            }
        }
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (indegree [i] == 0) {
                visited[i] = true;
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            int next = Edge[curr];
            if (next != -1 && !visited[next] && --indegree[next] == 0) {
                visited[next] = true;
                queue.offer (next);
            }
        }
        long maxsum = - 1;
        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }
            long currentValue = 0;
            int currentNode = i;
            while (!visited[ currentNode]) {
                currentValue += currentNode;
                visited[currentNode] = true;
                currentNode = Edge [currentNode];
            }
            if (currentNode == i && currentValue > 0) {
            maxsum = Math.max(maxsum, currentValue);
            }
        }
        return maxsum;
    }
}
