import java.util.LinkedList;

class Solution {

    public String simplifyPath(String path) {
        path = path.replaceAll("/+", "/");
        String[] splits = path.split("/", 0);
        LinkedList<String> stack = new LinkedList<>();
        for (String split : splits) {
            if ("".equals(split) || ".".equals(split)) {
                continue;
            }
            if ("..".equals(split)) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
                continue;
            }
            stack.add(split);
        }

        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append('/');
            sb.append(s);
        }

        return sb.toString();

    }
}