package service;

public class BST<K extends Comparable<K>, V> {
    private class Node<K, V> {
        private K key;
        private V val;
        private Node<K, V> left, right;
        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + val +
                    ", size=" + size +
                    '}';
        }
    }
    private Node<K, V> root;
    private int size;

    public void put(K key, V val) {
        if (key == null)
            throw new IllegalArgumentException("Null key is not allowed.");
        root = put(root, key, val);
    }

    private Node<K, V> put(Node<K, V> node, K key, V val) {

        if (node == null) {
            size++;
            return new Node<>(key, val);
        }

        int comparison = key.compareTo(node.key);

        if (comparison < 0)
            node.left = put(node.left, key, val);
        else if (comparison > 0)
            node.right = put(node.right, key, val);
        else
            node.val = val;

        return node;
    }
}
