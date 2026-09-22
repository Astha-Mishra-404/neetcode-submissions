class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();

        for (String email : emails) {
            // Split into local name and domain name
            String[] parts = email.split("@");
            String local = parts[0];
            String domain = parts[1];

            // Ignore everything after the first '+' in local name
            int plusIndex = local.indexOf('+');
            if (plusIndex != -1) {
                local = local.substring(0, plusIndex);
            }

            // Remove all periods '.' in local name
            local = local.replace(".", "");

            // Reconstruct and insert into the set
            uniqueEmails.add(local + "@" + domain);
        }

        return uniqueEmails.size();
    }
}