class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> visited = new HashSet<>();

        int x = 0, y = 0;

        visited.add(x + "," + y);

        for (char c : path.toCharArray()) {

            if (c == 'N') {
                y++;
            } else if (c == 'S') {
                y--;
            } else if (c == 'E') {
                x++;
            } else if (c == 'W') {
                x--;
            }

            String position = x + "," + y;

            if (visited.contains(position)) {
                return true;
            }

            visited.add(position);
        }

        return false;
    }
}