class TimeMap {

    private static class Pair {
        int time;
        String value;

        Pair(int time, String value) {
            this.time = time;
            this.value = value;
        }
    }

    private Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>())
           .add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        List<Pair> list = map.get(key);

        int left = 0, right = list.size() - 1;
        String answer = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (list.get(mid).time <= timestamp) {
                answer = list.get(mid).value;   // valid candidate
                left = mid + 1;                 // try to find a later one
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }
}
