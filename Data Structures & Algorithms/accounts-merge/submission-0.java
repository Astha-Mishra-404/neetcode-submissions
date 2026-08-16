class Solution {

    class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py) return;

            if (rank[px] < rank[py]) {
                parent[px] = py;
            } else if (rank[px] > rank[py]) {
                parent[py] = px;
            } else {
                parent[py] = px;
                rank[px]++;
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        int n = accounts.size();
        DSU dsu = new DSU(n);

        // email -> account index
        Map<String, Integer> emailOwner = new HashMap<>();

        // Union accounts having common email
        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);

            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);

                if (!emailOwner.containsKey(email)) {
                    emailOwner.put(email, i);
                } else {
                    dsu.union(i, emailOwner.get(email));
                }
            }
        }

        // root -> emails
        Map<Integer, List<String>> merged = new HashMap<>();

        for (String email : emailOwner.keySet()) {
            int root = dsu.find(emailOwner.get(email));

            merged.putIfAbsent(root, new ArrayList<>());
            merged.get(root).add(email);
        }

        List<List<String>> ans = new ArrayList<>();

        for (int root : merged.keySet()) {
            List<String> emails = merged.get(root);
            Collections.sort(emails);

            List<String> account = new ArrayList<>();
            account.add(accounts.get(root).get(0)); // person's name
            account.addAll(emails);

            ans.add(account);
        }

        return ans;
    }
}