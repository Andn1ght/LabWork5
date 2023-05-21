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
    }
}
