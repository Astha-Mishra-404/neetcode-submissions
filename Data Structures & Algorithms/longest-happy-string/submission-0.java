class Solution {
    class Pair {
        char ch;
        int cnt;

        Pair(char ch, int cnt) {
            this.ch = ch;
            this.cnt = cnt;
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> y.cnt - x.cnt);

        if (a > 0) pq.offer(new Pair('a', a));
        if (b > 0) pq.offer(new Pair('b', b));
        if (c > 0) pq.offer(new Pair('c', c));

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            Pair first = pq.poll();

            int n = sb.length();

            // Using first would create three consecutive same characters
            if (n >= 2 && sb.charAt(n - 1) == first.ch && sb.charAt(n - 2) == first.ch) {

                if (pq.isEmpty()) break;

                Pair second = pq.poll();

                sb.append(second.ch);
                second.cnt--;

                if (second.cnt > 0) pq.offer(second);
                pq.offer(first);
            } else {
                sb.append(first.ch);
                first.cnt--;

                if (first.cnt > 0) pq.offer(first);
            }
        }

        return sb.toString();
    }
}