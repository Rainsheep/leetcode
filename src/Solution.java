import java.util.HashMap;
import java.util.Map;

class Trie {

    class Node {

        Character c;
        boolean isNode;
        Map<Character, Node> list = new HashMap<>();

        public Node(Character c) {
            this.c = c;
        }
    }

    Node root;

    public Trie() {
        this.root = new Node(null);
    }

    public void insert(String word) {
        Node p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (p.list.containsKey(c)) {
                p = p.list.get(c);
            } else {
                Node next = new Node(c);
                p.list.put(c, next);
                p = next;
            }
            if (i == word.length() - 1) {
                p.isNode = true;
            }
        }
    }

    public boolean search(String word) {
        Node p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (p.list.containsKey(c)) {
                p = p.list.get(c);
            } else {
                return false;
            }

            if (i == word.length() - 1) {
                return p.isNode;
            }
        }
        return true;
    }

    public boolean startsWith(String prefix) {
        Node p = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (p.list.containsKey(c)) {
                p = p.list.get(c);
            } else {
                return false;
            }
        }
        return true;

    }
}

