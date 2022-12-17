import java.util.LinkedList;

class Solution {

    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isLeft(c)) {
                stack.add(c);
            } else if (!stack.isEmpty() && isMatch(stack.getLast(), c)) {
                stack.removeLast();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }

    public boolean isMatch(char left, char right) {
        return left == '(' && right == ')' || left == '[' && right == ']' || left == '{' && right == '}';
    }

    public boolean isLeft(char c) {
        return c == '(' || c == '[' || c == '{';
    }
}