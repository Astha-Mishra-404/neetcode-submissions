class CountSquares {

    // Store frequency of each point
    private Map<String, Integer> count;

    public CountSquares() {
        count = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0];
        int y = point[1];

        String key = x + "," + y;
        count.put(key, count.getOrDefault(key, 0) + 1);
    }

    public int count(int[] point) {
        int px = point[0];
        int py = point[1];

        int res = 0;

        // Iterate through all stored points
        for (String key : count.keySet()) {

            String[] parts = key.split(",");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);

            // Skip if:
            // 1. Same point
            // 2. Not forming diagonal of square
            if (x == px || y == py || Math.abs(x - px) != Math.abs(y - py)) {
                continue;
            }

            /*
                (px, py) ---- (x, py)
                   |              |
                   |              |
                (px, y) ---- (x, y)

                Current point (x, y) acts as diagonal
            */

            String p1 = x + "," + py;
            String p2 = px + "," + y;

            res += count.get(key)
                    * count.getOrDefault(p1, 0)
                    * count.getOrDefault(p2, 0);
        }

        return res;
    }
}
