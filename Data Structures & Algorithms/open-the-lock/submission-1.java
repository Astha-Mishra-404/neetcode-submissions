
class Solution {
    public int openLock(String[] deadends, String target) {

        Set<String> dead = new HashSet<>(Arrays.asList(deadends));

        if (dead.contains("0000")) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer("0000");
        visited.add("0000");

        int steps = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {

                String curr = queue.poll();

                if (curr.equals(target)) {
                    return steps;
                }

                for (int i = 0; i < 4; i++) {

                    char[] up = curr.toCharArray();
                    char[] down = curr.toCharArray();

                    // Rotate forward
                    up[i] = (up[i] == '9') ? '0' : (char) (up[i] + 1);

                    // Rotate backward
                    down[i] = (down[i] == '0') ? '9' : (char) (down[i] - 1);

                    String upStr = new String(up);
                    String downStr = new String(down);

                    if (!dead.contains(upStr) && !visited.contains(upStr)) {
                        visited.add(upStr);
                        queue.offer(upStr);
                    }

                    if (!dead.contains(downStr) && !visited.contains(downStr)) {
                        visited.add(downStr);
                        queue.offer(downStr);
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}