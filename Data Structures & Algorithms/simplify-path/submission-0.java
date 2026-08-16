class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();

        for (String dir : path.split("/")) {
            if (dir.equals("") || dir.equals(".")) {
                continue;
            }

            if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(dir);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder res = new StringBuilder();

        while (!stack.isEmpty()) {
            res.insert(0, "/" + stack.pop());
        }

        return res.toString();
    }
}