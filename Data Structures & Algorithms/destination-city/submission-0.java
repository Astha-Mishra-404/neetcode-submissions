
class Solution {
    public String destCity(List<List<String>> paths) {
        // Store all starting cities
        HashSet<String> set = new HashSet<>();

        for (List<String> path : paths) {
            set.add(path.get(0));
        }

        // Find the destination city with no outgoing trip
        for (List<String> path : paths) {
            String destination = path.get(1);

            if (!set.contains(destination)) {
                return destination;
            }
        }

        return "";
    }
}
